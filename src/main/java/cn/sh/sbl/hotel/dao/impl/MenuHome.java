/**
 * Copyright © 2013, Bunco All Rights Reserved.
 * cn.sh.sbl.hotel.beans.MenuHome.java
 * Create By: Bunco
 * Create Date: 2013-11-21 14:47:58
 */
package cn.sh.sbl.hotel.dao.impl;

import cn.sh.sbl.hotel.beans.Menu;
import cn.sh.sbl.hotel.common.ICommon;
import cn.sh.sbl.hotel.dao.IMenuHome;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Data access object for domain model class Menu.
 * @see cn.sh.sbl.hotel.beans.Menu
 * @author Bunco
 * @E-mail: amwihc512@qq.com
 * @version 1.0
 * @date 2013-11-21 14:47:58
 * @description terminal display menu
 */
@Repository
public class MenuHome implements IMenuHome {
	@Autowired
	private Logger logger;
	@Autowired
	private ICommon<Menu, Integer> common;

	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.dao.IMenuHome#createCriteria()
	 */
	public Criteria createCriteria() {
		logger.debug("creating Menu criteria");
		return this.common.createCriteria(Menu.class);
	}

	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.dao.IMenuHome#save(cn.sh.sbl.hotel.beans.Menu)
	 */
	public void save(Menu transientInstance) {
		logger.debug("persisting Menu instance: {}", transientInstance);
		try {
			this.common.save(transientInstance);
			logger.debug("persist successful");
		} catch (RuntimeException re) {
			logger.error("persist failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.dao.IMenuHome#attachDirty(cn.sh.sbl.hotel.beans.Menu)
	 */
	public void attachDirty(Menu instance) {
		logger.debug("attaching dirty Menu instance: {}", instance);
		try {
			this.common.attachDirty(instance);
			logger.debug("attach successful");
		} catch (RuntimeException re) {
			logger.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.dao.IMenuHome#delete(cn.sh.sbl.hotel.beans.Menu)
	 */
	public void delete(Menu persistentInstance) {
		logger.debug("deleting Menu instance: {}", persistentInstance);
		try {
			this.common.delete(persistentInstance);
			logger.debug("delete successful");
		} catch (RuntimeException re) {
			logger.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.dao.IMenuHome#merge(cn.sh.sbl.hotel.beans.Menu)
	 */
	public Menu merge(Menu detachedInstance) {
		logger.debug("merging Menu instance: {}", detachedInstance);
		try {
			Menu result = this.common.merge(detachedInstance);
			logger.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			logger.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.dao.IMenuHome#deleteById(java.lang.Integer)
	 */
	public void deleteById(java.lang.Integer persistentInstanceId) {
		logger.debug("deleting Menu instance with id: {}", persistentInstanceId);
		try {
			this.common.delete(Menu.class, persistentInstanceId);
			logger.debug("delete successful");
		} catch (RuntimeException re) {
			logger.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.dao.IMenuHome#findById(java.lang.Integer)
	 */
	public Menu findById(java.lang.Integer id) {
		logger.debug("getting Menu instance with id: {}", id);
		try {
			Menu instance = (Menu) this.common.get(Menu.class, id);
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
	 * @see cn.sh.sbl.hotel.dao.IMenuHome#findByExample(cn.sh.sbl.hotel.beans.Menu)
	 */
	public List<Menu> findByExample(Menu instance) {
		logger.debug("finding Menu instance by example: {}", instance);
		try {
			List<Menu> results = (List<Menu>) this.common
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
	 * @see cn.sh.sbl.hotel.dao.IMenuHome#findAll()
	 */
	public List<Menu> findAll() {
		return this.findAll("id", true);
	}

	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.dao.IMenuHome#findAll(java.lang.String)
	 */
	public List<Menu> findAll(String orderColumn) {
		return this.findAll(orderColumn, true);
	}

	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.dao.IMenuHome#findAll(java.lang.String, boolean)
	 */
	public List<Menu> findAll(String orderColumn, boolean asc) {
		logger.debug("finding all Menu instance with column: {}, asc: {}",
				orderColumn, asc);
		try {
			@SuppressWarnings("unchecked")
			List<Menu> results = (List<Menu>) this.common
					.query("from Menu order by " + orderColumn
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
	 * @see cn.sh.sbl.hotel.dao.IMenuHome#findByCriteria(org.hibernate.criterion.DetachedCriteria)
	 */
	public List<Menu> findByCriteria(DetachedCriteria criteria) {
		logger.debug("finding Menu instance with criteria: {}", criteria);
		try {
			List<Menu> results = (List<Menu>) this.common
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
	 * @see cn.sh.sbl.hotel.dao.IMenuHome#isExist(java.lang.String, java.lang.Object)
	 */
	public boolean isExist(String propertyName, Object propertyValue) {
		logger.debug("is exist Menu instance with property: {}, value: {}",
				propertyName, propertyValue);
		try {
			return this.common.isExist("Menu", propertyName, propertyValue);
		} catch (RuntimeException re) {
			logger.error("get failed", re);
			throw re;
		}
	}

}
