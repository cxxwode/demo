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
import cn.sh.sbl.hotel.beans.MenuFilmKey;

/**
 * @author samsung 
 * @E-mail: cxxwode@163.com
 * @version 1.0 
 * @date 2013-11-25 下午7:29:05
 * @description The interface of MenuFilmService.
 */
public interface IMenuFilmService {
	
	/**
	 * Description: Get MenuFilm Object By MenuFilmKey.
	 * @param menuFilmKey
	 * @return An Object Of MenuFilm.
	 */
	public MenuFilm getByPrimaryKey(MenuFilmKey menuFilmKey);
	
	/**
	 * Description: Get all MenuFilm .
	 * @return A List of MenuFilm.
	 */
	public List<MenuFilm> findAll();
	
	/**
	 * Description: Get MenuFilms by menuid from Database.
	 * @param menuid
	 * @return A List Of MenuFilm.
	 */
	public List<MenuFilm> getMenuFilmByMenuId(int menuid);
	
	/**
	 * Description: Get the Films that has been Published in a Menu 
	 *                 according to the menuid.
	 * @param menuid
	 * @return A List of Film that has been Published in a Menu.
	 */
	public List<Film> findFilmByMenuId(int menuid);

	/**
	 * Description: Add a List of MenuFilm record into Database.
	 * @param menuId The id of Menu.
	 * @param filmIds A List of Film id.
	 */
	public void addMenuFilm(int menuId, List<String> filmIds);
	
	
	/**
	 * Description: Delete a record of MenuFilm.
	 * @param menuFilm The Object which will be deleted.
	 */
	public void deleteMenuFilm(MenuFilm menuFilm);
}

