package com.mx.fic.inventory.business;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
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
import com.mx.fic.inventory.persistent.Company;
import com.mx.fic.inventory.persistent.Operations;
import com.mx.fic.inventory.persistent.Product;
import com.mx.fic.inventory.persistent.Status;
import com.mx.fic.inventory.persistent.TimeUnit;

@Stateless (mappedName= "OperationsBean")
@TransactionManagement (TransactionManagementType.CONTAINER)
public class OperationsBean implements OperationsBeanLocal {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@EJB (mappedName="ProductBean")
	private ProductBeanLocal productBean;
	
	@EJB (mappedName="InventoryBean")
	private InventoryBeanLocal inventoryBean;
	
	private static final Logger logger = LoggerFactory.getLogger(OperationsBean.class);


	/* (non-Javadoc)
	 * @see com.mx.fic.inventory.business.OperationsBeanLocal#save(com.mx.fic.inventory.dto.OperationsDTO)
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(final OperationsDTO operationsDTO) throws PersistenceException, Exception{
		final Operations operations = new Operations();
		final Product product = new Product();
		final Status status = new Status();
		final Company company = new Company();
		final TimeUnit timeUnit = new TimeUnit();
		InventoryDTO inventoryDTO = new InventoryDTO();
		boolean existProduct = false;
		Integer productId = 0;
		
		try{
			
			if(operationsDTO.getProductDTO().getId()== null || operationsDTO.getProductDTO().getId()==0){
				
				existProduct = productBean.productExists(operationsDTO.getProductDTO());
				
				if(existProduct){
					logger.info("error=> el producto ya existe, no puede ser insertado nuevamente");
					throw new PersistenceException("error=> el producto ya existe, no puede ser insertado nuevamente");
				}else{
					productId= productBean.save(operationsDTO.getProductDTO());
					operationsDTO.getProductDTO().setId(productId);
				}
				
			}else{
				productId = operationsDTO.getProductDTO().getId();
			}
			if(productId!=0){
				company.setId(operationsDTO.getCompanyId());
				operations.setCompany(company);
				
				operations.setUnitPrice(operationsDTO.getUnitPrice());
				
				if(operationsDTO.getProductDTO() != null){
					operationsDTO.getProductDTO().setCompanyId(operationsDTO.getCompanyId());
					product.setId(operationsDTO.getProductDTO().getId());
					product.setCompany(company);
					operations.setProduct(product);
				}
				
				
				status.setId(operationsDTO.getStatusId());
				operations.setStatus(status);
				
				operations.setStocks(operationsDTO.getStocks());
				
				timeUnit.setId(operationsDTO.getTimeUnitId());			
				operations.setTimeUnit(timeUnit);
				
				entityManager.persist(operations);
				
				inventoryDTO = inventoryBean.getOperationInventory(operationsDTO);
				
				logger.info("Se obtuvo el inventario => "+ inventoryDTO);
				
				if(inventoryDTO!=null && inventoryDTO.getCurrentStock()!=null){
					inventoryBean.save(inventoryDTO);
				}
				
			}else{
				logger.info("error => El id del producto es 0");
				throw new PersistenceException("error => El id del producto es 0");
			}
		}catch(EntityExistsException | IllegalArgumentException | TransactionRequiredException e ){
			e.printStackTrace();
			throw new PersistenceException("Error al guardar las operaciones");
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception("Ocurrió un error al guardar la operación");
		}
	}
	
	/* (non-Javadoc)
	 * @see com.mx.fic.inventory.business.OperationsBeanLocal#getAllByCompany(java.lang.Integer)
	 */
	@Override
	public List<OperationsDTO> getAllByCompany(final Integer companyId) throws PersistenceException{
		List<OperationsDTO> operationsDTOLst = null;
		OperationsDTO operationsDTO = null;
		List<Operations> operationsLst = new ArrayList<Operations>();
		
		TypedQuery<Operations> query = entityManager.createNamedQuery("Operations.getAllByCompany", Operations.class);
		query.setParameter("id", companyId);
		operationsLst= query.getResultList();
		
		if(operationsLst!= null && operationsLst.size()>0){
			operationsDTOLst = new ArrayList<OperationsDTO>();
			for(Operations op: operationsLst){
				operationsDTO = TransferObjectAssembler.getInstance().assembleTO(OperationsDTO.class, op);
				operationsDTOLst.add(operationsDTO);
			}
		}
		return operationsDTOLst;
	}

}
