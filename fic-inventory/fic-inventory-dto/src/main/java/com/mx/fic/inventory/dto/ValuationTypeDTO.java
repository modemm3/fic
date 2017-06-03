package com.mx.fic.inventory.dto;

public class ValuationTypeDTO implements BaseDTO {

	private static final long serialVersionUID = -7964096648923165828L;

	private Integer id;
	private String name;
	private String description;
	private String keyValuation;
	
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
	public String getKeyValuation() {
		return keyValuation;
	}
	public void setKeyValuation(String keyValuation) {
		this.keyValuation = keyValuation;
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((keyValuation == null) ? 0 : keyValuation.hashCode());
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
		ValuationTypeDTO other = (ValuationTypeDTO) obj;
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
		if (keyValuation == null) {
			if (other.keyValuation != null)
				return false;
		} else if (!keyValuation.equals(other.keyValuation))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ValuationTypeDTO [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", description=");
		builder.append(description);
		builder.append(", keyValuation=");
		builder.append(keyValuation);
		builder.append(", companyId=");
		builder.append("]");
		return builder.toString();
	}

}
