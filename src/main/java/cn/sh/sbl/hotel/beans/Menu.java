/**
 * Copyright © 2013, Bunco All Rights Reserved.
 * cn.sh.sbl.hotel.beans.Menu.java
 * Create By: Bunco
 * Create Date: 2013-11-21 14:47:56
 */
package cn.sh.sbl.hotel.beans;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Entity: cn.sh.sbl.hotel.beans.Menu
 * @author Bunco
 * @E-mail: amwihc512@qq.com
 * @version 1.0
 * @date 2013-11-21 14:47:56
 * @description terminal display menu
 */
public class Menu implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	/** 
	 * The id of the menu.
	 */
	private Integer id;

	/** 
	 * The parent of the menu.
	 */
	private Menu menu;

	/** 
	 * The terminal display style of the menu.
	 */
	private Category category;

	/** 
	 * The name of the menu.
	 */
	private String name;

	/** 
	 * The display sub menu order of the parent menu.
	 */
	private Integer displayOrder;

	/** 
	 * The path of the menu.
	 */
	private String path;

	/** 
	 * Has child of the menu.
	 */
	private Boolean hasChild;

	/** 
	 * Is valid of menu.
	 */
	private Boolean valid;

	/** 
	 * The level of the menu.
	 */
	private Integer level;

	/** 
	 * The icon of the menu.
	 */
	private String icon;

	/** 
	 * The  focus icon of the menu.
	 */
	private String focusIcon;

	/** 
	 * The last update time of the menu.
	 */
	private Date lastUpdate;

	/** 
	 * The remark of the menu.
	 */
	private String remark;

	private Set<Menu> menus = new HashSet<Menu>(0);

	private Set<MenuFilm> menuFilms = new HashSet<MenuFilm>(0);

	/**
	 * default constructor
	 */
	public Menu() {
	}

	/**
	 * minimal constructor
	 * @param lastUpdate		The last update time of the menu
	 */
	public Menu(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	/**
	 * full constructor
	 * @param menu		The parent of the menu
	 * @param category		The terminal display style of the menu
	 * @param name		The name of the menu
	 * @param displayOrder		The display sub menu order of the parent menu
	 * @param path		The path of the menu
	 * @param hasChild		Has child of the menu
	 * @param valid		Is valid of menu
	 * @param level		The level of the menu
	 * @param icon		The icon of the menu
	 * @param focusIcon		The  focus icon of the menu
	 * @param lastUpdate		The last update time of the menu
	 * @param remark		The remark of the menu
	 */
	public Menu(Menu menu, Category category, String name,
			Integer displayOrder, String path, Boolean hasChild, Boolean valid,
			Integer level, String icon, String focusIcon, Date lastUpdate,
			String remark, Set<Menu> menus, Set<MenuFilm> menuFilms) {
		this.menu = menu;
		this.category = category;
		this.name = name;
		this.displayOrder = displayOrder;
		this.path = path;
		this.hasChild = hasChild;
		this.valid = valid;
		this.level = level;
		this.icon = icon;
		this.focusIcon = focusIcon;
		this.lastUpdate = lastUpdate;
		this.remark = remark;
		this.menus = menus;
		this.menuFilms = menuFilms;
	}

	/**
	 * toJson
	 * @return String
	 */
	public String toJson() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		buffer.append("\"menu\":\"" + this.menu + "\",");
		buffer.append("\"category\":\"" + this.category + "\",");
		buffer.append("\"name\":\"" + this.name + "\",");
		buffer.append("\"displayOrder\":\"" + this.displayOrder + "\",");
		buffer.append("\"path\":\"" + this.path + "\",");
		buffer.append("\"hasChild\":\"" + this.hasChild + "\",");
		buffer.append("\"valid\":\"" + this.valid + "\",");
		buffer.append("\"level\":\"" + this.level + "\",");
		buffer.append("\"icon\":\"" + this.icon + "\",");
		buffer.append("\"focusIcon\":\"" + this.focusIcon + "\",");
		buffer.append("\"lastUpdate\":\"" + this.lastUpdate + "\",");
		buffer.append("\"remark\":\"" + this.remark + "\",");
		buffer.append("\"menus\":\"" + this.menus + "\",");
		buffer.append("\"menuFilms\":\"" + this.menuFilms + "\",");
		buffer.deleteCharAt(buffer.length() - 1);
		buffer.append("}");
		return buffer.toString();
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Menu[");
		buffer.append("\"menu\":\"" + this.menu + "\",");
		buffer.append("\"category\":\"" + this.category + "\",");
		buffer.append("\"name\":\"" + this.name + "\",");
		buffer.append("\"displayOrder\":\"" + this.displayOrder + "\",");
		buffer.append("\"path\":\"" + this.path + "\",");
		buffer.append("\"hasChild\":\"" + this.hasChild + "\",");
		buffer.append("\"valid\":\"" + this.valid + "\",");
		buffer.append("\"level\":\"" + this.level + "\",");
		buffer.append("\"icon\":\"" + this.icon + "\",");
		buffer.append("\"focusIcon\":\"" + this.focusIcon + "\",");
		buffer.append("\"lastUpdate\":\"" + this.lastUpdate + "\",");
		buffer.append("\"remark\":\"" + this.remark + "\",");
		buffer.append("\"menus\":\"" + this.menus + "\",");
		buffer.append("\"menuFilms\":\"" + this.menuFilms + "\",");
		buffer.deleteCharAt(buffer.length() - 1);
		buffer.append("]");
		return buffer.toString();
	}

	/**  
	 * get The id of the menu.
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * set The id of the menu.
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**  
	 * get The parent of the menu.
	 */
	public Menu getMenu() {
		return this.menu;
	}

	/**
	 * set The parent of the menu.
	 */
	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	/**  
	 * get The terminal display style of the menu.
	 */
	public Category getCategory() {
		return this.category;
	}

	/**
	 * set The terminal display style of the menu.
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

	/**  
	 * get The name of the menu.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * set The name of the menu.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**  
	 * get The display sub menu order of the parent menu.
	 */
	public Integer getDisplayOrder() {
		return this.displayOrder;
	}

	/**
	 * set The display sub menu order of the parent menu.
	 */
	public void setDisplayOrder(Integer displayOrder) {
		this.displayOrder = displayOrder;
	}

	/**  
	 * get The path of the menu.
	 */
	public String getPath() {
		return this.path;
	}

	/**
	 * set The path of the menu.
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**  
	 * get Has child of the menu.
	 */
	public Boolean getHasChild() {
		return this.hasChild;
	}

	/**
	 * set Has child of the menu.
	 */
	public void setHasChild(Boolean hasChild) {
		this.hasChild = hasChild;
	}

	/**  
	 * get Is valid of menu.
	 */
	public Boolean getValid() {
		return this.valid;
	}

	/**
	 * set Is valid of menu.
	 */
	public void setValid(Boolean valid) {
		this.valid = valid;
	}

	/**  
	 * get The level of the menu.
	 */
	public Integer getLevel() {
		return this.level;
	}

	/**
	 * set The level of the menu.
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}

	/**  
	 * get The icon of the menu.
	 */
	public String getIcon() {
		return this.icon;
	}

	/**
	 * set The icon of the menu.
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}

	/**  
	 * get The  focus icon of the menu.
	 */
	public String getFocusIcon() {
		return this.focusIcon;
	}

	/**
	 * set The  focus icon of the menu.
	 */
	public void setFocusIcon(String focusIcon) {
		this.focusIcon = focusIcon;
	}

	/**  
	 * get The last update time of the menu.
	 */
	public Date getLastUpdate() {
		return this.lastUpdate;
	}

	/**
	 * set The last update time of the menu.
	 */
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	/**  
	 * get The remark of the menu.
	 */
	public String getRemark() {
		return this.remark;
	}

	/**
	 * set The remark of the menu.
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**  
	 */
	public Set<Menu> getMenus() {
		return this.menus;
	}

	/**
	 */
	public void setMenus(Set<Menu> menus) {
		this.menus = menus;
	}

	/**  
	 */
	public Set<MenuFilm> getMenuFilms() {
		return this.menuFilms;
	}

	/**
	 */
	public void setMenuFilms(Set<MenuFilm> menuFilms) {
		this.menuFilms = menuFilms;
	}

}
