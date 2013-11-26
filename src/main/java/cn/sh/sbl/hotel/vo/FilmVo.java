/**
 * Copyright © 2013, bunco All Rights Reserved.
 * Project: hotel.demo
 * cn.sh.sbl.hotel.vo.ActorVo.java
 * Create By: bunco
 * Create Date: 2013-11-22 下午1:52:08
 */
package cn.sh.sbl.hotel.vo;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author bunco 
 * @E-mail: bunco.hb@gmail.com
 * @version 1.0 
 * @date 2013-11-22 下午1:52:08
 * @description TODO
 */
@XmlRootElement(name="film")
public class FilmVo {
	
	/** 
	 * The id of the film.
	 */
	private String id;

	/** 
	 * The title of the film.
	 */
	private String title;

	/** 
	 * The ratings of the film.
	 */
	private String ratings;

	/** 
	 * The release year of the film.
	 */
	private Date releaseYear;

	/** 
	 * The country of the film.
	 */
	private String country;

	/** 
	 * The length of the film (unit: min).
	 */
	private Short length;

	/** 
	 * The last update time of the film.
	 */
	private Date lastUpdate;

	/** 
	 * The description of the film.
	 */
	private String description;

	/** 
	 * The remark of the film.
	 */
	private String remark;
	
	private FileList fileList;
	
	public FilmVo(){
		
	}
	
	public FilmVo(String filmId, String fileTitle) {
		this.id = filmId;
		this.title = fileTitle;
	}
	
	public FilmVo(String filmId, String country, String description, Date lastUpdate, 
			short length, String ratings, String title, Date releaseYear) {
		this.id = filmId;
		this.country = country;
		this.description = description;
		this.lastUpdate = lastUpdate;
		this.length = length;
		this.ratings = ratings;
		this.title = title;
		this.releaseYear = releaseYear;
	}

	@XmlElement(name="files")
	public FileList getFileList() {
		return fileList;
	}

	public void setFileList(FileList fileList) {
		this.fileList = fileList;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRatings() {
		return ratings;
	}

	public void setRatings(String ratings) {
		this.ratings = ratings;
	}

	public Date getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Date releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Short getLength() {
		return length;
	}

	public void setLength(Short length) {
		this.length = length;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	
	
}
