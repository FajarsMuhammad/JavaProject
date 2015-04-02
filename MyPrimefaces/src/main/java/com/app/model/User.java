package com.app.model;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USER_USERID_GENERATOR", sequenceName="user_id_seq" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USER_USERID_GENERATOR")
	@Column(name="user_id")
	private Long userId;

	private Integer access;

	@Column(name="created_date")
	private Timestamp createdDate;

	private String password;

	@Column(name="right_name")
	private String rightName;

	@Column(name="user_about_you")
	private String userAboutYou;

	@Column(name="user_country")
	private String userCountry;

	@Column(name="user_gender")
	private String userGender;

	@Column(name="user_name")
	private String userName;

	//bi-directional many-to-one association to UserRole
	@OneToMany(mappedBy="user")
	private List<UserRole> userRoles;

	public User() {
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getAccess() {
		return this.access;
	}

	public void setAccess(Integer access) {
		this.access = access;
	}

	public Timestamp getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRightName() {
		return this.rightName;
	}

	public void setRightName(String rightName) {
		this.rightName = rightName;
	}

	public String getUserAboutYou() {
		return this.userAboutYou;
	}

	public void setUserAboutYou(String userAboutYou) {
		this.userAboutYou = userAboutYou;
	}

	public String getUserCountry() {
		return this.userCountry;
	}

	public void setUserCountry(String userCountry) {
		this.userCountry = userCountry;
	}

	public String getUserGender() {
		return this.userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<UserRole> getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public UserRole addUserRole(UserRole userRole) {
		getUserRoles().add(userRole);
		userRole.setUser(this);

		return userRole;
	}

	public UserRole removeUserRole(UserRole userRole) {
		getUserRoles().remove(userRole);
		userRole.setUser(null);

		return userRole;
	}

}