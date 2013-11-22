/**
 * Copyright © 2013, Bunco All Rights Reserved.
 * cn.sh.sbl.hotel.beans.ActorHome.java
 * Create By: Bunco
 * Create Date: 2013-11-21 14:47:58
 */
package cn.sh.sbl.hotel.dao.impl;

import cn.sh.sbl.hotel.beans.Actor;
import cn.sh.sbl.hotel.common.ICommon;
import cn.sh.sbl.hotel.dao.IActorHome;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Data access object for domain model class Actor.
 * @see cn.sh.sbl.hotel.beans.Actor
 * @author Bunco
 * @E-mail: amwihc512@qq.com
 * @version 1.0
 * @date 2013-11-21 14:47:58
 * @description the actor table
 */
@Repository
public class ActorHome implements IActorHome {
	@Autowired
	private Logger logger;
	@Autowired
	private ICommon<Actor, Integer> common;

	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.dao.IActorHome#createCriteria()
	 */
	public Criteria createCriteria() {
		logger.debug("creating Actor criteria");
		return this.common.createCriteria(Actor.class);
	}

	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.dao.IActorHome#save(cn.sh.sbl.hotel.beans.Actor)
	 */
	public void save(Actor transientInstance) {
		logger.debug("persisting Actor instance: {}", transientInstance);
		try {
			this.common.save(transientInstance);
			logger.debug("persist successful");
		} catch (RuntimeException re) {
			logger.error("persist failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.dao.IActorHome#attachDirty(cn.sh.sbl.hotel.beans.Actor)
	 */
	public void attachDirty(Actor instance) {
		logger.debug("attaching dirty Actor instance: {}", instance);
		try {
			this.common.attachDirty(instance);
			logger.debug("attach successful");
		} catch (RuntimeException re) {
			logger.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.dao.IActorHome#delete(cn.sh.sbl.hotel.beans.Actor)
	 */
	public void delete(Actor persistentInstance) {
		logger.debug("deleting Actor instance: {}", persistentInstance);
		try {
			this.common.delete(persistentInstance);
			logger.debug("delete successful");
		} catch (RuntimeException re) {
			logger.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.dao.IActorHome#merge(cn.sh.sbl.hotel.beans.Actor)
	 */
	public Actor merge(Actor detachedInstance) {
		logger.debug("merging Actor instance: {}", detachedInstance);
		try {
			Actor result = this.common.merge(detachedInstance);
			logger.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			logger.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.dao.IActorHome#deleteById(java.lang.Integer)
	 */
	public void deleteById(java.lang.Integer persistentInstanceId) {
		logger.debug("deleting Actor instance with id: {}",
				persistentInstanceId);
		try {
			this.common.delete(Actor.class, persistentInstanceId);
			logger.debug("delete successful");
		} catch (RuntimeException re) {
			logger.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.dao.IActorHome#findById(java.lang.Integer)
	 */
	public Actor findById(java.lang.Integer id) {
		logger.debug("getting Actor instance with id: {}", id);
		try {
			Actor instance = (Actor) this.common.get(Actor.class, id);
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
	 * @see cn.sh.sbl.hotel.dao.IActorHome#findByExample(cn.sh.sbl.hotel.beans.Actor)
	 */
	public List<Actor> findByExample(Actor instance) {
		logger.debug("finding Actor instance by example: {}", instance);
		try {
			List<Actor> results = (List<Actor>) this.common
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
	 * @see cn.sh.sbl.hotel.dao.IActorHome#findAll()
	 */
	public List<Actor> findAll() {
		return this.findAll("id", true);
	}

	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.dao.IActorHome#findAll(java.lang.String)
	 */
	public List<Actor> findAll(String orderColumn) {
		return this.findAll(orderColumn, true);
	}

	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.dao.IActorHome#findAll(java.lang.String, boolean)
	 */
	public List<Actor> findAll(String orderColumn, boolean asc) {
		logger.debug("finding all Actor instance with column: {}, asc: {}",
				orderColumn, asc);
		try {
			@SuppressWarnings("unchecked")
			List<Actor> results = (List<Actor>) this.common
					.query("from Actor order by " + orderColumn
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
	 * @see cn.sh.sbl.hotel.dao.IActorHome#findByCriteria(org.hibernate.criterion.DetachedCriteria)
	 */
	public List<Actor> findByCriteria(DetachedCriteria criteria) {
		logger.debug("finding Actor instance with criteria: {}", criteria);
		try {
			List<Actor> results = (List<Actor>) this.common
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
	 * @see cn.sh.sbl.hotel.dao.IActorHome#isExist(java.lang.String, java.lang.Object)
	 */
	public boolean isExist(String propertyName, Object propertyValue) {
		logger.debug("is exist Actor instance with property: {}, value: {}",
				propertyName, propertyValue);
		try {
			return this.common.isExist("Actor", propertyName, propertyValue);
		} catch (RuntimeException re) {
			logger.error("get failed", re);
			throw re;
		}
	}

}
