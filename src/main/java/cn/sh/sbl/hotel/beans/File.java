/**
 * Copyright © 2013, Bunco All Rights Reserved.
 * cn.sh.sbl.hotel.beans.File.java
 * Create By: Bunco
 * Create Date: 2013-11-21 14:47:56
 */
package cn.sh.sbl.hotel.beans;

import java.util.Date;

/**
 * Entity: cn.sh.sbl.hotel.beans.File
 * @author Bunco
 * @E-mail: amwihc512@qq.com
 * @version 1.0
 * @date 2013-11-21 14:47:56
 * @description the film file table
 */
public class File implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	/** 
	 * The id of the file.
	 */
	/** 
	 * The id of the film.
	 */
	private FileId id;

	/** 
	 * The id of the film.
	 */
	private Film film;

	/** 
	 * The file type of the films.
	 */
	private Category category;

	/** 
	 * The name of the file.
	 */
	private String fileName;

	/** 
	 * The size of the file.
	 */
	private String fileSize;

	/** 
	 * The last update time of the file.
	 */
	private Date lastUpdate;

	/** 
	 * The remark of the file.
	 */
	private String remark;

	/**
	 * default constructor
	 */
	public File() {
	}

	/**
	 * minimal constructor
	 * @param id		The id of the file
	 * @param id		The id of the film
	 * @param film		The id of the film
	 * @param lastUpdate		The last update time of the file
	 */
	public File(FileId id, Film film, Date lastUpdate) {
		this.id = id;
		this.film = film;
		this.lastUpdate = lastUpdate;
	}

	/**
	 * full constructor
	 * @param id		The id of the file
	 * @param id		The id of the film
	 * @param film		The id of the film
	 * @param category		The file type of the films
	 * @param fileName		The name of the file
	 * @param fileSize		The size of the file
	 * @param lastUpdate		The last update time of the file
	 * @param remark		The remark of the file
	 */
	public File(FileId id, Film film, Category category, String fileName,
			String fileSize, Date lastUpdate, String remark) {
		this.id = id;
		this.film = film;
		this.category = category;
		this.fileName = fileName;
		this.fileSize = fileSize;
		this.lastUpdate = lastUpdate;
		this.remark = remark;
	}

	/**
	 * toJson
	 * @return String
	 */
	public String toJson() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		buffer.append("\"id\":\"" + this.id + "\",");
		buffer.append("\"film\":\"" + this.film + "\",");
		buffer.append("\"category\":\"" + this.category + "\",");
		buffer.append("\"fileName\":\"" + this.fileName + "\",");
		buffer.append("\"fileSize\":\"" + this.fileSize + "\",");
		buffer.append("\"lastUpdate\":\"" + this.lastUpdate + "\",");
		buffer.append("\"remark\":\"" + this.remark + "\",");
		buffer.deleteCharAt(buffer.length() - 1);
		buffer.append("}");
		return buffer.toString();
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("File[");
		buffer.append("\"id\":\"" + this.id + "\",");
		buffer.append("\"film\":\"" + this.film + "\",");
		buffer.append("\"category\":\"" + this.category + "\",");
		buffer.append("\"fileName\":\"" + this.fileName + "\",");
		buffer.append("\"fileSize\":\"" + this.fileSize + "\",");
		buffer.append("\"lastUpdate\":\"" + this.lastUpdate + "\",");
		buffer.append("\"remark\":\"" + this.remark + "\",");
		buffer.deleteCharAt(buffer.length() - 1);
		buffer.append("]");
		return buffer.toString();
	}

	/**  
	 * get The id of the file.
	 * get The id of the film.
	 */
	public FileId getId() {
		return this.id;
	}

	/**
	 * set The id of the file.
	 * set The id of the film.
	 */
	public void setId(FileId id) {
		this.id = id;
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
	 * get The file type of the films.
	 */
	public Category getCategory() {
		return this.category;
	}

	/**
	 * set The file type of the films.
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

	/**  
	 * get The name of the file.
	 */
	public String getFileName() {
		return this.fileName;
	}

	/**
	 * set The name of the file.
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**  
	 * get The size of the file.
	 */
	public String getFileSize() {
		return this.fileSize;
	}

	/**
	 * set The size of the file.
	 */
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	/**  
	 * get The last update time of the file.
	 */
	public Date getLastUpdate() {
		return this.lastUpdate;
	}

	/**
	 * set The last update time of the file.
	 */
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	/**  
	 * get The remark of the file.
	 */
	public String getRemark() {
		return this.remark;
	}

	/**
	 * set The remark of the file.
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

}
