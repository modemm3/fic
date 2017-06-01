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
import com.mx.fic.inventory.dto.TypePersonDTO;
import com.mx.fic.inventory.persistent.Company;
import com.mx.fic.inventory.persistent.TypePerson;

@Local
@Stateless (mappedName = "TypePersonBean")
@TransactionManagement (TransactionManagementType.CONTAINER)
public class TypePersonBean {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(final TypePersonDTO typePersonDTO) throws PersistenceException{
		final TypePerson typePerson = new TypePerson();
		final Company company = new Company();
		
		try{
			typePerson.setName(typePersonDTO.getName());
			typePerson.setDescription(typePersonDTO.getDescription());
			
			company.setId(typePersonDTO.getCompanyId());
			typePerson.setCompany(company);
			
			entityManager.persist(typePerson);
		}catch(EntityExistsException | IllegalArgumentException | TransactionRequiredException e ){
			throw new PersistenceException("Erro al guardar los estatus");
		}
	}
	
	public List<TypePersonDTO> getAllByCompany(final Integer companyId) throws PersistenceException{
		List<TypePerson> typePersonLst = new ArrayList<TypePerson>();
		List<TypePersonDTO> typePersonDTOLst = null;
		TypePersonDTO typePersonDTO = null;
		
		TypedQuery<TypePerson> query = entityManager.createNamedQuery("TypePerson.getAllByCompany", TypePerson.class);
		query.setParameter("id", companyId);
		typePersonLst = query.getResultList();
		
		if(typePersonLst!=null && typePersonLst.size()>0){
			typePersonDTOLst = new ArrayList<TypePersonDTO>();
			
			for(TypePerson tp: typePersonLst){
				typePersonDTO = TransferObjectAssembler.getInstance().assembleTO(TypePersonDTO.class, tp);
				typePersonDTOLst.add(typePersonDTO);
			}
		}
		
		return typePersonDTOLst;
	}

}
