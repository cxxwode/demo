/**
 * Copyright  2013, samsung All Rights Reserved.
 * Project: hotel.demo Maven Webapp
 * cn.sh.sbl.hotel.service.impl.MenuFilmService.java
 * Create By: samsung
 * Create Date: 2013-11-25 下午7:35:27
 */
package cn.sh.sbl.hotel.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.sh.sbl.hotel.beans.Film;
import cn.sh.sbl.hotel.beans.FilmExample;
import cn.sh.sbl.hotel.beans.Menu;
import cn.sh.sbl.hotel.beans.MenuExample;
import cn.sh.sbl.hotel.beans.MenuFilm;
import cn.sh.sbl.hotel.beans.MenuFilmExample;
import cn.sh.sbl.hotel.beans.MenuFilmKey;
import cn.sh.sbl.hotel.dao.FilmMapper;
import cn.sh.sbl.hotel.dao.MenuFilmMapper;
import cn.sh.sbl.hotel.dao.MenuMapper;
import cn.sh.sbl.hotel.service.ICategoryService;
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
	
	/**
	 * @see IMenuFilmService#getByPrimaryKey(MenuFilmKey)
	 */
	public MenuFilm getByPrimaryKey(MenuFilmKey menuFilmKey){
		return menuFilmMapper.selectByPrimaryKey(menuFilmKey);
	}
	
	/**
	 * @see IMenuFilmService#findAll()
	 */
	public List<MenuFilm> findAll() {
		return this.menuFilmMapper.selectByExample(null);
	}
	/**
	 * @see IMenuFilmService#getMenuFilmByMenuId(int)
	 */
	public List<MenuFilm> getMenuFilmByMenuId(int menuid) {
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

	/**
	 * @see IMenuFilmService#addMenuFilm(int, List)
	 */
	@Transactional(rollbackFor=RuntimeException.class)
	public void addMenuFilm(int menuId, List<String> filmIds) {
		Menu menu = this.menuMapper.selectByPrimaryKey(menuId);
		if(menu.getValid() && !menu.getHasChild()) {
			for(String f : filmIds) {
				MenuFilm menuFilm = new MenuFilm();
				menuFilm.setMenuId(menu.getId());
				menuFilm.setFilmId(f);
				menuFilm.setLastUpdate(new Date());
				if(!isMenuFilmExist(menu.getId(), f)) {
					menuFilmMapper.insert(menuFilm);
					logger.info("publish film {{}} into menu {{}} success！", f, menu.getName());
				} else {
					logger.debug("publish film{{}} into menu{{}} failed, this film is published！", f, menu.getName());
					continue;
				}
			}
		} else {
			logger.error("Please check menu {{}} is valid or not has child menu！",menu.getName());
		}
	}
	
	/**
	 * 检查某个节目是否与菜单已经存在关系
	 * Description: Check whether The MenuFilm with the menuId and filmId has been
	 * 				existed in Database.
	 * @param menuId
	 * @param filmId
	 * @return A Boolean Value True or False.
	 */
	public boolean isMenuFilmExist(int menuId, String filmId) {
		MenuFilmKey key = new MenuFilmKey();
		key.setMenuId(menuId);
		key.setFilmId(filmId);
		return menuFilmMapper.selectByPrimaryKey(key) == null ? false : true;
	}

	/**
	 * @see IMenuFilmService#deleteMenuFilm(MenuFilm)
	 */
	public void deleteMenuFilm(MenuFilm menuFilm) {
		menuFilmMapper.deleteByPrimaryKey(menuFilm);
		logger.info("删除栏目节目关系{menuId,filmId} = {{} , {}}", menuFilm.getMenuId(), menuFilm.getFilmId());
	}
	
	/*
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
	
	/**
	 * @see IMenuFilmService#findFilmByMenuId(int)
	 */
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

