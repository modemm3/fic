package com.mx.fic.inventory.business;

import javax.ejb.Local;

import com.mx.fic.inventory.business.exception.PersistenceException;
import com.mx.fic.inventory.request.CompanyRequest;

@Local
public interface CompanyBeanLocal {

	void saveCompanyAddress(CompanyRequest request) throws PersistenceException, Exception;

}