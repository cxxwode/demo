/**
 * Copyright © 2013, bunco All Rights Reserved.
 * Project: hotel.demo
 * cn.sh.sbl.hotel.dao.IMenuFilmHome.java
 * Create By: bunco
 * Create Date: 2013-11-21 下午3:10:22
 */
package cn.sh.sbl.hotel.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;

import cn.sh.sbl.hotel.beans.MenuFilm;

/**
 * @author bunco 
 * @E-mail: bunco.hb@gmail.com
 * @version 1.0 
 * @date 2013-11-21 下午3:10:22
 * @description TODO
 */
public interface IMenuFilmHome {

	/**
	 * Create a new Criteria instance, for the given MenuFilm class
	 * @param clazz
	 * @return Criteria
	 */
	public abstract Criteria createCriteria();

	/**
	 * save MenuFilm Instance
	 * @param transientInstance the menu film table
	 * @see MenuFilm
	 */
	public abstract void save(MenuFilm transientInstance);

	/**
	 * attach dirty MenuFilm Instance
	 * @param instance the menu film table
	 * @see MenuFilm
	 */
	public abstract void attachDirty(MenuFilm instance);

	/**
	 * delete MenuFilm Instance
	 * @param persistentInstance the menu film table
	 * @see MenuFilm
	 */
	public abstract void delete(MenuFilm persistentInstance);

	/**
	 * merge MenuFilm Instance
	 * @param detachedInstance the menu film table
	 * @see MenuFilm
	 */
	public abstract MenuFilm merge(MenuFilm detachedInstance);

	/**
	 * delete MenuFilm Instance
	 * @param persistentInstanceId
	 */
	public abstract void deleteById(
			cn.sh.sbl.hotel.beans.MenuFilmId persistentInstanceId);

	/**
	 * getting MenuFilm Instance with id from the datastore.
	 * @param id
	 * @return @see MenuFilm
	 */
	public abstract MenuFilm findById(cn.sh.sbl.hotel.beans.MenuFilmId id);

	/**
	 * finding MenuFilm instance by example
	 * @param instance MenuFilm
	 * @return @see List<MenuFilm>
	 */
	public abstract List<MenuFilm> findByExample(MenuFilm instance);

	/**
	 * finding all MenuFilm Instance
	 * @return @see List<MenuFilm>
	 */
	public abstract List<MenuFilm> findAll();

	/**
	 * finding all MenuFilm Instance with order column
	 * @return @see List<MenuFilm>
	 */
	public abstract List<MenuFilm> findAll(String orderColumn);

	/**
	 * finding all MenuFilm Instance with order column asc
	 * @return @see List<MenuFilm>
	 */
	public abstract List<MenuFilm> findAll(String orderColumn, boolean asc);

	/**
	 * finding MenuFilm Instance with criteria
	 * @return @see List<MenuFilm>
	 */
	public abstract List<MenuFilm> findByCriteria(DetachedCriteria criteria);

	/**
	 * Is exist instance with property name and value
	 * @param propertyName object property name
	 * @param propertyValue object property value
	 * @return is exists instance
	 */
	public abstract boolean isExist(String propertyName, Object propertyValue);

}