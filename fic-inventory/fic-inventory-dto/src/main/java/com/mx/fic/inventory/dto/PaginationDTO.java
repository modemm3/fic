package com.mx.fic.inventory.dto;

public class PaginationDTO implements BaseDTO {
	
	private Integer pageInitial;
	private Integer numberRecords;
	
	public Integer getPageInitial() {
		return pageInitial;
	}
	public void setPageInitial(Integer pageInitial) {
		this.pageInitial = pageInitial;
	}
	public Integer getNumberRecords() {
		return numberRecords;
	}
	public void setNumberRecords(Integer numberRecords) {
		this.numberRecords = numberRecords;
	}

}
