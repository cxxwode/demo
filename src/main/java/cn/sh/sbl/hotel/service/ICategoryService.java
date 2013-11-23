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
 * @description TODO
 */
public interface ICategoryService {

	public List<Category> findAll();
	
	public List<Category> findByKey(String key);
}
