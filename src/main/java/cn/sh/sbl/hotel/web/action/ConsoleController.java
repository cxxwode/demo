/**
 * Copyright  2013, samsung All Rights Reserved.
 * Project: demo
 * cn.sh.sbl.hotel.web.action.ConsoleController.java
 * Create By: samsung
 * Create Date: 2013-11-23 下午7:27:07
 */
package cn.sh.sbl.hotel.web.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.sh.sbl.hotel.beans.Film;
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
@RequestMapping("/c")
public class ConsoleController {
	public static final String RETURN_STATUS = "status";
	public static final String RETURN_ERROR_MSG = "errMsg";
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

	@RequestMapping(value={"/menu/all"})
	@Transactional
	public ModelAndView getAllMenu(ModelMap modelMap) {
		List<Menu> menuList = this.menuService.findAll();
		modelMap.put("menuList", menuList);
		return new ModelAndView("menu", modelMap);
	}
	
	/**
	 * 获取指定菜单信息
	 * @param id
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value={"/menu/{id}"})
	public ModelAndView getMenu(@PathVariable("id")int id,ModelMap modelMap) {
		Menu menu = this.menuService.get(id);
		modelMap.put("menu_c", menu);
		return new ModelAndView("menu", modelMap);
	}
	
	/**
	 * 删除菜单
	 * @param id
	 * @return
	 */
	public Object delMenu(@PathVariable("id")int id) {
		return null;
	}
	
	@RequestMapping(value={"/menu/add"})
	public ModelAndView addMenu(@RequestParam("icon")MultipartFile icon, 
			@RequestParam("focusIcon")MultipartFile focusIcon, 
			@RequestParam("name")String name, 
			@RequestParam("parent")Integer parent, 
			HttpServletRequest request,
			ModelMap modelMap) {
		logger.debug("name: {}", name);
		logger.debug("file original name: {}, name: {}, size: {}, type: {}", 
				icon.getOriginalFilename(), icon.getName(),
				icon.getSize(), icon.getContentType());
		logger.debug("file original name: {}, name: {}, size: {}, type: {}", 
				focusIcon.getOriginalFilename(), focusIcon.getName(),
				focusIcon.getSize(), focusIcon.getContentType());
		
		String realPath = request.getSession().getServletContext().getRealPath("/");  
		try {
			Assert.notNull(parent);
			// TODO save file to path
			upload(realPath, icon);
			upload(realPath, focusIcon);
			// TODO new Menu()  to save
//			this.menuService.save(menu);
			modelMap.put(RETURN_STATUS, "OK");
		} catch (IllegalArgumentException e) {
			logger.debug("menu parent can not be null!");
			modelMap.put(RETURN_STATUS, "ERROR");
			modelMap.put(RETURN_ERROR_MSG, e.getMessage());
		}
		return new ModelAndView("add_menu", modelMap);
	}
	
	@RequestMapping("/menu/rename/{id}/{name}")
	public ModelAndView renameMenu(@PathVariable("id")int id, @PathVariable("name")String name, ModelMap modelMap) {
		Menu menu = this.menuService.get(id);
		try {
			Assert.notNull(menu);
			Assert.notNull(name);
			menu.setName(name);
			this.menuService.rename(menu);
			modelMap.put(RETURN_STATUS, "OK");
		} catch (IllegalArgumentException e) {
			modelMap.put(RETURN_STATUS, "ERROR");
			modelMap.put(RETURN_ERROR_MSG, e.getMessage());
		}
		return new ModelAndView("rename", modelMap);
	}
	
	
	public String upload(String realPath, MultipartFile mf) {
		if(mf.isEmpty()) {
			logger.debug("empty file: {}!", mf);
			return "empty file: " + mf;
		}else {
			logger.debug("file original name: {}, name: {}, size: {}, type: {}", 
					mf.getOriginalFilename(), mf.getName(),
					mf.getSize(), mf.getContentType());
			
			File destFile = new File(realPath + "/upload/" + mf.getOriginalFilename());
			if (!destFile.getParentFile().exists()) {
				logger.info("This is first upload, make parent dir: {}, canRead: {}, canWrite: {}, canExecute: {}", 
						destFile.getParentFile().mkdirs(), destFile.getParentFile().setReadable(true, false) 
							&& destFile.getParentFile().canRead(),
						destFile.getParentFile().setWritable(true, false) 
							&& destFile.getParentFile().canWrite(),
						destFile.getParentFile().setExecutable(true, false)
							&& destFile.getParentFile().canExecute());
			}
			try {
				mf.transferTo(destFile);
				return mf + "upload success!";
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				logger.error("", e);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "success";
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
								destFile.getParentFile().mkdirs(), destFile.getParentFile().setReadable(true, false) 
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
	
	@RequestMapping(value={"/films/all"})
	public ModelAndView getAllFilm(ModelMap modelMap) {
		return new ModelAndView("", modelMap);
	}
	
}

