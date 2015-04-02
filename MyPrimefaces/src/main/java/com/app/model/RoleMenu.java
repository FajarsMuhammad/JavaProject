package com.app.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the role_menu database table.
 * 
 */
@Entity
@Table(name="role_menu")
@NamedQuery(name="RoleMenu.findAll", query="SELECT r FROM RoleMenu r")
public class RoleMenu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "role_menu_id_seq")
	@GeneratedValue(generator = "role_menu_id_seq", strategy = GenerationType.SEQUENCE)
	@Column(name="role_menu_id")
	private Long roleMenuId;

	@Column(name="created_by")
	private String createdBy;

	@Column(name="created_date")
	private Timestamp createdDate;

	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;
	
	@ManyToOne
	@JoinColumn(name = "menu_id")
	private Menu menu;

	public RoleMenu() {
	}

	public Long getRoleMenuId() {
		return this.roleMenuId;
	}

	public void setRoleMenuId(Long roleMenuId) {
		this.roleMenuId = roleMenuId;
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

	public Menu getMenu() {
		return this.menu;
	}

	public void setMenuId(Menu menu) {
		this.menu = menu;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRoleId(Role role) {
		this.role = role;
	}

}