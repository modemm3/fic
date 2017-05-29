package com.mx.fic.inventory.business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
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
import com.mx.fic.inventory.dto.ProviderDTO;
import com.mx.fic.inventory.persistent.Company;
import com.mx.fic.inventory.persistent.Provider;
import com.mx.fic.inventory.persistent.Status;
import com.mx.fic.inventory.persistent.TypePerson;

@Local
@Stateless (mappedName = "ProviderBean")
@TransactionManagement (TransactionManagementType.CONTAINER)
public class ProviderBean {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(final ProviderDTO providerDTO) throws PersistenceException{
		final Provider provider = new Provider();
		final Company company = new Company();
		final Status status = new Status();
		final TypePerson typePerson = new TypePerson();
		
		try{
			
			company.setId(providerDTO.getCompanyId());
			provider.setCompany(company);
			provider.setEmail(providerDTO.getEmail());
			provider.setLastName(providerDTO.getLastName());
			provider.setName(providerDTO.getName());
			provider.setReasonSocial(providerDTO.getReasonSocial());
			provider.setRfc(providerDTO.getRfc());
			status.setId(providerDTO.getStatusId());
			provider.setStatus(status);
			provider.setSurName(providerDTO.getSurName());
			typePerson.setId(providerDTO.getTypePersonId());
			provider.setTypePerson(typePerson);
			
			entityManager.persist(provider);
			
		}catch(EntityExistsException | IllegalArgumentException | TransactionRequiredException e ){
			throw new PersistenceException("Erro al guardar al proveedor");
		}
	}
	
	public List<ProviderDTO> getAllByCompany(final Integer companyId) throws PersistenceException{
		List<ProviderDTO> providerDTOLst = null;
		List<Provider> providerLst = new ArrayList<Provider>();
		ProviderDTO providerDTO = null;
		
		TypedQuery<Provider> query = entityManager.createNamedQuery("Provider.getAllByCompany", Provider.class);
		query.setParameter("id", companyId);
		providerLst = query.getResultList();
		
		if(providerLst!=null && providerLst.size()>0){
			providerDTOLst = new ArrayList<ProviderDTO>();
			
			for(Provider pr : providerLst){
				providerDTO = TransferObjectAssembler.getInstance().assembleTO(ProviderDTO.class, pr);
				providerDTOLst.add(providerDTO);
			}
		}
		
		return providerDTOLst;
	}
	
}
