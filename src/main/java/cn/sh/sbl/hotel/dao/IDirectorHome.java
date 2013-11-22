/**
 * Copyright © 2013, bunco All Rights Reserved.
 * Project: hotel.demo
 * cn.sh.sbl.hotel.dao.IDirectorHome.java
 * Create By: bunco
 * Create Date: 2013-11-21 下午3:08:47
 */
package cn.sh.sbl.hotel.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;

import cn.sh.sbl.hotel.beans.Director;

/**
 * @author bunco 
 * @E-mail: bunco.hb@gmail.com
 * @version 1.0 
 * @date 2013-11-21 下午3:08:47
 * @description TODO
 */
public interface IDirectorHome {

	/**
	 * Create a new Criteria instance, for the given Director class
	 * @param clazz
	 * @return Criteria
	 */
	public abstract Criteria createCriteria();

	/**
	 * save Director Instance
	 * @param transientInstance the director table
	 * @see Director
	 */
	public abstract void save(Director transientInstance);

	/**
	 * attach dirty Director Instance
	 * @param instance the director table
	 * @see Director
	 */
	public abstract void attachDirty(Director instance);

	/**
	 * delete Director Instance
	 * @param persistentInstance the director table
	 * @see Director
	 */
	public abstract void delete(Director persistentInstance);

	/**
	 * merge Director Instance
	 * @param detachedInstance the director table
	 * @see Director
	 */
	public abstract Director merge(Director detachedInstance);

	/**
	 * delete Director Instance
	 * @param persistentInstanceId
	 */
	public abstract void deleteById(java.lang.Integer persistentInstanceId);

	/**
	 * getting Director Instance with id from the datastore.
	 * @param id
	 * @return @see Director
	 */
	public abstract Director findById(java.lang.Integer id);

	/**
	 * finding Director instance by example
	 * @param instance Director
	 * @return @see List<Director>
	 */
	public abstract List<Director> findByExample(Director instance);

	/**
	 * finding all Director Instance
	 * @return @see List<Director>
	 */
	public abstract List<Director> findAll();

	/**
	 * finding all Director Instance with order column
	 * @return @see List<Director>
	 */
	public abstract List<Director> findAll(String orderColumn);

	/**
	 * finding all Director Instance with order column asc
	 * @return @see List<Director>
	 */
	public abstract List<Director> findAll(String orderColumn, boolean asc);

	/**
	 * finding Director Instance with criteria
	 * @return @see List<Director>
	 */
	public abstract List<Director> findByCriteria(DetachedCriteria criteria);

	/**
	 * Is exist instance with property name and value
	 * @param propertyName object property name
	 * @param propertyValue object property value
	 * @return is exists instance
	 */
	public abstract boolean isExist(String propertyName, Object propertyValue);

}