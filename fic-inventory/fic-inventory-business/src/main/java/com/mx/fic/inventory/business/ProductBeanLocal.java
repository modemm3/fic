package com.mx.fic.inventory.business;

import java.util.List;

import javax.ejb.Local;

import com.mx.fic.inventory.business.exception.PersistenceException;
import com.mx.fic.inventory.dto.ProductDTO;

@Local
public interface ProductBeanLocal {

	Integer save(ProductDTO productDTO) throws PersistenceException;

	List<ProductDTO> getAllByCompany(Integer idCompany) throws PersistenceException;

	boolean productExists(ProductDTO productDTO) throws PersistenceException;

}