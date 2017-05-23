package com.mx.fic.inventory.business.builder;

import com.mx.fic.inventory.business.builder.config.AbstractDTOBuilder;
import com.mx.fic.inventory.business.builder.config.BuilderConfiguration;
import com.mx.fic.inventory.dto.BaseDTO;
import com.mx.fic.inventory.dto.SecretQuestionDTO;
import com.mx.fic.inventory.persistent.BaseEntity;
import com.mx.fic.inventory.persistent.SecretQuestion;

@BuilderConfiguration (dtoClass=SecretQuestionDTO.class, entityClass= SecretQuestion.class)
public class SecretQuestionBuilder extends AbstractDTOBuilder{

	public BaseDTO createDTO(BaseEntity entity) {
		final SecretQuestionDTO secretQuestionDTO= new SecretQuestionDTO();
		final SecretQuestion secretQuestion= (SecretQuestion)entity;
		
		secretQuestionDTO.setId(secretQuestion.getId());
		secretQuestionDTO.setQuestion(secretQuestion.getQuestion());
		
		return secretQuestionDTO;
	}

}
