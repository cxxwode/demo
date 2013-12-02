/**
 * Copyright © 2013, bunco All Rights Reserved.
 * Project: hotel.demo
 * cn.sh.sbl.hotel.service.impl.IActorService.java
 * Create By: bunco
 * Create Date: 2013-11-21 下午3:50:00
 */
package cn.sh.sbl.hotel.service;

import java.util.List;

import cn.sh.sbl.hotel.beans.Menu;

/**
 * @author bunco 
 * @E-mail: bunco.hb@gmail.com
 * @version 1.0 
 * @date 2013-11-21 下午3:50:00
 * @description TODO
 */
public interface IMenuService {

	/**
	 * Description: Get all Menu from Database.
	 * @return A List of Menu.
	 */
	public abstract List<Menu> findAll();
	
	/**
	 * Description: Get A Menu by the id of it's id.
	 * @param id
	 * @return An Object of Menu.
	 */
	public abstract Menu get(int id);
	
	/**
	 * Description: Get it's children Menus by the menu's id from the Database.
	 * @param id
	 * @return A List of Menu.
	 */
	public List<Menu> getChildrenById(int id);
	
	/**
	 * Description: Insert a Menu Record into Datebase.
	 * @param menu
	 */
	public void save(Menu menu);
	
	/**
	 * Description: Delete a Menu Record of the Database.
	 * @param menu The Record will be deleted.
	 */
	public void deleteMenu(Menu menu);

	/**
	 * Description: Change the name of a Menu then Update the Database record accordingly.
	 * @param menu
	 */
	public void rename(Menu menu);
}