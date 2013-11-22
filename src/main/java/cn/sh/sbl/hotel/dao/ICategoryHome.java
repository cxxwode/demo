/**
 * Copyright © 2013, bunco All Rights Reserved.
 * Project: hotel.demo
 * cn.sh.sbl.hotel.dao.ICategoryHome.java
 * Create By: bunco
 * Create Date: 2013-11-21 下午3:08:08
 */
package cn.sh.sbl.hotel.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;

import cn.sh.sbl.hotel.beans.Category;

/**
 * @author bunco 
 * @E-mail: bunco.hb@gmail.com
 * @version 1.0 
 * @date 2013-11-21 下午3:08:08
 * @description TODO
 */
public interface ICategoryHome {

	/**
	 * Create a new Criteria instance, for the given Category class
	 * @param clazz
	 * @return Criteria
	 */
	public abstract Criteria createCriteria();

	/**
	 * save Category Instance
	 * @param transientInstance the categorys table
	 * @see Category
	 */
	public abstract void save(Category transientInstance);

	/**
	 * attach dirty Category Instance
	 * @param instance the categorys table
	 * @see Category
	 */
	public abstract void attachDirty(Category instance);

	/**
	 * delete Category Instance
	 * @param persistentInstance the categorys table
	 * @see Category
	 */
	public abstract void delete(Category persistentInstance);

	/**
	 * merge Category Instance
	 * @param detachedInstance the categorys table
	 * @see Category
	 */
	public abstract Category merge(Category detachedInstance);

	/**
	 * delete Category Instance
	 * @param persistentInstanceId
	 */
	public abstract void deleteById(java.lang.Integer persistentInstanceId);

	/**
	 * getting Category Instance with id from the datastore.
	 * @param id
	 * @return @see Category
	 */
	public abstract Category findById(java.lang.Integer id);

	/**
	 * finding Category instance by example
	 * @param instance Category
	 * @return @see List<Category>
	 */
	public abstract List<Category> findByExample(Category instance);

	/**
	 * finding all Category Instance
	 * @return @see List<Category>
	 */
	public abstract List<Category> findAll();

	/**
	 * finding all Category Instance with order column
	 * @return @see List<Category>
	 */
	public abstract List<Category> findAll(String orderColumn);

	/**
	 * finding all Category Instance with order column asc
	 * @return @see List<Category>
	 */
	public abstract List<Category> findAll(String orderColumn, boolean asc);

	/**
	 * finding Category Instance with criteria
	 * @return @see List<Category>
	 */
	public abstract List<Category> findByCriteria(DetachedCriteria criteria);

	/**
	 * Is exist instance with property name and value
	 * @param propertyName object property name
	 * @param propertyValue object property value
	 * @return is exists instance
	 */
	public abstract boolean isExist(String propertyName, Object propertyValue);

}