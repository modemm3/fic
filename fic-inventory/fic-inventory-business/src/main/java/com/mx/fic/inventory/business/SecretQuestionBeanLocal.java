package com.mx.fic.inventory.business;

import java.util.List;

import javax.ejb.Local;

import com.mx.fic.inventory.dto.SecretQuestionDTO;

@Local
public interface SecretQuestionBeanLocal {

	List<SecretQuestionDTO> getAll();

}