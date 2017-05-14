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
import com.mx.fic.inventory.dto.MeasureUnitDTO;
import com.mx.fic.inventory.persistent.MeasureUnit;

@Local
@Stateless (mappedName="MeasureUnitBean")
@TransactionManagement (TransactionManagementType.CONTAINER)
public class MeasureUnitBean {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<MeasureUnitDTO> getAllByCompany(final Integer idCompany){
		List<MeasureUnitDTO> measureUnitDTOLst= null;
		MeasureUnitDTO measureUnitDTO= null;
		List<MeasureUnit> measureUnitLst= new ArrayList<MeasureUnit>();
		
		TypedQuery<MeasureUnit> query= entityManager.createNamedQuery("id", MeasureUnit.class);
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
