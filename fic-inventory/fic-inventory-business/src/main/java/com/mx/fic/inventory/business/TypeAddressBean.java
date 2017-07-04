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
import com.mx.fic.inventory.dto.TypeAddressDTO;
import com.mx.fic.inventory.persistent.Company;
import com.mx.fic.inventory.persistent.TypeAddress;

//@Local
@Stateless (mappedName = "TypeAddressBean")
@TransactionManagement (TransactionManagementType.CONTAINER)
public class TypeAddressBean implements TypeAddressBeanLocal  {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	/* (non-Javadoc)
	 * @see com.mx.fic.inventory.business.TypeAddressBeanLocal#save(com.mx.fic.inventory.dto.TypeAddressDTO)
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(final TypeAddressDTO typeAddressDTO) throws PersistenceException{
		final TypeAddress typeAddress = new TypeAddress();
		final Company company = new Company();
		
		try{
			
			company.setId(typeAddressDTO.getCompanyId());
			typeAddress.setDescription(typeAddressDTO.getDescription());
			typeAddress.setName(typeAddressDTO.getName());
			typeAddress.setCompany(company);
			
			entityManager.persist(typeAddress);
			
		}catch(EntityExistsException | IllegalArgumentException | TransactionRequiredException e ){
			throw new PersistenceException("Erro al guardar las temporadas");
		}
	}
	
	/* (non-Javadoc)
	 * @see com.mx.fic.inventory.business.TypeAddressBeanLocal#getAllByCompany(java.lang.Integer)
	 */
	@Override
	public List<TypeAddressDTO> getAllByCompany(final Integer companyId) throws PersistenceException{
		List<TypeAddressDTO> typeAddresDTOLst = null;
		TypeAddressDTO typeAddresDTO = null;
		List<TypeAddress> typeAddresLst = new ArrayList<TypeAddress>();
		
		TypedQuery<TypeAddress> query = entityManager.createNamedQuery("TypeAddress.getAllByCompany", TypeAddress.class);
		query.setParameter("id", companyId);
		typeAddresLst = query.getResultList();
		
		if(typeAddresLst!= null && typeAddresLst.size()>0){
			typeAddresDTOLst = new ArrayList<TypeAddressDTO>();
			for(TypeAddress tp: typeAddresLst){
				typeAddresDTO = TransferObjectAssembler.getInstance().assembleTO(TypeAddressDTO.class, tp);
				typeAddresDTOLst.add(typeAddresDTO);
			}
		}
		
		return typeAddresDTOLst;
	}

}
