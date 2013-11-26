/**
 * Copyright  2013, samsung All Rights Reserved.
 * Project: hotel.demo Maven Webapp
 * cn.sh.sbl.hotel.service.IFileService.java
 * Create By: samsung
 * Create Date: 2013-11-26 上午10:59:46
 */
package cn.sh.sbl.hotel.service;

import java.util.List;

import cn.sh.sbl.hotel.beans.File;

/**
 * @author samsung 
 * @E-mail: cxxwode@163.com
 * @version 1.0 
 * @date 2013-11-26 上午10:59:46
 * @description TODO
 */
public interface IFileService {
	
	public List<File> findAll() ;
	
	public List<File> findFileByFilmId(String filmId) ;
}

