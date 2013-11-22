/**
 * Copyright © 2013, bunco All Rights Reserved.
 * Project: hotel.demo
 * cn.sh.sbl.hotel.dao.IFileHome.java
 * Create By: bunco
 * Create Date: 2013-11-21 下午3:09:18
 */
package cn.sh.sbl.hotel.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;

import cn.sh.sbl.hotel.beans.File;

/**
 * @author bunco 
 * @E-mail: bunco.hb@gmail.com
 * @version 1.0 
 * @date 2013-11-21 下午3:09:18
 * @description TODO
 */
public interface IFileHome {

	/**
	 * Create a new Criteria instance, for the given File class
	 * @param clazz
	 * @return Criteria
	 */
	public abstract Criteria createCriteria();

	/**
	 * save File Instance
	 * @param transientInstance the film file table
	 * @see File
	 */
	public abstract void save(File transientInstance);

	/**
	 * attach dirty File Instance
	 * @param instance the film file table
	 * @see File
	 */
	public abstract void attachDirty(File instance);

	/**
	 * delete File Instance
	 * @param persistentInstance the film file table
	 * @see File
	 */
	public abstract void delete(File persistentInstance);

	/**
	 * merge File Instance
	 * @param detachedInstance the film file table
	 * @see File
	 */
	public abstract File merge(File detachedInstance);

	/**
	 * delete File Instance
	 * @param persistentInstanceId
	 */
	public abstract void deleteById(
			cn.sh.sbl.hotel.beans.FileId persistentInstanceId);

	/**
	 * getting File Instance with id from the datastore.
	 * @param id
	 * @return @see File
	 */
	public abstract File findById(cn.sh.sbl.hotel.beans.FileId id);

	/**
	 * finding File instance by example
	 * @param instance File
	 * @return @see List<File>
	 */
	public abstract List<File> findByExample(File instance);

	/**
	 * finding all File Instance
	 * @return @see List<File>
	 */
	public abstract List<File> findAll();

	/**
	 * finding all File Instance with order column
	 * @return @see List<File>
	 */
	public abstract List<File> findAll(String orderColumn);

	/**
	 * finding all File Instance with order column asc
	 * @return @see List<File>
	 */
	public abstract List<File> findAll(String orderColumn, boolean asc);

	/**
	 * finding File Instance with criteria
	 * @return @see List<File>
	 */
	public abstract List<File> findByCriteria(DetachedCriteria criteria);

	/**
	 * Is exist instance with property name and value
	 * @param propertyName object property name
	 * @param propertyValue object property value
	 * @return is exists instance
	 */
	public abstract boolean isExist(String propertyName, Object propertyValue);

}