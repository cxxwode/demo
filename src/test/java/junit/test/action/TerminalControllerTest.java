/**
 * Copyright © 2013, bunco All Rights Reserved.
 * Project: hotel.demo
 * junit.test.action.TerminalControllerTest.java
 * Create By: bunco
 * Create Date: 2013-11-22 下午8:20:43
 */
package junit.test.action;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import cn.sh.sbl.hotel.web.action.TerminalController;

/**
 * @author bunco
 * @E-mail: bunco.hb@gmail.com
 * @version 1.0
 * @date 2013-11-22 下午8:20:43
 * @description TODO
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath*:applicationContext-*.xml", 
		"file:src/main/webapp/WEB-INF/mvc/mvc.xml" })
public class TerminalControllerTest {
	@Autowired
	private Logger logger;
	@Autowired
	private TerminalController terminalController;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(terminalController).build();
	}
	
	@Test
	public void test() throws Exception {
		ResultActions ra = this.mockMvc.perform(MockMvcRequestBuilders
				.get("/t/test.json"));//.accept(MediaType.APPLICATION_XML));
		MvcResult mr = ra.andReturn();
		assertEquals(200, mr.getResponse().getStatus());
	}

	@Ignore
	@Test
	public void testMenu() throws Exception {
		ResultActions ra = this.mockMvc.perform(MockMvcRequestBuilders
				.post("/t/menu/1.json"));//.accept(MediaType.APPLICATION_XML));
		MvcResult mr = ra.andReturn();
		assertNotNull(mr.getModelAndView().getModelMap().get("menus"));
		assertEquals(200, mr.getResponse().getStatus());
	}
	
	@Ignore
	@Test
	public void testMenuFilm() throws Exception {
		ResultActions ra = this.mockMvc.perform(MockMvcRequestBuilders
				.post("/t/films/2.xml"));//.accept(MediaType.APPLICATION_XML));
		MvcResult mr = ra.andReturn();
		assertNotNull(mr.getModelAndView().getModelMap().get("MenuFilm"));
		assertEquals(200, mr.getResponse().getStatus());
	}
}
