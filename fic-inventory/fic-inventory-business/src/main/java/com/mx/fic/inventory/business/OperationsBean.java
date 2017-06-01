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
import com.mx.fic.inventory.dto.OperationsDTO;
import com.mx.fic.inventory.persistent.Company;
import com.mx.fic.inventory.persistent.MovementType;
import com.mx.fic.inventory.persistent.Operations;
import com.mx.fic.inventory.persistent.Product;
import com.mx.fic.inventory.persistent.Provider;
import com.mx.fic.inventory.persistent.Status;
import com.mx.fic.inventory.persistent.TimeUnit;

@Local
@Stateless (mappedName= "OperationsBean")
@TransactionManagement (TransactionManagementType.CONTAINER)
public class OperationsBean {
	
	@PersistenceContext
	private EntityManager entityManager;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(final OperationsDTO operationsDTO) throws PersistenceException{
		final Operations operations = new Operations();
		final MovementType movementType = new MovementType();
		final Product product = new Product();
		final Provider provider = new Provider();
		final Status status = new Status();
		final Company company = new Company();
		final TimeUnit timeUnit = new TimeUnit();
		
		
		try{
		
			company.setId(operationsDTO.getCompanyId());
			operations.setCompany(company);
			
			operations.setCreationDate(operationsDTO.getCreationDate());
			operations.setDeliveryTime(operationsDTO.getDeliveryTime());
			operations.setFolioDocument(operationsDTO.getFolioDocument());
			
			movementType.setId(operationsDTO.getMovementTypeId());
			operations.setMovementType(movementType);
			
			product.setId(operationsDTO.getProductId());
			operations.setProduct(product);
			
			provider.setId(operationsDTO.getProviderId());
			operations.setProvider(provider);
			
			status.setId(operationsDTO.getStatusId());
			operations.setStatus(status);
			
			operations.setStocks(operationsDTO.getStocks());
			
			timeUnit.setId(operationsDTO.getTimeUnitId());			
			operations.setTimeUnit(timeUnit);
			
			entityManager.persist(operations);
		}catch(EntityExistsException | IllegalArgumentException | TransactionRequiredException e ){
			throw new PersistenceException("Erro al guardar las operaciones");
		}
	}
	
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
