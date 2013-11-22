/**
 * Copyright © 2013, bunco All Rights Reserved.
 * Project: hotel.demo
 * cn.sh.sbl.hotel.dao.IActorHome.java
 * Create By: bunco
 * Create Date: 2013-11-21 下午3:07:01
 */
package cn.sh.sbl.hotel.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;

import cn.sh.sbl.hotel.beans.Actor;

/**
 * @author bunco 
 * @E-mail: bunco.hb@gmail.com
 * @version 1.0 
 * @date 2013-11-21 下午3:07:01
 * @description TODO
 */
public interface IActorHome {

	/**
	 * Create a new Criteria instance, for the given Actor class
	 * @param clazz
	 * @return Criteria
	 */
	public abstract Criteria createCriteria();

	/**
	 * save Actor Instance
	 * @param transientInstance the actor table
	 * @see Actor
	 */
	public abstract void save(Actor transientInstance);

	/**
	 * attach dirty Actor Instance
	 * @param instance the actor table
	 * @see Actor
	 */
	public abstract void attachDirty(Actor instance);

	/**
	 * delete Actor Instance
	 * @param persistentInstance the actor table
	 * @see Actor
	 */
	public abstract void delete(Actor persistentInstance);

	/**
	 * merge Actor Instance
	 * @param detachedInstance the actor table
	 * @see Actor
	 */
	public abstract Actor merge(Actor detachedInstance);

	/**
	 * delete Actor Instance
	 * @param persistentInstanceId
	 */
	public abstract void deleteById(java.lang.Integer persistentInstanceId);

	/**
	 * getting Actor Instance with id from the datastore.
	 * @param id
	 * @return @see Actor
	 */
	public abstract Actor findById(java.lang.Integer id);

	/**
	 * finding Actor instance by example
	 * @param instance Actor
	 * @return @see List<Actor>
	 */
	public abstract List<Actor> findByExample(Actor instance);

	/**
	 * finding all Actor Instance
	 * @return @see List<Actor>
	 */
	public abstract List<Actor> findAll();

	/**
	 * finding all Actor Instance with order column
	 * @return @see List<Actor>
	 */
	public abstract List<Actor> findAll(String orderColumn);

	/**
	 * finding all Actor Instance with order column asc
	 * @return @see List<Actor>
	 */
	public abstract List<Actor> findAll(String orderColumn, boolean asc);

	/**
	 * finding Actor Instance with criteria
	 * @return @see List<Actor>
	 */
	public abstract List<Actor> findByCriteria(DetachedCriteria criteria);

	/**
	 * Is exist instance with property name and value
	 * @param propertyName object property name
	 * @param propertyValue object property value
	 * @return is exists instance
	 */
	public abstract boolean isExist(String propertyName, Object propertyValue);

}