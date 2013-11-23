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
import org.springframework.test.annotation.Repeat;
import org.springframework.test.annotation.Timed;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import cn.sh.sbl.hotel.beans.Actor;
import cn.sh.sbl.hotel.beans.Film;
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
public class ActorTest {
	@Autowired
	private Logger logger;
	@Autowired
	private IActorService actorService;

	@Test
	@Transactional
	@Timed(millis=2000)
	@Repeat(10)
	public void test() {
		List<Actor> list = this.actorService.findAll();
		logger.debug("list size: {}", list.size());
		for (Actor actor : list) {
			StringBuilder filmNames = new StringBuilder();
			for (Film film : actor.getFilms()) {
				filmNames.append(film.getTitle() + " director size: " + film.getDirectors().size());
			}
			logger.debug("{} {} {} - [{}]", actor.getId(), actor.getFirstName(), actor.getLastName(), filmNames.toString());
		}
		assertTrue(0 < list.size());
	}
}
