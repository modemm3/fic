package com.mx.fic.inventory.dto;

import java.math.BigDecimal;

public class ProductDTO implements BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -87290933255998354L;
	private Integer id;
	private String name;
	private BigDecimal publicPrice;
	private BigDecimal stock;
	private Integer categoryId;
	private Integer departmentId;
	private Integer productId;
	private BigDecimal buyPrice;
	private String code;
	
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
	public BigDecimal getPublicPrice() {
		return publicPrice;
	}
	public void setPublicPrice(BigDecimal publicPrice) {
		this.publicPrice = publicPrice;
	}
	public BigDecimal getStock() {
		return stock;
	}
	public void setStock(BigDecimal stock) {
		this.stock = stock;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public Integer getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public BigDecimal getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(BigDecimal buyPrice) {
		this.buyPrice = buyPrice;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", publicPrice=");
		builder.append(publicPrice);
		builder.append(", stock=");
		builder.append(stock);
		builder.append(", categoryId=");
		builder.append(categoryId);
		builder.append(", departmentId=");
		builder.append(departmentId);
		builder.append(", productId=");
		builder.append(productId);
		builder.append(", buyPrice=");
		builder.append(buyPrice);
		builder.append(", code=");
		builder.append(code);
		builder.append("]");
		return builder.toString();
	}

}
