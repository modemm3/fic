package com.mx.fic.inventory.business;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mx.fic.inventory.dto.ProductDTO;



@Local
@Stateless (mappedName="ProductBean")
@TransactionManagement (TransactionManagementType.CONTAINER)
public class ProductBean{
	@PersistenceContext
	private EntityManager entityManager;

	public void save(final ProductDTO productDTO) {
		
	}

}
