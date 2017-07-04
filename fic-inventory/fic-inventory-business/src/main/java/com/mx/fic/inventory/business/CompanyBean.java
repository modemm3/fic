package com.mx.fic.inventory.business;

import java.sql.Timestamp;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TransactionRequiredException;

import com.mx.fic.inventory.business.exception.PersistenceException;
import com.mx.fic.inventory.persistent.Address;
import com.mx.fic.inventory.persistent.Company;
import com.mx.fic.inventory.persistent.Status;
import com.mx.fic.inventory.persistent.TypeAddress;
import com.mx.fic.inventory.request.CompanyRequest;

//@Local
@Stateless (mappedName= "CompanyBean")
@TransactionManagement (TransactionManagementType.CONTAINER)
public class CompanyBean implements CompanyBeanLocal{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	/* (non-Javadoc)
	 * @see com.mx.fic.inventory.business.CompanyBeanLocal#saveCompanyAddress(com.mx.fic.inventory.request.CompanyRequest)
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void saveCompanyAddress(CompanyRequest request) throws PersistenceException, Exception{
		final Company company = new Company();
		final Status status = new Status();
		final Address address = new Address();
		final TypeAddress typeAddress = new TypeAddress();
		
		try{
			company.setContactName(request.getCompanyDTO().getContactName());
			company.setCreationDate(request.getCompanyDTO().getCreationDate());
			company.setEmail(request.getCompanyDTO().getEmail());
			company.setName(request.getCompanyDTO().getName());
			company.setReasonSocial(request.getCompanyDTO().getReasonSocial());
			company.setRfc(request.getCompanyDTO().getRfc());
			company.setCreationDate(new Timestamp(System.currentTimeMillis()));
			company.setModifyDate(new Timestamp(System.currentTimeMillis()));
			
			status.setId(request.getCompanyDTO().getStatusId());
			company.setStatus(status);
			
			entityManager.persist(company);
			entityManager.flush();
			
			address.setCity(request.getAddressDTO().getCity());
			address.setColony(request.getAddressDTO().getColony());
			address.setCompany(company);
			address.setExteriorNumber(request.getAddressDTO().getExteriorNumber());
			address.setInteriorNumber(request.getAddressDTO().getInteriorNumber());
			address.setPostalCode(request.getAddressDTO().getPostalCode());
		    address.setState(request.getAddressDTO().getState());
		    address.setStatus(status);
		    address.setStreet(request.getAddressDTO().getStreet());
		    address.setTown(request.getAddressDTO().getTown());
		    typeAddress.setId(request.getAddressDTO().getTypeAddressId());
		    address.setTypeAddress(typeAddress);
		    
		    entityManager.persist(address);
		}catch(EntityExistsException | IllegalArgumentException | TransactionRequiredException e ){
			e.printStackTrace();
			throw new PersistenceException("Error al guardar la compañía");
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception("Exception al guardar la compañía");
		}
		
	}

}
