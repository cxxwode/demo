/**
 * Copyright © 2013, Bunco All Rights Reserved.
 * cn.sh.sbl.hotel.beans.Actor.java
 * Create By: Bunco
 * Create Date: 2013-11-21 14:47:56
 */
package cn.sh.sbl.hotel.beans;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Entity: cn.sh.sbl.hotel.beans.Actor
 * @author Bunco
 * @E-mail: amwihc512@qq.com
 * @version 1.0
 * @date 2013-11-21 14:47:56
 * @description the actor table
 */
public class Actor implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	/** 
	 * The id of the actor.
	 */
	private Integer id;

	/** 
	 * The  first name of the actor.
	 */
	private String firstName;

	/** 
	 * The last name of the actor.
	 */
	private String lastName;

	/** 
	 * The last update time of the actor.
	 */
	private Date lastUpdate;

	private Set<Film> films = new HashSet<Film>(0);

	/**
	 * default constructor
	 */
	public Actor() {
	}

	/**
	 * minimal constructor
	 * @param lastUpdate		The last update time of the actor
	 */
	public Actor(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	/**
	 * full constructor
	 * @param firstName		The  first name of the actor
	 * @param lastName		The last name of the actor
	 * @param lastUpdate		The last update time of the actor
	 */
	public Actor(String firstName, String lastName, Date lastUpdate,
			Set<Film> films) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.lastUpdate = lastUpdate;
		this.films = films;
	}

	/**
	 * toJson
	 * @return String
	 */
	public String toJson() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		buffer.append("\"firstName\":\"" + this.firstName + "\",");
		buffer.append("\"lastName\":\"" + this.lastName + "\",");
		buffer.append("\"lastUpdate\":\"" + this.lastUpdate + "\",");
		buffer.append("\"films\":\"" + this.films + "\",");
		buffer.deleteCharAt(buffer.length() - 1);
		buffer.append("}");
		return buffer.toString();
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Actor[");
		buffer.append("\"firstName\":\"" + this.firstName + "\",");
		buffer.append("\"lastName\":\"" + this.lastName + "\",");
		buffer.append("\"lastUpdate\":\"" + this.lastUpdate + "\",");
		buffer.append("\"films\":\"" + this.films + "\",");
		buffer.deleteCharAt(buffer.length() - 1);
		buffer.append("]");
		return buffer.toString();
	}

	/**  
	 * get The id of the actor.
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * set The id of the actor.
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**  
	 * get The  first name of the actor.
	 */
	public String getFirstName() {
		return this.firstName;
	}

	/**
	 * set The  first name of the actor.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**  
	 * get The last name of the actor.
	 */
	public String getLastName() {
		return this.lastName;
	}

	/**
	 * set The last name of the actor.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**  
	 * get The last update time of the actor.
	 */
	public Date getLastUpdate() {
		return this.lastUpdate;
	}

	/**
	 * set The last update time of the actor.
	 */
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
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

}
