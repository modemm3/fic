package com.mx.fic.inventory.business;

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
import com.mx.fic.inventory.services.ProductRemote;



@Stateless (mappedName="ProductBean")
@TransactionManagement (TransactionManagementType.CONTAINER)
public class ProductBean implements ProductRemote{
//	@PersistenceUnit(unitName="unit-fic")
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
		
		status.setId(1);
		status.setName("Pendiente");
		status.setDescription("Ninguno");
		
		product.setBarcode("codigo de pruebas");
		product.setDescription("descripcion de prueba");
		product.setMaximumStock(23);
		product.setMinimumStock(1);
		product.setName("Leche lala");
		measureUnit.setId(1);
		measureUnit.setDescription("descripcion mesasure");
		measureUnit.setName("measure");
		product.setMeasureUnit(measureUnit);
		company.setId(1);
		company.setName("compania uno");
		product.setCompany(company);
		product.setStatus(status);
		System.out.println("Enti=> "+ entityManager);
		entityManager.persist(status);
		
	}

}
