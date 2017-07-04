package com.mx.fic.inventory.business;

import java.util.List;

import javax.ejb.Local;

import com.mx.fic.inventory.business.exception.PersistenceException;
import com.mx.fic.inventory.dto.SeasonDTO;

@Local
public interface SeasonBeanLocal {

	void save(SeasonDTO seasonDTO) throws PersistenceException;

	List<SeasonDTO> getAllByCompany(Integer companyId) throws PersistenceException;

}