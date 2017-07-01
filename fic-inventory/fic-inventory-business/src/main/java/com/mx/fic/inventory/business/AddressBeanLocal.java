package com.mx.fic.inventory.business;

import java.util.List;

import javax.ejb.Local;

import com.mx.fic.inventory.business.exception.PersistenceException;
import com.mx.fic.inventory.dto.AddressDTO;

@Local
public interface AddressBeanLocal {

	/* (non-Javadoc)
	 * @see com.mx.fic.inventory.business.AddressBeanLocal#save(com.mx.fic.inventory.dto.AddressDTO)
	 */
	void save(AddressDTO addressDTO) throws PersistenceException;

	/* (non-Javadoc)
	 * @see com.mx.fic.inventory.business.AddressBeanLocal#getAllByCompany(java.lang.Integer)
	 */
	List<AddressDTO> getAllByCompany(Integer companyId) throws PersistenceException;

}