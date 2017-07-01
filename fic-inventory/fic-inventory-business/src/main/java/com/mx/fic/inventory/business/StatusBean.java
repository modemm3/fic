package com.mx.fic.inventory.business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TransactionRequiredException;
import javax.persistence.TypedQuery;

import com.mx.fic.inventory.business.builder.config.TransferObjectAssembler;
import com.mx.fic.inventory.business.exception.PersistenceException;
import com.mx.fic.inventory.dto.StatusDTO;
import com.mx.fic.inventory.persistent.Company;
import com.mx.fic.inventory.persistent.Status;

//@Local
@Stateless (mappedName="StatusBean")
@TransactionManagement (TransactionManagementType.CONTAINER)
public class StatusBean implements StatusBeanLocal{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	/* (non-Javadoc)
	 * @see com.mx.fic.inventory.business.StatusBeanLocal#save(com.mx.fic.inventory.dto.StatusDTO)
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(final StatusDTO statusDTO) throws PersistenceException{
		final Status status = new Status();
		final Company company= new Company();
		
		try{
			company.setId(statusDTO.getCompanyId());
			status.setCompany(company);
			status.setDescription(statusDTO.getDescription());;
			status.setName(statusDTO.getName());
			
			entityManager.persist(status);
			
		}catch(EntityExistsException | IllegalArgumentException | TransactionRequiredException e ){
			throw new PersistenceException("Erro al guardar los estatus");
		}
	}
	
	/* (non-Javadoc)
	 * @see com.mx.fic.inventory.business.StatusBeanLocal#getAllByCompany(java.lang.Integer)
	 */
	@Override
	public List<StatusDTO> getAllByCompany(final Integer idCompany) throws PersistenceException{		
		List<StatusDTO> statusDTOLst=null;
		StatusDTO statusDTO= null;
		List<Status> statusLst= new ArrayList<Status>();
		
		TypedQuery<Status> query= entityManager.createNamedQuery("Status.getAllByCompany", Status.class);
		query.setParameter("id", idCompany);
		statusLst= query.getResultList();
		
		if(statusLst!=null && statusLst.size()>0){
			statusDTOLst=new ArrayList<StatusDTO>();
			for(Status s: statusLst){
				statusDTO= TransferObjectAssembler.getInstance().assembleTO(StatusDTO.class, s);
				statusDTOLst.add(statusDTO);
			}	
		}
		return statusDTOLst;
	}

}
