package com.mx.fic.inventory.business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
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
import com.mx.fic.inventory.dto.MovementConceptDTO;
import com.mx.fic.inventory.persistent.Company;
import com.mx.fic.inventory.persistent.MovementConcept;
import com.mx.fic.inventory.persistent.Status;

@Local
@Stateless (mappedName= "MovementConceptoBean")
@TransactionManagement (TransactionManagementType.CONTAINER)
public class MovementConceptBean {

	@PersistenceContext
	private EntityManager entityManager;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(final MovementConceptDTO movementConceptDTO) throws PersistenceException{
		final MovementConcept movementConcept = new MovementConcept();
		final Company company = new Company();
		final Status status = new Status();
		
		try{
			company.setId(movementConceptDTO.getCompanyId());
			status.setId(movementConceptDTO.getStatusId());
			movementConcept.setCompany(company);
			movementConcept.setDescription(movementConceptDTO.getDescription());
			movementConcept.setName(movementConceptDTO.getName());
			movementConcept.setStatus(status);
			
			entityManager.persist(movementConcept);
		}catch(EntityExistsException | IllegalArgumentException | TransactionRequiredException e ){
			throw new PersistenceException("Errror al guardar los movimientos de concepto");
		}
	}
	
	public List<MovementConceptDTO> getAllByCompany(final Integer companyId) throws PersistenceException{
		List<MovementConceptDTO> movementConceptDTOLst = null;
		MovementConceptDTO movementConceptDTO = null;
		List<MovementConcept> movementConceptLst = new ArrayList<MovementConcept>();
		
		TypedQuery<MovementConcept> query = entityManager.createNamedQuery("MovementConcept.getAllByCompany",MovementConcept.class);
		query.setParameter("id", companyId);
		movementConceptLst = query.getResultList();
		
		if(movementConceptLst!= null && movementConceptLst.size()>0){
			movementConceptDTOLst = new ArrayList<MovementConceptDTO>();
			for(MovementConcept mc : movementConceptLst){
				movementConceptDTO = TransferObjectAssembler.getInstance().assembleTO(MovementConceptDTO.class, mc);
				movementConceptDTOLst.add(movementConceptDTO);
			}
		}
		return movementConceptDTOLst; 
	}
}
