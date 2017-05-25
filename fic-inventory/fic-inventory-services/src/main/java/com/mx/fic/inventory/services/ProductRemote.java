package com.mx.fic.inventory.services;

import javax.ejb.Remote;

import com.mx.fic.inventory.dto.ProductDTO;

@Remote
public interface ProductRemote {
	void save(final ProductDTO productDTO) throws Exception;
}
