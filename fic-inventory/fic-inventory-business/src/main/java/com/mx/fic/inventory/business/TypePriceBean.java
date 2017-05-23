package com.mx.fic.inventory.business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.mx.fic.inventory.business.builder.config.TransferObjectAssembler;
import com.mx.fic.inventory.dto.TypePriceDTO;
import com.mx.fic.inventory.persistent.TypePrice;

@Local
@Stateless (mappedName= "TypePriceBean")
@TransactionManagement (TransactionManagementType.CONTAINER)
public class TypePriceBean {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<TypePriceDTO> getAllByCompany(final Integer idCompany){
		List<TypePriceDTO> typePriceDTOLst= null;
		TypePriceDTO typePryceDTO=null;
		List<TypePrice> typePriceLst= new ArrayList<TypePrice>();
		
		TypedQuery<TypePrice> query = entityManager.createNamedQuery("TypePrice.getAllByCompany",TypePrice.class);
		query.setParameter("id", idCompany);
		typePriceLst= query.getResultList();
		
		if(typePriceLst!= null && typePriceLst.size()>0){
			typePriceDTOLst= new ArrayList<TypePriceDTO>();
			for(TypePrice tp: typePriceLst){
				typePryceDTO= TransferObjectAssembler.getInstance().assembleTO(typePryceDTO.getClass(), tp);
				typePriceDTOLst.add(typePryceDTO);
			}
		}
		
		return typePriceDTOLst;
	}
	

}
