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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
	
	private static final Logger logger = LoggerFactory.getLogger(InventoryBean.class);

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(final InventoryDTO inventoryDTO) throws PersistenceException, Exception{
		final Inventory inventory = new Inventory();
	    final Company company = new Company();
	    final Product product = new Product();
	    
	    logger.info("Entra a guardar el inventoryDTO => "+ inventoryDTO);
	    
	    try{
	    
	    	company.setId(inventoryDTO.getCompanyId());
	    	inventory.setCompany(company);
	    	inventory.setCurrentStock(inventoryDTO.getCurrentStock());
	    	if(inventoryDTO.getProductDTO()!=null){
	    		product.setId(inventoryDTO.getProductDTO().getId());
	    	}
	    	inventory.setProduct(product);
	    	
	    	entityManager.persist(inventory);
	    	
		}catch(EntityExistsException | IllegalArgumentException | TransactionRequiredException e ){
			e.printStackTrace();
			throw new PersistenceException("fail al guardar el inventario");
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception("fail save inventory ");
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
			e.printStackTrace();
			throw new PersistenceException("fail al obtener los inventarios por compañía");
		} catch(Exception e){
			e.printStackTrace();
			throw new Exception ("fail save");
		}
	
		return inventoryDTOLst;
	}
	
	public Inventory findProductByCompany(final ProductDTO productDTO) throws PersistenceException, Exception{
		List<Inventory>  inventoryLst = new ArrayList<Inventory>();
		Inventory inventoryExist= null;
		Integer count =0;
		
		try{
			TypedQuery<Inventory> query = entityManager.createNamedQuery("Inventory.findProductByCompany", Inventory.class);
			query.setParameter("id", productDTO.getCompanyId());
			query.setParameter("idProduct", productDTO.getId());
			
			inventoryLst= query.getResultList();
			
			if(inventoryLst!=null && inventoryLst.size()>0){
				inventoryExist= inventoryLst.get(0);
			}
		
		}catch(EntityExistsException | IllegalArgumentException | TransactionRequiredException e ){
			e.printStackTrace();
			throw new PersistenceException("fail al obtener el inventario por producto y compañía");
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception("fail Exception");
		}
		
		return inventoryExist;
	}
	
	public InventoryDTO getOperationInventory(final OperationsDTO operationsDTO) throws PersistenceException, Exception{
		Inventory inventory = null;
		InventoryDTO inventoryDTO = null;
		MovementConcept movementConcept= null;
		Double newStock=0.0;
		
		System.out.println("Se imprime el producto de operaciones => "+ operationsDTO.getProductDTO() );
		inventory = findProductByCompany(operationsDTO.getProductDTO());
		
		try{
			if(inventory!=null && (inventory.getId()!=null && inventory.getId()!=0)){
				TypedQuery<MovementConcept>  query = entityManager.createNamedQuery("Operations.getMovementConcept", MovementConcept.class);
				query.setParameter("movementTypeId", operationsDTO.getMovementTypeId());
				
				movementConcept= query.getSingleResult();
				
				if(movementConcept!=null){
						if(movementConcept.getName().toUpperCase().equals("ENTRADAS")){
							newStock= inventory.getCurrentStock() + operationsDTO.getStocks();
						}else if(movementConcept.getName().toUpperCase().equals("SALIDAS")){
							newStock= inventory.getCurrentStock() + operationsDTO.getStocks();
						}else{
							newStock= operationsDTO.getStocks();
						}
						
						inventory.setCurrentStock(newStock);
				}else{
					logger.info("fail, el movement concept en getOperationInventory no existe");
					throw new PersistenceException("No existe ningun concepto de movimiento");
				}
			}
			else{
				inventoryDTO = new InventoryDTO();
				inventoryDTO.setCompanyId(operationsDTO.getCompanyId());
				inventoryDTO.setCurrentStock( operationsDTO.getStocks());
				inventoryDTO.setProductDTO(operationsDTO.getProductDTO());
			}
		}catch(EntityExistsException | IllegalArgumentException | TransactionRequiredException e ){
			e.printStackTrace();
			throw new PersistenceException("fail al obtener el inventario en getOperationInventory ");
		}catch(Exception e ){
			e.printStackTrace();
			throw new Exception("fail exception");
		}			
		
		return inventoryDTO;
		
	}

}
