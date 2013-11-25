/**
 * Copyright  2013, samsung All Rights Reserved.
 * Project: hotel.demo Maven Webapp
 * junit.test.service.MenuTest.java
 * Create By: samsung
 * Create Date: 2013-11-25 下午7:05:38
 */
package junit.test.service;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import cn.sh.sbl.hotel.service.IMenuFilmService;
import cn.sh.sbl.hotel.service.IMenuService;

/**
 * @author samsung 
 * @E-mail: cxxwode@163.com
 * @version 1.0 
 * @date 2013-11-25 下午7:05:38
 * @description TODO
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath*:applicationContext-*.xml", 
		"file:src/main/webapp/WEB-INF/mvc/mvc.xml" })
public class MenuTest {
	@Autowired
	private Logger logger;
	@Autowired
	private IMenuService menuService;
	@Autowired
	private IMenuFilmService menuFilmService;
	
	@Test
	public void testFindMenuByParentId() {
		// menu service 
		assertTrue(0 < this.menuService.findAll().size());
		//assertTrue(0 < this.menuService.getChildrenById(1).size());
	}
	
	@Ignore
	@Test
	public void testFindMenuFilmByMenuId() {
		assertTrue(0 < this.menuFilmService.getMenuFilmByMenuId(2).size());
	}
	
	@Test
	public void testFindFilmByMenuId() {
		assertTrue(0 < this.menuFilmService.findFilmByMenuId(2).size());
	}
}

