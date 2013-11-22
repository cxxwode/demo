/**
 * Copyright © 2013, Bunco All Rights Reserved.
 * cn.sh.sbl.hotel.beans.CategoryHome.java
 * Create By: Bunco
 * Create Date: 2013-11-21 14:47:58
 */
package cn.sh.sbl.hotel.dao.impl;

import cn.sh.sbl.hotel.beans.Category;
import cn.sh.sbl.hotel.common.ICommon;
import cn.sh.sbl.hotel.dao.ICategoryHome;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Data access object for domain model class Category.
 * @see cn.sh.sbl.hotel.beans.Category
 * @author Bunco
 * @E-mail: amwihc512@qq.com
 * @version 1.0
 * @date 2013-11-21 14:47:58
 * @description the categorys table
 */
@Repository
public class CategoryHome implements ICategoryHome {
	@Autowired
	private Logger logger;
	@Autowired
	private ICommon<Category, Integer> common;

	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.dao.ICategoryHome#createCriteria()
	 */
	public Criteria createCriteria() {
		logger.debug("creating Category criteria");
		return this.common.createCriteria(Category.class);
	}

	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.dao.ICategoryHome#save(cn.sh.sbl.hotel.beans.Category)
	 */
	public void save(Category transientInstance) {
		logger.debug("persisting Category instance: {}", transientInstance);
		try {
			this.common.save(transientInstance);
			logger.debug("persist successful");
		} catch (RuntimeException re) {
			logger.error("persist failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.dao.ICategoryHome#attachDirty(cn.sh.sbl.hotel.beans.Category)
	 */
	public void attachDirty(Category instance) {
		logger.debug("attaching dirty Category instance: {}", instance);
		try {
			this.common.attachDirty(instance);
			logger.debug("attach successful");
		} catch (RuntimeException re) {
			logger.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.dao.ICategoryHome#delete(cn.sh.sbl.hotel.beans.Category)
	 */
	public void delete(Category persistentInstance) {
		logger.debug("deleting Category instance: {}", persistentInstance);
		try {
			this.common.delete(persistentInstance);
			logger.debug("delete successful");
		} catch (RuntimeException re) {
			logger.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.dao.ICategoryHome#merge(cn.sh.sbl.hotel.beans.Category)
	 */
	public Category merge(Category detachedInstance) {
		logger.debug("merging Category instance: {}", detachedInstance);
		try {
			Category result = this.common.merge(detachedInstance);
			logger.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			logger.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.dao.ICategoryHome#deleteById(java.lang.Integer)
	 */
	public void deleteById(java.lang.Integer persistentInstanceId) {
		logger.debug("deleting Category instance with id: {}",
				persistentInstanceId);
		try {
			this.common.delete(Category.class, persistentInstanceId);
			logger.debug("delete successful");
		} catch (RuntimeException re) {
			logger.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.dao.ICategoryHome#findById(java.lang.Integer)
	 */
	public Category findById(java.lang.Integer id) {
		logger.debug("getting Category instance with id: {}", id);
		try {
			Category instance = (Category) this.common.get(Category.class, id);
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
	 * @see cn.sh.sbl.hotel.dao.ICategoryHome#findByExample(cn.sh.sbl.hotel.beans.Category)
	 */
	public List<Category> findByExample(Category instance) {
		logger.debug("finding Category instance by example: {}", instance);
		try {
			List<Category> results = (List<Category>) this.common
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
	 * @see cn.sh.sbl.hotel.dao.ICategoryHome#findAll()
	 */
	public List<Category> findAll() {
		return this.findAll("id", true);
	}

	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.dao.ICategoryHome#findAll(java.lang.String)
	 */
	public List<Category> findAll(String orderColumn) {
		return this.findAll(orderColumn, true);
	}

	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.dao.ICategoryHome#findAll(java.lang.String, boolean)
	 */
	public List<Category> findAll(String orderColumn, boolean asc) {
		logger.debug("finding all Category instance with column: {}, asc: {}",
				orderColumn, asc);
		try {
			@SuppressWarnings("unchecked")
			List<Category> results = (List<Category>) this.common
					.query("from Category order by " + orderColumn
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
	 * @see cn.sh.sbl.hotel.dao.ICategoryHome#findByCriteria(org.hibernate.criterion.DetachedCriteria)
	 */
	public List<Category> findByCriteria(DetachedCriteria criteria) {
		logger.debug("finding Category instance with criteria: {}", criteria);
		try {
			List<Category> results = (List<Category>) this.common
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
	 * @see cn.sh.sbl.hotel.dao.ICategoryHome#isExist(java.lang.String, java.lang.Object)
	 */
	public boolean isExist(String propertyName, Object propertyValue) {
		logger.debug("is exist Category instance with property: {}, value: {}",
				propertyName, propertyValue);
		try {
			return this.common.isExist("Category", propertyName, propertyValue);
		} catch (RuntimeException re) {
			logger.error("get failed", re);
			throw re;
		}
	}

}
