/**
 * Copyright © 2013, Bunco All Rights Reserved.
 * cn.sh.sbl.hotel.beans.MenuFilmId.java
 * Create By: Bunco
 * Create Date: 2013-11-21 14:47:56
 */
package cn.sh.sbl.hotel.beans;

/**
 * Entity: cn.sh.sbl.hotel.beans.MenuFilmId
 * @author Bunco
 * @E-mail: amwihc512@qq.com
 * @version 1.0
 * @date 2013-11-21 14:47:56
 * @description the menu film table
 */
public class MenuFilmId implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	/** 
	 * The id of the menu.
	 */
	private int menuId;

	/** 
	 * The id of the film.
	 */
	private String filmId;

	/**
	 * default constructor
	 */
	public MenuFilmId() {
	}

	/**
	 * full constructor
	 * @param menuId		The id of the menu
	 * @param filmId		The id of the film
	 */
	public MenuFilmId(int menuId, String filmId) {
		this.menuId = menuId;
		this.filmId = filmId;
	}

	/**
	 * toJson
	 * @return String
	 */
	public String toJson() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		buffer.append("\"menuId\":\"" + this.menuId + "\",");
		buffer.append("\"filmId\":\"" + this.filmId + "\",");
		buffer.deleteCharAt(buffer.length() - 1);
		buffer.append("}");
		return buffer.toString();
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("MenuFilmId[");
		buffer.append("\"menuId\":\"" + this.menuId + "\",");
		buffer.append("\"filmId\":\"" + this.filmId + "\",");
		buffer.deleteCharAt(buffer.length() - 1);
		buffer.append("]");
		return buffer.toString();
	}

	/**  
	 * get The id of the menu.
	 */
	public int getMenuId() {
		return this.menuId;
	}

	/**
	 * set The id of the menu.
	 */
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	/**  
	 * get The id of the film.
	 */
	public String getFilmId() {
		return this.filmId;
	}

	/**
	 * set The id of the film.
	 */
	public void setFilmId(String filmId) {
		this.filmId = filmId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof MenuFilmId))
			return false;
		MenuFilmId castOther = (MenuFilmId) other;

		return (this.getMenuId() == castOther.getMenuId())
				&& ((this.getFilmId() == castOther.getFilmId()) || (this
						.getFilmId() != null && castOther.getFilmId() != null && this
						.getFilmId().equals(castOther.getFilmId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getMenuId();
		result = 37 * result
				+ (getFilmId() == null ? 0 : this.getFilmId().hashCode());
		return result;
	}

}
