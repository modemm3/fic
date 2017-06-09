package com.mx.fic.inventory.business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TransactionRequiredException;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mx.fic.inventory.business.builder.config.TransferObjectAssembler;
import com.mx.fic.inventory.business.exception.PersistenceException;
import com.mx.fic.inventory.dto.InventoryOperationDTO;
import com.mx.fic.inventory.persistent.InventoryOperation;
import com.mx.fic.inventory.request.InventoryOperationRequest;

@Local
@Stateless (mappedName="InventoryOperationBean")
@TransactionManagement (TransactionManagementType.CONTAINER)
public class InventoryOperationBean {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	private static final Logger logger = LoggerFactory.getLogger(InventoryOperationBean.class);
	
	public List<InventoryOperationDTO> getAllByProductAndCompany(final InventoryOperationRequest request) throws PersistenceException, Exception{
		List<InventoryOperationDTO> inventoryOperationDTOLst = null;
		InventoryOperationDTO inventoryOperationDTO = null;
		List<InventoryOperation> inventoryOperationLst = new ArrayList<InventoryOperation>();
		
		try{
			TypedQuery<InventoryOperation> query = entityManager.createNamedQuery("InventoryOperation.getAllByProductAndCompany", InventoryOperation.class);
			query.setParameter("companyId", request.getCompanyId());
			query.setParameter("productId", request.getProductId());
			inventoryOperationLst = query.getResultList();
			
			if(inventoryOperationLst!=null && inventoryOperationLst.size()>0){
				inventoryOperationDTOLst = new ArrayList<InventoryOperationDTO>();
				
				for(InventoryOperation io: inventoryOperationLst){
					inventoryOperationDTO = TransferObjectAssembler.getInstance().assembleTO(InventoryOperationDTO.class, io);
					inventoryOperationDTOLst.add(inventoryOperationDTO);
				}
			}
		}catch(EntityExistsException | IllegalArgumentException | TransactionRequiredException e ){
			logger.info("Error al obtener el inventario operacion por compañía y producto");
			throw new PersistenceException("Error al obtener el inventario operacion por compañía y producto");
		}catch(Exception e){
			logger.info("Error al obtener el inventario operacion por compañía y producto");
			throw new Exception("Error al obtener el inventario operacion por compañía y producto");
		}
		return inventoryOperationDTOLst;
	}
}
