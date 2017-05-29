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
import com.mx.fic.inventory.dto.MeasureUnitDTO;
import com.mx.fic.inventory.persistent.Company;
import com.mx.fic.inventory.persistent.MeasureUnit;

@Local
@Stateless (mappedName="MeasureUnitBean")
@TransactionManagement (TransactionManagementType.CONTAINER)
public class MeasureUnitBean {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(final MeasureUnitDTO measureUnitDTO) throws PersistenceException{
		final MeasureUnit measureUnit = new MeasureUnit();
		final Company company = new Company();
		try{
			company.setId(measureUnitDTO.getCompanyId());
			measureUnit.setName(measureUnitDTO.getName());
			measureUnit.setDescription(measureUnitDTO.getDescription());
			measureUnit.setCompany(company);
			
			entityManager.persist(measureUnit);
		}catch(EntityExistsException | IllegalArgumentException | TransactionRequiredException e ){
			throw new PersistenceException("Errror al guardar las unidades de medida");
		}
	}
	
	public List<MeasureUnitDTO> getAllByCompany(final Integer idCompany) throws PersistenceException{
		List<MeasureUnitDTO> measureUnitDTOLst= null;
		MeasureUnitDTO measureUnitDTO= null;
		List<MeasureUnit> measureUnitLst= new ArrayList<MeasureUnit>();
		
		TypedQuery<MeasureUnit> query= entityManager.createNamedQuery("MeasureUnit.getAllByCompany", MeasureUnit.class);
		query.setParameter("id", idCompany);
		measureUnitLst = query.getResultList();
		
		if(measureUnitLst!=null && measureUnitLst.size()>0){
			measureUnitDTOLst= new ArrayList<MeasureUnitDTO>();
			for(MeasureUnit m: measureUnitLst){
				measureUnitDTO= TransferObjectAssembler.getInstance().assembleTO(MeasureUnitDTO.class, m);
				measureUnitDTOLst.add(measureUnitDTO);
			}
		}
		return measureUnitDTOLst;
	}

}
