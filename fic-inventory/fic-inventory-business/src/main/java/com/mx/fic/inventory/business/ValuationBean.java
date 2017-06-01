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
import javax.persistence.TransactionRequiredException;
import javax.persistence.TypedQuery;

import com.mx.fic.inventory.business.builder.config.TransferObjectAssembler;
import com.mx.fic.inventory.business.exception.PersistenceException;
import com.mx.fic.inventory.dto.ValuationDTO;
import com.mx.fic.inventory.persistent.Company;
import com.mx.fic.inventory.persistent.Status;
import com.mx.fic.inventory.persistent.Valuation;
import com.mx.fic.inventory.persistent.ValuationType;

@Local
@Stateless (mappedName="ValuationBean")
@TransactionManagement (TransactionManagementType.CONTAINER)
public class ValuationBean {
	
	private EntityManager entityManager;
	
	@TransactionAttribute (TransactionAttributeType.REQUIRED)
	public void saveValuation(final ValuationDTO valuationDTO) throws PersistenceException{
		final Valuation valuation = new Valuation();
		final Status status = new Status();
		final Company company = new Company();
		final ValuationType valuationType = new ValuationType();
		
		try{
		
			valuation.setDateEnd(valuationDTO.getDateEnd());
			valuation.setDateStart(valuationDTO.getDateStart());
			valuation.setExerciseFiscal(valuationDTO.getExerciseFiscal());
			valuation.setSerialId(valuationDTO.getSerialId());
			
			status.setId(valuationDTO.getStatusId());
			valuation.setStatus(status);
			company.setId(valuationDTO.getCompanyId());
			valuation.setCompany(company);
			valuationType.setId(valuationDTO.getValuationTypeId());
			valuation.setValuationType(valuationType);
			entityManager.persist(valuation);

		}catch(EntityExistsException | IllegalArgumentException | TransactionRequiredException e ){
			throw new PersistenceException("Erro al guardar las valuaciones");
		}
	}
	
	public List<ValuationDTO> getAllByCompany(final Integer companyId) throws PersistenceException{
		List<Valuation> valuationLst = new ArrayList<Valuation>();
		List<ValuationDTO> valuationDTOLst = null;
		ValuationDTO valuationDTO = null;
		
		TypedQuery<Valuation> query = entityManager.createNamedQuery("Valuation.getAllByCompany", Valuation.class);
		
		valuationLst = query.getResultList();
		
		if(valuationLst!= null && valuationLst.size()>0){
			valuationDTOLst = new ArrayList<ValuationDTO>();
			for(Valuation val : valuationLst){
				valuationDTO = TransferObjectAssembler.getInstance().assembleTO(ValuationDTO.class, val);
				valuationDTOLst.add(valuationDTO);
			}
		}
		return valuationDTOLst;
	}

}
