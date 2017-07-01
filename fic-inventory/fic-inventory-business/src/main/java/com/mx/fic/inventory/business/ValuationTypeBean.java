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
import com.mx.fic.inventory.dto.ValuationTypeDTO;
import com.mx.fic.inventory.persistent.ValuationType;

//@Local
@Stateless (mappedName= "ValuationTypeBean")
@TransactionManagement (TransactionManagementType.CONTAINER)
public class ValuationTypeBean implements ValuationTypeBeanLocal {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	/* (non-Javadoc)
	 * @see com.mx.fic.inventory.business.ValuationTypeBeanLocal#save(com.mx.fic.inventory.dto.ValuationTypeDTO)
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(final ValuationTypeDTO valuationTypeDTO) throws PersistenceException{
		final ValuationType valuationType = new ValuationType();
		//final Company company= new Company();
		
		try{
			//company.setId(valuationTypeDTO.getCompanyId());

			//valuationType.setCompany(company);
			valuationType.setDescription(valuationTypeDTO.getDescription());
			valuationType.setKeyValuation(valuationTypeDTO.getKeyValuation());
			valuationType.setName(valuationTypeDTO.getName());
			
			entityManager.persist(valuationType);
			
		}catch(EntityExistsException | IllegalArgumentException | TransactionRequiredException e ){
			throw new PersistenceException("Erro al guardar los tipos de valuaciones");
		}
	}
	
	/* (non-Javadoc)
	 * @see com.mx.fic.inventory.business.ValuationTypeBeanLocal#getAll()
	 */
	@Override
	public List<ValuationTypeDTO> getAll() throws PersistenceException{		
		List<ValuationTypeDTO> valuationTypeDTOLst=null;
		ValuationTypeDTO valuationTypeDTO= null;
		List<ValuationType> valuationTypeLst= new ArrayList<ValuationType>();
		
		TypedQuery<ValuationType> query= entityManager.createNamedQuery("ValuationType.getAll", ValuationType.class);
		valuationTypeLst= query.getResultList();
		
		if(valuationTypeLst!=null && valuationTypeLst.size()>0){
			valuationTypeDTOLst=new ArrayList<ValuationTypeDTO>();
			for(ValuationType vt: valuationTypeLst){
				valuationTypeDTO= TransferObjectAssembler.getInstance().assembleTO(ValuationTypeDTO.class, vt);
				valuationTypeDTOLst.add(valuationTypeDTO);
			}	
		}
		return valuationTypeDTOLst;
	}

}
