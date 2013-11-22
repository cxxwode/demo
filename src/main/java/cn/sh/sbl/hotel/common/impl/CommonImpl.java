/**
 * Copyright © 2012, Bunco All Rights Reserved.
 * Project: HotelVodSys
 * cn.sh.sbl.hotelvod.common.impl.CommonImpl<POJO>.java
 * Create By: Bunco
 * Create Date: 2012-5-15 上午10:13:05
 */
package cn.sh.sbl.hotel.common.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.sh.sbl.hotel.common.ICommon;

/**
 * Implementation of <code>ICommon</code> using Hibernate.
 * The SessionFactory property is annotated for automatic resource injection.
 * @author Bunco
 * @E-mail: bunco.hb@gmail.com
 * @version 1.0
 * @date 2013-11-21 上午11:59:05
 * @description 持久化通用类, 定义实体对象的添, 删, 改, 查等通用操作
 * @param <POJO>
 *            The type of the domain object for which this instance is to be
 *            used.
 * @param <ID>
 *            The type of the id of the domain object for which this instance is
 *            to be used.
 */
@Repository
public class CommonImpl<POJO, ID extends Serializable> extends HibernateDaoSupport implements
		ICommon<POJO, ID> {
	/**
	 * Create a new Criteria instance, for the given entity class, or a superclass of an entity class.
	 * @param clazz
	 * @return
	 */
	public Criteria createCriteria(Class<POJO> clazz) {
		return getSession().createCriteria(clazz);
	}
	
	/**
	 * Create a new Criteria instance, for the given entity name.
	 * @param entityName
	 * @return
	 */
	public Criteria createCriteria(String entityName) {
		return getSession().createCriteria(entityName);
	}
	
	/**
	 * 保存实体对象<br />
	 * Persist the given transient instances and add them to the datastore,
	 * first assigning a generated identifier. (Or using the current value of
	 * the identifier property if the assigned generator is used.) This
	 * operation cascades to associated instances if the association is mapped
	 * with cascade="save-update".
	 * @param pojo
	 */
	@SuppressWarnings("unchecked")
	public ID save(POJO pojo) {
		return (ID) this.getHibernateTemplate().save(pojo);
	}
	
	/**
	 * attaching dirty instance
	 * @param pojo
	 */
	public void attachDirty(POJO pojo) {
		this.getHibernateTemplate().saveOrUpdate(pojo);
	}
	
	/**
	 * 批量保存实体对象<br/>
	 * Batch persist the given transient instances and add them to the datastore,
	 * first assigning a generated identifier. (Or using the current value of
	 * the identifier property if the assigned generator is used.) This
	 * operation cascades to associated instances if the association is mapped
	 * with cascade="save-update".
	 * @param pojos
	 */
	public void save(POJO... pojos) {
		for (POJO pojo : pojos) {
			this.getHibernateTemplate().save(pojo);
		}
	}

	/**
	 * 删除实体对象<br/>
	 * Remove all the entities of the given type from the datastore that have
	 * one of these ids.
	 * @param clazz
	 * @param id
	 */
	public void delete(Class<POJO> clazz, ID... ids) {
		for (ID serializable : ids) {
			this.getHibernateTemplate().delete(
					this.getHibernateTemplate().load(clazz, serializable));
		}
	}
	
	/**
	 * Copy the state of the given object onto the persistent object with the
	 * same identifier. If there is no persistent instance currently associated
	 * with the session, it will be loaded. Return the persistent instance. If
	 * the given instance is unsaved, save a copy of and return it as a newly
	 * persistent instance. The given instance does not become associated with
	 * the session. This operation cascades to associated instances if the
	 * association is mapped with cascade="merge".<br/>
	 * The difference between <code>update()</code> and <code>merge()</code> is
	 * significant: <code>update()</code> will make the given object persistent
	 * and throw and error if another object with the same ID is already
	 * persistent in the Session. <code>merge()</code> doesn't care if another
	 * object is already persistent, but it also doesn't make the given object
	 * persistent; it just copies over the values to the datastore.
	 * @param pojo
	 * @return merged POJO
	 */
	public POJO merge(POJO pojo) {
		return this.getHibernateTemplate().merge(pojo);
	}
	
	/**
	 * 删除实体对象<br/>
	 * Remove the specified entity from the datastore.
	 * @param pojo
	 */
	public void delete(POJO pojo) {
		this.getHibernateTemplate().delete(pojo);
	}

	/**
	 * 修改实体对象, 未进行持久化判断....使用时应先加载再修改<br/>
	 * Update the persistent instance with the identifier of the given detached
	 * instance. If there is a persistent instance with the same identifier, an
	 * exception is thrown. This operation cascades to associated instances if
	 * the association is mapped with cascade="save-update".<br/>
	 * The difference between <code>update()</code> and <code>merge()</code> is
	 * significant: <code>update()</code> will make the given object persistent
	 * and throw and error if another object with the same ID is already
	 * persistent in the Session. <code>merge()</code> doesn't care if another
	 * object is already persistent, but it also doesn't make the given object
	 * persistent; it just copies over the values to the datastore.
	 * @param pojo
	 */
	public void update(POJO... pojos) {
		for (POJO pojo : pojos) {
			this.getHibernateTemplate().update(pojo);
		}
	}

	/**
	 * 根据对象ID加载对象<br/>
	 * Return the persistent instance of the given entity class with the given
	 * identifier, assuming that the instance exists. Throw an unrecoverable
	 * exception if there is no matching database row.<br/>
	 * If the class is mapped with a proxy, <code>load()</code> just returns an
	 * uninitialized proxy and does not actually hit the database until you
	 * invoke a method of the proxy. This behaviour is very useful if you wish
	 * to create an association to an object without actually loading it from
	 * the database. It also allows multiple instances to be loaded as a batch
	 * if batch-size is defined for the class mapping.
	 * @param clazz
	 * @param id
	 * @return POJO
	 */
	public POJO load(Class<POJO> clazz, ID id) {
		return (POJO) this.getHibernateTemplate().load(clazz, id);
	}

	/**
	 * 根据对象ID加载对象, 和Load()功能相似, 作用范围不同<br/>
	 * Return the persistent instance of the given entity class with the given
	 * identifier, or null if there is no such persistent instance.
	 * <code>get()</code> always hits the database immediately.
	 * @param clazz
	 * @param id
	 * @return POJO
	 */
	public POJO get(Class<POJO> clazz, ID id) {
		return (POJO) this.getHibernateTemplate().get(clazz, id);
	}
	
	/**
	 * finding instance by example
	 * @param example
	 * @return List<POJO>
	 */
	@SuppressWarnings("unchecked")
	public List<POJO> findByExample(POJO example) {
		return this.getHibernateTemplate().findByExample(example);
	}
	
	/**
	 * finding instance by criteria
	 * @param criteria
	 * @return List<POJO>
	 */
	@SuppressWarnings("unchecked")
	public List<POJO> findByCriteria(DetachedCriteria criteria) {
		return this.getHibernateTemplate().findByCriteria(criteria);
	}
	
	/**
	 * 根据指定属性名和值查询对象是否存在
	 * @param entityName 查询是否存在的对象
	 * @param propertyName 对象属性名
	 * @param propertyValue 对象属性值
	 * @return 是否存在该对象
	 */
	public boolean isExist(String entityName, String propertyName, final Object propertyValue) {
		final String hql = "select count(*) from " + entityName + " as t where t." + propertyName + " = ?";
		List<?> list = this.getHibernateTemplate().execute(new HibernateCallback<List<?>>() {
			public List<?> doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				CommonImpl.this.bindParameter(query, propertyValue);
				return query.list();
			}
		});
		
		if (0 < list.size()) {
			if (0 < Long.valueOf(list.get(0).toString())) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
	
	/**
	 * 查询记录是否存在, 非命名
	 * @param hql HQL语句
	 * @param params 参数列表
	 * @return 是否存在该对象
	 */
	public boolean isExist(final String hql, final Object... params) {
		return 0 < this.sizeOf(hql, params);
	}
	
	/**
	 * 查询记录是否存在, 命名查询
	 * @param hql 命名HQL语句
	 * @param params 参数列表
	 * @return 是否存在该对象
	 */
	public boolean isExistNamed(final String hql, final Object... params) {
		return 0 < this.sizeOfNamed(hql, params);
	}
	
	/**
	 * 查询记录数, 非命名查询
	 * @param hql HQL语句
	 * @param params 参数列表
	 * @return 记录数
	 */
	public long sizeOf(final String hql, final Object... params) {
		List<?> list = this.getHibernateTemplate().execute(new HibernateCallback<List<?>>() {
			public List<?> doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				CommonImpl.this.bindParameter(query, params);
				return query.list();
			}
		});
		if (0 < list.size()) {
			return Long.valueOf(list.get(0).toString());
		}
		return 0;
	}
	
	/**
	 * 查询记录数, 命名查询
	 * @param hql 命名HQL语句
	 * @param params 参数列表
	 * @return 记录数
	 */
	public long sizeOfNamed(final String hql, final Object... params) {
		List<?> list = this.getHibernateTemplate().execute(new HibernateCallback<List<?>>() {
			public List<?> doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				CommonImpl.this.bindParameter(query, params);
				return query.list();
			}
		});
		if (0 < list.size()) {
			return Long.valueOf(list.get(0).toString());
		}
		return 0;
	}
	
	/**
	 * 执行HQL语句, 非命名, 非查询
	 * @param hql  hql语句
	 * @param params 参数列表
	 * @return
	 */
	public int execute(final String hql, final Object... params) {
		return this.getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			public Integer doInHibernate(Session session) {
				Query query = session.createQuery(hql);
				CommonImpl.this.bindParameter(query, params);
				return query.executeUpdate();
			}
		});
	}
	
	/**
	 * 执行HQL语句, 非查询
	 * @param hql  hql语句
	 * @param params 参数列表
	 * @return
	 */
	public int executeNamed(final String hql, final Object... params) {
		return this.getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			public Integer doInHibernate(Session session) {
				Query query = session.getNamedQuery(hql);
				CommonImpl.this.bindParameter(query, params);
				return query.executeUpdate();
			}
		});
	}

	/**
	 * 查询结果
	 * @param hql HQL语句
	 * @param params 参数列表
	 * @return List<?>
	 */
	public List<?> query(final String hql, final Object... params) {
		return this.getHibernateTemplate().executeFind(new HibernateCallback<List<?>>() {
			public List<?> doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				CommonImpl.this.bindParameter(query, params);
				return query.list();
			}
		});
	}

	/**
	 * 查询结果, 分页
	 * @param hql HQL语句
	 * @param currPage 当前页
	 * @param pageSize 页大小
	 * @param params 参数列表
	 * @return List<?>
	 */
	public List<?> queryPage(final String hql, final int currPage, final int pageSize,
			final Object... params) {
		return this.getHibernateTemplate().executeFind(new HibernateCallback<List<?>>() {
			public List<?> doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql)
						.setFirstResult((currPage - 1) * pageSize)
						.setMaxResults(pageSize);
				CommonImpl.this.bindParameter(query, params);
				return query.list();
			}
		});
	}

	/**
	 * 采用命名查询结果
	 * @param hql 命名HQL语句
	 * @param params 参数列表
	 * @return
	 */
	public List<?> queryNamed(final String hql, final Object... params) {
		return this.getHibernateTemplate().executeFind(new HibernateCallback<List<?>>() {
			public List<?> doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.getNamedQuery(hql);
				CommonImpl.this.bindParameter(query, params);
				return query.list();
			}
		});
	}

	/**
	 * 采用命名查询结果, 分页, 指定结果集大小
	 * @param hql 命名HQL语句
	 * @param currPage 当前页
	 * @param pageSize 页大小
	 * @param params 参数列表
	 * @return
	 */
	public List<?> queryNamedPage(final String hql, final int currPage,
			final int pageSize, final Object... params) {
		return this.getHibernateTemplate().executeFind(new HibernateCallback<List<?>>() {
			public List<?> doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.getNamedQuery(hql)
						.setFirstResult((currPage - 1) * pageSize)
						.setMaxResults(pageSize);
				CommonImpl.this.bindParameter(query, params);
				return query.list();
			}
		});
	}

	/**
	 * 查询结果, 指定结果集大小
	 * @param maxResult 指定结果集大小
	 * @param hql HQL语句
	 * @param params 参数列表
	 * @return List<?>
	 */
	public List<?> query(final int maxResult, final String hql,
			final Object... params) {
		return this.getHibernateTemplate().executeFind(new HibernateCallback<List<?>>() {
			public List<?> doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql).setMaxResults(maxResult);
				CommonImpl.this.bindParameter(query, params);
				return query.list();
			}
		});
	}

	/**
	 * 采用命名查询结果, 指定结果集大小
	 * @param maxResult 指定结果集大小
	 * @param hql 命名HQL语句
	 * @param params 参数列表
	 * @return List<?>
	 */
	public List<?> queryNamed(final int maxResult, final String hql,
			final Object... params) {
		return this.getHibernateTemplate().executeFind(new HibernateCallback<List<?>>() {
			public List<?> doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.getNamedQuery(hql).setMaxResults(
						maxResult);
				CommonImpl.this.bindParameter(query, params);
				return query.list();
			}
		});
	}

	/**
	 * 分页查询
	 * @param offset 从多少条记录开始查询
	 * @param pageSize 页大小
	 * @param hql 用于查询HQL语句
	 * @param params 参数列表
	 * @return List<?>
	 */
	public List<?> query(final int offset, final int pageSize, final String hql,
			final Object... params) {
		return this.getHibernateTemplate().executeFind(new HibernateCallback<List<?>>() {
			public List<?> doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql).setFirstResult(offset)
						.setMaxResults(pageSize);
				CommonImpl.this.bindParameter(query, params);
				return query.list();
			}
		});
	}

	/**
	 * 采用命名分页查询
	 * @param offset 偏移量
	 * @param pageSize 页大小
	 * @param hql 命名查询名称
	 * @param params 参数列表
	 * @return
	 */
	public List<?> queryNamed(final int offset, final int pageSize,
			final String hql, final Object... params) {
		return this.getHibernateTemplate().executeFind(new HibernateCallback<List<?>>() {
			public List<?> doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.getNamedQuery(hql).setFirstResult(offset)
						.setMaxResults(pageSize);
				CommonImpl.this.bindParameter(query, params);
				return query.list();
			}
		});
	}
	
	/**
	 * 绑定参数
	 * @param query
	 * @param params
	 */
	public void bindParameter(Query query, Object... params) {
		if (params == null)
			return;
		int i = 0;
		for (Object object : params) {
			if (object instanceof Map) {
				Map<?, ?> map = (Map<?, ?>) object;
				for (Iterator<?> iter = map.entrySet().iterator(); iter.hasNext();) {
					Map.Entry<?, ?> entry = (Entry<?, ?>) iter.next();
				    String key = (String) entry.getKey();
				    if (entry.getValue() instanceof List) {
				    	query.setParameterList(key, (List<?>)entry.getValue());
					} else if (entry.getValue().getClass().isArray()) {
						query.setParameterList(key, (List<?>)entry.getValue());
					} else {
						query.setParameter(key, entry.getValue());
					};
				}
			} else if (object instanceof List) {
				throw new IllegalArgumentException("List 形式的参数请以Map集合传递!");
			} else if (object.getClass().isArray()) {
				throw new IllegalArgumentException("Array 形式的参数请以Map集合传递!");
			}else {
				query.setParameter(i++, object);
			}
		}
	}
	
	@Autowired
	public void setSessionFactoryOverride(SessionFactory sessionFactory)    {  
      super.setSessionFactory(sessionFactory);  
    } 
}