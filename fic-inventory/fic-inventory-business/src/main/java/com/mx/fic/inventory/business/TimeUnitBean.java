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
import com.mx.fic.inventory.dto.TimeUnitDTO;
import com.mx.fic.inventory.persistent.Company;
import com.mx.fic.inventory.persistent.TimeUnit;

@Local
@Stateless (mappedName = "TimeUnitBean")
@TransactionManagement (TransactionManagementType.CONTAINER)
public class TimeUnitBean {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(final TimeUnitDTO timeUnitDTO) throws PersistenceException{
		
		final TimeUnit timeUnit = new TimeUnit();
		final Company company = new Company();
		
		try{
			timeUnit.setDescription(timeUnitDTO.getDescription());
			timeUnit.setName(timeUnitDTO.getName());
			company.setId(timeUnitDTO.getCompanyId());
			timeUnit.setCompany(company);
			
			entityManager.persist(timeUnit);
		}catch(EntityExistsException | IllegalArgumentException | TransactionRequiredException e ){
			throw new PersistenceException("Errror al guardar las unidades de tiempo");
		}
	}
	
	public List<TimeUnitDTO> getAllByCompany(final Integer companyId ) throws PersistenceException{
		List<TimeUnitDTO> timeUnitDTOLst = new ArrayList<TimeUnitDTO>();
		List<TimeUnit> timeUnitLst = new ArrayList<TimeUnit>();
		TimeUnitDTO timeUnitDTO = null;
		
		TypedQuery<TimeUnit> queryTimeUnit = entityManager.createNamedQuery("TimeUnit.getAllByCompany", TimeUnit.class);
		queryTimeUnit.setParameter("id", companyId);
		
		timeUnitLst = queryTimeUnit.getResultList();
		
		if(timeUnitLst!= null && timeUnitLst.size()>0){
			timeUnitDTOLst = new ArrayList<TimeUnitDTO>();
			for(TimeUnit tu: timeUnitLst){
				timeUnitDTO= TransferObjectAssembler.getInstance().assembleTO(TimeUnitDTO.class, tu);
				timeUnitDTOLst.add(timeUnitDTO);
			}
		}
		
		return timeUnitDTOLst;
		
	} 

}
