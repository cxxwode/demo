/**
 * Copyright  2013, samsung All Rights Reserved.
 * Project: demo Maven Webapp
 * cn.sh.sbl.hotel.vo.FileVo.java
 * Create By: samsung
 * Create Date: 2013-11-23 下午1:35:35
 */
package cn.sh.sbl.hotel.vo;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import cn.sh.sbl.hotel.beans.Category;
import cn.sh.sbl.hotel.beans.FileId;
import cn.sh.sbl.hotel.beans.Film;

/**
 * @author samsung 
 * @E-mail: cxxwode@163.com
 * @version 1.0 
 * @date 2013-11-23 下午1:35:35
 * @description TODO
 */
@XmlRootElement
public class FileVo {
	
	/** 
	 * The id of the film.
	 */
	private FileId id;

	/** 
	 * The file type of the films.
	 */
	private CategoryVo categoryVo;

	/** 
	 * The name of the file.
	 */
	private String fileName;

	/** 
	 * The size of the file.
	 */
	private String fileSize;

	/** 
	 * The last update time of the file.
	 */
	private Date lastUpdate;

	/** 
	 * The remark of the file.
	 */
	private String remark;

	public FileId getId() {
		return id;
	}

	public void setId(FileId id) {
		this.id = id;
	}

	public CategoryVo getCategoryVo() {
		return categoryVo;
	}

	public void setCategoryVo(CategoryVo categoryVo) {
		this.categoryVo = categoryVo;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}

