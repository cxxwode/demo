/**
 * Copyright © 2013, Bunco All Rights Reserved.
 * cn.sh.sbl.hotel.beans.Category.java
 * Create By: Bunco
 * Create Date: 2013-11-21 14:47:56
 */
package cn.sh.sbl.hotel.beans;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Entity: cn.sh.sbl.hotel.beans.Category
 * @author Bunco
 * @E-mail: amwihc512@qq.com
 * @version 1.0
 * @date 2013-11-21 14:47:56
 * @description the categorys table
 */
public class Category implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	/** 
	 * The id of the category.
	 */
	private Integer id;

	/** 
	 * The key of the category.
	 */
	private String ckey;

	/** 
	 * The value of the category.
	 */
	private String cval;

	/** 
	 * The last update time of the category.
	 */
	private Date lastUpdate;

	private Set<File> files = new HashSet<File>(0);

	private Set<Film> films = new HashSet<Film>(0);

	private Set<Menu> menus = new HashSet<Menu>(0);

	private Set<Film> films_1 = new HashSet<Film>(0);

	/**
	 * default constructor
	 */
	public Category() {
	}

	/**
	 * minimal constructor
	 * @param lastUpdate		The last update time of the category
	 */
	public Category(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	/**
	 * full constructor
	 * @param ckey		The key of the category
	 * @param cval		The value of the category
	 * @param lastUpdate		The last update time of the category
	 */
	public Category(String ckey, String cval, Date lastUpdate, Set<File> files,
			Set<Film> films, Set<Menu> menus, Set<Film> films_1) {
		this.ckey = ckey;
		this.cval = cval;
		this.lastUpdate = lastUpdate;
		this.files = files;
		this.films = films;
		this.menus = menus;
		this.films_1 = films_1;
	}

	/**
	 * toJson
	 * @return String
	 */
	public String toJson() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		buffer.append("\"ckey\":\"" + this.ckey + "\",");
		buffer.append("\"cval\":\"" + this.cval + "\",");
		buffer.append("\"lastUpdate\":\"" + this.lastUpdate + "\",");
		buffer.append("\"files\":\"" + this.files + "\",");
		buffer.append("\"films\":\"" + this.films + "\",");
		buffer.append("\"menus\":\"" + this.menus + "\",");
		buffer.append("\"films_1\":\"" + this.films_1 + "\",");
		buffer.deleteCharAt(buffer.length() - 1);
		buffer.append("}");
		return buffer.toString();
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Category[");
		buffer.append("\"ckey\":\"" + this.ckey + "\",");
		buffer.append("\"cval\":\"" + this.cval + "\",");
		buffer.append("\"lastUpdate\":\"" + this.lastUpdate + "\",");
		buffer.append("\"files\":\"" + this.files + "\",");
		buffer.append("\"films\":\"" + this.films + "\",");
		buffer.append("\"menus\":\"" + this.menus + "\",");
		buffer.append("\"films_1\":\"" + this.films_1 + "\",");
		buffer.deleteCharAt(buffer.length() - 1);
		buffer.append("]");
		return buffer.toString();
	}

	/**  
	 * get The id of the category.
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * set The id of the category.
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**  
	 * get The key of the category.
	 */
	public String getCkey() {
		return this.ckey;
	}

	/**
	 * set The key of the category.
	 */
	public void setCkey(String ckey) {
		this.ckey = ckey;
	}

	/**  
	 * get The value of the category.
	 */
	public String getCval() {
		return this.cval;
	}

	/**
	 * set The value of the category.
	 */
	public void setCval(String cval) {
		this.cval = cval;
	}

	/**  
	 * get The last update time of the category.
	 */
	public Date getLastUpdate() {
		return this.lastUpdate;
	}

	/**
	 * set The last update time of the category.
	 */
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	/**  
	 */
	public Set<File> getFiles() {
		return this.files;
	}

	/**
	 */
	public void setFiles(Set<File> files) {
		this.files = files;
	}

	/**  
	 */
	public Set<Film> getFilms() {
		return this.films;
	}

	/**
	 */
	public void setFilms(Set<Film> films) {
		this.films = films;
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
	public Set<Film> getFilms_1() {
		return this.films_1;
	}

	/**
	 */
	public void setFilms_1(Set<Film> films_1) {
		this.films_1 = films_1;
	}

}
