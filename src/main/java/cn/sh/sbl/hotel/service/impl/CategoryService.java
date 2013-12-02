/**
 * Copyright © 2013, bunco All Rights Reserved.
 * Project: demo
 * cn.sh.sbl.hotel.service.impl.CategoryService.java
 * Create By: bunco
 * Create Date: 2013-11-23 下午6:41:27
 */
package cn.sh.sbl.hotel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sh.sbl.hotel.beans.Category;
import cn.sh.sbl.hotel.beans.CategoryExample;
import cn.sh.sbl.hotel.dao.CategoryMapper;
import cn.sh.sbl.hotel.service.ICategoryService;

/**
 * @author bunco 
 * @E-mail: bunco.hb@gmail.com
 * @version 1.0 
 * @date 2013-11-23 下午6:41:27
 * @description TODO
 */
@Service
public class CategoryService implements ICategoryService {
	@Autowired
	private CategoryMapper categoryMapper;

	/**
	 * @see ICategoryService#findAll()
	 */
	public List<Category> findAll() {
		return this.categoryMapper.selectByExample(null);
	}
	
	/**
	 * @see ICategoryService#findByKey(String)
	 */
	public List<Category> findByKey(String key) {
		CategoryExample example = new CategoryExample();
		example.createCriteria().andCkeyEqualTo(key);
		return this.categoryMapper.selectByExample(example);
	}
}
