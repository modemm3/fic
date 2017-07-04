package com.mx.fic.inventory.business;

import java.util.List;

import javax.ejb.Local;

import com.mx.fic.inventory.business.exception.PersistenceException;
import com.mx.fic.inventory.dto.TypeAddressDTO;

@Local
public interface TypeAddressBeanLocal {

	void save(TypeAddressDTO typeAddressDTO) throws PersistenceException;

	List<TypeAddressDTO> getAllByCompany(Integer companyId) throws PersistenceException;

}