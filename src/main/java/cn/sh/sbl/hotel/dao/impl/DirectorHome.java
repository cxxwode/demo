/**
 * Copyright © 2013, Bunco All Rights Reserved.
 * cn.sh.sbl.hotel.beans.DirectorHome.java
 * Create By: Bunco
 * Create Date: 2013-11-21 14:47:58
 */
package cn.sh.sbl.hotel.dao.impl;

import cn.sh.sbl.hotel.beans.Director;
import cn.sh.sbl.hotel.common.ICommon;
import cn.sh.sbl.hotel.dao.IDirectorHome;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Data access object for domain model class Director.
 * @see cn.sh.sbl.hotel.beans.Director
 * @author Bunco
 * @E-mail: amwihc512@qq.com
 * @version 1.0
 * @date 2013-11-21 14:47:58
 * @description the director table
 */
@Repository
public class DirectorHome implements IDirectorHome {
	@Autowired
	private Logger logger;
	@Autowired
	private ICommon<Director, Integer> common;

	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.dao.IDirectorHome#createCriteria()
	 */
	public Criteria createCriteria() {
		logger.debug("creating Director criteria");
		return this.common.createCriteria(Director.class);
	}

	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.dao.IDirectorHome#save(cn.sh.sbl.hotel.beans.Director)
	 */
	public void save(Director transientInstance) {
		logger.debug("persisting Director instance: {}", transientInstance);
		try {
			this.common.save(transientInstance);
			logger.debug("persist successful");
		} catch (RuntimeException re) {
			logger.error("persist failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.dao.IDirectorHome#attachDirty(cn.sh.sbl.hotel.beans.Director)
	 */
	public void attachDirty(Director instance) {
		logger.debug("attaching dirty Director instance: {}", instance);
		try {
			this.common.attachDirty(instance);
			logger.debug("attach successful");
		} catch (RuntimeException re) {
			logger.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.dao.IDirectorHome#delete(cn.sh.sbl.hotel.beans.Director)
	 */
	public void delete(Director persistentInstance) {
		logger.debug("deleting Director instance: {}", persistentInstance);
		try {
			this.common.delete(persistentInstance);
			logger.debug("delete successful");
		} catch (RuntimeException re) {
			logger.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.dao.IDirectorHome#merge(cn.sh.sbl.hotel.beans.Director)
	 */
	public Director merge(Director detachedInstance) {
		logger.debug("merging Director instance: {}", detachedInstance);
		try {
			Director result = this.common.merge(detachedInstance);
			logger.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			logger.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.dao.IDirectorHome#deleteById(java.lang.Integer)
	 */
	public void deleteById(java.lang.Integer persistentInstanceId) {
		logger.debug("deleting Director instance with id: {}",
				persistentInstanceId);
		try {
			this.common.delete(Director.class, persistentInstanceId);
			logger.debug("delete successful");
		} catch (RuntimeException re) {
			logger.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.dao.IDirectorHome#findById(java.lang.Integer)
	 */
	public Director findById(java.lang.Integer id) {
		logger.debug("getting Director instance with id: {}", id);
		try {
			Director instance = (Director) this.common.get(Director.class, id);
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
	 * @see cn.sh.sbl.hotel.dao.IDirectorHome#findByExample(cn.sh.sbl.hotel.beans.Director)
	 */
	public List<Director> findByExample(Director instance) {
		logger.debug("finding Director instance by example: {}", instance);
		try {
			List<Director> results = (List<Director>) this.common
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
	 * @see cn.sh.sbl.hotel.dao.IDirectorHome#findAll()
	 */
	public List<Director> findAll() {
		return this.findAll("id", true);
	}

	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.dao.IDirectorHome#findAll(java.lang.String)
	 */
	public List<Director> findAll(String orderColumn) {
		return this.findAll(orderColumn, true);
	}

	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.dao.IDirectorHome#findAll(java.lang.String, boolean)
	 */
	public List<Director> findAll(String orderColumn, boolean asc) {
		logger.debug("finding all Director instance with column: {}, asc: {}",
				orderColumn, asc);
		try {
			@SuppressWarnings("unchecked")
			List<Director> results = (List<Director>) this.common
					.query("from Director order by " + orderColumn
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
	 * @see cn.sh.sbl.hotel.dao.IDirectorHome#findByCriteria(org.hibernate.criterion.DetachedCriteria)
	 */
	public List<Director> findByCriteria(DetachedCriteria criteria) {
		logger.debug("finding Director instance with criteria: {}", criteria);
		try {
			List<Director> results = (List<Director>) this.common
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
	 * @see cn.sh.sbl.hotel.dao.IDirectorHome#isExist(java.lang.String, java.lang.Object)
	 */
	public boolean isExist(String propertyName, Object propertyValue) {
		logger.debug("is exist Director instance with property: {}, value: {}",
				propertyName, propertyValue);
		try {
			return this.common.isExist("Director", propertyName, propertyValue);
		} catch (RuntimeException re) {
			logger.error("get failed", re);
			throw re;
		}
	}

}
