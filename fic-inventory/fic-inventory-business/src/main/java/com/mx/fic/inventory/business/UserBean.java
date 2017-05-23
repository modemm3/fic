package com.mx.fic.inventory.business;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mx.fic.inventory.dto.UserDTO;
import com.mx.fic.inventory.persistent.User;

@LocalBean
@Stateless (mappedName= "UserBean")
@TransactionManagement (TransactionManagementType.CONTAINER)
public class UserBean {
	
	@PersistenceContext(unitName= "unit-fic")
	private EntityManager entityManager;
	
	public void save(UserDTO userDTO){
		User user = new User();
		
		user.setActive(userDTO.getActive());
		user.setCreationDate(userDTO.getCreationDate());
		user.setLastAccess(userDTO.getLastAccess());
		user.setModificationDate(userDTO.getModificationDate());
		user.setModifyBy(user.getModifyBy());
		user.setName(user.getName());
		user.setPassword(user.getPassword());
		user.setPasswordChangeDate(user.getPasswordChangeDate());
		user.setPasswordChangeEnable(user.getPasswordChangeEnable());
		user.setPasswordChangeNotification(user.getPasswordChangeNotification());
		user.setResponseSecret(user.getResponseSecret());
		user.setSecretQuestion(user.getSecretQuestion());
	
		entityManager.persist(user);
	}

}
