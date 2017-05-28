package com.mx.fic.inventory.dto;

import java.sql.Timestamp;

public class ValuationDTO implements BaseDTO{

	private static final long serialVersionUID = 7734863048969078204L;

	private Integer serialId;
	private Integer exerciseFiscal;
	private Timestamp dateStart;
	private Timestamp dateEnd;	
	private Integer valuationTypeId;
	private Integer companyId;
	private Integer statusId;

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
	public Integer getValuationTypeId() {
		return valuationTypeId;
	}
	public void setValuationTypeId(Integer valuationTypeId) {
		this.valuationTypeId = valuationTypeId;
	}
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	public Integer getStatusId() {
		return statusId;
	}
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((companyId == null) ? 0 : companyId.hashCode());
		result = prime * result + ((dateEnd == null) ? 0 : dateEnd.hashCode());
		result = prime * result + ((dateStart == null) ? 0 : dateStart.hashCode());
		result = prime * result + ((exerciseFiscal == null) ? 0 : exerciseFiscal.hashCode());
		result = prime * result + ((serialId == null) ? 0 : serialId.hashCode());
		result = prime * result + ((statusId == null) ? 0 : statusId.hashCode());
		result = prime * result + ((valuationTypeId == null) ? 0 : valuationTypeId.hashCode());
		return result;
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ValuationDTO other = (ValuationDTO) obj;
		if (companyId == null) {
			if (other.companyId != null)
				return false;
		} else if (!companyId.equals(other.companyId))
			return false;
		if (dateEnd == null) {
			if (other.dateEnd != null)
				return false;
		} else if (!dateEnd.equals(other.dateEnd))
			return false;
		if (dateStart == null) {
			if (other.dateStart != null)
				return false;
		} else if (!dateStart.equals(other.dateStart))
			return false;
		if (exerciseFiscal == null) {
			if (other.exerciseFiscal != null)
				return false;
		} else if (!exerciseFiscal.equals(other.exerciseFiscal))
			return false;
		if (serialId == null) {
			if (other.serialId != null)
				return false;
		} else if (!serialId.equals(other.serialId))
			return false;
		if (statusId == null) {
			if (other.statusId != null)
				return false;
		} else if (!statusId.equals(other.statusId))
			return false;
		if (valuationTypeId == null) {
			if (other.valuationTypeId != null)
				return false;
		} else if (!valuationTypeId.equals(other.valuationTypeId))
			return false;
		return true;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ValuationDTO [serialId=");
		builder.append(serialId);
		builder.append(", exerciseFiscal=");
		builder.append(exerciseFiscal);
		builder.append(", dateStart=");
		builder.append(dateStart);
		builder.append(", dateEnd=");
		builder.append(dateEnd);
		builder.append(", valuationTypeId=");
		builder.append(valuationTypeId);
		builder.append(", companyId=");
		builder.append(companyId);
		builder.append(", statusId=");
		builder.append(statusId);
		builder.append("]");
		return builder.toString();
	}
	
}
