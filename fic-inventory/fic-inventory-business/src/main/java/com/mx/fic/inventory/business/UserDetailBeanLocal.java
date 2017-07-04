package com.mx.fic.inventory.business;

import javax.ejb.Local;

import com.mx.fic.inventory.dto.UserDetailDTO;

@Local
public interface UserDetailBeanLocal {

	void save(UserDetailDTO userDetailDTO);

}