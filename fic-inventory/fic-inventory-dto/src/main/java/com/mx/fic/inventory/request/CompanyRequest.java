package com.mx.fic.inventory.request;

import com.mx.fic.inventory.dto.AddressDTO;
import com.mx.fic.inventory.dto.CompanyDTO;

public class CompanyRequest {
	
	private AddressDTO addressDTO;
	private CompanyDTO companyDTO;
	
	public AddressDTO getAddressDTO() {
		return addressDTO;
	}
	public void setAddressDTO(AddressDTO addressDTO) {
		this.addressDTO = addressDTO;
	}
	public CompanyDTO getCompanyDTO() {
		return companyDTO;
	}
	public void setCompanyDTO(CompanyDTO companyDTO) {
		this.companyDTO = companyDTO;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CompanyRequest [addressDTO=").append(addressDTO).append(", companyDTO=").append(companyDTO)
				.append("]");
		return builder.toString();
	}

}
