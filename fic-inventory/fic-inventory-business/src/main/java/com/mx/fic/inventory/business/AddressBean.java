package com.mx.fic.inventory.business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TransactionRequiredException;
import javax.persistence.TypedQuery;

import com.mx.fic.inventory.business.builder.config.TransferObjectAssembler;
import com.mx.fic.inventory.business.exception.PersistenceException;
import com.mx.fic.inventory.dto.AddressDTO;
import com.mx.fic.inventory.persistent.Address;
import com.mx.fic.inventory.persistent.Company;
import com.mx.fic.inventory.persistent.Status;
import com.mx.fic.inventory.persistent.TypeAddress;
import com.mx.fic.inventory.services.AddressBeanLocal;

@Stateless (mappedName = "AddressBean")
@TransactionManagement (TransactionManagementType.CONTAINER)
public class AddressBean implements AddressBeanLocal{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(final AddressDTO addressDTO) throws PersistenceException{
		final Address address = new Address();
		final TypeAddress typeAddress = new TypeAddress();
		final Company company = new Company();
		final Status status = new Status();
		
		try{
			
			address.setCity(addressDTO.getCity());
			address.setColony(addressDTO.getColony());
			address.setExteriorNumber(addressDTO.getExteriorNumber());
			address.setInteriorNumber(addressDTO.getInteriorNumber());
			address.setPostalCode(addressDTO.getPostalCode());
			address.setState(addressDTO.getState());
			address.setStreet(addressDTO.getStreet());
			address.setTown(addressDTO.getTown());
			
			typeAddress.setId(addressDTO.getTypeAddressId());
			company.setId(addressDTO.getCompanyId());
			status.setId(addressDTO.getStatusId());
			
			address.setTypeAddress(typeAddress);
			address.setStatus(status);
			address.setCompany(company);
			
			entityManager.persist(address);
		}catch(EntityExistsException | IllegalArgumentException | TransactionRequiredException e ){
			throw new PersistenceException("Errror al guardar en la tabla de productos");
		}
	}
	
	public List<AddressDTO> getAllByCompany(final Integer companyId) throws PersistenceException{
		List<AddressDTO> addressDTOLst = null;
		List<Address> addressLst = null;
		AddressDTO addressDTO = null;
		
		TypedQuery<Address> queryAddress = entityManager.createNamedQuery("Address.getAllByCompany", Address.class);
		queryAddress.setParameter("id", companyId);
		
		addressLst = queryAddress.getResultList();
		
		if(addressLst!= null && addressLst.size()>0){
			addressDTOLst = new ArrayList<AddressDTO>();
			for(Address a : addressLst){
				addressDTO = TransferObjectAssembler.getInstance().assembleTO(AddressDTO.class, a);
				addressDTOLst.add(addressDTO);
			}
		}
		
		return addressDTOLst;
		
	}

}
