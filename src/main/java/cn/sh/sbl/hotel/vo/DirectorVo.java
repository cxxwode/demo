/**
 * Copyright  2013, samsung All Rights Reserved.
 * Project: demo Maven Webapp
 * cn.sh.sbl.hotel.vo.DirectorVo.java
 * Create By: samsung
 * Create Date: 2013-11-23 下午2:19:49
 */
package cn.sh.sbl.hotel.vo;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author samsung 
 * @E-mail: cxxwode@163.com
 * @version 1.0 
 * @date 2013-11-23 下午2:19:49
 * @description TODO
 */
public class DirectorVo {
	/** 
	 * The id of the director.
	 */
	private Integer id;

	/** 
	 * The director first name.
	 */
	private String firstName;

	/** 
	 * The last name of the director.
	 */
	private String lastName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
}

