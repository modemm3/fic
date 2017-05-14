package com.mx.fic.inventory.business;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
	@PersistenceContext(unitName="unit-fic")
	private EntityManager entityManager;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(final ProductDTO productDTO) {
		/*
		 * Agregar la fecha de creacion del producto
		 * */
		final Product product= new Product();
		final MeasureUnit measureUnit= new MeasureUnit();
		final Company company= new Company();
		final Status status= new Status();
		
		measureUnit.setId(productDTO.getMeasureUnitDTO().getId());
		measureUnit.setName(productDTO.getMeasureUnitDTO().getName());
		company.setId(productDTO.getCompanyDTO().getId());
		company.setName(productDTO.getCompanyDTO().getName());
		status.setId(productDTO.getStatusDTO().getId());
		status.setName(productDTO.getStatusDTO().getName());
		
		product.setCompany(company);
		product.setMeasureUnit(measureUnit);
		product.setStatus(status);
		product.setBarcode(productDTO.getBarCode());
		product.setDescription(productDTO.getDescription());
		product.setMaximumStock(productDTO.getMaximumStock());
		product.setMinimumStock(productDTO.getMinimunStock());
		product.setName(productDTO.getName());
		
		entityManager.persist(product);
		
	}

}
