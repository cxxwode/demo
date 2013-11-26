/**
 * Copyright © 2013, bunco All Rights Reserved.
 * Project: hotel.demo
 * cn.sh.sbl.hotel.web.action.TerminalController.java
 * Create By: bunco
 * Create Date: 2013-11-22 下午1:54:55
 */
package cn.sh.sbl.hotel.web.action;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.sh.sbl.hotel.beans.File;
import cn.sh.sbl.hotel.beans.Film;
import cn.sh.sbl.hotel.beans.Menu;
import cn.sh.sbl.hotel.service.IFileService;
import cn.sh.sbl.hotel.service.IFilmService;
import cn.sh.sbl.hotel.service.IMenuFilmService;
import cn.sh.sbl.hotel.service.IMenuService;
import cn.sh.sbl.hotel.vo.FileList;
import cn.sh.sbl.hotel.vo.FilmList;
import cn.sh.sbl.hotel.vo.FilmVo;

/**
 * @author bunco 
 * @E-mail: bunco.hb@gmail.com
 * @version 1.0 
 * @date 2013-11-22 下午1:54:55
 * @description defined all of the terminal visit interface to access data object
 */
@Controller
public class TerminalController {
	@Autowired
	private Logger logger;
	@Autowired
	private IMenuService menuService;
	@Autowired
	private IFilmService filmService;
	@Autowired
	private IMenuFilmService menuFilmService;
	@Autowired
	private IFileService fileService;
	
	
	/**
	 * this is test url pattern is a template
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value={"/test"})
	@Transactional
	public ModelAndView demo(ModelMap modelMap) {
		return new ModelAndView("hello", modelMap);
	}
	
	/**
	 * 用于终端一级栏目的展现和子栏目的展现, 进入主界面或进入非叶子栏目执行
	 * @param id 父级菜单编号(如果是进入主界面执行, 则id==root)
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value={"/menu/{id}"})
	@Transactional
	public ModelAndView getMenu(@PathVariable("id")int id, ModelMap modelMap) {
		// TODO 需要实现根据父级菜单ID获取子菜单信息, 只需要获取下一级菜单即可
		Menu presentMenu = this.menuService.get(id);
		logger.info("{}{}",presentMenu.getValid() , presentMenu.getHasChild());
		List<Menu> childMenus = this.menuService.getChildrenById(id);
		modelMap.put("menus", childMenus);
		return new ModelAndView("menu", modelMap);
	}
	
	/**
	 * 用于终端栏目下的影片展现, 点击进入叶子栏目执行(hasChild==false)
	 * @param id
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value={"/films/{id}"})
	@Transactional
	public ModelAndView getFilms(@PathVariable("id")int id, ModelMap modelMap) {
		// TODO 需要实现根据菜单编号, 查询该菜单下绑定的影片列表(需要校验只有不包含子菜单的的菜单), 需返回影片的描述信息, 及海报路径
		//Menu presentMenu = this.menuService.get(id);
		//logger.debug("{}菜单{}合法{}子节点",presentMenu.getName(),presentMenu.getValid(),!presentMenu.getHasChild());
		
		List<FilmVo> filmVos = new ArrayList<FilmVo>();
		List<Film> films = this.menuFilmService.findFilmByMenuId(id);
		for(Film f : films) {
			logger.debug("{}====",films.size());
			FilmVo filmVo = new FilmVo(f.getId(), f.getTitle());
			List<File> files = this.fileService.findFileByFilmId(f.getId());
			filmVo.setFileList(new FileList(files));
			filmVos.add(filmVo);
		}
		modelMap.put("film", new FilmList(filmVos));
		return new ModelAndView("films", modelMap);
	}
	
	/**
	 * 点击栏目下的海报执行
	 * @param id 影片编号
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value={"/film/{id}"})
	@Transactional
	public ModelAndView getFilm(@PathVariable("id")String id, ModelMap modelMap) {
		// TODO 需要实现根据影片编号, 查询该影片的文件信息, 需返回影片的描述信息, 海报路径, 视频文件及字幕路径. 
		// 需记录logger.info日志, 目的记录影片海报的查看信息. 为以后统计报表做准备
		
		Film f = this.filmService.get(id);
		logger.debug("{}",f.getTitle());
		FilmVo filmVo = new FilmVo(f.getId(), f.getTitle());
		List<File> files = this.fileService.findFileByFilmId(f.getId());
		filmVo.setFileList(new FileList(files));
		
		modelMap.put("filmVo", filmVo);
		return new ModelAndView("film", modelMap);
	}
	
	/**
	 * 终端开始播放影片时执行
	 * @param id 影片编号
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value={"/play/{id}"})
	@Transactional
	public ModelAndView startPlay(@PathVariable("id")int id, ModelMap modelMap) {
		// 需记录logger.info日志, 目的记录影片播放信息. 为以后统计报表做准备
		this.logger.info("start play: {}", id);
		return new ModelAndView("start", modelMap);
	}
	
	/**
	 * 终端停止播放影片时执行
	 * @param id 影片编号
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value={"/stop/{id}"})
	@Transactional
	public ModelAndView stopPlay(@PathVariable("id")int id, ModelMap modelMap) {
		// 需记录logger.info日志, 目的记录影片播放信息. 为以后统计报表做准备
		this.logger.info("stop play: {}", id);
		return new ModelAndView("stop", modelMap);
	}
}