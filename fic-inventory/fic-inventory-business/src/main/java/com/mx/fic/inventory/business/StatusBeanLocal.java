package com.mx.fic.inventory.business;

import java.util.List;

import javax.ejb.Local;

import com.mx.fic.inventory.business.exception.PersistenceException;
import com.mx.fic.inventory.dto.StatusDTO;

@Local
public interface StatusBeanLocal {

	void save(StatusDTO statusDTO) throws PersistenceException;

	List<StatusDTO> getAllByCompany(Integer idCompany) throws PersistenceException;

}