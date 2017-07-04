package com.mx.fic.inventory.business;

import java.util.List;

import javax.ejb.Local;

import com.mx.fic.inventory.business.exception.PersistenceException;
import com.mx.fic.inventory.dto.OperationsDTO;

@Local
public interface OperationsBeanLocal {

	void save(OperationsDTO operationsDTO) throws PersistenceException, Exception;

	List<OperationsDTO> getAllByCompany(Integer companyId) throws PersistenceException;

}