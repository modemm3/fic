package com.mx.fic.inventory.business;

import java.util.List;

import javax.ejb.Local;

import com.mx.fic.inventory.business.exception.PersistenceException;
import com.mx.fic.inventory.dto.TypePersonDTO;

@Local
public interface TypePersonBeanLocal {

	void save(TypePersonDTO typePersonDTO) throws PersistenceException;

	List<TypePersonDTO> getAllByCompany(Integer companyId) throws PersistenceException;

}