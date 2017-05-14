package com.mx.fic.inventory.business;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import com.mx.fic.inventory.business.builder.config.TransferObjectAssembler;
import com.mx.fic.inventory.dto.StatusDTO;
import com.mx.fic.inventory.persistent.Status;

@Local
@Stateless (mappedName="StatusBean")
@TransactionManagement (TransactionManagementType.CONTAINER)
public class StatusBean {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<StatusDTO> getAllByCompany(final Integer idCompany){		
		List<StatusDTO> statusDTOLst=null;
		StatusDTO statusDTO= null;
		List<Status> statusLst= new ArrayList<Status>();
		
		TypedQuery<Status> query= entityManager.createNamedQuery("Status.getAll", Status.class);
		query.setParameter("id", idCompany);
		statusLst= query.getResultList();
		
		if(statusLst!=null && statusLst.size()>0){
			statusDTOLst=new ArrayList<StatusDTO>();
			for(Status s: statusLst){
				statusDTO= TransferObjectAssembler.getInstance().assembleTO(statusDTO.getClass(), s);
				statusDTOLst.add(statusDTO);
			}	
		}
		return statusDTOLst;
	}

}
