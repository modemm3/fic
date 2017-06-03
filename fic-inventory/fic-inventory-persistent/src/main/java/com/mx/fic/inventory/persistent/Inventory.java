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
@Table(name="inventory")
@NamedQueries({
	@NamedQuery(name="Inventory.getAllByCompany", query="select inv from Inventory inv where inv.company.id=:id"),
	@NamedQuery(name="Inventory.findProductByCompany", query="select inv from Inventory inv where inv.product.id=:idProduct and inv.company.id=:id")
})
public class Inventory implements BaseEntity{
	
	private static final long serialVersionUID = -1021756101977949557L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="current_stock")
	private Double currentStock;
	@JoinColumn(name="product_id", referencedColumnName="id")
	@ManyToOne(fetch=FetchType.LAZY)
	private Product product;
	@Column(name="modification_date")
	private Timestamp modificationDate;
	@JoinColumn(name="company_id", referencedColumnName="id")
	@ManyToOne(fetch= FetchType.LAZY)
	private Company company;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getCurrentStock() {
		return currentStock;
	}
	public void setCurrentStock(Double currentStock) {
		this.currentStock = currentStock;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Timestamp getModificationDate() {
		return modificationDate;
	}
	public void setModificationDate(Timestamp modificationDate) {
		this.modificationDate = modificationDate;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}

}
