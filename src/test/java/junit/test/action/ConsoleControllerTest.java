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
import java.io.IOException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
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

import cn.sh.sbl.hotel.beans.FileType;
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
	public void testGetAllMenu()throws Exception {
		ResultActions ra = this.mockMvc.perform(MockMvcRequestBuilders
				.post("/c/menu/all.json"));//.accept(MediaType.APPLICATION_XML));
		MvcResult mr = ra.andReturn();
		assertNotNull(mr.getModelAndView().getModelMap().get("menuList"));
		assertEquals(200, mr.getResponse().getStatus());
	}
	
	@Test
	public void testAddMenuFailed() throws Exception {
		String iconFileName = "icon.png";
		String focusIconFileName = "icon_focus.png";
		MockMultipartFile iconFile = new MockMultipartFile(
				"icon", iconFileName, "application/octet-stream", 
				new ClassPathResource(iconFileName).getInputStream());
		MockMultipartFile focusIconFile = new MockMultipartFile(
				"focusIcon", focusIconFileName, "application/octet-stream", 
				new ClassPathResource(focusIconFileName).getInputStream());
		MockMultipartHttpServletRequestBuilder builder =
				MockMvcRequestBuilders.fileUpload("/c/menu/add.json").file(iconFile).file(focusIconFile);
		ResultActions ra = this.mockMvc.perform(builder.param("name", "BlueMovies").param("parent", ""));
		MvcResult mr = ra.andReturn();
//		assertEquals("ERROR", mr.getModelAndView().getModelMap().get(ConsoleController.RETURN_STATUS));
		assertEquals(200, mr.getResponse().getStatus());
	}
	
	@Test
	public void testAddMenuSuccess() throws Exception {
		String iconFileName = "icon.png";
		String focusIconFileName = "icon_focus.png";
		MockMultipartFile iconFile = new MockMultipartFile(
				"icon", iconFileName, "application/octet-stream", 
				new ClassPathResource(iconFileName).getInputStream());
		MockMultipartFile focusIconFile = new MockMultipartFile(
				"focusIcon", focusIconFileName, "application/octet-stream", 
				new ClassPathResource(focusIconFileName).getInputStream());
		MockMultipartHttpServletRequestBuilder builder =
				MockMvcRequestBuilders.fileUpload("/c/menu/add.json").file(iconFile).file(focusIconFile);
		ResultActions ra = this.mockMvc.perform(builder.param("name", "BlueMovies").param("parent", "1"));
		MvcResult mr = ra.andReturn();
		assertEquals("OK", mr.getModelAndView().getModelMap().get(ConsoleController.RETURN_STATUS));
		assertEquals(200, mr.getResponse().getStatus());
	}
	
	@Test
	@Ignore
	public void testGetSimpleMenu_c() throws Exception {
		ResultActions ra = this.mockMvc.perform(MockMvcRequestBuilders
				.post("/c/menu/1.json"));//.accept(MediaType.APPLICATION_XML));
		MvcResult mr = ra.andReturn();
		assertNotNull(mr.getModelAndView().getModelMap().get("menu_c"));
		assertEquals(200, mr.getResponse().getStatus());
	}
	
	
	
	@Test
	public void testUpload() throws Exception {
		String originalFilename = "jetty-distribution-9.1.0.v20131115.tar.gz";
		MockMultipartFile mockMultipartFile = new MockMultipartFile(
				"file", originalFilename, "application/octet-stream", originalFilename.getBytes());
//				new FileInputStream("/opt/local/" + originalFilename));
		MockMultipartHttpServletRequestBuilder builder =
				MockMvcRequestBuilders.fileUpload("/c/upload/jsl.json").file(mockMultipartFile);
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

	@Test
	public void test() throws IOException {
		Resource resource = new ClassPathResource("NamedQuery.hbm.xml");
		logger.debug("{}: exists: {}", resource.getFile().getAbsolutePath(), resource.getFile().exists());
		assertTrue(resource.getFile().exists());
	}

	@Test
	public void testRenameMenu() throws Exception {
		ResultActions ra = this.mockMvc.perform(MockMvcRequestBuilders
				.post("/c/menu/rename/8/iwodsl.json"));//.accept(MediaType.APPLICATION_XML));
		MvcResult mr = ra.andReturn();
		assertEquals("OK", mr.getModelAndView().getModelMap().get(ConsoleController.RETURN_STATUS));
		assertEquals(200, mr.getResponse().getStatus());
	} 
	
	@Test
	public void testFindFilmByMenuId() throws Exception {
		ResultActions ra = this.mockMvc.perform(MockMvcRequestBuilders
				.post("/c/menu/films/2.json"));//.accept(MediaType.APPLICATION_XML));
		MvcResult mr = ra.andReturn();
		assertEquals("OK", mr.getModelAndView().getModelMap().get(ConsoleController.RETURN_STATUS));
		assertEquals(200, mr.getResponse().getStatus());
	}
	
	@Test
	public void testFindAllFilm() throws Exception {
		ResultActions ra = this.mockMvc.perform(MockMvcRequestBuilders
				.post("/c/films/all.json"));//.accept(MediaType.APPLICATION_XML));
		MvcResult mr = ra.andReturn();
		assertEquals("OK", mr.getModelAndView().getModelMap().get(ConsoleController.RETURN_STATUS));
		assertEquals(200, mr.getResponse().getStatus());
	}
	
	@Test
	public void testPublishFilm() throws Exception {
		ResultActions ra = this.mockMvc.perform(MockMvcRequestBuilders
				.post("/c/menu/publish/3.json").param("filmId", "FM00000001"));//.accept(MediaType.APPLICATION_XML));
		MvcResult mr = ra.andReturn();
		assertEquals("OK", mr.getModelAndView().getModelMap().get(ConsoleController.RETURN_STATUS));
		assertEquals(200, mr.getResponse().getStatus());
	}
	
	@Test
//	@Ignore("unimplement")
	public void testAddFilm() throws Exception {
		String posterFileName = "FM0000001.jpg";
		String contentFileName = "icon.png";
		MockMultipartFile iconFile = new MockMultipartFile(
				"poster", posterFileName, "application/octet-stream", 
				new ClassPathResource(posterFileName).getInputStream());
		MockMultipartFile focusIconFile = new MockMultipartFile(
				"content", contentFileName, "application/octet-stream", 
				new ClassPathResource(contentFileName).getInputStream());
		MockMultipartHttpServletRequestBuilder builder =
				MockMvcRequestBuilders.fileUpload("/c/film/add.json").file(iconFile).file(focusIconFile);
		ResultActions ra = this.mockMvc.perform(builder.param("title", "破坏 Sabotage").param("length", "0"));
		MvcResult mr = ra.andReturn();
		assertEquals("OK", mr.getModelAndView().getModelMap().get(ConsoleController.RETURN_STATUS));
		assertEquals(200, mr.getResponse().getStatus());
	}
}
