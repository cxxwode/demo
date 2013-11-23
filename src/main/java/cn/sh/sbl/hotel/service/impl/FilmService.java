/**
 * Copyright  2013, samsung All Rights Reserved.
 * Project: demo Maven Webapp
 * cn.sh.sbl.hotel.service.impl.FilmService.java
 * Create By: samsung
 * Create Date: 2013-11-23 下午1:08:56
 */
/**
 * 
 */
package cn.sh.sbl.hotel.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sh.sbl.hotel.beans.Film;
import cn.sh.sbl.hotel.dao.IFilmHome;
import cn.sh.sbl.hotel.service.IFilmService;

/**
 * @author samsung 
 * @E-mail: cxxwode@163.com
 * @version 1.0 
 * @date 2013-11-23 下午1:08:56
 * @description TODO
 */

@Service
public class FilmService implements IFilmService {

	@Autowired
	private Logger logger;
	@Autowired
	private IFilmHome filmHome;
	
	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.service.IFilmService#findAll()
	 */
	public List<Film> findAll() {
		// TODO Auto-generated method stub
		return this.filmHome.findAll();
	}

	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.service.IFilmService#get(int)
	 */
	public Film get(String id) {
		// TODO Auto-generated method stub
		return this.filmHome.findById(id);
	}

	public void addFilm(Film film) {
		// TODO Auto-generated method stub
		this.filmHome.save(film);
	}
}

