package com.mx.fic.inventory.business;

import java.sql.Timestamp;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TransactionRequiredException;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.mx.fic.inventory.business.exception.PersistenceException;
import com.mx.fic.inventory.dto.OperationMasterDTO;
import com.mx.fic.inventory.persistent.Company;
import com.mx.fic.inventory.persistent.MovementType;
import com.mx.fic.inventory.persistent.OperationMaster;
import com.mx.fic.inventory.persistent.Status;

@Stateless (mappedName="OperationMasterBean")
@TransactionManagement (TransactionManagementType.CONTAINER)
public class OperationMasterBean implements OperationMasterBeanLocal {

	@PersistenceContext 
	private EntityManager entityManager;
	
	private static final Logger logger = LoggerFactory.getLogger(OperationMasterBean.class);

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Integer save(OperationMasterDTO operationMasterDTO) throws PersistenceException {
		logger.info("Bean operationMaster "+ operationMasterDTO);
		final OperationMaster operationMaster = new OperationMaster();
		MovementType movemenType = new MovementType();
		Company company= null;
		Status status = new Status();

		System.out.println("=> "+operationMasterDTO);
		
		
		try{
		if(operationMasterDTO.getCompanyId()!=null){
			company = new Company();
			company.setId(operationMasterDTO.getCompanyId());
		}
		
		if(operationMasterDTO.getMovementTypeId()!=null){
			movemenType = new MovementType();
			movemenType.setId(operationMasterDTO.getMovementTypeId());
		}
		
		if(operationMasterDTO.getStatusId()!=null){
			status = new Status();
			status.setId(operationMasterDTO.getStatusId());
		}
		
		operationMaster.setCompany(company);
		operationMaster.setFolioDocument(operationMasterDTO.getFolioDocument());
		operationMaster.setMovementType(movemenType);
		operationMaster.setOperationDate(new Timestamp(operationMasterDTO.getOperationDate()));
		operationMaster.setStatus(status);
		operationMaster.setModificationDate(new Timestamp(System.currentTimeMillis()));
		operationMaster.setCreationDate(new Timestamp(System.currentTimeMillis()));
		
		entityManager.persist(operationMaster);
		entityManager.flush();
		}catch(EntityExistsException | IllegalArgumentException | TransactionRequiredException e){
			logger.error("Error en bean "+e);
			throw new PersistenceException("Error al guardar la operación maestra");
		}
		
		return operationMaster.getId();
	}

	public Boolean updateStatus(Integer statusId, Integer operationMasterId) throws PersistenceException, Exception {
		boolean resultUpdate=false;
		Status status= null;
		OperationMaster operationMaster = null;
		
		try{
			
			operationMaster = entityManager.find(OperationMaster.class, operationMasterId);
			
			status = new Status();
			status.setId(statusId);
			operationMaster.setStatus(status);
			
			if(operationMaster!=null){
				entityManager.persist(operationMaster);
				resultUpdate = true;
			}
			
		}catch(EntityExistsException | IllegalArgumentException | TransactionRequiredException e){
			logger.error("Error en bean "+e);
			e.printStackTrace();
			throw new PersistenceException("Error al actualizar el estatus de la operacion master");
		}
		return resultUpdate;
	}

}
