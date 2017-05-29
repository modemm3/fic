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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table (name="valuation")
@NamedQueries ({
	@NamedQuery (name="Valuation.getAllByCompany", query="select val from Valuation val where val.company.id=:id")
})
public class Valuation implements BaseEntity{

	private static final long serialVersionUID = 8823162178216896791L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer serialId;
	@Column(name="fiscal_exercise")
	private Integer exerciseFiscal;
	@Column(name="start_date")
	private Timestamp dateStart;
	@Column(name="end_date")
	private Timestamp dateEnd;
	@JoinColumn(name="valuation_type_id", referencedColumnName="id")
	@ManyToOne(fetch=FetchType.LAZY)	
	private ValuationType valuationType;
	@JoinColumn(name="company_id", referencedColumnName="id")
	@ManyToOne(fetch=FetchType.LAZY)		
	private Company company;
	@JoinColumn(name="status_id", referencedColumnName="id")
	@ManyToOne(fetch=FetchType.LAZY)		
	private Status status;
	
	public Integer getSerialId() {
		return serialId;
	}
	public void setSerialId(Integer serialId) {
		this.serialId = serialId;
	}
	public Integer getExerciseFiscal() {
		return exerciseFiscal;
	}
	public void setExerciseFiscal(Integer exerciseFiscal) {
		this.exerciseFiscal = exerciseFiscal;
	}
	public Timestamp getDateStart() {
		return dateStart;
	}
	public void setDateStart(Timestamp dateStart) {
		this.dateStart = dateStart;
	}
	public Timestamp getDateEnd() {
		return dateEnd;
	}
	public void setDateEnd(Timestamp dateEnd) {
		this.dateEnd = dateEnd;
	}
	public ValuationType getValuationType() {
		return valuationType;
	}
	public void setValuationType(ValuationType valuationType) {
		this.valuationType = valuationType;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}

}
