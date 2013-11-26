/**
 * Copyright  2013, samsung All Rights Reserved.
 * Project: demo
 * cn.sh.sbl.hotel.web.action.ConsoleController.java
 * Create By: samsung
 * Create Date: 2013-11-23 下午7:27:07
 */
package cn.sh.sbl.hotel.web.action;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.sh.sbl.hotel.beans.Menu;
import cn.sh.sbl.hotel.service.IFilmService;
import cn.sh.sbl.hotel.service.IMenuService;

/**
 * @author samsung 
 * @E-mail: cxxwode@163.com
 * @version 1.0 
 * @date 2013-11-23 下午7:27:07
 * @description TODO
 */
@Controller
public class ConsoleController {
	@Autowired
	private Logger logger;
	@Autowired
	private IMenuService menuService;
	@Autowired
	private IFilmService filmService;
	
	/**
	 * this method will get all menu for the menuTree
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value={"/findAllMenu"})
	@Transactional
	public ModelAndView getAllMenu(ModelMap modelMap) {
		List<Menu> menuList = this.menuService.findAll();
		modelMap.put("menuList", menuList);
		return new ModelAndView("menu", modelMap);
	}
	
	/**
	 * 
	 * @param id
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value={"/menu_c/{id}"})
	public ModelAndView getMenu(@PathVariable("id")int id,ModelMap modelMap) {
		Menu menu = this.menuService.get(id);
		modelMap.put("menu_c", menu);
		return new ModelAndView("menu", modelMap);
	}
	
	/**
	 * this is test url pattern is a template
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value={"/upload/{name}"}, method=RequestMethod.POST)
	@Transactional
	public ModelAndView demo(@PathVariable("name")String name, @RequestParam("file")MultipartFile[] files,
			HttpServletRequest request, ModelMap modelMap) {
		String realPath = request.getSession().getServletContext().getRealPath("/");  
		logger.debug("start uplpad file! real path: {}", realPath);
		boolean success = true;
		if (0 < files.length) {
			for (MultipartFile multipartFile : files) {
				if (multipartFile.isEmpty()) {
					logger.debug("empty file: {}!", multipartFile);
					continue;
				}
				logger.debug("file original name: {}, name: {}, size: {}, type: {}", 
						multipartFile.getOriginalFilename(), multipartFile.getName(),
						multipartFile.getSize(), multipartFile.getContentType());
				try {
					File destFile = new File(realPath + "/upload/" + multipartFile.getOriginalFilename());
					logger.debug("File[{}] - [{}] will upload to: {}", 
							multipartFile.getOriginalFilename(), 
							destFile.setExecutable(false) && !destFile.canExecute(),
							destFile.getAbsolutePath());
					if (!destFile.getParentFile().exists()) {
						logger.info("This is first upload, make parent dir: {}, canRead: {}, canWrite: {}, canExecute: {}", 
								destFile.mkdirs(), destFile.getParentFile().setReadable(true, false) 
									&& destFile.getParentFile().canRead(),
								destFile.getParentFile().setWritable(true, false) 
									&& destFile.getParentFile().canWrite(),
								destFile.getParentFile().setExecutable(true, false)
									&& destFile.getParentFile().canExecute());
					}
					multipartFile.transferTo(destFile);
					modelMap.put(multipartFile.getOriginalFilename(), "upload successfull!");
				} catch (Exception e) {
					success = false;
					logger.error("", e);
					modelMap.put(multipartFile.getOriginalFilename(), e.getMessage());
				}
			}
			modelMap.put("result", success);
		} else {
			modelMap.put("result", false);
			modelMap.put("errMsg", "Please select a file to upload!");
		}
		return new ModelAndView("upload", modelMap);
	}
	
	
	
}

