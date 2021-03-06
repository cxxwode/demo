/**
 * Copyright  2013, samsung All Rights Reserved.
 * Project: demo
 * cn.sh.sbl.hotel.vo.CategoryVo.java
 * Create By: samsung
 * Create Date: 2013-11-23 下午4:20:01
 */
package cn.sh.sbl.hotel.vo;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author samsung 
 * @E-mail: cxxwode@163.com
 * @version 1.0 
 * @date 2013-11-23 下午4:20:01
 * @description TODO
 */

@XmlRootElement(name="Category")
public class CategoryVo {
	/** 
	 * The id of the category.
	 */
	private Integer id;

	/** 
	 * The key of the category.
	 */
	private String ckey;

	/** 
	 * The value of the category.
	 */
	private String cval;

	/**
	 * Get id
	 * @return id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Set id
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * Get ckey
	 * @return ckey
	 */
	public String getCkey() {
		return ckey;
	}

	/**
	 * Set ckey
	 * @param ckey
	 */
	public void setCkey(String ckey) {
		this.ckey = ckey;
	}

	/**
	 * Get cval
	 * @return cval
	 */
	public String getCval() {
		return cval;
	}
	
	/**
	 * Set cval
	 * @param cval
	 */
	public void setCval(String cval) {
		this.cval = cval;
	}
}

