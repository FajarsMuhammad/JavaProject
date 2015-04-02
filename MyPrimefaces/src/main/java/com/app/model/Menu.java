package com.app.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the menu2 database table.
 * 
 */
@Entity
@NamedQuery(name="Menu.findAll", query="SELECT m FROM Menu m")
public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MENU2_MENUID_GENERATOR", sequenceName="menu_id_seq" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MENU2_MENUID_GENERATOR")
	@Column(name="menu_id")
	private Long menuId;

	@Column(name="menu_code")
	private String menuCode;

	@Column(name="menu_level")
	private Integer menuLevel;

	@Column(name="menu_name")
	private String menuName;

	@Column(name="menu_type")
	private Integer menuType;

	@Column(name="menu_url")
	private String menuUrl;

	@Column(name="parent_code")
	private String parentCode;

	private Integer sequence;


	public Menu() {
	}

	public Long getMenuId() {
		return this.menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public String getMenuCode() {
		return this.menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	public Integer getMenuLevel() {
		return this.menuLevel;
	}

	public void setMenuLevel(Integer menuLevel) {
		this.menuLevel = menuLevel;
	}

	public String getMenuName() {
		return this.menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public Integer getMenuType() {
		return this.menuType;
	}

	public void setMenuType(Integer menuType) {
		this.menuType = menuType;
	}

	public String getMenuUrl() {
		return this.menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public String getParentCode() {
		return this.parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public Integer getSequence() {
		return this.sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

}