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
import com.mx.fic.inventory.dto.ProductDTO;
import com.mx.fic.inventory.persistent.Company;
import com.mx.fic.inventory.persistent.MeasureUnit;
import com.mx.fic.inventory.persistent.Product;
import com.mx.fic.inventory.persistent.Status;

@Local
@Stateless (mappedName="ProductBean")
@TransactionManagement (TransactionManagementType.CONTAINER)
public class ProductBean{
	//@PersistenceUnit(unitName="unit-fic")
	@PersistenceContext
	private EntityManager entityManager;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(final ProductDTO productDTO) throws PersistenceException {
		/*
		 * Agregar la fecha de creacion del producto
		 * */
		final Product product= new Product();
		final MeasureUnit measureUnit= new MeasureUnit();
		final Company company= new Company();
		final Status status= new Status();
		try{
			measureUnit.setId(productDTO.getMeasureUnitDTO().getId());
			measureUnit.setName(productDTO.getMeasureUnitDTO().getName());
			company.setId(productDTO.getCompanyDTO().getId());
			company.setName(productDTO.getCompanyDTO().getName());
			status.setId(productDTO.getStatusDTO().getId());
			status.setName(productDTO.getStatusDTO().getName());
			
			product.setCompany(company);
			product.setMeasure(measureUnit);
			product.setStatus(status);
			product.setBarcode(productDTO.getBarCode());
			product.setDescription(productDTO.getDescription());
			product.setMaximumStock(productDTO.getMaximumStock());
			product.setMinimumStock(productDTO.getMinimunStock());
			product.setName(productDTO.getName());
			
			entityManager.persist(product);
		}catch(EntityExistsException | IllegalArgumentException | TransactionRequiredException e ){
			throw new PersistenceException("Errror al guardar en la tabla de productos");
		}
	}
	
	public List<ProductDTO> getAllByCompany(final Integer idCompany) throws PersistenceException {
		List<ProductDTO> productDTOLst = new ArrayList<ProductDTO>();
		List<Product> productLst= new ArrayList<Product>();
		ProductDTO productDTO = null;
		
		TypedQuery<Product> queryProduct= entityManager.createNamedQuery("Product.getAllByCompany",Product.class);
		queryProduct.setParameter("id", idCompany );
		
		productLst = queryProduct.getResultList();
		
		if(productLst!= null && productLst.size()>0){
			productDTOLst = new ArrayList<ProductDTO>();
			for(Product p: productLst){
				productDTO=TransferObjectAssembler.getInstance().assembleTO(productDTO.getClass(), p);
				productDTOLst.add(productDTO);
			}
		}
		
		
		return productDTOLst;
	}
	
	/*public List<ProductDTO> deleteProductByCompany(final ProductDTO productDTO){
		
	}*/

}
