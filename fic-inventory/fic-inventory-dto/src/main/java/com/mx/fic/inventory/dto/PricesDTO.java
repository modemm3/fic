package com.mx.fic.inventory.dto;

import java.sql.Timestamp;

public class PricesDTO implements BaseDTO{

	private static final long serialVersionUID = -7741870907736597838L;
	private Integer id;
	private TypePriceDTO typePriceDTO;
	private Double price;
	private ProductDTO productDTO;
	private Timestamp creationDate;
	private SeasonDTO seasonDTO;
	private StatusDTO statusDTO;
	private CompanyDTO companyDTO;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public TypePriceDTO getTypePriceDTO() {
		return typePriceDTO;
	}
	public void setTypePriceDTO(TypePriceDTO typePriceDTO) {
		this.typePriceDTO = typePriceDTO;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public ProductDTO getProductDTO() {
		return productDTO;
	}
	public void setProductDTO(ProductDTO productDTO) {
		this.productDTO = productDTO;
	}
	public Timestamp getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}
	public SeasonDTO getSeasonDTO() {
		return seasonDTO;
	}
	public void setSeasonDTO(SeasonDTO seasonDTO) {
		this.seasonDTO = seasonDTO;
	}
	public StatusDTO getStatusDTO() {
		return statusDTO;
	}
	public void setStatusDTO(StatusDTO statusDTO) {
		this.statusDTO = statusDTO;
	}
	public CompanyDTO getCompanyDTO() {
		return companyDTO;
	}
	public void setCompanyDTO(CompanyDTO companyDTO) {
		this.companyDTO = companyDTO;
	}
	
}
