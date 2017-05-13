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
@Table (name="retries")
public class Retries implements BaseEntity{

	private static final long serialVersionUID = 8142326530131496122L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@JoinColumn(name="user_id", referencedColumnName="id")
	@ManyToOne(fetch=FetchType.LAZY)
	private User user;
	@Column(name="retry")
	private Integer retry;
	@Column(name="max_retry")
	private Integer maxRetry;
	@Column(name="minutes")
	private Integer minutes;
	@Column(name="active")
	private boolean active;
	
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
	public Integer getRetry() {
		return retry;
	}
	public void setRetry(Integer retry) {
		this.retry = retry;
	}
	public Integer getMaxRetry() {
		return maxRetry;
	}
	public void setMaxRetry(Integer maxRetry) {
		this.maxRetry = maxRetry;
	}
	public Integer getMinutes() {
		return minutes;
	}
	public void setMinutes(Integer minutes) {
		this.minutes = minutes;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public String toString() {
		return "Retries [id=" + id + ", retry=" + retry + ", maxRetry=" + maxRetry + ", minutes=" + minutes
				+ ", active=" + active + "]";
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (active ? 1231 : 1237);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((maxRetry == null) ? 0 : maxRetry.hashCode());
		result = prime * result + ((minutes == null) ? 0 : minutes.hashCode());
		result = prime * result + ((retry == null) ? 0 : retry.hashCode());
		return result;
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Retries other = (Retries) obj;
		if (active != other.active)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (maxRetry == null) {
			if (other.maxRetry != null)
				return false;
		} else if (!maxRetry.equals(other.maxRetry))
			return false;
		if (minutes == null) {
			if (other.minutes != null)
				return false;
		} else if (!minutes.equals(other.minutes))
			return false;
		if (retry == null) {
			if (other.retry != null)
				return false;
		} else if (!retry.equals(other.retry))
			return false;
		return true;
	}
	
}
