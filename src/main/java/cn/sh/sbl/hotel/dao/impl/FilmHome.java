/**
 * Copyright © 2013, Bunco All Rights Reserved.
 * cn.sh.sbl.hotel.beans.FilmHome.java
 * Create By: Bunco
 * Create Date: 2013-11-21 14:47:58
 */
package cn.sh.sbl.hotel.dao.impl;

import cn.sh.sbl.hotel.beans.Film;
import cn.sh.sbl.hotel.common.ICommon;
import cn.sh.sbl.hotel.dao.IFilmHome;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Data access object for domain model class Film.
 * @see cn.sh.sbl.hotel.beans.Film
 * @author Bunco
 * @E-mail: amwihc512@qq.com
 * @version 1.0
 * @date 2013-11-21 14:47:58
 * @description the film table
 */
@Repository
public class FilmHome implements IFilmHome {
	@Autowired
	private Logger logger;
	@Autowired
	private ICommon<Film, String> common;

	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.dao.IFilmHome#createCriteria()
	 */
	public Criteria createCriteria() {
		logger.debug("creating Film criteria");
		return this.common.createCriteria(Film.class);
	}

	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.dao.IFilmHome#save(cn.sh.sbl.hotel.beans.Film)
	 */
	public void save(Film transientInstance) {
		logger.debug("persisting Film instance: {}");
		try {
			this.common.save(transientInstance);
			logger.debug("persist successful");
		} catch (RuntimeException re) {
			logger.error("persist failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.dao.IFilmHome#attachDirty(cn.sh.sbl.hotel.beans.Film)
	 */
	public void attachDirty(Film instance) {
		logger.debug("attaching dirty Film instance: {}", instance);
		try {
			this.common.attachDirty(instance);
			logger.debug("attach successful");
		} catch (RuntimeException re) {
			logger.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.dao.IFilmHome#delete(cn.sh.sbl.hotel.beans.Film)
	 */
	public void delete(Film persistentInstance) {
		logger.debug("deleting Film instance: {}", persistentInstance.getId());
		try {
			this.common.delete(persistentInstance);
			logger.debug("delete successful");
		} catch (RuntimeException re) {
			logger.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.dao.IFilmHome#merge(cn.sh.sbl.hotel.beans.Film)
	 */
	public Film merge(Film detachedInstance) {
		logger.debug("merging Film instance: {}", detachedInstance);
		try {
			Film result = this.common.merge(detachedInstance);
			logger.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			logger.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.dao.IFilmHome#deleteById(java.lang.String)
	 */
	public void deleteById(java.lang.String persistentInstanceId) {
		logger.debug("deleting Film instance with id: {}", persistentInstanceId);
		try {
			this.common.delete(Film.class, persistentInstanceId);
			logger.debug("delete successful");
		} catch (RuntimeException re) {
			logger.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.dao.IFilmHome#findById(java.lang.String)
	 */
	public Film findById(java.lang.String id) {
		logger.debug("getting Film instance with id: {}", id);
		try {
			Film instance = (Film) this.common.get(Film.class, id);
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
	 * @see cn.sh.sbl.hotel.dao.IFilmHome#findByExample(cn.sh.sbl.hotel.beans.Film)
	 */
	public List<Film> findByExample(Film instance) {
		logger.debug("finding Film instance by example: {}", instance);
		try {
			List<Film> results = (List<Film>) this.common
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
	 * @see cn.sh.sbl.hotel.dao.IFilmHome#findAll()
	 */
	public List<Film> findAll() {
		return this.findAll("id", true);
	}

	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.dao.IFilmHome#findAll(java.lang.String)
	 */
	public List<Film> findAll(String orderColumn) {
		return this.findAll(orderColumn, true);
	}

	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.dao.IFilmHome#findAll(java.lang.String, boolean)
	 */
	public List<Film> findAll(String orderColumn, boolean asc) {
		logger.debug("finding all Film instance with column: {}, asc: {}",
				orderColumn, asc);
		try {
			@SuppressWarnings("unchecked")
			List<Film> results = (List<Film>) this.common
					.query("from Film order by " + orderColumn
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
	 * @see cn.sh.sbl.hotel.dao.IFilmHome#findByCriteria(org.hibernate.criterion.DetachedCriteria)
	 */
	public List<Film> findByCriteria(DetachedCriteria criteria) {
		logger.debug("finding Film instance with criteria: {}", criteria);
		try {
			List<Film> results = (List<Film>) this.common
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
	 * @see cn.sh.sbl.hotel.dao.IFilmHome#isExist(java.lang.String, java.lang.Object)
	 */
	public boolean isExist(String propertyName, Object propertyValue) {
		logger.debug("is exist Film instance with property: {}, value: {}",
				propertyName, propertyValue);
		try {
			return this.common.isExist("Film", propertyName, propertyValue);
		} catch (RuntimeException re) {
			logger.error("get failed", re);
			throw re;
		}
	}

}
