package com.mx.fic.inventory.persistent;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="sesssions")
public class Sesssions implements BaseEntity{
	
	private static final long serialVersionUID = 1524199260135646502L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@JoinColumn(name="user_id", referencedColumnName="id")
	@ManyToOne(fetch=FetchType.LAZY)
	private User user;
	@Column(name="jsession_id")
	private String jSessionId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getjSessionId() {
		return jSessionId;
	}
	public void setjSessionId(String jSessionId) {
		this.jSessionId = jSessionId;
	}
	
	public String toString() {
		return "Sesssions [id=" + id + ", user=" + user + ", jSessionId=" + jSessionId + "]";
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((jSessionId == null) ? 0 : jSessionId.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sesssions other = (Sesssions) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (jSessionId == null) {
			if (other.jSessionId != null)
				return false;
		} else if (!jSessionId.equals(other.jSessionId))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
}
