package com.mx.fic.inventory.persistent;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table (name="operation_master")
@NamedQueries({
	@NamedQuery(name="OperationMaster.updateStatus", 
			query="update OperationMaster opM set opM.status.id=:statusId where opM.id=:opMastId")
})
public class OperationMaster implements BaseEntity{
	
	private static final long serialVersionUID = 4294420049156118001L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="operation_date") 
	private Timestamp operationDate;
	@JoinColumn(name="status_id", referencedColumnName="id")
	@ManyToOne(fetch=FetchType.LAZY)
	private Status status;
	@JoinColumn(name="movement_type_id", referencedColumnName="id")
	@ManyToOne(fetch=FetchType.LAZY)
	private MovementType movementType;
	@JoinColumn(name="company_id", referencedColumnName="id")
	@ManyToOne(fetch=FetchType.LAZY)
	private Company company;
	@Column(name="folio_document")
	private String folioDocument;
	@Column(name="creation_date")
	private Timestamp creationDate;
	@Column(name="modification_date")
	private Timestamp modificationDate;
	
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
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public MovementType getMovementType() {
		return movementType;
	}
	public void setMovementType(MovementType movementType) {
		this.movementType = movementType;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public String getFolioDocument() {
		return folioDocument;
	}
	public void setFolioDocument(String folioDocument) {
		this.folioDocument = folioDocument;
	}
	
	public Timestamp getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}
	public Timestamp getModificationDate() {
		return modificationDate;
	}
	public void setModificationDate(Timestamp modificationDate) {
		this.modificationDate = modificationDate;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OperationMaster [id=");
		builder.append(id);
		builder.append(", operationDate=");
		builder.append(operationDate);
		builder.append(", status=");
		builder.append(status);
		builder.append(", movementType=");
		builder.append(movementType);
		builder.append(", company=");
		builder.append(company);
		builder.append(", folioDocument=");
		builder.append(folioDocument);
		builder.append(", creationDate=");
		builder.append(creationDate);
		builder.append(", modificationDate=");
		builder.append(modificationDate);
		builder.append("]");
		return builder.toString();
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((folioDocument == null) ? 0 : folioDocument.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((modificationDate == null) ? 0 : modificationDate.hashCode());
		result = prime * result + ((movementType == null) ? 0 : movementType.hashCode());
		result = prime * result + ((operationDate == null) ? 0 : operationDate.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OperationMaster other = (OperationMaster) obj;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
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
		if (modificationDate == null) {
			if (other.modificationDate != null)
				return false;
		} else if (!modificationDate.equals(other.modificationDate))
			return false;
		if (movementType == null) {
			if (other.movementType != null)
				return false;
		} else if (!movementType.equals(other.movementType))
			return false;
		if (operationDate == null) {
			if (other.operationDate != null)
				return false;
		} else if (!operationDate.equals(other.operationDate))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
	
}
