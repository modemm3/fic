package com.mx.fic.inventory.business;

import javax.ejb.Local;

import com.mx.fic.inventory.dto.UserDTO;

@Local
public interface UserBeanLocal {

	void save(UserDTO userDTO);

}