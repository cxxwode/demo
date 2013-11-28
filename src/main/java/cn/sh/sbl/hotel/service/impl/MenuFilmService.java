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
	 * 按联合主键查找
	 * @param menuFilmKey
	 * @return
	 */
	public MenuFilm getByPrimarryKey(MenuFilmKey menuFilmKey){
		return menuFilmMapper.selectByPrimaryKey(menuFilmKey);
	}
	
	/**
	 * 查找全部MenuFilm
	 */
	public List<MenuFilm> findAll() {
		return this.menuFilmMapper.selectByExample(null);
	}

	/**
	 * 查找菜单下全部MenuFilm
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
	 * 添加菜单节目关系
	 * @param menu
	 * @param films 可以批量添加节目到菜单
	 */
	@Transactional(rollbackFor=RuntimeException.class)
	public void addMenuFilm(Menu menu, List<Film> films) {
		if(menu.getValid() && !menu.getHasChild()) {
			for(Film f : films) {
				MenuFilm menuFilm = new MenuFilm();
				menuFilm.setMenuId(menu.getId());
				menuFilm.setFilmId(f.getId());
				menuFilm.setLastUpdate(new Date());
				if(!isMenuFilmExist(menu.getId(), f.getId())) {
					menuFilmMapper.insert(menuFilm);
					logger.info("添加节目{{}}到{{}}菜单下成功！",f.getTitle(),menu.getName());
				} else {
					logger.debug("添加节目{{}}到{{}}菜单下失败,该节目已经在该菜单下！",f.getTitle(),menu.getName());
					continue;
				}
			}
		} else {
			logger.error("请检查菜单{{}}是否合法或是否为叶子菜单！",menu.getName());
		}
	}
	
	/**
	 * 检查某个节目是否与菜单已经存在关系
	 * @param menuId
	 * @param filmId
	 * @return
	 */
	public boolean isMenuFilmExist(int menuId, String filmId) {
		MenuFilmKey key = new MenuFilmKey();
		key.setMenuId(menuId);
		key.setFilmId(filmId);
		return menuFilmMapper.selectByPrimaryKey(key) == null ? false : true;
	}

	/**
	 * 删除节目栏目关系
	 */
	public void deleteMenuFilm(MenuFilm menuFilm) {
		menuFilmMapper.deleteByPrimaryKey(menuFilm);
		logger.info("删除栏目节目关系{menuId,filmId} = {{} , {}}", menuFilm.getMenuId(), menuFilm.getFilmId());
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

