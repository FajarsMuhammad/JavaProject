package com.app.model;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;


/**
 * The persistent class for the customer database table.
 * 
 */
@Entity
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;
		
		
	@Id
	@SequenceGenerator(name="my_seq", sequenceName="customer_id_seq")
	@GeneratedValue(generator = "my_seq", strategy = GenerationType.SEQUENCE)	
	@Column(name="customer_id")
	private Long customerId;

	private String address;

	@Column(name="created_by")
	private String createdBy;

	@Column(name="created_date")
	private Timestamp createdDate;

	@Column(name="customer_code")
	private String customerCode;

	@Column(name="customer_grade")
	private String customerGrade;

	@Column(name="customer_name")
	private String customerName;

	private Integer deleted;

	private String gender;

	@Column(name="last_updated")
	private Timestamp lastUpdated;

	@Column(name="last_updated_by")
	private String lastUpdatedBy;

	@Column(name="term_of_payment")
	private boolean termOfPayment;
	
	//@Transient
	//private boolean checked;

	//public boolean isChecked() {
	//	return checked;
	//}

	//public void setChecked(boolean checked) {
		//this.checked = checked;
	//	setTermOfPayment(checked ? 1 : 0);
	//}

	public Customer() {
	}

	public Long getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public String getCustomerCode() {
		return this.customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getCustomerGrade() {
		return this.customerGrade;
	}

	public void setCustomerGrade(String customerGrade) {
		this.customerGrade = customerGrade;
	}

	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Integer getDeleted() {
		return this.deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Timestamp getLastUpdated() {
		return this.lastUpdated;
	}

	public void setLastUpdated(Timestamp lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public String getLastUpdatedBy() {
		return this.lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public boolean getTermOfPayment() {
		return this.termOfPayment;
	}

	public void setTermOfPayment(boolean termOfPayment) {
		this.termOfPayment = termOfPayment;
	}

}