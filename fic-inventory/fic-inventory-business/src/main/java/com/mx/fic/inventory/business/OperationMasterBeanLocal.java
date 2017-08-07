package com.mx.fic.inventory.business;

import javax.ejb.Local;

import com.mx.fic.inventory.business.exception.PersistenceException;
import com.mx.fic.inventory.dto.OperationMasterDTO;

@Local
public interface OperationMasterBeanLocal {

	public Integer save(OperationMasterDTO operationMasterDTO) throws PersistenceException, Exception;
		
}
