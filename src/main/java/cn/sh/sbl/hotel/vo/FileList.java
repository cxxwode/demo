/**
 * Copyright © 2013, bunco All Rights Reserved.
 * Project: demo
 * cn.sh.sbl.hotel.vo.FileList.java
 * Create By: bunco
 * Create Date: 2013-11-23 下午6:06:04
 */
package cn.sh.sbl.hotel.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author bunco 
 * @E-mail: bunco.hb@gmail.com
 * @version 1.0 
 * @date 2013-11-23 下午6:06:04
 * @description TODO
 */
public class FileList {
	private List<FileVo> fileVos;
	
	public FileList() {}
	
	public FileList(List<FileVo> fileVos) {
		this.fileVos = fileVos;
	}
	/** 
	 * 获取 fileVos 
	 * @return fileVos fileVos 
	 */
	@XmlElement(name="file")
	public List<FileVo> getFileVos() {
		return fileVos;
	}
	/** 
	 * 设置 fileVos 
	 * @param fileVos fileVos 
	 */
	public void setFileVos(List<FileVo> fileVos) {
		this.fileVos = fileVos;
	}
}
