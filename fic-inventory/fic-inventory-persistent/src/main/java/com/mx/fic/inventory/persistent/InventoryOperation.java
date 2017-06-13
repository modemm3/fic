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
@Table (name="inventory_operation")
@NamedQueries({
	@NamedQuery(name="InventoryOperation.getAllByProductAndCompany", query = "select inventoryop from InventoryOperation inventoryop where inventoryop.companyId=:companyId and inventoryop.product.id=:productId order by inventoryop.id asc")
})
public class InventoryOperation implements BaseEntity{

	private static final long serialVersionUID = 7366333918596137733L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@JoinColumn(name="operation_id", referencedColumnName="id")
	@ManyToOne(fetch=FetchType.LAZY)
	private Operations operation;
	@Column(name="movement_concept")
	private String movementConcept;
	@Column(name="movement_type")
	private String movementType;
	@Column(name="movement_date")
	private Timestamp movementDate;
	@Column(name="amount")
	private Double amount;
	@Column(name="value_unit")
	private Double valueUnit;
	@Column(name="value_total")
	private Double valueTotal;
	@Column(name="amount_balance")
	private Double amountBalance;
	@Column(name="value_unit_balance") 
	private Double valueUnitBalance;
	@Column(name="value_total_balance")
	private Double valueTotalBalance;
	@Column(name="company_id")
	private Integer companyId;
	@JoinColumn(name="product_id", referencedColumnName="id")
	@ManyToOne(fetch=FetchType.LAZY)
	private Product product;
	@JoinColumn(name="inventory_operation_id", referencedColumnName="id")
	@ManyToOne(fetch=FetchType.LAZY)
	private InventoryOperation inventoryOperationRoot;
	@Column(name="status")
	private Boolean status;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Operations getOperation() {
		return operation;
	}
	public void setOperation(Operations operation) {
		this.operation = operation;
	}
	public String getMovementConcept() {
		return movementConcept;
	}
	public void setMovementConcept(String movementConcept) {
		this.movementConcept = movementConcept;
	}
	public String getMovementType() {
		return movementType;
	}
	public void setMovementType(String movementType) {
		this.movementType = movementType;
	}
	public Timestamp getMovementDate() {
		return movementDate;
	}
	public void setMovementDate(Timestamp movementDate) {
		this.movementDate = movementDate;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Double getValueUnit() {
		return valueUnit;
	}
	public void setValueUnit(Double valueUnit) {
		this.valueUnit = valueUnit;
	}
	public Double getValueTotal() {
		return valueTotal;
	}
	public void setValueTotal(Double valueTotal) {
		this.valueTotal = valueTotal;
	}
	public Double getAmountBalance() {
		return amountBalance;
	}
	public void setAmountBalance(Double amountBalance) {
		this.amountBalance = amountBalance;
	}
	public Double getValueUnitBalance() {
		return valueUnitBalance;
	}
	public void setValueUnitBalance(Double valueUnitBalance) {
		this.valueUnitBalance = valueUnitBalance;
	}
	public Double getValueTotalBalance() {
		return valueTotalBalance;
	}
	public void setValueTotalBalance(Double valueTotalBalance) {
		this.valueTotalBalance = valueTotalBalance;
	}
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public InventoryOperation getInventoryOperationRoot() {
		return inventoryOperationRoot;
	}
	public void setInventoryOperationRoot(InventoryOperation inventoryOperationRoot) {
		this.inventoryOperationRoot = inventoryOperationRoot;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}

}
