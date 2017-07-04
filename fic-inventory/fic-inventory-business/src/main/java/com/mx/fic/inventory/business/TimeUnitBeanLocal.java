package com.mx.fic.inventory.business;

import java.util.List;

import javax.ejb.Local;

import com.mx.fic.inventory.business.exception.PersistenceException;
import com.mx.fic.inventory.dto.TimeUnitDTO;

@Local
public interface TimeUnitBeanLocal {

	void save(TimeUnitDTO timeUnitDTO) throws PersistenceException;

	List<TimeUnitDTO> getAllByCompany(Integer companyId) throws PersistenceException;

}