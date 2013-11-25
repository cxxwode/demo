/**
 * Copyright  2013, samsung All Rights Reserved.
 * Project: hotel.demo Maven Webapp
 * cn.sh.sbl.hotel.service.IMenuFilmService.java
 * Create By: samsung
 * Create Date: 2013-11-25 下午7:29:05
 */
package cn.sh.sbl.hotel.service;

import java.util.List;

import cn.sh.sbl.hotel.beans.Film;
import cn.sh.sbl.hotel.beans.MenuFilm;

/**
 * @author samsung 
 * @E-mail: cxxwode@163.com
 * @version 1.0 
 * @date 2013-11-25 下午7:29:05
 * @description TODO
 */
public interface IMenuFilmService {
	
	public List<MenuFilm> findAll();
	
	public List<MenuFilm> getMenuFilmByMenuId(int menuid);
	
	public List<Film> findFilmByMenuId(int menuid);
}

