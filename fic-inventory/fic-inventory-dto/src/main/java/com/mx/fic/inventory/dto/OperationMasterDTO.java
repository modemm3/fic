package com.mx.fic.inventory.dto;

import java.sql.Timestamp;

public class OperationMasterDTO {
	
	private Integer id;
	private Timestamp operationDate;
	private Integer statusId;
	private Integer movementTypeId;
	private Integer companyId;
	private String folioDocument;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Timestamp getOperationDate() {
		return operationDate;
	}
	public void setOperationDate(Timestamp operationDate) {
		this.operationDate = operationDate;
	}
	public Integer getStatusId() {
		return statusId;
	}
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}
	public Integer getMovementTypeId() {
		return movementTypeId;
	}
	public void setMovementTypeId(Integer movementTypeId) {
		this.movementTypeId = movementTypeId;
	}
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	public String getFolioDocument() {
		return folioDocument;
	}
	public void setFolioDocument(String folioDocument) {
		this.folioDocument = folioDocument;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OperationMasterDTO [id=");
		builder.append(id);
		builder.append(", operationDate=");
		builder.append(operationDate);
		builder.append(", statusId=");
		builder.append(statusId);
		builder.append(", movementTypeId=");
		builder.append(movementTypeId);
		builder.append(", companyId=");
		builder.append(companyId);
		builder.append(", folioDocument=");
		builder.append(folioDocument);
		builder.append("]");
		return builder.toString();
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((companyId == null) ? 0 : companyId.hashCode());
		result = prime * result + ((folioDocument == null) ? 0 : folioDocument.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((movementTypeId == null) ? 0 : movementTypeId.hashCode());
		result = prime * result + ((operationDate == null) ? 0 : operationDate.hashCode());
		result = prime * result + ((statusId == null) ? 0 : statusId.hashCode());
		return result;
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OperationMasterDTO other = (OperationMasterDTO) obj;
		if (companyId == null) {
			if (other.companyId != null)
				return false;
		} else if (!companyId.equals(other.companyId))
			return false;
		if (folioDocument == null) {
			if (other.folioDocument != null)
				return false;
		} else if (!folioDocument.equals(other.folioDocument))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (movementTypeId == null) {
			if (other.movementTypeId != null)
				return false;
		} else if (!movementTypeId.equals(other.movementTypeId))
			return false;
		if (operationDate == null) {
			if (other.operationDate != null)
				return false;
		} else if (!operationDate.equals(other.operationDate))
			return false;
		if (statusId == null) {
			if (other.statusId != null)
				return false;
		} else if (!statusId.equals(other.statusId))
			return false;
		return true;
	}

}
