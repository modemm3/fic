package com.mx.fic.inventory.business;

import java.util.List;

import javax.ejb.Local;

import com.mx.fic.inventory.business.exception.PersistenceException;
import com.mx.fic.inventory.dto.MeasureUnitDTO;

@Local
public interface MeasureUnitBeanLocal {

	void save(MeasureUnitDTO measureUnitDTO) throws PersistenceException;

	List<MeasureUnitDTO> getAllByCompany(Integer idCompany) throws PersistenceException;

}