package com.mx.fic.inventory.business;

import java.util.List;

import javax.ejb.Local;

import com.mx.fic.inventory.business.exception.PersistenceException;
import com.mx.fic.inventory.dto.MovementConceptDTO;

@Local
public interface MovementConceptBeanLocal {

	void save(MovementConceptDTO movementConceptDTO) throws PersistenceException;

	List<MovementConceptDTO> getAllByCompany(Integer companyId) throws PersistenceException;

}