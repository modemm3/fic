package com.mx.fic.inventory.persistent;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

/**
 * Country entity
 *
 */
public class Country 
{
	@GeneratedValue
	private Integer id;
	@Column
	private String name;
	
}
