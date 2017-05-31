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
import com.mx.fic.inventory.dto.MovementTypeDTO;
import com.mx.fic.inventory.persistent.Company;
import com.mx.fic.inventory.persistent.MovementConcept;
import com.mx.fic.inventory.persistent.MovementType;
import com.mx.fic.inventory.persistent.Status;

@Local
@Stateless (mappedName ="MovementTypeBean")
@TransactionManagement (TransactionManagementType.CONTAINER)
public class MovementTypeBean {

	@PersistenceContext
	private EntityManager entityManager;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(final MovementTypeDTO movementTypeDTO) throws PersistenceException{
		final MovementType movementType = new MovementType();
		final Company company = new Company();
		final Status status = new Status();
		final MovementConcept movementConcept = new MovementConcept();
		
		try{
			movementType.setDescription(movementTypeDTO.getDescription());
			movementType.setName(movementTypeDTO.getName());
			
			company.setId(movementTypeDTO.getCompanyId());
			status.setId(movementTypeDTO.getStatusId());
			movementConcept.setId(movementTypeDTO.getMovementConceptId());
			
			movementType.setCompany(company);
			movementType.setStatus(status);
			movementType.setMovementConcept(movementConcept);
			
			entityManager.persist(movementType);
			
		}catch(EntityExistsException | IllegalArgumentException | TransactionRequiredException e ){
			throw new PersistenceException("Erro al guardar los estatus");
		}
	}
	
	public List<MovementTypeDTO> getAllByCompany(final Integer companyId) throws PersistenceException{
		List<MovementType> movementTypeLst = new ArrayList<MovementType>();
		List<MovementTypeDTO> movementTypeDTOLst = null;
		MovementTypeDTO movementTypeDTO = null;
		
		TypedQuery<MovementType> query = entityManager.createNamedQuery("MovementType.getAllByCompany", MovementType.class);
		query.setParameter("id", companyId);
		movementTypeLst = query.getResultList();
		
		if(movementTypeLst!= null && movementTypeLst.size()>0){
			movementTypeDTOLst = new ArrayList<MovementTypeDTO>();
			for(MovementType mt: movementTypeLst){
				movementTypeDTO = TransferObjectAssembler.getInstance().assembleTO(MovementTypeDTO.class, mt);
				movementTypeDTOLst.add(movementTypeDTO);
			}
		}
		
		return movementTypeDTOLst;
	}
}