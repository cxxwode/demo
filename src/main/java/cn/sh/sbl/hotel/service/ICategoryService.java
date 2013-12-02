/**
 * Copyright © 2013, bunco All Rights Reserved.
 * Project: demo
 * cn.sh.sbl.hotel.service.ICategoryService.java
 * Create By: bunco
 * Create Date: 2013-11-23 下午6:40:09
 */
package cn.sh.sbl.hotel.service;

import java.util.List;

import cn.sh.sbl.hotel.beans.Category;

/**
 * @author bunco 
 * @E-mail: bunco.hb@gmail.com
 * @version 1.0 
 * @date 2013-11-23 下午6:40:09
 * @description the interface of CategoryService
 */
public interface ICategoryService {

	/**
	 * Description: Get all the Categories from the Database.
	 * @return An list of Category.
	 */
	public List<Category> findAll();
	
	/**
	 * Description: Get Categories by the properties of key.
	 * @param key The key of  Category.
	 * @return  An list of Category.
	 */
	public List<Category> findByKey(String key);
}
