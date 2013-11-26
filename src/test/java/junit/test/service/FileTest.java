/**
 * Copyright  2013, samsung All Rights Reserved.
 * Project: hotel.demo Maven Webapp
 * junit.test.service.FileTest.java
 * Create By: samsung
 * Create Date: 2013-11-26 上午11:27:52
 */
package junit.test.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import cn.sh.sbl.hotel.service.IFileService;

/**
 * @author samsung 
 * @E-mail: cxxwode@163.com
 * @version 1.0 
 * @date 2013-11-26 上午11:27:52
 * @description TODO
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath*:applicationContext-*.xml"})
public class FileTest {
	@Autowired
	private Logger logger;
	@Autowired
	private IFileService fileService;
	
	@Test
	public void testFindFilesByFilmId(){
		this.fileService.findFileByFilmId("embed01");
	}
}

