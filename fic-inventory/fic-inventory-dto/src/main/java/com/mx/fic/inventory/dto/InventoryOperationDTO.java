package com.mx.fic.inventory.dto;

import java.sql.Timestamp;

public class InventoryOperationDTO implements BaseDTO{

	private static final long serialVersionUID = -8485845877258715182L;

	private Integer id;
	private Integer operationId;
	private String movementConcept;
	private String movementType;
	private Timestamp movementDate;
	private Double amount;
	private Double valueUnit;
	private Double valueTotal;
	private Double amountBalance;
	private Double valueUnitBalance;
	private Double valueTotalBalance;
	private Integer companyId;
	private Integer productId;
	private Integer inventoryOperationRootId;
	private Boolean status;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getOperationId() {
		return operationId;
	}
	public void setOperationId(Integer operationId) {
		this.operationId = operationId;
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
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getInventoryOperationRootId() {
		return inventoryOperationRootId;
	}
	public void setInventoryOperationRootId(Integer inventoryOperationRootId) {
		this.inventoryOperationRootId = inventoryOperationRootId;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
}
