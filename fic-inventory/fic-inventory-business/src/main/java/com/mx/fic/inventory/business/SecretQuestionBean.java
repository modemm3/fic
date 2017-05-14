package com.mx.fic.inventory.business;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mx.fic.inventory.dto.SecretQuestionDTO;

@Local
@Stateless (mappedName= "SecretQuestionBean")
@TransactionManagement (TransactionManagementType.CONTAINER)
public class SecretQuestionBean {
	
	@PersistenceContext(unitName="unit-fic")
	private EntityManager entityManager;
	
	public List<SecretQuestionDTO> getAll(){
		
		//final SecretQuestion secretQuestion();
	}

}
