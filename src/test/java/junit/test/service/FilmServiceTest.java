/**
 * Copyright © 2013, bunco All Rights Reserved.
 * Project: demo
 * junit.test.service.FilmServiceTest.java
 * Create By: bunco
 * Create Date: 2013-11-23 下午6:32:18
 */
package junit.test.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

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
	public void testAddFilmSuccessThenDelete() {
		Film film = new Film();
		film.setId("asdfoasdf");
		film.setTitle("july 3");
		
		film.setLanguage("中文");
		
		List<File> list = new ArrayList<File>();
		File posterFile = new File();
		posterFile.setFilmId(film.getId());
		posterFile.setFileName("asdfk.png");
		posterFile.setCategoryFilm(14);
		posterFile.setFileSize(239423L);
		list.add(posterFile);
		
		File contentFile = new File();
		contentFile.setFilmId(film.getId());
		contentFile.setFileName("asdfk.ts");
		contentFile.setCategoryFilm(13);
		contentFile.setFileSize(234555L);
		list.add(contentFile);
		this.filmService.addFilm(film, list);
		assertEquals(film.getTitle(), this.filmService.get(film.getId()).getTitle());
		this.filmService.deleteFilm(film.getId());
	}
	
	@Test(expected=RuntimeException.class)
	public void testAddFilmFailedAndRollback() {
		Film film = new Film();
		film.setId("asdfoasdf2");
		film.setTitle("july 4");
		
		List<File> list = new ArrayList<File>();
		File posterFile = new File();
		posterFile.setFilmId(film.getId());
		posterFile.setFileName("4sdfk.png");
		posterFile.setCategoryFilm(14);
		posterFile.setFileSize(4334534L);
		list.add(posterFile);
		
		File contentFile = new File();
		contentFile.setFileName("asdfk.ts");
		contentFile.setCategoryFilm(13);
		contentFile.setFileSize(34543534L); 
		list.add(contentFile);
		this.filmService.addFilm(film, list);
	}
	
	@Test
	public void testDeleteInexistenceFilm() {
		this.filmService.deleteFilm("I think this ID should not exist");
	}
}
