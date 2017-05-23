package com.mx.fic.inventory.dto;

import java.sql.Timestamp;

public class UserDTO implements BaseDTO{

	private static final long serialVersionUID = 47894269877956026L;

	private Integer id;
	private UserDetailDTO userDetail;
	private String name;
	private String password;
	private Boolean active;
	private Timestamp creationDate;
	private Timestamp modificationDate;
	private UserDTO modifyBy;
	private Timestamp lastAccess;
	private Timestamp passwordChangeDate;
	private Boolean passwordChangeEnable;
	private SecretQuestionDTO secretQuestionDTO;
	private String responseSecret;
	private Integer passwordChangeNotification;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public UserDetailDTO getUserDetail() {
		return userDetail;
	}
	public void setUserDetail(UserDetailDTO userDetail) {
		this.userDetail = userDetail;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public Timestamp getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}
	public Timestamp getModificationDate() {
		return modificationDate;
	}
	public void setModificationDate(Timestamp modificationDate) {
		this.modificationDate = modificationDate;
	}
	public UserDTO getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(UserDTO modifyBy) {
		this.modifyBy = modifyBy;
	}
	public Timestamp getLastAccess() {
		return lastAccess;
	}
	public void setLastAccess(Timestamp lastAccess) {
		this.lastAccess = lastAccess;
	}
	public Timestamp getPasswordChangeDate() {
		return passwordChangeDate;
	}
	public void setPasswordChangeDate(Timestamp passwordChangeDate) {
		this.passwordChangeDate = passwordChangeDate;
	}
	public Boolean getPasswordChangeEnable() {
		return passwordChangeEnable;
	}
	public void setPasswordChangeEnable(Boolean passwordChangeEnable) {
		this.passwordChangeEnable = passwordChangeEnable;
	}
	public SecretQuestionDTO getSecretQuestionDTO() {
		return secretQuestionDTO;
	}
	public void setSecretQuestionDTO(SecretQuestionDTO secretQuestionDTO) {
		this.secretQuestionDTO = secretQuestionDTO;
	}
	public String getResponseSecret() {
		return responseSecret;
	}
	public void setResponseSecret(String responseSecret) {
		this.responseSecret = responseSecret;
	}
	public Integer getPasswordChangeNotification() {
		return passwordChangeNotification;
	}
	public void setPasswordChangeNotification(Integer passwordChangeNotification) {
		this.passwordChangeNotification = passwordChangeNotification;
	}
	
	public String toString() {
		return "UserDTO [id=" + id + ", userDetail=" + userDetail + ", name=" + name + ", password=" + password
				+ ", active=" + active + ", creationDate=" + creationDate + ", modificationDate=" + modificationDate
				+ ", modifyBy=" + modifyBy + ", lastAccess=" + lastAccess + ", passwordChangeDate=" + passwordChangeDate
				+ ", passwordChangeEnable=" + passwordChangeEnable + ", secretQuestionDTO=" + secretQuestionDTO
				+ ", responseSecret=" + responseSecret + ", passwordChangeNotification=" + passwordChangeNotification
				+ "]";
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((active == null) ? 0 : active.hashCode());
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastAccess == null) ? 0 : lastAccess.hashCode());
		result = prime * result + ((modificationDate == null) ? 0 : modificationDate.hashCode());
		result = prime * result + ((modifyBy == null) ? 0 : modifyBy.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((passwordChangeDate == null) ? 0 : passwordChangeDate.hashCode());
		result = prime * result + ((passwordChangeEnable == null) ? 0 : passwordChangeEnable.hashCode());
		result = prime * result + ((passwordChangeNotification == null) ? 0 : passwordChangeNotification.hashCode());
		result = prime * result + ((responseSecret == null) ? 0 : responseSecret.hashCode());
		result = prime * result + ((secretQuestionDTO == null) ? 0 : secretQuestionDTO.hashCode());
		result = prime * result + ((userDetail == null) ? 0 : userDetail.hashCode());
		return result;
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDTO other = (UserDTO) obj;
		if (active == null) {
			if (other.active != null)
				return false;
		} else if (!active.equals(other.active))
			return false;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastAccess == null) {
			if (other.lastAccess != null)
				return false;
		} else if (!lastAccess.equals(other.lastAccess))
			return false;
		if (modificationDate == null) {
			if (other.modificationDate != null)
				return false;
		} else if (!modificationDate.equals(other.modificationDate))
			return false;
		if (modifyBy == null) {
			if (other.modifyBy != null)
				return false;
		} else if (!modifyBy.equals(other.modifyBy))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (passwordChangeDate == null) {
			if (other.passwordChangeDate != null)
				return false;
		} else if (!passwordChangeDate.equals(other.passwordChangeDate))
			return false;
		if (passwordChangeEnable == null) {
			if (other.passwordChangeEnable != null)
				return false;
		} else if (!passwordChangeEnable.equals(other.passwordChangeEnable))
			return false;
		if (passwordChangeNotification == null) {
			if (other.passwordChangeNotification != null)
				return false;
		} else if (!passwordChangeNotification.equals(other.passwordChangeNotification))
			return false;
		if (responseSecret == null) {
			if (other.responseSecret != null)
				return false;
		} else if (!responseSecret.equals(other.responseSecret))
			return false;
		if (secretQuestionDTO == null) {
			if (other.secretQuestionDTO != null)
				return false;
		} else if (!secretQuestionDTO.equals(other.secretQuestionDTO))
			return false;
		if (userDetail == null) {
			if (other.userDetail != null)
				return false;
		} else if (!userDetail.equals(other.userDetail))
			return false;
		return true;
	}
	
}
