package com.mx.fic.inventory.business.builder;

import com.mx.fic.inventory.business.builder.config.AbstractDTOBuilder;
import com.mx.fic.inventory.business.builder.config.BuilderConfiguration;
import com.mx.fic.inventory.business.builder.config.TransferObjectAssembler;
import com.mx.fic.inventory.dto.BaseDTO;
import com.mx.fic.inventory.dto.SecretQuestionDTO;
import com.mx.fic.inventory.dto.UserDTO;
import com.mx.fic.inventory.persistent.BaseEntity;
import com.mx.fic.inventory.persistent.User;

@BuilderConfiguration (dtoClass= UserDTO.class, entityClass= User.class)
public class UserBuilder extends AbstractDTOBuilder{

	public BaseDTO createDTO(BaseEntity entity) {
		UserDTO userDTO = new UserDTO();
		User user= (User) entity;
		
		userDTO.setActive(user.getActive());
		userDTO.setCreationDate(user.getCreationDate());
		userDTO.setId(user.getId());
		userDTO.setLastAccess(user.getLastAccess());
		userDTO.setModificationDate(user.getModificationDate());
		if(user.getModifyBy()!=null){			
			userDTO.setModifyBy(TransferObjectAssembler.getInstance().assembleTO(UserDTO.class, user.getModifyBy()));
		}
		userDTO.setName(user.getName());
		userDTO.setPassword(user.getPassword());
		userDTO.setPasswordChangeDate(user.getPasswordChangeDate());
		userDTO.setPasswordChangeEnable(user.getPasswordChangeEnable());
		userDTO.setPasswordChangeNotification(user.getPasswordChangeNotification());
		userDTO.setResponseSecret(user.getResponseSecret());
		if(user.getSecretQuestion()!=null){
			userDTO.setSecretQuestionDTO(TransferObjectAssembler.getInstance().assembleTO(SecretQuestionDTO.class, user.getSecretQuestion()));
		}
		return userDTO;
	}

}
