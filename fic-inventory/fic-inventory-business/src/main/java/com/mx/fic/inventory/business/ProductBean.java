package com.mx.fic.inventory.business;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import com.mx.fic.inventory.dto.ProductDTO;
import com.mx.fic.inventory.persistent.Company;
import com.mx.fic.inventory.persistent.MeasureUnit;
import com.mx.fic.inventory.persistent.Product;



@Local
@Stateless (mappedName="ProductBean")
@TransactionManagement (TransactionManagementType.CONTAINER)
public class ProductBean{
	@PersistenceContext
	private EntityManager entityManager;

	public void save(final ProductDTO productDTO) {
		Product product= new Product();
		MeasureUnit measureUnit= new MeasureUnit();
		Company company= new Company();
		
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
		
		entityManager.persist(product);
		
		entityManager.close();
	}

}
