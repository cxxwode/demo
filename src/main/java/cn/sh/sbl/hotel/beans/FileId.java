/**
 * Copyright © 2013, Bunco All Rights Reserved.
 * cn.sh.sbl.hotel.beans.FileId.java
 * Create By: Bunco
 * Create Date: 2013-11-21 14:47:56
 */
package cn.sh.sbl.hotel.beans;

/**
 * Entity: cn.sh.sbl.hotel.beans.FileId
 * @author Bunco
 * @E-mail: amwihc512@qq.com
 * @version 1.0
 * @date 2013-11-21 14:47:56
 * @description the film file table
 */
public class FileId implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	/** 
	 * The id of the file.
	 */
	private int id;

	/** 
	 * The id of the film.
	 */
	private String filmId;

	/**
	 * default constructor
	 */
	public FileId() {
	}

	/**
	 * full constructor
	 * @param id		The id of the file
	 * @param filmId		The id of the film
	 */
	public FileId(int id, String filmId) {
		this.id = id;
		this.filmId = filmId;
	}

	/**
	 * toJson
	 * @return String
	 */
	public String toJson() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		buffer.append("\"id\":\"" + this.id + "\",");
		buffer.append("\"filmId\":\"" + this.filmId + "\",");
		buffer.deleteCharAt(buffer.length() - 1);
		buffer.append("}");
		return buffer.toString();
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("FileId[");
		buffer.append("\"id\":\"" + this.id + "\",");
		buffer.append("\"filmId\":\"" + this.filmId + "\",");
		buffer.deleteCharAt(buffer.length() - 1);
		buffer.append("]");
		return buffer.toString();
	}

	/**  
	 * get The id of the file.
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * set The id of the file.
	 */
	public void setId(int id) {
		this.id = id;
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
		if (!(other instanceof FileId))
			return false;
		FileId castOther = (FileId) other;

		return (this.getId() == castOther.getId())
				&& ((this.getFilmId() == castOther.getFilmId()) || (this
						.getFilmId() != null && castOther.getFilmId() != null && this
						.getFilmId().equals(castOther.getFilmId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getId();
		result = 37 * result
				+ (getFilmId() == null ? 0 : this.getFilmId().hashCode());
		return result;
	}

}
