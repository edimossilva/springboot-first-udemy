package com.loop.firstproject.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.loop.firstproject.enums.ProfileEnum;

@Entity
@Table(name = "employer")
public class Employer implements Serializable {

	private static final long serialVersionUID = 2248649304288611329L;
	
	private Long id;
	private String name;
	private String email;
	private String cpf;
	private BigDecimal valuePerHour;
	private ProfileEnum profile;
	private Date creationDate;
	private Date updateDate;
	private Float lunchTimeQuantity;
	private Float workTimeQuantity;
	private String password;
	private Enterprise enterprise;

	@Enumerated(EnumType.STRING)
	@Column(name = "profile", nullable = false)
	public ProfileEnum getProfile() {
		return profile;
	}

	public void setProfile(ProfileEnum profile) {
		this.profile = profile;
	}

	@Column(name = "creation_date", nullable = false)
	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Column(name = "update_date", nullable = false)
	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	
	@PreUpdate
	public void preUpdate() {
		updateDate = new Date();
	}

	@PrePersist
	public void prePersist() {
		final Date newDate = new Date();
		creationDate = newDate;
		updateDate = newDate;
	}

	@Override
	public String toString() {
		return "Employer [id=" + id + ", name=" + name + ", email=" + email + ", cpf=" + cpf + ", valuePerHour="
				+ valuePerHour + ", profile=" + profile + ", creationDate=" + creationDate + ", updateDate="
				+ updateDate + ", lunchTimeQuantity=" + lunchTimeQuantity + ", workTimeQuantity=" + workTimeQuantity
				+ ", password=" + password + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "email", nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "password", nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name = "cpf", nullable = false)
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Column(name = "value_per_hour", nullable = false)
	public BigDecimal getValuePerHour() {
		return valuePerHour;
	}

	public void setValuePerHour(BigDecimal valuePerHour) {
		this.valuePerHour = valuePerHour;
	}

	@Column(name = "lunch_time_quantity", nullable = false)
	public Float getLunchTimeQuantity() {
		return lunchTimeQuantity;
	}

	public void setLunchTimeQuantity(Float lunchTimeQuantity) {
		this.lunchTimeQuantity = lunchTimeQuantity;
	}

	@Column(name = "work_time_quantity", nullable = false)
	public Float getWorkTimeQuantity() {
		return workTimeQuantity;
	}

	public void setWorkTimeQuantity(Float workTimeQuantity) {
		this.workTimeQuantity = workTimeQuantity;
	}
}
