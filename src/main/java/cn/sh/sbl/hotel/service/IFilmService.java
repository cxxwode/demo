/**
 * Copyright  2013, samsung All Rights Reserved.
 * Project: demo Maven Webapp
 * cn.sh.sbl.hotel.service.IFilmService.java
 * Create By: samsung
 * Create Date: 2013-11-23 下午1:07:27
 */
/**
 * 
 */
package cn.sh.sbl.hotel.service;

import java.util.List;

import cn.sh.sbl.hotel.beans.File;
import cn.sh.sbl.hotel.beans.Film;

/**
 * @author samsung 
 * @E-mail: cxxwode@163.com
 * @version 1.0 
 * @date 2013-11-23 下午1:07:27
 * @description TODO
 */

public interface IFilmService {

	public abstract List<Film> findAll();
	
	public abstract Film get(String id);
	
	public void addFilm(Film film, List<File> files);
	
	public void deleteFilm(String id);
	
}

