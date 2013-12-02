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
 * @description The interface of FileService.
 */

public interface IFilmService {

	/**
	 * Description: Get all of the Film object from the Database.
	 * @return A list of Film.
	 */
	public abstract List<Film> findAll();
	
	/**
	 * Description: Get a film object from database by the film id.
	 * @param id 
	 * @return A film Object.
	 */
	
	public abstract Film get(String id);
	
	/**
	 * Description: Add a film object and it's associated files into Database.
	 * @param film The Object will be insert into Database.
	 * @param files The Object list of File will be insert into Database.
	 * 
	 */
	public void addFilm(Film film, List<File> files);
	
	/**
	 * Description: Delete a Film Object of Database by the film id.
	 * @param id
	 */
	public void deleteFilm(String id);
	
	public String getMaxId();
}

