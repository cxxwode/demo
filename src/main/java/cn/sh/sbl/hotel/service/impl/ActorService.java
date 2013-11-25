/**
 * Copyright © 2013, bunco All Rights Reserved.
 * Project: hotel.demo
 * cn.sh.sbl.hotel.service.impl.ActorService.java
 * Create By: bunco
 * Create Date: 2013-11-21 下午3:32:53
 */
package cn.sh.sbl.hotel.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.sh.sbl.hotel.beans.Actor;
import cn.sh.sbl.hotel.dao.ActorMapper;
import cn.sh.sbl.hotel.service.IActorService;

/**
 * @author bunco 
 * @E-mail: bunco.hb@gmail.com
 * @version 1.0 
 * @date 2013-11-21 下午3:32:53
 * @description TODO
 */
@Service
public class ActorService implements IActorService {
	@Autowired
	private Logger logger;
	@Autowired
	private ActorMapper actorMapper;
	
	/* (non-Javadoc)
	 * @see cn.sh.sbl.hotel.service.impl.IActorService#findAll()
	 */
	public List<Actor> findAll() {
		return this.actorMapper.selectByExample(null);
	}

	public Actor get(int id) {
		return this.actorMapper.selectByPrimaryKey(id);
	}

	public void save(Actor actor) {
		this.logger.debug("to save actor: {}", actor);
		this.actorMapper.insert(actor);
	}
}
