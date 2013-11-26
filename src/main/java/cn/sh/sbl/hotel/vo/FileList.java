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

import cn.sh.sbl.hotel.beans.File;

/**
 * @author bunco 
 * @E-mail: bunco.hb@gmail.com
 * @version 1.0 
 * @date 2013-11-23 下午6:06:04
 * @description TODO
 */
public class FileList {
	private List<File> files;

	public FileList() {
		
	}
	
	public FileList(List<File> files) {
		this.files = files;
	}
	
	@XmlElement(name="file")
	public List<File> getFiles() {
		return files;
	}

	public void setFiles(List<File> files) {
		this.files = files;
	}
	
	

}
