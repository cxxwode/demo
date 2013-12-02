/**
 * Copyright  2013, samsung All Rights Reserved.
 * Project: hotel.demo Maven Webapp
 * cn.sh.sbl.hotel.service.IFileService.java
 * Create By: samsung
 * Create Date: 2013-11-26 上午10:59:46
 */
package cn.sh.sbl.hotel.service;

import java.util.List;

import cn.sh.sbl.hotel.beans.Category;
import cn.sh.sbl.hotel.beans.File;
import cn.sh.sbl.hotel.beans.FileType;

/**
 * @author samsung 
 * @E-mail: cxxwode@163.com
 * @version 1.0 
 * @date 2013-11-26 上午10:59:46
 * @description the interface of FileService
 */
public interface IFileService {
	
	/**
	 * @return List<File> A list of File object.
	 * Description: Get all the File objects from the database.
	 */
	public List<File> findAll() ;
	
	/**
	 * Description: Delete the associated files of the Film by the film id.
	 * @param filmId The id of a film.
	 */
	public void deleteFileByFilmId(String filmId);

	/**
	 * Description: Get all the associated files of a film by the film id.
	 * @param filmId
	 * @return List<File> A list of File object.
	 */
	public List<File> findFileByFilmId(String filmId);
	
	/**
	 * Description: Get the poster file of a film by the film id.
	 * @param filmId
	 * @return File An object of poster file.
	 */
	public File findPostFileByFilmId(String filmId);
	
	/**
	 * Description: Get the CategoryId by of a FileType.
	 * @param fileType 
	 * @return Category An Object of Category bean.
	 */
	public Category getFileTypeCategoryId(FileType fileType);
}
