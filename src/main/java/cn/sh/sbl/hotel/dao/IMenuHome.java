/**
 * Copyright © 2013, bunco All Rights Reserved.
 * Project: hotel.demo
 * cn.sh.sbl.hotel.dao.IMenuHome.java
 * Create By: bunco
 * Create Date: 2013-11-21 下午3:10:49
 */
package cn.sh.sbl.hotel.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;

import cn.sh.sbl.hotel.beans.Menu;

/**
 * @author bunco 
 * @E-mail: bunco.hb@gmail.com
 * @version 1.0 
 * @date 2013-11-21 下午3:10:49
 * @description TODO
 */
public interface IMenuHome {

	/**
	 * Create a new Criteria instance, for the given Menu class
	 * @param clazz
	 * @return Criteria
	 */
	public abstract Criteria createCriteria();

	/**
	 * save Menu Instance
	 * @param transientInstance terminal display menu
	 * @see Menu
	 */
	public abstract void save(Menu transientInstance);

	/**
	 * attach dirty Menu Instance
	 * @param instance terminal display menu
	 * @see Menu
	 */
	public abstract void attachDirty(Menu instance);

	/**
	 * delete Menu Instance
	 * @param persistentInstance terminal display menu
	 * @see Menu
	 */
	public abstract void delete(Menu persistentInstance);

	/**
	 * merge Menu Instance
	 * @param detachedInstance terminal display menu
	 * @see Menu
	 */
	public abstract Menu merge(Menu detachedInstance);

	/**
	 * delete Menu Instance
	 * @param persistentInstanceId
	 */
	public abstract void deleteById(java.lang.Integer persistentInstanceId);

	/**
	 * getting Menu Instance with id from the datastore.
	 * @param id
	 * @return @see Menu
	 */
	public abstract Menu findById(java.lang.Integer id);

	/**
	 * finding Menu instance by example
	 * @param instance Menu
	 * @return @see List<Menu>
	 */
	public abstract List<Menu> findByExample(Menu instance);

	/**
	 * finding all Menu Instance
	 * @return @see List<Menu>
	 */
	public abstract List<Menu> findAll();

	/**
	 * finding all Menu Instance with order column
	 * @return @see List<Menu>
	 */
	public abstract List<Menu> findAll(String orderColumn);

	/**
	 * finding all Menu Instance with order column asc
	 * @return @see List<Menu>
	 */
	public abstract List<Menu> findAll(String orderColumn, boolean asc);

	/**
	 * finding Menu Instance with criteria
	 * @return @see List<Menu>
	 */
	public abstract List<Menu> findByCriteria(DetachedCriteria criteria);

	/**
	 * Is exist instance with property name and value
	 * @param propertyName object property name
	 * @param propertyValue object property value
	 * @return is exists instance
	 */
	public abstract boolean isExist(String propertyName, Object propertyValue);

}