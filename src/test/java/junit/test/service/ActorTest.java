/**
 * Copyright © 2013, bunco All Rights Reserved.
 * Project: hotel.demo
 * service.ActorTest.java
 * Create By: bunco
 * Create Date: 2013-11-21 下午3:35:31
 */
package junit.test.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Timed;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import cn.sh.sbl.hotel.beans.Actor;
import cn.sh.sbl.hotel.service.IActorService;

/**
 * @author bunco 
 * @E-mail: bunco.hb@gmail.com
 * @version 1.0 
 * @date 2013-11-21 下午3:35:31
 * @description TODO
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath*:applicationContext-*.xml"})
//		"file:src/main/webapp/WEB-INF/mvc/mvc.xml"})
public class ActorTest {
	@Autowired
	private Logger logger;
	@Autowired
	private IActorService actorService;

	@Test
	@Timed(millis=2000)
	public void testFindAll() {
		List<Actor> list = this.actorService.findAll();
		logger.debug("list size: {}", list.size());
		assertTrue(0 < list.size());
	}
	
	@Test
	public void testAddActor() {
		String firstName = "one";
		String lastName = "A";
		Actor actor = new Actor();
		actor.setFirstName(firstName);
		actor.setLastName(lastName);
		this.actorService.save(actor);
	}
}
