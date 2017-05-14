package com.mx.fic.inventory.persistent;

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
@Table (name="product")
public class Product implements BaseEntity {
	
	private static final long serialVersionUID = -6332573782213330068L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="name")
	private String name;
	@Column(name="description")
	private String description;
	@Column(name="barcode")
	private String barcode;
	@JoinColumn(name="measure_unit_id", referencedColumnName="id")
	@ManyToOne(fetch=FetchType.LAZY)
	private MeasureUnit measureUnit;
	@Column(name="minimum_stock")
	private Integer minimumStock;
	@Column(name="maximum_stock")
	private Integer maximumStock;
	@JoinColumn(name="company_id", referencedColumnName="id")
	@ManyToOne(fetch=FetchType.LAZY)
	private Company company;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public MeasureUnit getMeasureUnit() {
		return measureUnit;
	}
	public void setMeasureUnit(MeasureUnit measureUnit) {
		this.measureUnit = measureUnit;
	}
	public Integer getMinimumStock() {
		return minimumStock;
	}
	public void setMinimumStock(Integer minimumStock) {
		this.minimumStock = minimumStock;
	}
	public Integer getMaximumStock() {
		return maximumStock;
	}
	public void setMaximumStock(Integer maximumStock) {
		this.maximumStock = maximumStock;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", barcode=" + barcode
				+ ", measureUnit=" + measureUnit + ", minimumStock=" + minimumStock + ", maximumStock=" + maximumStock
				+ ", company=" + company + "]";
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((barcode == null) ? 0 : barcode.hashCode());
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((maximumStock == null) ? 0 : maximumStock.hashCode());
		result = prime * result + ((measureUnit == null) ? 0 : measureUnit.hashCode());
		result = prime * result + ((minimumStock == null) ? 0 : minimumStock.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (barcode == null) {
			if (other.barcode != null)
				return false;
		} else if (!barcode.equals(other.barcode))
			return false;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (maximumStock == null) {
			if (other.maximumStock != null)
				return false;
		} else if (!maximumStock.equals(other.maximumStock))
			return false;
		if (measureUnit == null) {
			if (other.measureUnit != null)
				return false;
		} else if (!measureUnit.equals(other.measureUnit))
			return false;
		if (minimumStock == null) {
			if (other.minimumStock != null)
				return false;
		} else if (!minimumStock.equals(other.minimumStock))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
