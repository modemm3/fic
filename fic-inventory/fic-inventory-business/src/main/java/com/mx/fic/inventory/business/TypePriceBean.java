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

/**
 * Contiene las operaciones para dar de alta, actualizar, 
 * consultar y/o eliminar los tipo de precio pertenecientes
 * a una compañía
 * @author developer
 *
 */
@Stateless (mappedName= "TypePriceBean")
@TransactionManagement (TransactionManagementType.CONTAINER)
public class TypePriceBean implements TypePriceBeanLocal {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	/* (non-Javadoc)
	 * @see com.mx.fic.inventory.business.TypePriceBeanLocal#save(com.mx.fic.inventory.dto.TypePriceDTO)
	 */
	/**
	 * Método que guarda el tipo de precio perteneciente a alguna compañía
	 * @param Recibe el objeto a guardar correspondiente al tipo de precio
	 * @return no retorna resultado, sin embargo si se produce un fallo 
	 * regresa una excepción
	 */
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
	

	/**
	 * Método que consulta la lista de precios pertenecientes a una 
	 * compañía
	 * @param Recibe el id de la compañía
	 * @return Retorna la lista de precios pertenecientes a una compañía
	 */
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

	/**
	 * Método que actualiza el tipo de precio por Id
	 * @param Recibe el objeto a actualizar correspondiente a el tipo de precio
	 * @Return Regresa un boolean para indicar si la actualización se realizo
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public boolean update(TypePriceDTO typePriceDTO) throws PersistenceException {
		
		TypePrice typePrice = null;
		boolean result= false;
		
		typePrice = entityManager.find(TypePrice.class, typePriceDTO.getId());
		
		if(typePrice!=null){
			
			typePrice.setDescription(typePriceDTO.getDescription());
			typePrice.setName(typePriceDTO.getName());
			entityManager.persist(typePrice);
			result = true;
		}
		
		return result;
	}
	

}
