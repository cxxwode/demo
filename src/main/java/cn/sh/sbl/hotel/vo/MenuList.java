/**
 * Copyright © 2013, bunco All Rights Reserved.
 * Project: demo
 * cn.sh.sbl.hotel.vo.MenusVo.java
 * Create By: bunco
 * Create Date: 2013-11-23 下午5:42:02
 */
package cn.sh.sbl.hotel.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author bunco 
 * @E-mail: bunco.hb@gmail.com
 * @version 1.0 
 * @date 2013-11-23 下午5:42:02
 * @description TODO
 */
@XmlRootElement(name="menus")
public class MenuList {
	private List<MenuVo> menus;
	
	public MenuList() {}
	
	public MenuList(List<MenuVo> menus) {
		this.menus = menus;
	}

	/** 
	 * 获取 menus 
	 * @return menus menus 
	 */
	@XmlElement(name="menu")
	public List<MenuVo> getMenus() {
		return menus;
	}

	/** 
	 * 设置 menus 
	 * @param menus menus 
	 */
	public void setMenus(List<MenuVo> menus) {
		this.menus = menus;
	}
}
