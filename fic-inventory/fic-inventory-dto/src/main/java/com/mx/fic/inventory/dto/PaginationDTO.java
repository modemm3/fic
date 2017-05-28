package com.mx.fic.inventory.dto;

public class PaginationDTO implements BaseDTO {

	private static final long serialVersionUID = -4579415042708872188L;
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
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numberRecords == null) ? 0 : numberRecords.hashCode());
		result = prime * result + ((pageInitial == null) ? 0 : pageInitial.hashCode());
		return result;
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PaginationDTO other = (PaginationDTO) obj;
		if (numberRecords == null) {
			if (other.numberRecords != null)
				return false;
		} else if (!numberRecords.equals(other.numberRecords))
			return false;
		if (pageInitial == null) {
			if (other.pageInitial != null)
				return false;
		} else if (!pageInitial.equals(other.pageInitial))
			return false;
		return true;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PaginationDTO [pageInitial=");
		builder.append(pageInitial);
		builder.append(", numberRecords=");
		builder.append(numberRecords);
		builder.append("]");
		return builder.toString();
	}

}
