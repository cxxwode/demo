/**
 * Copyright © 2013, bunco All Rights Reserved.
 * Project: hotel.demo
 * cn.sh.sbl.hotel.vo.ActorVo.java
 * Create By: bunco
 * Create Date: 2013-11-22 下午1:52:08
 */
package cn.sh.sbl.hotel.vo;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author bunco 
 * @E-mail: bunco.hb@gmail.com
 * @version 1.0 
 * @date 2013-11-22 下午1:52:08
 * @description TODO
 */
@XmlRootElement
public class MenuVo {
	
	/**
	 * The id of the menu.
	 */
	private Integer id;
	/** 
	 * The name of the menu.
	 */
	private String name;

	/** 
	 * The display sub menu order of the parent menu.
	 */
	private Integer displayOrder;

	/** 
	 * The path of the menu.
	 */
	private String path;

	/** 
	 * Has child of the menu.
	 */
	private Boolean hasChild;

	/** 
	 * Is valid of menu.
	 */
	private Boolean valid;

	/** 
	 * The level of the menu.
	 */
	private Integer level;

	/** 
	 * The icon of the menu.
	 */
	private String icon;

	/** 
	 * The  focus icon of the menu.
	 */
	private String focusIcon;

	/** 
	 * The last update time of the menu.
	 */
	private Date lastUpdate;

	/** 
	 * The remark of the menu.
	 */
	private String remark;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(Integer displayOrder) {
		this.displayOrder = displayOrder;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Boolean getHasChild() {
		return hasChild;
	}

	public void setHasChild(Boolean hasChild) {
		this.hasChild = hasChild;
	}

	public Boolean getValid() {
		return valid;
	}

	public void setValid(Boolean valid) {
		this.valid = valid;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getFocusIcon() {
		return focusIcon;
	}

	public void setFocusIcon(String focusIcon) {
		this.focusIcon = focusIcon;
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
