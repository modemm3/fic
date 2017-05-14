package com.mx.fic.inventory.business;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import com.mx.fic.inventory.dto.ProductDTO;
import com.mx.fic.inventory.persistent.Company;
import com.mx.fic.inventory.persistent.MeasureUnit;
import com.mx.fic.inventory.persistent.Product;
import com.mx.fic.inventory.persistent.Status;



@Local
@Stateless (mappedName="ProductBean")
@TransactionManagement (TransactionManagementType.CONTAINER)
public class ProductBean{
	@PersistenceUnit(unitName="unit-fic")
	@PersistenceContext
	private EntityManager entityManager;

	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(final ProductDTO productDTO) {
		/*
		 * Agregar la fecha de creacion del producto
		 * */
		Product product= new Product();
		MeasureUnit measureUnit= new MeasureUnit();
		Company company= new Company();
		Status status= new Status();
		
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
