package com.mx.fic.inventory.business;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@LocalBean
@Stateless (mappedName= "UserBean")
@TransactionManagement (TransactionManagementType.CONTAINER)
public class UserBean {
	
	@PersistenceContext(unitName= "unit-fic")
	private EntityManager entityManager;
	
	public void save(){
		
	}

}
