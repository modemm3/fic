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
import com.mx.fic.inventory.dto.PricesDTO;
import com.mx.fic.inventory.persistent.Company;
import com.mx.fic.inventory.persistent.Prices;
import com.mx.fic.inventory.persistent.Product;
import com.mx.fic.inventory.persistent.Season;
import com.mx.fic.inventory.persistent.Status;
import com.mx.fic.inventory.persistent.TypePrice;

//@Local
@Stateless (mappedName="PricesBean")
@TransactionManagement (TransactionManagementType.CONTAINER)
public class PricesBean implements PricesBeanLocal{
	
	@PersistenceContext
	private EntityManager entityManager;

	/* (non-Javadoc)
	 * @see com.mx.fic.inventory.business.PricesBeanLocal#save(com.mx.fic.inventory.dto.PricesDTO)
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(final PricesDTO pricesDTO) throws PersistenceException{
	
		final Prices price= new Prices();
		final Company company = new Company();
		final Season season = new Season();
		final Status status = new Status();
		final TypePrice typePrice = new TypePrice();
		final Product product = new Product();
		
		try{
			company.setId(pricesDTO.getCompanyId());
			season.setId(pricesDTO.getSeasonId());
			typePrice.setId(pricesDTO.getTypePriceId());
			status.setId(pricesDTO.getStatusId());
			product.setId(pricesDTO.getProductId());
			price.setCompany(company);
			price.setProduct(product);
			price.setSeason(season);
			price.setStatus(status);
			price.setTypePrice(typePrice);
			price.setPrice(pricesDTO.getPrice());
			price.setCreationDate(pricesDTO.getCreationDate());
			
			entityManager.persist(price);
		}catch(EntityExistsException | IllegalArgumentException | TransactionRequiredException e ){
			throw new PersistenceException("Errror al guardar los precios");
		}		
	}
	
	/* (non-Javadoc)
	 * @see com.mx.fic.inventory.business.PricesBeanLocal#getAllByCompany(java.lang.Integer)
	 */
	@Override
	public List<PricesDTO> getAllByCompany(final Integer companyId) throws PersistenceException{
		List<PricesDTO> pricesDTOLst = new ArrayList<PricesDTO>();
		List<Prices> pricesLst = new ArrayList<Prices>();
		PricesDTO pricesDTO = null;
		
		TypedQuery<Prices> queryPrice = entityManager.createNamedQuery("Prices.getAllByCompany", Prices.class);
		queryPrice.setParameter("id", companyId);
		
		pricesLst = queryPrice.getResultList();
		
		if(pricesLst!=null && pricesLst.size()>0){
			pricesDTOLst = new ArrayList<PricesDTO>();
			for(Prices pr: pricesLst){
				pricesDTO= TransferObjectAssembler.getInstance().assembleTO(PricesDTO.class, pr);
				pricesDTOLst.add(pricesDTO);
			}
		}
		
		return pricesDTOLst;
	}

}
