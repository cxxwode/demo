/**
 * Copyright  2013, samsung All Rights Reserved.
 * Project: hotel.demo Maven Webapp
 * cn.sh.sbl.hotel.service.impl.MenuFilmService.java
 * Create By: samsung
 * Create Date: 2013-11-25 下午7:35:27
 */
package cn.sh.sbl.hotel.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sh.sbl.hotel.beans.Film;
import cn.sh.sbl.hotel.beans.FilmExample;
import cn.sh.sbl.hotel.beans.MenuExample;
import cn.sh.sbl.hotel.beans.MenuFilm;
import cn.sh.sbl.hotel.beans.MenuFilmExample;
import cn.sh.sbl.hotel.dao.FilmMapper;
import cn.sh.sbl.hotel.dao.MenuFilmMapper;
import cn.sh.sbl.hotel.dao.MenuMapper;
import cn.sh.sbl.hotel.service.IMenuFilmService;
import cn.sh.sbl.hotel.vo.FilmVo;

/**
 * @author samsung 
 * @E-mail: cxxwode@163.com
 * @version 1.0 
 * @date 2013-11-25 下午7:35:27
 * @description TODO
 */
@Service
public class MenuFilmService implements IMenuFilmService {

	@Autowired
	private Logger logger;
	@Autowired
	private MenuFilmMapper menuFilmMapper;
	@Autowired
	private MenuMapper menuMapper;
	@Autowired
	private FilmMapper filmMapper;
	
	public List<MenuFilm> findAll() {
		// TODO Auto-generated method stub
		return this.menuFilmMapper.selectByExample(null);
	}

	public List<MenuFilm> getMenuFilmByMenuId(int menuid) {
		// TODO Auto-generated method stub
		MenuExample menuExample = new MenuExample();
		menuExample.createCriteria().andIdEqualTo(menuid)
			.andValidEqualTo(true)
			.andHasChildEqualTo(false);
		if(menuMapper.selectByExample(menuExample).size() > 0){
			MenuFilmExample menuFilmExample = new MenuFilmExample();
			menuFilmExample.createCriteria().andMenuIdEqualTo(menuid);
			return this.menuFilmMapper.selectByExample(menuFilmExample);
		}else {
			return null;
		}
		
	}

	/*
	 * (non-Javadoc)
	 * @see cn.sh.sbl.hotel.service.IMenuFilmService#findFilmByMenuId(int)
	 * 由菜单id返回电影列表
	 */
	public List<Film> findFilmByMenuId(int menuid) {
		List<MenuFilm> menuFilms = this.getMenuFilmByMenuId(menuid);
		List<Film> films = new ArrayList<Film>();
		for(MenuFilm mf : menuFilms) {
			FilmExample filmExample = new FilmExample();
			filmExample.createCriteria().andIdEqualTo(mf.getFilmId()).isValid();
			films.add(this.filmMapper.selectByExample(filmExample).get(0));
		}
		logger.debug("================{}",films.size());
		return films;
	}
	
	public List<FilmVo> findFilmVoByMenuId(int menuid) {
		List<MenuFilm> menuFilms = this.getMenuFilmByMenuId(menuid);
		
		List<FilmVo> filmVos = new ArrayList<FilmVo>();
		for(MenuFilm mf : menuFilms) {
			FilmExample filmExample = new FilmExample();
			filmExample.createCriteria().andIdEqualTo(mf.getFilmId()).isValid();
			Film film = this.filmMapper.selectByExample(filmExample).get(0);
			FilmVo filmVo = new FilmVo(film.getId(), film.getCountry(), film.getDescription(), film.getLastUpdate(), film.getLength(), film.getRatings(), film.getTitle(), film.getReleaseYear());
			
			filmVos.add(filmVo);
			
		}
		return filmVos;
	}
}

