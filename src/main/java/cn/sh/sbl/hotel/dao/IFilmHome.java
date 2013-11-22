/**
 * Copyright © 2013, bunco All Rights Reserved.
 * Project: hotel.demo
 * cn.sh.sbl.hotel.dao.IFilmHome.java
 * Create By: bunco
 * Create Date: 2013-11-21 下午3:09:53
 */
package cn.sh.sbl.hotel.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;

import cn.sh.sbl.hotel.beans.Film;

/**
 * @author bunco 
 * @E-mail: bunco.hb@gmail.com
 * @version 1.0 
 * @date 2013-11-21 下午3:09:53
 * @description TODO
 */
public interface IFilmHome {

	/**
	 * Create a new Criteria instance, for the given Film class
	 * @param clazz
	 * @return Criteria
	 */
	public abstract Criteria createCriteria();

	/**
	 * save Film Instance
	 * @param transientInstance the film table
	 * @see Film
	 */
	public abstract void save(Film transientInstance);

	/**
	 * attach dirty Film Instance
	 * @param instance the film table
	 * @see Film
	 */
	public abstract void attachDirty(Film instance);

	/**
	 * delete Film Instance
	 * @param persistentInstance the film table
	 * @see Film
	 */
	public abstract void delete(Film persistentInstance);

	/**
	 * merge Film Instance
	 * @param detachedInstance the film table
	 * @see Film
	 */
	public abstract Film merge(Film detachedInstance);

	/**
	 * delete Film Instance
	 * @param persistentInstanceId
	 */
	public abstract void deleteById(java.lang.String persistentInstanceId);

	/**
	 * getting Film Instance with id from the datastore.
	 * @param id
	 * @return @see Film
	 */
	public abstract Film findById(java.lang.String id);

	/**
	 * finding Film instance by example
	 * @param instance Film
	 * @return @see List<Film>
	 */
	public abstract List<Film> findByExample(Film instance);

	/**
	 * finding all Film Instance
	 * @return @see List<Film>
	 */
	public abstract List<Film> findAll();

	/**
	 * finding all Film Instance with order column
	 * @return @see List<Film>
	 */
	public abstract List<Film> findAll(String orderColumn);

	/**
	 * finding all Film Instance with order column asc
	 * @return @see List<Film>
	 */
	public abstract List<Film> findAll(String orderColumn, boolean asc);

	/**
	 * finding Film Instance with criteria
	 * @return @see List<Film>
	 */
	public abstract List<Film> findByCriteria(DetachedCriteria criteria);

	/**
	 * Is exist instance with property name and value
	 * @param propertyName object property name
	 * @param propertyValue object property value
	 * @return is exists instance
	 */
	public abstract boolean isExist(String propertyName, Object propertyValue);

}