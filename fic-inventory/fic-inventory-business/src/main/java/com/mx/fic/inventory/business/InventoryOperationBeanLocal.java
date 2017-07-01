package com.mx.fic.inventory.business;

import java.util.List;

import javax.ejb.Local;

import com.mx.fic.inventory.business.exception.PersistenceException;
import com.mx.fic.inventory.dto.InventoryOperationDTO;
import com.mx.fic.inventory.request.InventoryOperationRequest;

@Local
public interface InventoryOperationBeanLocal {

	List<InventoryOperationDTO> getAllByProductAndCompany(InventoryOperationRequest request)
			throws PersistenceException, Exception;

}