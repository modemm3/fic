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

import com.mx.fic.inventory.dto.InventoryDTO;
import com.mx.fic.inventory.dto.OperationsDTO;
import com.mx.fic.inventory.dto.ProductDTO;
import com.mx.fic.inventory.persistent.Company;
import com.mx.fic.inventory.persistent.Inventory;
import com.mx.fic.inventory.persistent.MovementConcept;
import com.mx.fic.inventory.persistent.Product;

@Local
@Stateless (mappedName="InventoryBean")
@TransactionManagement (TransactionManagementType.CONTAINER)
public class InventoryBean {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(final InventoryDTO inventoryDTO) throws PersistenceException, Exception{
		final Inventory inventory = new Inventory();
	    final Company company = new Company();
	    final Product product = new Product();
	    
	    try{
	    	company.setId(inventoryDTO.getCompanyId());
	    	inventory.setCompany(company);
	    	inventory.setCurrentStock(inventoryDTO.getCurrentStock());
	    	product.setId(inventoryDTO.getProductDTO().getId());
	    	inventory.setProduct(product);
	    	
	    	entityManager.persist(inventory);
	    	
		}catch(EntityExistsException | IllegalArgumentException | TransactionRequiredException e ){
			throw new PersistenceException("Error al guardar el inventario");
		}  
	}
	
	public List<InventoryDTO> getAllByCompany(final Integer companyId) throws PersistenceException, Exception{
		List<InventoryDTO> inventoryDTOLst = null;
		InventoryDTO inventoryDTO = null;
		List<Inventory> inventoryLst = new ArrayList<Inventory>();
		
		try{
			TypedQuery<Inventory> query = entityManager.createNamedQuery("Inventory.getAllByCompany", Inventory.class);
			query.setParameter("id",companyId);
			inventoryLst = query.getResultList();
			
			if(inventoryLst!= null && inventoryLst.size()>0){
				inventoryDTOLst = new ArrayList<InventoryDTO>();
				for(Inventory i : inventoryLst){
					inventoryDTO = TransferObjectAssembler.getInstance().assembleTO(InventoryDTO.class, i);
					inventoryDTOLst.add(inventoryDTO);
				}
			}
		}catch(EntityExistsException | IllegalArgumentException | TransactionRequiredException e ){
			throw new PersistenceException("Error al guardar el inventario");
		} 
	
		return inventoryDTOLst;
	}
	
	public InventoryDTO findProductByCompany(final ProductDTO productDTO) throws PersistenceException, Exception{
		InventoryDTO inventoryDTO = new InventoryDTO();
		List<Inventory>  inventoryLst = new ArrayList<Inventory>();
		List<InventoryDTO> inventoryDTOLst = null;
		Integer count =0;
		
		try{
			TypedQuery<Inventory> query = entityManager.createNamedQuery("Inventory.findProductByCompany", Inventory.class);
			query.setParameter("id", productDTO.getCompanyId());
			query.setParameter("idProduct", productDTO.getId());
			
			inventoryLst= query.getResultList();
			
			if(inventoryLst!=null && inventoryLst.size()>0){
				inventoryDTOLst = new ArrayList<InventoryDTO>();
				for(Inventory i : inventoryLst){
					inventoryDTO =TransferObjectAssembler.getInstance().assembleTO(InventoryDTO.class, i);
					inventoryDTOLst.add(inventoryDTO);
				}
			}
			if(inventoryDTOLst!=null && inventoryDTOLst.size()>0){
				count = inventoryDTOLst.size();
				if(count>1){
					throw new PersistenceException("Se encontra mas de un registro para la compaia => "+ productDTO.getCompanyId() + " product => "+ productDTO.getId());
				}
			}
		
		}catch(EntityExistsException | IllegalArgumentException | TransactionRequiredException e ){
			throw new PersistenceException("Erro al guardar los estatus");
		}
		
		return inventoryDTO;
	}
	
	public InventoryDTO getOperationInventory(final OperationsDTO operationsDTO) throws PersistenceException, Exception{
		InventoryDTO inventoryDTO = new InventoryDTO();
		MovementConcept movementConcept= null;
		Double newStock=0.0;
		
		inventoryDTO = findProductByCompany(operationsDTO.getProductDTO());
		
		try{
			if(inventoryDTO!=null && (inventoryDTO.getId()!=null && inventoryDTO.getId()!=0)){
				TypedQuery<MovementConcept>  query = entityManager.createNamedQuery("Operations.getMovementConcept", MovementConcept.class);
				query.setParameter("movementTypeId", operationsDTO.getMovementTypeId());
				
				movementConcept= query.getSingleResult();
				
			if(movementConcept!=null){
					if(movementConcept.getName().equals("entradas")){
						newStock= inventoryDTO.getCurrentStock() + operationsDTO.getStocks();
					}else if(movementConcept.getName().equals("salidas")){
						newStock= inventoryDTO.getCurrentStock() + operationsDTO.getStocks();
					}else{
						newStock= operationsDTO.getStocks();
					}
					
					inventoryDTO.setCurrentStock(newStock);
			}else{
				inventoryDTO.setCompanyId(operationsDTO.getCompanyId());
				inventoryDTO.setCurrentStock( operationsDTO.getStocks());
				inventoryDTO.setProductDTO(operationsDTO.getProductDTO());
			}
			}
		}catch(EntityExistsException | IllegalArgumentException | TransactionRequiredException e ){
			throw new PersistenceException("Erro al obtener el inventario");
		}			
		
		return inventoryDTO;
		
	}

}
