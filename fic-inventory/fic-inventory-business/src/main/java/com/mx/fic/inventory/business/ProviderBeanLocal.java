package com.mx.fic.inventory.business;

import java.util.List;

import javax.ejb.Local;

import com.mx.fic.inventory.business.exception.PersistenceException;
import com.mx.fic.inventory.dto.ProviderDTO;

@Local
public interface ProviderBeanLocal {

	void save(ProviderDTO providerDTO) throws PersistenceException;

	List<ProviderDTO> getAllByCompany(Integer companyId) throws PersistenceException;

}