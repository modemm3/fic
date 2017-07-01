package com.mx.fic.inventory.business;

import java.util.List;

import javax.ejb.Local;

import com.mx.fic.inventory.business.exception.PersistenceException;
import com.mx.fic.inventory.dto.MovementTypeDTO;

@Local
public interface MovementTypeBeanLocal {

	void save(MovementTypeDTO movementTypeDTO) throws PersistenceException;

	List<MovementTypeDTO> getAllByCompany(Integer companyId) throws PersistenceException;

}