/**
 * Copyright © 2013, Bunco All Rights Reserved.
 * cn.sh.sbl.hotel.beans.Film.java
 * Create By: Bunco
 * Create Date: 2013-11-21 14:47:56
 */
package cn.sh.sbl.hotel.beans;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Entity: cn.sh.sbl.hotel.beans.Film
 * @author Bunco
 * @E-mail: amwihc512@qq.com
 * @version 1.0
 * @date 2013-11-21 14:47:56
 * @description the film table
 */
public class Film implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

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

	private Set<File> files = new HashSet<File>(0);

	private Set<MenuFilm> menuFilms = new HashSet<MenuFilm>(0);

	private Set<Category> categories = new HashSet<Category>(0);

	private Set<Category> categories_1 = new HashSet<Category>(0);

	private Set<Director> directors = new HashSet<Director>(0);

	private Set<Actor> actors = new HashSet<Actor>(0);

	/**
	 * default constructor
	 */
	public Film() {
	}

	/**
	 * minimal constructor
	 * @param id		The id of the film
	 * @param lastUpdate		The last update time of the film
	 */
	public Film(String id, Date lastUpdate) {
		this.id = id;
		this.lastUpdate = lastUpdate;
	}

	/**
	 * full constructor
	 * @param id		The id of the film
	 * @param title		The title of the film
	 * @param ratings		The ratings of the film
	 * @param releaseYear		The release year of the film
	 * @param country		The country of the film
	 * @param length		The length of the film (unit: min)
	 * @param lastUpdate		The last update time of the film
	 * @param description		The description of the film
	 * @param remark		The remark of the film
	 */
	public Film(String id, String title, String ratings, Date releaseYear,
			String country, Short length, Date lastUpdate, String description,
			String remark, Set<File> files, Set<MenuFilm> menuFilms,
			Set<Category> categories, Set<Category> categories_1,
			Set<Director> directors, Set<Actor> actors) {
		this.id = id;
		this.title = title;
		this.ratings = ratings;
		this.releaseYear = releaseYear;
		this.country = country;
		this.length = length;
		this.lastUpdate = lastUpdate;
		this.description = description;
		this.remark = remark;
		this.files = files;
		this.menuFilms = menuFilms;
		this.categories = categories;
		this.categories_1 = categories_1;
		this.directors = directors;
		this.actors = actors;
	}

	/**
	 * toJson
	 * @return String
	 */
	public String toJson() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		buffer.append("\"id\":\"" + this.id + "\",");
		buffer.append("\"title\":\"" + this.title + "\",");
		buffer.append("\"ratings\":\"" + this.ratings + "\",");
		buffer.append("\"releaseYear\":\"" + this.releaseYear + "\",");
		buffer.append("\"country\":\"" + this.country + "\",");
		buffer.append("\"length\":\"" + this.length + "\",");
		buffer.append("\"lastUpdate\":\"" + this.lastUpdate + "\",");
		buffer.append("\"description\":\"" + this.description + "\",");
		buffer.append("\"remark\":\"" + this.remark + "\",");
		buffer.append("\"files\":\"" + this.files + "\",");
		buffer.append("\"menuFilms\":\"" + this.menuFilms + "\",");
		buffer.append("\"categories\":\"" + this.categories + "\",");
		buffer.append("\"categories_1\":\"" + this.categories_1 + "\",");
		buffer.append("\"directors\":\"" + this.directors + "\",");
		buffer.append("\"actors\":\"" + this.actors + "\",");
		buffer.deleteCharAt(buffer.length() - 1);
		buffer.append("}");
		return buffer.toString();
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Film[");
		buffer.append("\"id\":\"" + this.id + "\",");
		buffer.append("\"title\":\"" + this.title + "\",");
		buffer.append("\"ratings\":\"" + this.ratings + "\",");
		buffer.append("\"releaseYear\":\"" + this.releaseYear + "\",");
		buffer.append("\"country\":\"" + this.country + "\",");
		buffer.append("\"length\":\"" + this.length + "\",");
		buffer.append("\"lastUpdate\":\"" + this.lastUpdate + "\",");
		buffer.append("\"description\":\"" + this.description + "\",");
		buffer.append("\"remark\":\"" + this.remark + "\",");
		buffer.append("\"files\":\"" + this.files + "\",");
		buffer.append("\"menuFilms\":\"" + this.menuFilms + "\",");
		buffer.append("\"categories\":\"" + this.categories + "\",");
		buffer.append("\"categories_1\":\"" + this.categories_1 + "\",");
		buffer.append("\"directors\":\"" + this.directors + "\",");
		buffer.append("\"actors\":\"" + this.actors + "\",");
		buffer.deleteCharAt(buffer.length() - 1);
		buffer.append("]");
		return buffer.toString();
	}

	/**  
	 * get The id of the film.
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * set The id of the film.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**  
	 * get The title of the film.
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * set The title of the film.
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**  
	 * get The ratings of the film.
	 */
	public String getRatings() {
		return this.ratings;
	}

	/**
	 * set The ratings of the film.
	 */
	public void setRatings(String ratings) {
		this.ratings = ratings;
	}

	/**  
	 * get The release year of the film.
	 */
	public Date getReleaseYear() {
		return this.releaseYear;
	}

	/**
	 * set The release year of the film.
	 */
	public void setReleaseYear(Date releaseYear) {
		this.releaseYear = releaseYear;
	}

	/**  
	 * get The country of the film.
	 */
	public String getCountry() {
		return this.country;
	}

	/**
	 * set The country of the film.
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**  
	 * get The length of the film (unit: min).
	 */
	public Short getLength() {
		return this.length;
	}

	/**
	 * set The length of the film (unit: min).
	 */
	public void setLength(Short length) {
		this.length = length;
	}

	/**  
	 * get The last update time of the film.
	 */
	public Date getLastUpdate() {
		return this.lastUpdate;
	}

	/**
	 * set The last update time of the film.
	 */
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	/**  
	 * get The description of the film.
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * set The description of the film.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**  
	 * get The remark of the film.
	 */
	public String getRemark() {
		return this.remark;
	}

	/**
	 * set The remark of the film.
	 */
	public void setRemark(String remark) {
		this.remark = remark;
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
	public Set<MenuFilm> getMenuFilms() {
		return this.menuFilms;
	}

	/**
	 */
	public void setMenuFilms(Set<MenuFilm> menuFilms) {
		this.menuFilms = menuFilms;
	}

	/**  
	 */
	public Set<Category> getCategories() {
		return this.categories;
	}

	/**
	 */
	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	/**  
	 */
	public Set<Category> getCategories_1() {
		return this.categories_1;
	}

	/**
	 */
	public void setCategories_1(Set<Category> categories_1) {
		this.categories_1 = categories_1;
	}

	/**  
	 */
	public Set<Director> getDirectors() {
		return this.directors;
	}

	/**
	 */
	public void setDirectors(Set<Director> directors) {
		this.directors = directors;
	}

	/**  
	 */
	public Set<Actor> getActors() {
		return this.actors;
	}

	/**
	 */
	public void setActors(Set<Actor> actors) {
		this.actors = actors;
	}

}
