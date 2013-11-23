/**
 * Copyright © 2013, bunco All Rights Reserved.
 * Project: hotel.demo
 * cn.sh.sbl.hotel.vo.ActorVo.java
 * Create By: bunco
 * Create Date: 2013-11-22 下午1:52:08
 */
package cn.sh.sbl.hotel.vo;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author lufeng 
 * @E-mail: 
 * @version 1.0 
 * @date 2013年11月22日23:07:48
 * @description TODO
 */
@XmlRootElement(name="ActorVo")
public class ActorVo {
	private int id;
	private String firstName;
	private String lastName;
	
	public ActorVo() {}
	
	public ActorVo(int id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/** 
	 * 获取 id 
	 * @return id id 
	 */
	public int getId() {
		return id;
	}

	/** 
	 * 设置 id 
	 * @param id id 
	 */
	public void setId(int id) {
		this.id = id;
	}

	/** 
	 * 获取 firstName 
	 * @return firstName firstName 
	 */
	public String getFirstName() {
		return firstName;
	}

	/** 
	 * 设置 firstName 
	 * @param firstName firstName 
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/** 
	 * 获取 lastName 
	 * @return lastName lastName 
	 */
	public String getLastName() {
		return lastName;
	}

	/** 
	 * 设置 lastName 
	 * @param lastName lastName 
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
