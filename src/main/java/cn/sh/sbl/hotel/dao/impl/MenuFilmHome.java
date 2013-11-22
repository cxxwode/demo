/**
 * Copyright © 2013, Bunco All Rights Reserved.
 * cn.sh.sbl.hotel.beans.MenuFilmHome.java
 * Create By: Bunco
 * Create Date: 2013-11-21 14:47:58
 */
package cn.sh.sbl.hotel.dao.impl;

import cn.sh.sbl.hotel.beans.MenuFilm;
import cn.sh.sbl.hotel.beans.MenuFilmId;
import cn.sh.sbl.hotel.common.ICommon;
import cn.sh.sbl.hotel.dao.IMenuFilmHome;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Data access object for domain model class MenuFilm.
 * @see cn.sh.sbl.hotel.beans.MenuFilm
 * @author Bunco
 * @E-mail: amwihc512@qq.com
 * @version 1.0
 * @date 2013-11-21 14:47:58
 * @description the menu film table
 */
@Repository
public class MenuFilmHome implements IMenuFilmHome {
	@Autowired
	private Logger logger;
	@Autowired
	private ICommon<MenuFilm, MenuFilmId> common;

	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.dao.IMenuFilmHome#createCriteria()
	 */
	public Criteria createCriteria() {
		logger.debug("creating MenuFilm criteria");
		return this.common.createCriteria(MenuFilm.class);
	}

	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.dao.IMenuFilmHome#save(cn.sh.sbl.hotel.beans.MenuFilm)
	 */
	public void save(MenuFilm transientInstance) {
		logger.debug("persisting MenuFilm instance: {}", transientInstance);
		try {
			this.common.save(transientInstance);
			logger.debug("persist successful");
		} catch (RuntimeException re) {
			logger.error("persist failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.dao.IMenuFilmHome#attachDirty(cn.sh.sbl.hotel.beans.MenuFilm)
	 */
	public void attachDirty(MenuFilm instance) {
		logger.debug("attaching dirty MenuFilm instance: {}", instance);
		try {
			this.common.attachDirty(instance);
			logger.debug("attach successful");
		} catch (RuntimeException re) {
			logger.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.dao.IMenuFilmHome#delete(cn.sh.sbl.hotel.beans.MenuFilm)
	 */
	public void delete(MenuFilm persistentInstance) {
		logger.debug("deleting MenuFilm instance: {}", persistentInstance);
		try {
			this.common.delete(persistentInstance);
			logger.debug("delete successful");
		} catch (RuntimeException re) {
			logger.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.dao.IMenuFilmHome#merge(cn.sh.sbl.hotel.beans.MenuFilm)
	 */
	public MenuFilm merge(MenuFilm detachedInstance) {
		logger.debug("merging MenuFilm instance: {}", detachedInstance);
		try {
			MenuFilm result = this.common.merge(detachedInstance);
			logger.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			logger.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.dao.IMenuFilmHome#deleteById(cn.sh.sbl.hotel.beans.MenuFilmId)
	 */
	public void deleteById(cn.sh.sbl.hotel.beans.MenuFilmId persistentInstanceId) {
		logger.debug("deleting MenuFilm instance with id: {}",
				persistentInstanceId);
		try {
			this.common.delete(MenuFilm.class, persistentInstanceId);
			logger.debug("delete successful");
		} catch (RuntimeException re) {
			logger.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.dao.IMenuFilmHome#findById(cn.sh.sbl.hotel.beans.MenuFilmId)
	 */
	public MenuFilm findById(cn.sh.sbl.hotel.beans.MenuFilmId id) {
		logger.debug("getting MenuFilm instance with id: {}", id);
		try {
			MenuFilm instance = (MenuFilm) this.common.get(MenuFilm.class, id);
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
	 * @see cn.sh.sbl.hotel.dao.IMenuFilmHome#findByExample(cn.sh.sbl.hotel.beans.MenuFilm)
	 */
	public List<MenuFilm> findByExample(MenuFilm instance) {
		logger.debug("finding MenuFilm instance by example: {}", instance);
		try {
			List<MenuFilm> results = (List<MenuFilm>) this.common
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
	 * @see cn.sh.sbl.hotel.dao.IMenuFilmHome#findAll()
	 */
	public List<MenuFilm> findAll() {
		return this.findAll("id", true);
	}

	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.dao.IMenuFilmHome#findAll(java.lang.String)
	 */
	public List<MenuFilm> findAll(String orderColumn) {
		return this.findAll(orderColumn, true);
	}

	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.dao.IMenuFilmHome#findAll(java.lang.String, boolean)
	 */
	public List<MenuFilm> findAll(String orderColumn, boolean asc) {
		logger.debug("finding all MenuFilm instance with column: {}, asc: {}",
				orderColumn, asc);
		try {
			@SuppressWarnings("unchecked")
			List<MenuFilm> results = (List<MenuFilm>) this.common
					.query("from MenuFilm order by " + orderColumn
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
	 * @see cn.sh.sbl.hotel.dao.IMenuFilmHome#findByCriteria(org.hibernate.criterion.DetachedCriteria)
	 */
	public List<MenuFilm> findByCriteria(DetachedCriteria criteria) {
		logger.debug("finding MenuFilm instance with criteria: {}", criteria);
		try {
			List<MenuFilm> results = (List<MenuFilm>) this.common
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
	 * @see cn.sh.sbl.hotel.dao.IMenuFilmHome#isExist(java.lang.String, java.lang.Object)
	 */
	public boolean isExist(String propertyName, Object propertyValue) {
		logger.debug("is exist MenuFilm instance with property: {}, value: {}",
				propertyName, propertyValue);
		try {
			return this.common.isExist("MenuFilm", propertyName, propertyValue);
		} catch (RuntimeException re) {
			logger.error("get failed", re);
			throw re;
		}
	}

}
