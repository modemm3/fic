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
import com.mx.fic.inventory.dto.TypePriceDTO;
import com.mx.fic.inventory.persistent.Company;
import com.mx.fic.inventory.persistent.Status;
import com.mx.fic.inventory.persistent.TypePrice;

//@Local
@Stateless (mappedName= "TypePriceBean")
@TransactionManagement (TransactionManagementType.CONTAINER)
public class TypePriceBean implements TypePriceBeanLocal {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	/* (non-Javadoc)
	 * @see com.mx.fic.inventory.business.TypePriceBeanLocal#save(com.mx.fic.inventory.dto.TypePriceDTO)
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(final TypePriceDTO typePriceDTO) throws PersistenceException{
		final TypePrice typePrice = new TypePrice();
		final Company company = new Company();
		final Status status = new Status();
		
		try{
			company.setId(typePriceDTO.getCompanyId());
			status.setId(typePriceDTO.getStatusId());
			typePrice.setCompany(company);
			typePrice.setStatus(status);
			typePrice.setDescription(typePriceDTO.getDescription());
			typePrice.setName(typePriceDTO.getName());
			
			entityManager.persist(typePrice);
			
		}catch(EntityExistsException | IllegalArgumentException | TransactionRequiredException e ){
			throw new PersistenceException("Erro al guardar los tipos de precio");
		}
	}
	
	/* (non-Javadoc)
	 * @see com.mx.fic.inventory.business.TypePriceBeanLocal#getAllByCompany(java.lang.Integer)
	 */
	@Override
	public List<TypePriceDTO> getAllByCompany(final Integer idCompany) throws PersistenceException {
		List<TypePriceDTO> typePriceDTOLst= null;
		TypePriceDTO typePryceDTO=null;
		List<TypePrice> typePriceLst= new ArrayList<TypePrice>();
		
		TypedQuery<TypePrice> query = entityManager.createNamedQuery("TypePrice.getAllByCompany",TypePrice.class);
		query.setParameter("id", idCompany);
		typePriceLst= query.getResultList();
		
		if(typePriceLst!= null && typePriceLst.size()>0){
			typePriceDTOLst= new ArrayList<TypePriceDTO>();
			for(TypePrice tp: typePriceLst){
				typePryceDTO= TransferObjectAssembler.getInstance().assembleTO(TypePriceDTO.class, tp);
				typePriceDTOLst.add(typePryceDTO);
			}
		}
		
		return typePriceDTOLst;
	}
	

}
