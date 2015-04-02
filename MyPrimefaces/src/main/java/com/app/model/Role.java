package com.app.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the role database table.
 * 
 */
@Entity
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "role_id_seq")
	@GeneratedValue(generator = "role_id_seq", strategy = GenerationType.SEQUENCE)
	@Column(name="role_id")
	private Long roleId;

	@Column(name="role_longdescription")
	private String roleLongdescription;

	@Column(name="role_shortdescription")
	private String roleShortdescription;

	private Integer version;

	//bi-directional many-to-one association to UserRole
	@OneToMany(mappedBy="role")
	private List<UserRole> userRoles;

	public Role() {
	}

	public Long getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleLongdescription() {
		return this.roleLongdescription;
	}

	public void setRoleLongdescription(String roleLongdescription) {
		this.roleLongdescription = roleLongdescription;
	}

	public String getRoleShortdescription() {
		return this.roleShortdescription;
	}

	public void setRoleShortdescription(String roleShortdescription) {
		this.roleShortdescription = roleShortdescription;
	}

	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public List<UserRole> getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public UserRole addUserRole(UserRole userRole) {
		getUserRoles().add(userRole);
		userRole.setRole(this);

		return userRole;
	}

	public UserRole removeUserRole(UserRole userRole) {
		getUserRoles().remove(userRole);
		userRole.setRole(null);

		return userRole;
	}

}