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
import com.mx.fic.inventory.dto.SeasonDTO;
import com.mx.fic.inventory.persistent.Company;
import com.mx.fic.inventory.persistent.Season;

@Local
@Stateless (mappedName= "SeasonBean")
@TransactionManagement (TransactionManagementType.CONTAINER)
public class SeasonBean {
	
	@PersistenceContext
	private EntityManager entityManager;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(final SeasonDTO seasonDTO) throws PersistenceException{
		final Season season = new Season();
		final Company company = new Company();
		
		try{
			company.setId(seasonDTO.getCompanyId());
			season.setDescription(seasonDTO.getDescription());
			season.setEndDate(seasonDTO.getEndDate());
			season.setName(seasonDTO.getName());
			season.setStartDate(seasonDTO.getStartDate());
			season.setCompany(company);
			
			entityManager.persist(season);
		}catch(EntityExistsException | IllegalArgumentException | TransactionRequiredException e ){
			throw new PersistenceException("Erro al guardar las temporadas");
		}
	}
	
	public List<SeasonDTO> getAllByCompany(final Integer companyId) throws PersistenceException{
		List<SeasonDTO> seasonDTOLst = null;
		SeasonDTO seasonDTO = null;
		List<Season> seasonLst = new ArrayList<Season>();
		
		TypedQuery<Season> query = entityManager.createNamedQuery("Season.getAllByCompany", Season.class);
		query.setParameter("id", companyId);
		seasonLst= query.getResultList();
		
		if(seasonLst!= null && seasonLst.size()>0){
			seasonDTOLst = new ArrayList<SeasonDTO>();
			for(Season s: seasonLst){
				seasonDTO = TransferObjectAssembler.getInstance().assembleTO(SeasonDTO.class, s);
				seasonDTOLst.add(seasonDTO);
			}
		}
		return seasonDTOLst;
	}
}
