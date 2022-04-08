package tech.klok.challenge.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;

import tech.klok.challenge.model.categories.ChargeStatus;

@Entity
@Table(name="t_charge")
public class Charge implements Serializable{

	private static final long serialVersionUID = -8843957538784161722L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="charge_id")
	private Long id;
	
	@Temporal(TemporalType.DATE)
	private Date chargingDate;
	
	private ChargeStatus status;
	
	@Min(value=0)
	private Double amount;


	public Date getChargingDate() {
		return chargingDate;
	}
	public void setChargingDate(Date chargingDate) {
		this.chargingDate = chargingDate;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public ChargeStatus getStatus() {
		return status;
	}
	public void setStatus(ChargeStatus status) {
		this.status = status;
	}
	
}