/**
 * Copyright  2013, samsung All Rights Reserved.
 * Project: demo Maven Webapp
 * cn.sh.sbl.hotel.vo.FileVo.java
 * Create By: samsung
 * Create Date: 2013-11-23 下午1:35:35
 */
package cn.sh.sbl.hotel.vo;

import java.util.Date;

/**
 * @author samsung 
 * @E-mail: cxxwode@163.com
 * @version 1.0 
 * @date 2013-11-23 下午1:35:35
 * @description TODO
 */
public class FileVo {
	
	/** 
	 * The id of the file.
	 */
	private int fileId;
	
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

	/** 
	 * 获取 Theidofthefile. 
	 * @return fileId Theidofthefile. 
	 */
	public int getFileId() {
		return fileId;
	}

	/** 
	 * 设置 Theidofthefile. 
	 * @param fileId Theidofthefile. 
	 */
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

}

