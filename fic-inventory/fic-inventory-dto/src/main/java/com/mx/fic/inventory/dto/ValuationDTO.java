package com.mx.fic.inventory.dto;

import java.sql.Timestamp;

public class ValuationDTO implements BaseDTO{

	private static final long serialVersionUID = 7734863048969078204L;

	private Integer serialId;
	private Integer exerciseFiscal;
	private Timestamp dateStart;
	private Timestamp dateEnd;	
	private ValuationTypeDTO valuationTypeDTO;	
	private CompanyDTO companyDTO;	
	private StatusDTO statusDTO;
	
	public Integer getSerialId() {
		return serialId;
	}
	public void setSerialId(Integer serialId) {
		this.serialId = serialId;
	}
	public Integer getExerciseFiscal() {
		return exerciseFiscal;
	}
	public void setExerciseFiscal(Integer exerciseFiscal) {
		this.exerciseFiscal = exerciseFiscal;
	}
	public Timestamp getDateStart() {
		return dateStart;
	}
	public void setDateStart(Timestamp dateStart) {
		this.dateStart = dateStart;
	}
	public Timestamp getDateEnd() {
		return dateEnd;
	}
	public void setDateEnd(Timestamp dateEnd) {
		this.dateEnd = dateEnd;
	}
	public ValuationTypeDTO getValuationTypeDTO() {
		return valuationTypeDTO;
	}
	public void setValuationTypeDTO(ValuationTypeDTO valuationTypeDTO) {
		this.valuationTypeDTO = valuationTypeDTO;
	}
	public CompanyDTO getCompanyDTO() {
		return companyDTO;
	}
	public void setCompanyDTO(CompanyDTO companyDTO) {
		this.companyDTO = companyDTO;
	}
	public StatusDTO getStatusDTO() {
		return statusDTO;
	}
	public void setStatusDTO(StatusDTO statusDTO) {
		this.statusDTO = statusDTO;
	}
	
}
