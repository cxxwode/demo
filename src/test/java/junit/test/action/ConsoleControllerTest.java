/**
 * Copyright © 2013, bunco All Rights Reserved.
 * Project: demo
 * junit.test.action.ConsoleControllerTest.java
 * Create By: bunco
 * Create Date: 2013-11-24 上午11:23:33
 */
package junit.test.action;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMultipartHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import cn.sh.sbl.hotel.web.action.ConsoleController;

/**
 * @author bunco 
 * @E-mail: bunco.hb@gmail.com
 * @version 1.0 
 * @date 2013-11-24 上午11:23:33
 * @description TODO
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath*:applicationContext-*.xml", 
		"file:src/main/webapp/WEB-INF/mvc/mvc.xml" })
public class ConsoleControllerTest {
	@Autowired
	private Logger logger;
	@Autowired
	private ConsoleController consoleController;
	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(consoleController).build();
		
	}

	@Test
	@Transactional
	public void testUpload() throws Exception {
		String originalFilename = "jetty-distribution-9.1.0.v20131115.tar.gz";
		MockMultipartFile mockMultipartFile = new MockMultipartFile(
				"file", originalFilename, "application/octet-stream", 
				new FileInputStream("/opt/local/" + originalFilename));
		MockMultipartHttpServletRequestBuilder builder =
				MockMvcRequestBuilders.fileUpload("/upload/jsl.json").file(mockMultipartFile);
		ResultActions ra = this.mockMvc.perform(builder);//.sessionAttr("servletContext", mockServletContext));
		MvcResult mr = ra.andReturn();
		String realPath = mr.getRequest().getSession().getServletContext().getRealPath("/");
		assertEquals(200, mr.getResponse().getStatus());
		File file = new File(realPath + "/upload/" + originalFilename);
		boolean exists = file.exists();
		boolean delete = file.delete();
		logger.info("{} exists: {}, then delete: {}", file.getAbsolutePath(), exists, delete);
		assertTrue(exists && delete);
	}

	@Ignore
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
