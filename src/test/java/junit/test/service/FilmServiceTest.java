/**
 * Copyright © 2013, bunco All Rights Reserved.
 * Project: demo
 * junit.test.service.FilmServiceTest.java
 * Create By: bunco
 * Create Date: 2013-11-23 下午6:32:18
 */
package junit.test.service;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import cn.sh.sbl.hotel.beans.Category;
import cn.sh.sbl.hotel.beans.File;
import cn.sh.sbl.hotel.beans.Film;
import cn.sh.sbl.hotel.service.ICategoryService;
import cn.sh.sbl.hotel.service.IFilmService;

/**
 * @author bunco 
 * @E-mail: bunco.hb@gmail.com
 * @version 1.0 
 * @date 2013-11-23 下午6:32:18
 * @description TODO
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath*:applicationContext-*.xml", 
		"file:src/main/webapp/WEB-INF/mvc/mvc.xml" })
public class FilmServiceTest {
	@Autowired
	private Logger logger;
	@Autowired
	private IFilmService filmService;
	@Autowired
	private ICategoryService categoryService;
	
	@Test
	@Transactional
	public void testAddFilmSuccess() {
		Film film = new Film();
		film.setId("test001");
		film.setTitle("007");
		film.setLastUpdate(new Date());
		
		List<Category> fileTypeCategories = this.categoryService.findByKey("file_type");
		List<Category> genreCategories = this.categoryService.findByKey("genre");
		List<Category> languageCategories = this.categoryService.findByKey("language");
		film.setCategories(new HashSet<Category>(genreCategories));
		film.setCategories_1(new HashSet<Category>(languageCategories));
		
		File postFile = new File();
		postFile.setFilm(film);
		postFile.setFileName("test001.png");
		postFile.setCategory(fileTypeCategories.get(0));
		
		this.filmService.addFilm(film);
		assertNotNull(this.filmService.get("test001"));
	}
}
