package com.mx.fic.inventory.business.builder.config;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import com.mx.fic.inventory.dto.BaseDTO;
import com.mx.fic.inventory.persistent.BaseEntity;

@Retention(RetentionPolicy.RUNTIME)
public @interface BuilderConfiguration {

	Class<? extends BaseEntity> entityClass();
	Class<? extends BaseDTO> dtoClass();

}
