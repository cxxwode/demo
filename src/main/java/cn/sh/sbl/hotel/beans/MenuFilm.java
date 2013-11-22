/**
 * Copyright © 2013, Bunco All Rights Reserved.
 * cn.sh.sbl.hotel.beans.MenuFilm.java
 * Create By: Bunco
 * Create Date: 2013-11-21 14:47:56
 */
package cn.sh.sbl.hotel.beans;

import java.util.Date;

/**
 * Entity: cn.sh.sbl.hotel.beans.MenuFilm
 * @author Bunco
 * @E-mail: amwihc512@qq.com
 * @version 1.0
 * @date 2013-11-21 14:47:56
 * @description the menu film table
 */
public class MenuFilm implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	/** 
	 * The id of the menu.
	 */
	/** 
	 * The id of the film.
	 */
	private MenuFilmId id;

	/** 
	 * The id of the menu.
	 */
	private Menu menu;

	/** 
	 * The id of the film.
	 */
	private Film film;

	/** 
	 * The display film order of the menu.
	 */
	private Integer displayOrder;

	/** 
	 * The last update time of the menu film.
	 */
	private Date lastUpdate;

	/**
	 * default constructor
	 */
	public MenuFilm() {
	}

	/**
	 * minimal constructor
	 * @param id		The id of the menu
	 * @param id		The id of the film
	 * @param menu		The id of the menu
	 * @param film		The id of the film
	 * @param lastUpdate		The last update time of the menu film
	 */
	public MenuFilm(MenuFilmId id, Menu menu, Film film, Date lastUpdate) {
		this.id = id;
		this.menu = menu;
		this.film = film;
		this.lastUpdate = lastUpdate;
	}

	/**
	 * full constructor
	 * @param id		The id of the menu
	 * @param id		The id of the film
	 * @param menu		The id of the menu
	 * @param film		The id of the film
	 * @param displayOrder		The display film order of the menu
	 * @param lastUpdate		The last update time of the menu film
	 */
	public MenuFilm(MenuFilmId id, Menu menu, Film film, Integer displayOrder,
			Date lastUpdate) {
		this.id = id;
		this.menu = menu;
		this.film = film;
		this.displayOrder = displayOrder;
		this.lastUpdate = lastUpdate;
	}

	/**
	 * toJson
	 * @return String
	 */
	public String toJson() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		buffer.append("\"id\":\"" + this.id + "\",");
		buffer.append("\"menu\":\"" + this.menu + "\",");
		buffer.append("\"film\":\"" + this.film + "\",");
		buffer.append("\"displayOrder\":\"" + this.displayOrder + "\",");
		buffer.append("\"lastUpdate\":\"" + this.lastUpdate + "\",");
		buffer.deleteCharAt(buffer.length() - 1);
		buffer.append("}");
		return buffer.toString();
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("MenuFilm[");
		buffer.append("\"id\":\"" + this.id + "\",");
		buffer.append("\"menu\":\"" + this.menu + "\",");
		buffer.append("\"film\":\"" + this.film + "\",");
		buffer.append("\"displayOrder\":\"" + this.displayOrder + "\",");
		buffer.append("\"lastUpdate\":\"" + this.lastUpdate + "\",");
		buffer.deleteCharAt(buffer.length() - 1);
		buffer.append("]");
		return buffer.toString();
	}

	/**  
	 * get The id of the menu.
	 * get The id of the film.
	 */
	public MenuFilmId getId() {
		return this.id;
	}

	/**
	 * set The id of the menu.
	 * set The id of the film.
	 */
	public void setId(MenuFilmId id) {
		this.id = id;
	}

	/**  
	 * get The id of the menu.
	 */
	public Menu getMenu() {
		return this.menu;
	}

	/**
	 * set The id of the menu.
	 */
	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	/**  
	 * get The id of the film.
	 */
	public Film getFilm() {
		return this.film;
	}

	/**
	 * set The id of the film.
	 */
	public void setFilm(Film film) {
		this.film = film;
	}

	/**  
	 * get The display film order of the menu.
	 */
	public Integer getDisplayOrder() {
		return this.displayOrder;
	}

	/**
	 * set The display film order of the menu.
	 */
	public void setDisplayOrder(Integer displayOrder) {
		this.displayOrder = displayOrder;
	}

	/**  
	 * get The last update time of the menu film.
	 */
	public Date getLastUpdate() {
		return this.lastUpdate;
	}

	/**
	 * set The last update time of the menu film.
	 */
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

}
