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

import org.apache.log4j.Logger;

import com.mx.fic.inventory.business.builder.config.TransferObjectAssembler;
import com.mx.fic.inventory.business.exception.PersistenceException;
import com.mx.fic.inventory.dto.MeasureUnitDTO;
import com.mx.fic.inventory.persistent.Company;
import com.mx.fic.inventory.persistent.MeasureUnit;

//@Local
@Stateless (mappedName="MeasureUnitBean")
@TransactionManagement (TransactionManagementType.CONTAINER)
public class MeasureUnitBean implements MeasureUnitBeanLocal {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	private final static Logger logger = Logger.getLogger(MeasureUnitBean.class);
	
	/* (non-Javadoc)
	 * @see com.mx.fic.inventory.business.MeasureUnitBeanLocal#save(com.mx.fic.inventory.dto.MeasureUnitDTO)
	 */
	@Override
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
			logger.error("Error en Bean "+ e);
			throw new PersistenceException("Errror al guardar las unidades de medida");
		}
	}
	
	/* (non-Javadoc)
	 * @see com.mx.fic.inventory.business.MeasureUnitBeanLocal#getAllByCompany(java.lang.Integer)
	 */
	@Override
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
