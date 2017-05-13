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
import javax.persistence.Table;

@Entity
@Table (name="operations")
public class Operations implements BaseEntity{

	private static final long serialVersionUID = -4660754422148475290L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@JoinColumn(name="product_id", referencedColumnName="id")
	@ManyToOne(fetch=FetchType.LAZY)
	private Product product;
	@JoinColumn(name="movement_type_id", referencedColumnName="id")
	@ManyToOne(fetch=FetchType.LAZY)
	private MovementType movementType;
	@JoinColumn(name="status_id", referencedColumnName="id")
	@ManyToOne(fetch=FetchType.LAZY)
	private Status status;
	@Column(name="creation_date")
	private Timestamp creationDate;
	@Column(name="stocks")
	private Integer stocks;
	@Column(name="folio_document")
	private String folioDocument;
	@Column(name="time_unit_id")
	private Integer timeUnitId;
	@Column(name="delivery_time")
	private Integer deliveryTime;
	@JoinColumn(name="provider_id", referencedColumnName="id")
	@ManyToOne(fetch=FetchType.LAZY)
	private Provider provider;
	@JoinColumn(name="company_id", referencedColumnName="id")
	@ManyToOne(fetch=FetchType.LAZY)
	private Company company;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public MovementType getMovementType() {
		return movementType;
	}
	public void setMovementType(MovementType movementType) {
		this.movementType = movementType;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Timestamp getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}
	public Integer getStocks() {
		return stocks;
	}
	public void setStocks(Integer stocks) {
		this.stocks = stocks;
	}
	public String getFolioDocument() {
		return folioDocument;
	}
	public void setFolioDocument(String folioDocument) {
		this.folioDocument = folioDocument;
	}
	public Integer getTimeUnitId() {
		return timeUnitId;
	}
	public void setTimeUnitId(Integer timeUnitId) {
		this.timeUnitId = timeUnitId;
	}
	public Integer getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(Integer deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	public Provider getProvider() {
		return provider;
	}
	public void setProvider(Provider provider) {
		this.provider = provider;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	
	public String toString() {
		return "Operations [id=" + id + ", product=" + product + ", movementType=" + movementType + ", status=" + status
				+ ", creationDate=" + creationDate + ", stocks=" + stocks + ", folioDocument=" + folioDocument
				+ ", timeUnitId=" + timeUnitId + ", deliveryTime=" + deliveryTime + ", company=" + company + "]";
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((deliveryTime == null) ? 0 : deliveryTime.hashCode());
		result = prime * result + ((folioDocument == null) ? 0 : folioDocument.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((movementType == null) ? 0 : movementType.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((stocks == null) ? 0 : stocks.hashCode());
		result = prime * result + ((timeUnitId == null) ? 0 : timeUnitId.hashCode());
		return result;
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Operations other = (Operations) obj;
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
		if (deliveryTime == null) {
			if (other.deliveryTime != null)
				return false;
		} else if (!deliveryTime.equals(other.deliveryTime))
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
		if (movementType == null) {
			if (other.movementType != null)
				return false;
		} else if (!movementType.equals(other.movementType))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (stocks == null) {
			if (other.stocks != null)
				return false;
		} else if (!stocks.equals(other.stocks))
			return false;
		if (timeUnitId == null) {
			if (other.timeUnitId != null)
				return false;
		} else if (!timeUnitId.equals(other.timeUnitId))
			return false;
		return true;
	}
	
}
