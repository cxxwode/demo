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
import org.springframework.transaction.annotation.Transactional;

import cn.sh.sbl.hotel.beans.File;
import cn.sh.sbl.hotel.beans.FileExample;
import cn.sh.sbl.hotel.beans.Film;
import cn.sh.sbl.hotel.dao.FileMapper;
import cn.sh.sbl.hotel.dao.FilmMapper;
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
	private FilmMapper filmMapper;
	@Autowired
	private FileMapper fileMapper;
	
	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.service.IFilmService#findAll()
	 */
	public List<Film> findAll() {
		return this.filmMapper.selectByExample(null);
	}

	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.service.IFilmService#get(int)
	 */
	public Film get(String id) {
		return this.filmMapper.selectByPrimaryKey(id);
	}

	@Transactional(rollbackFor=RuntimeException.class)
	public void addFilm(Film film, List<File> files) {
		if (null == film.getId()) {
			String maxId = this.filmMapper.maxIdByExample(null);
			film.setId("FM" + String.format("%08d", Integer.valueOf(maxId.substring(2)) + 1));
		}
		this.filmMapper.insert(film);
		for (File file : files) {
			this.fileMapper.insert(file);
		}
	}

	@Transactional(rollbackFor=RuntimeException.class)
	public void deleteFilm(String id) {
		FileExample example = new FileExample();
		example.createCriteria().andFilmIdEqualTo(id);
		this.fileMapper.deleteByExample(example);
		this.filmMapper.deleteByPrimaryKey(id);
	}
	
	public String getMaxId() {
		return this.filmMapper.maxIdByExample(null);
	}
}

