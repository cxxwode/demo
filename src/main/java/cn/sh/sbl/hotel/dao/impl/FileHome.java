/**
 * Copyright © 2013, Bunco All Rights Reserved.
 * cn.sh.sbl.hotel.beans.FileHome.java
 * Create By: Bunco
 * Create Date: 2013-11-21 14:47:58
 */
package cn.sh.sbl.hotel.dao.impl;

import cn.sh.sbl.hotel.beans.File;
import cn.sh.sbl.hotel.beans.FileId;
import cn.sh.sbl.hotel.common.ICommon;
import cn.sh.sbl.hotel.dao.IFileHome;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Data access object for domain model class File.
 * @see cn.sh.sbl.hotel.beans.File
 * @author Bunco
 * @E-mail: amwihc512@qq.com
 * @version 1.0
 * @date 2013-11-21 14:47:58
 * @description the film file table
 */
@Repository
public class FileHome implements IFileHome {
	@Autowired
	private Logger logger;
	@Autowired
	private ICommon<File, FileId> common;

	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.dao.IFileHome#createCriteria()
	 */
	public Criteria createCriteria() {
		logger.debug("creating File criteria");
		return this.common.createCriteria(File.class);
	}

	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.dao.IFileHome#save(cn.sh.sbl.hotel.beans.File)
	 */
	public void save(File transientInstance) {
		logger.debug("persisting File instance: {}", transientInstance);
		try {
			this.common.save(transientInstance);
			logger.debug("persist successful");
		} catch (RuntimeException re) {
			logger.error("persist failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.dao.IFileHome#attachDirty(cn.sh.sbl.hotel.beans.File)
	 */
	public void attachDirty(File instance) {
		logger.debug("attaching dirty File instance: {}", instance);
		try {
			this.common.attachDirty(instance);
			logger.debug("attach successful");
		} catch (RuntimeException re) {
			logger.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.dao.IFileHome#delete(cn.sh.sbl.hotel.beans.File)
	 */
	public void delete(File persistentInstance) {
		logger.debug("deleting File instance: {}", persistentInstance);
		try {
			this.common.delete(persistentInstance);
			logger.debug("delete successful");
		} catch (RuntimeException re) {
			logger.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.dao.IFileHome#merge(cn.sh.sbl.hotel.beans.File)
	 */
	public File merge(File detachedInstance) {
		logger.debug("merging File instance: {}", detachedInstance);
		try {
			File result = this.common.merge(detachedInstance);
			logger.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			logger.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.dao.IFileHome#deleteById(cn.sh.sbl.hotel.beans.FileId)
	 */
	public void deleteById(cn.sh.sbl.hotel.beans.FileId persistentInstanceId) {
		logger.debug("deleting File instance with id: {}", persistentInstanceId);
		try {
			this.common.delete(File.class, persistentInstanceId);
			logger.debug("delete successful");
		} catch (RuntimeException re) {
			logger.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.dao.IFileHome#findById(cn.sh.sbl.hotel.beans.FileId)
	 */
	public File findById(cn.sh.sbl.hotel.beans.FileId id) {
		logger.debug("getting File instance with id: {}", id);
		try {
			File instance = (File) this.common.get(File.class, id);
			if (instance == null) {
				logger.debug("get successful, no instance found");
			} else {
				logger.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			logger.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.dao.IFileHome#findByExample(cn.sh.sbl.hotel.beans.File)
	 */
	public List<File> findByExample(File instance) {
		logger.debug("finding File instance by example: {}", instance);
		try {
			List<File> results = (List<File>) this.common
					.findByExample(instance);
			logger.debug("find by example successful, result size: {}",
					results.size());
			return results;
		} catch (RuntimeException re) {
			logger.error("find by example failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.dao.IFileHome#findAll()
	 */
	public List<File> findAll() {
		return this.findAll("id", true);
	}

	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.dao.IFileHome#findAll(java.lang.String)
	 */
	public List<File> findAll(String orderColumn) {
		return this.findAll(orderColumn, true);
	}

	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.dao.IFileHome#findAll(java.lang.String, boolean)
	 */
	public List<File> findAll(String orderColumn, boolean asc) {
		logger.debug("finding all File instance with column: {}, asc: {}",
				orderColumn, asc);
		try {
			@SuppressWarnings("unchecked")
			List<File> results = (List<File>) this.common
					.query("from File order by " + orderColumn
							+ (asc ? " ASC" : " DESC"));
			logger.debug("find all instance successful, result size: {}",
					results.size());
			return results;
		} catch (RuntimeException re) {
			logger.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.dao.IFileHome#findByCriteria(org.hibernate.criterion.DetachedCriteria)
	 */
	public List<File> findByCriteria(DetachedCriteria criteria) {
		logger.debug("finding File instance with criteria: {}", criteria);
		try {
			List<File> results = (List<File>) this.common
					.findByCriteria(criteria);
			logger.debug(
					"find instance with criteria successful, result size: {}",
					results.size());
			return results;
		} catch (RuntimeException re) {
			logger.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.dao.IFileHome#isExist(java.lang.String, java.lang.Object)
	 */
	public boolean isExist(String propertyName, Object propertyValue) {
		logger.debug("is exist File instance with property: {}, value: {}",
				propertyName, propertyValue);
		try {
			return this.common.isExist("File", propertyName, propertyValue);
		} catch (RuntimeException re) {
			logger.error("get failed", re);
			throw re;
		}
	}

}
