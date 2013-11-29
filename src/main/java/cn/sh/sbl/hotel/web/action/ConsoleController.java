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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.sh.sbl.hotel.beans.Category;
import cn.sh.sbl.hotel.beans.FileType;
import cn.sh.sbl.hotel.beans.Film;
import cn.sh.sbl.hotel.beans.Menu;
import cn.sh.sbl.hotel.beans.MenuFilm;
import cn.sh.sbl.hotel.service.IFileService;
import cn.sh.sbl.hotel.service.IFilmService;
import cn.sh.sbl.hotel.service.IMenuFilmService;
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
	@Autowired
	private IFileService fileService;
	@Autowired
	private IMenuFilmService menuFilmService;
	

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
	 * delete menu
	 * @param id  the id of menu
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
			upload(realPath, icon, null);
			upload(realPath, focusIcon, null);
			// TODO new Menu()  to save
//			this.menuService.save(menu);
			modelMap.put(RETURN_STATUS, "OK");
		} catch (Exception e) {
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
	
	
	public String upload(String realPath, MultipartFile mf, String newName) throws IllegalStateException, IOException {
		if(mf.isEmpty()) {
			logger.debug("empty file: {}!", mf);
			throw new IllegalArgumentException(mf.getOriginalFilename() + " is empty!");
		}else {
			logger.debug("file original name: {}, name: {}, size: {}, type: {}", 
					mf.getOriginalFilename(), mf.getName(),
					mf.getSize(), mf.getContentType());
			
			File destFile = new File(realPath + "/" + (null != newName ? newName : "/upload/" + mf.getOriginalFilename()));
			logger.debug("destFile: {}, parent: {}", destFile.getAbsolutePath(), destFile.getParentFile());
			if (!destFile.getParentFile().exists()) {
				logger.info("This is first upload, make parent dir: {}, canRead: {}, canWrite: {}, canExecute: {}", 
						destFile.getParentFile().mkdirs(), destFile.getParentFile().setReadable(true, false) 
							&& destFile.getParentFile().canRead(),
						destFile.getParentFile().setWritable(true, false) 
							&& destFile.getParentFile().canWrite(),
						destFile.getParentFile().setExecutable(true, false)
							&& destFile.getParentFile().canExecute());
			}
			mf.transferTo(destFile);
			return mf + "upload success!";
		}
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
	
	/**
	 * find all film
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value={"/films/all"})
	public ModelAndView getAllFilm(ModelMap modelMap) {
		modelMap.put("films", this.filmService.findAll());
		modelMap.put(RETURN_STATUS, "OK");
		return new ModelAndView("", modelMap);
	}
	
	@RequestMapping("/menu/films/{id}")
	public ModelAndView getFilmByMenu(@PathVariable int id, ModelMap modelMap) {
		try {
			Assert.notNull(id);
			List<Film> list = new ArrayList<Film>();
			List<MenuFilm> menuFilms = this.menuFilmService.getMenuFilmByMenuId(id);
			for (MenuFilm menuFilm : menuFilms) {
				Film film = this.filmService.get(menuFilm.getFilmId());
				film.setRemark(this.fileService.findPostFileByFilmId(menuFilm.getFilmId()).getFileName());
				list.add(film);
			}
			modelMap.put(RETURN_STATUS, "OK");
			modelMap.put("films", list);
		} catch (Exception e) {
			modelMap.put(RETURN_STATUS, "ERROR");
			modelMap.put(RETURN_ERROR_MSG, e.getMessage());
		}
		return new ModelAndView("menu_films", modelMap);
	}
	
	@RequestMapping("/menu/publish/{menuId}")
	public ModelAndView publishFilm(@PathVariable("menuId") int menuId, 
			@RequestParam("filmId[]") String[] filmId, ModelMap modelMap) {
		try {
			Assert.notNull(menuId);
			Assert.notEmpty(filmId);
			this.menuFilmService.addMenuFilm(menuId, Arrays.asList(filmId));
			modelMap.put(RETURN_STATUS, "OK");
		} catch (Exception e) {
			modelMap.put(RETURN_STATUS, "ERROR");
			modelMap.put(RETURN_ERROR_MSG, e.getMessage());
		}
		return new ModelAndView("publish", modelMap);
	}
	
	@RequestMapping("/film/add")
	public ModelAndView addFilm(@RequestParam("title") String title,
			@RequestParam(required=false) String actor,
			@RequestParam(required=false) String director,
			@RequestParam(required=false) String language,
			@RequestParam(required=false) String release_year,
			@RequestParam(required=false) String country,
			@RequestParam(required=false) Short length,
			@RequestParam(required=false) String genre,
			@RequestParam(required=false) String ratings,
			@RequestParam(required=false) String description,
			@RequestParam("poster") MultipartFile poster,
			@RequestParam("content") MultipartFile content,
			@RequestParam(required=false) MultipartFile srt,
			HttpServletRequest request,
			ModelMap modelMap) {
		String realPath = request.getSession().getServletContext().getRealPath("/");  
		logger.debug("add film to {}", realPath);
		try {
			String maxId = this.filmService.getMaxId();
			Assert.notNull(title);
			Film film = new Film();
			film.setTitle(title);
			film.setActor(actor);
			film.setCountry(country);
			film.setDescription(description);
			film.setDirector(director);
			film.setGenre(genre);
			film.setLanguage(language);
			film.setLength(length);
			film.setRatings(ratings);
			film.setReleaseYear(release_year);
			film.setId("FM" + String.format("%08d", Integer.valueOf(maxId.substring(2)) + 1));
			
			List<cn.sh.sbl.hotel.beans.File> list = new ArrayList<cn.sh.sbl.hotel.beans.File>();
			// upload poster file 
			cn.sh.sbl.hotel.beans.File posterFile = new cn.sh.sbl.hotel.beans.File();
			Category posterCategory = this.fileService.getFileTypeCategoryId(FileType.Poster);
			posterFile.setCategoryFilm(posterCategory.getId());
			posterFile.setFileName(rename(poster.getOriginalFilename(), film.getId()));
			posterFile.setFileSize(poster.getSize());
			posterFile.setFilmId(film.getId());
			list.add(posterFile);
			upload(realPath, poster, posterFile.getFileName());
			//upload content file
			cn.sh.sbl.hotel.beans.File contentFile = new cn.sh.sbl.hotel.beans.File();
			Category contentCategory = this.fileService.getFileTypeCategoryId(FileType.Content);
			contentFile.setCategoryFilm(contentCategory.getId());
			contentFile.setFileName(rename(content.getOriginalFilename(), film.getId()));
			contentFile.setFileSize(poster.getSize());
			contentFile.setFilmId(film.getId());
			list.add(contentFile);
			upload(realPath, content, contentFile.getFileName());
			if (null != srt && !srt.isEmpty()) {
				// upload srt file, this is optional
				cn.sh.sbl.hotel.beans.File srtFile = new cn.sh.sbl.hotel.beans.File();
				Category srtCategory = this.fileService.getFileTypeCategoryId(FileType.Subtitle);
				srtFile.setCategoryFilm(srtCategory.getId());
				srtFile.setFileName(rename(srt.getOriginalFilename(), film.getId()));
				srtFile.setFileSize(poster.getSize());
				srtFile.setFilmId(film.getId());
				list.add(srtFile);
				upload(realPath, srt, srtFile.getFileName());
			}
			this.filmService.addFilm(film, list);
			modelMap.put(RETURN_STATUS, "OK");
		} catch (Exception e) {
			logger.error("", e);
			modelMap.put(RETURN_STATUS, "ERROR");
			modelMap.put(RETURN_ERROR_MSG, e.getMessage());
		}
		return new ModelAndView("add_film", modelMap);
	}
	
	private String rename(String oldName, String newName) {
		return "upload/" + newName + oldName.substring(oldName.lastIndexOf("."));
	}
}

