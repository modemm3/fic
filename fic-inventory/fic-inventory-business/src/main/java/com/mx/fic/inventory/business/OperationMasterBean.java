package com.mx.fic.inventory.business;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mx.fic.inventory.business.exception.PersistenceException;
import com.mx.fic.inventory.dto.OperationMasterDTO;
import com.mx.fic.inventory.persistent.OperationMaster;

@Stateless (mappedName="OperationMasterBean")
@TransactionManagement (TransactionManagementType.CONTAINER)
public class OperationMasterBean implements OperationMasterBeanLocal {

	@PersistenceContext 
	private EntityManager entityManager;
	
	private static final Logger logger = LoggerFactory.getLogger(OperationMasterBean.class);
	
	public void save(OperationMasterDTO operationMasterDTO) throws PersistenceException, Exception {
		final OperationMaster operationMaster = new OperationMaster();
		
		
		
	}

}
