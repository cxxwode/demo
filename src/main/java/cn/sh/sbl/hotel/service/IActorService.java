/**
 * Copyright © 2013, bunco All Rights Reserved.
 * Project: hotel.demo
 * cn.sh.sbl.hotel.service.impl.IActorService.java
 * Create By: bunco
 * Create Date: 2013-11-21 下午3:50:00
 */
package cn.sh.sbl.hotel.service;

import java.util.List;

import cn.sh.sbl.hotel.beans.Actor;

/**
 * @author bunco 
 * @E-mail: bunco.hb@gmail.com
 * @version 1.0 
 * @date 2013-11-21 下午3:50:00
 * @description TODO
 */
public interface IActorService {

	public abstract List<Actor> findAll();
	
	public abstract Actor get(int id);
	
	public void save(Actor actor);
}