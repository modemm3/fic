package com.mx.fic.inventory.business.builder;

import com.mx.fic.inventory.business.builder.config.AbstractDTOBuilder;
import com.mx.fic.inventory.business.builder.config.BuilderConfiguration;
import com.mx.fic.inventory.dto.BaseDTO;
import com.mx.fic.inventory.dto.UserDetailDTO;
import com.mx.fic.inventory.persistent.BaseEntity;
import com.mx.fic.inventory.persistent.UserDetail;

@BuilderConfiguration (dtoClass = UserDetailDTO.class, entityClass= UserDetail.class)
public class UserDetailBuilder extends AbstractDTOBuilder {

	public BaseDTO createDTO(BaseEntity entity) {
		UserDetailDTO userDetailDTO = new UserDetailDTO();
		UserDetail userDetail = (UserDetail) entity;
		
		userDetailDTO.setAddress(userDetail.getAddress());
		userDetailDTO.setCurp(userDetail.getCurp());
		userDetailDTO.setEmail(userDetail.getEmail());
		userDetailDTO.setId(userDetail.getId());
		userDetailDTO.setLastAccess(userDetail.getLastAccess());
		userDetailDTO.setLastName(userDetail.getLastName());
		userDetailDTO.setName(userDetail.getName());
		userDetailDTO.setRfc(userDetail.getRfc());
		userDetailDTO.setShortName(userDetail.getShortName());
		userDetailDTO.setSurName(userDetail.getSurName());
		
		return userDetailDTO;
	}

}
