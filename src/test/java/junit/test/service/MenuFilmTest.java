/**
 * Copyright  2013, samsung All Rights Reserved.
 * Project: hotel.demo Maven Webapp
 * junit.test.service.MenuFilmTest.java
 * Create By: samsung
 * Create Date: 2013-11-27 下午1:08:34
 */
package junit.test.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import cn.sh.sbl.hotel.beans.Film;
import cn.sh.sbl.hotel.beans.Menu;
import cn.sh.sbl.hotel.beans.MenuFilmKey;
import cn.sh.sbl.hotel.service.IFilmService;
import cn.sh.sbl.hotel.service.IMenuFilmService;
import cn.sh.sbl.hotel.service.IMenuService;

/**
 * @author samsung 
 * @E-mail: cxxwode@163.com
 * @version 1.0 
 * @date 2013-11-27 下午1:08:34
 * @description TODO
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath*:applicationContext-*.xml", 
		"file:src/main/webapp/WEB-INF/mvc/mvc.xml" })
public class MenuFilmTest {
	@Autowired
	private Logger logger;
	@Autowired
	private IMenuService menuService;
	@Autowired
	private IMenuFilmService menuFilmService;
	@Autowired
	private IFilmService filmService;
	
	@Test
	public void testAddMenuFilmSuccessThenDelete() {
		Menu menu = menuService.get(2);
		Film film = filmService.get("embed05");
		List<Film> f = new ArrayList<Film>();
		f.add(film);
		menuFilmService.addMenuFilm(menu, f);
		MenuFilmKey key = new MenuFilmKey();
		key.setMenuId(menu.getId());
		key.setFilmId(film.getId());
		menuFilmService.deleteMenuFilm(menuFilmService.getByPrimarryKey(key));
	}
	
	@Test
	public void testAddMenuFilmFail() {
		Menu menu = menuService.get(2);
		Film film = filmService.get("embed01");
		List<Film> f = new ArrayList<Film>();
		f.add(film);
		menuFilmService.addMenuFilm(menu, f);
	}
	
}

