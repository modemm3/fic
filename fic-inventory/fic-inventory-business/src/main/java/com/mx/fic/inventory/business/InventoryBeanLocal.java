package com.mx.fic.inventory.business;

import java.util.List;

import javax.ejb.Local;

import com.mx.fic.inventory.business.exception.PersistenceException;
import com.mx.fic.inventory.dto.InventoryDTO;
import com.mx.fic.inventory.dto.OperationsDTO;
import com.mx.fic.inventory.dto.ProductDTO;
import com.mx.fic.inventory.persistent.Inventory;

@Local
public interface InventoryBeanLocal {

	void save(InventoryDTO inventoryDTO) throws PersistenceException, Exception;

	List<InventoryDTO> getAllByCompany(Integer companyId) throws PersistenceException, Exception;

	Inventory findProductByCompany(ProductDTO productDTO) throws PersistenceException, Exception;

	InventoryDTO getOperationInventory(OperationsDTO operationsDTO) throws PersistenceException, Exception;

}