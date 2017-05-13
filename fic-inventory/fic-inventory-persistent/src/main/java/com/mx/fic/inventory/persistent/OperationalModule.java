package com.mx.fic.inventory.persistent;

import java.sql.Timestamp;

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
@Table (name="operational_module")
public class OperationalModule implements BaseEntity{
	
	private static final long serialVersionUID = -7968907044018553283L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="name")
	private String name;
	@Column(name="description")
	private String description;
	@Column(name="key")
	private Integer key;
	@Column(name="active")
	private Boolean active;
	@Column(name="creation_date")
	private Timestamp creationDate;
	@Column(name="last_update")
	private Timestamp lastUpdate;
	@JoinColumn(name="modify_by", referencedColumnName="id")
	@ManyToOne(fetch=FetchType.LAZY)
	private User user;
	@Column(name="is_parent")
	private Boolean isParent;
	@Column(name="class")
	private String clase;
	@Column(name="title")
	private String title;
	@Column(name="is_module")
	private Boolean isModule;
	@JoinColumn(name="parent", referencedColumnName="id")
	@ManyToOne(fetch=FetchType.LAZY)
	private OperationalModule parent;
	
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
	public Integer getKey() {
		return key;
	}
	public void setKey(Integer key) {
		this.key = key;
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
	public Timestamp getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Boolean getIsParent() {
		return isParent;
	}
	public void setIsParent(Boolean isParent) {
		this.isParent = isParent;
	}
	public String getClase() {
		return clase;
	}
	public void setClase(String clase) {
		this.clase = clase;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Boolean getIsModule() {
		return isModule;
	}
	public void setIsModule(Boolean isModule) {
		this.isModule = isModule;
	}
	public OperationalModule getParent() {
		return parent;
	}
	public void setParent(OperationalModule parent) {
		this.parent = parent;
	}
	
	public String toString() {
		return "OperationalModule [id=" + id + ", name=" + name + ", description=" + description + ", key=" + key
				+ ", active=" + active + ", creationDate=" + creationDate + ", lastUpdate=" + lastUpdate + ", user="
				+ user + ", isParent=" + isParent + ", clase=" + clase + ", title=" + title + ", isModule=" + isModule
				+ ", parent=" + parent + "]";
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((active == null) ? 0 : active.hashCode());
		result = prime * result + ((clase == null) ? 0 : clase.hashCode());
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((isModule == null) ? 0 : isModule.hashCode());
		result = prime * result + ((isParent == null) ? 0 : isParent.hashCode());
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((lastUpdate == null) ? 0 : lastUpdate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((parent == null) ? 0 : parent.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		OperationalModule other = (OperationalModule) obj;
		if (active == null) {
			if (other.active != null)
				return false;
		} else if (!active.equals(other.active))
			return false;
		if (clase == null) {
			if (other.clase != null)
				return false;
		} else if (!clase.equals(other.clase))
			return false;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
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
		if (isModule == null) {
			if (other.isModule != null)
				return false;
		} else if (!isModule.equals(other.isModule))
			return false;
		if (isParent == null) {
			if (other.isParent != null)
				return false;
		} else if (!isParent.equals(other.isParent))
			return false;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (lastUpdate == null) {
			if (other.lastUpdate != null)
				return false;
		} else if (!lastUpdate.equals(other.lastUpdate))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (parent == null) {
			if (other.parent != null)
				return false;
		} else if (!parent.equals(other.parent))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

}
