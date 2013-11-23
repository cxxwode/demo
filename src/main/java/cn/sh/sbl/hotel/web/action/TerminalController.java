/**
 * Copyright © 2013, bunco All Rights Reserved.
 * Project: hotel.demo
 * cn.sh.sbl.hotel.web.action.TerminalController.java
 * Create By: bunco
 * Create Date: 2013-11-22 下午1:54:55
 */
package cn.sh.sbl.hotel.web.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.sh.sbl.hotel.beans.Actor;
import cn.sh.sbl.hotel.beans.File;
import cn.sh.sbl.hotel.beans.Film;
import cn.sh.sbl.hotel.beans.Menu;
import cn.sh.sbl.hotel.beans.MenuFilm;
import cn.sh.sbl.hotel.service.IActorService;
import cn.sh.sbl.hotel.service.IFilmService;
import cn.sh.sbl.hotel.service.IMenuService;
import cn.sh.sbl.hotel.vo.ActorVo;
import cn.sh.sbl.hotel.vo.FileVo;
import cn.sh.sbl.hotel.vo.FilmVo;
import cn.sh.sbl.hotel.vo.MenuVo;

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
	private IActorService actorService;
	@Autowired
	private IMenuService menuService;
	@Autowired
	private IFilmService filmService;
	/**
	 * this is test url pattern is a template
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value={"/test"})
	@Transactional
	public ModelAndView demo(ModelMap modelMap) {
		Actor actor = this.actorService.get(1);
		ActorVo actorVo = new ActorVo();
		for (Film film : actor.getFilms()) {
			actorVo.setFirstName(film.getTitle());
			actorVo.setLastName(String.valueOf(film.getDirectors().size()));
			actorVo.setId(actor.getId());
		}
		modelMap.put("Actor", actorVo);
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
		if(presentMenu.getValid() && presentMenu.getHasChild()) {
			Iterator<Menu> it =  presentMenu.getMenus().iterator();
			List<MenuVo> children =  new ArrayList<MenuVo>();
			Menu child = null;
			while(it.hasNext()) {
				child = it.next();
				MenuVo menuVo = new MenuVo();
				menuVo.setId(child.getId());
				menuVo.setName(child.getName());
				children.add(menuVo);
			}
			modelMap.put("Menu", children);
		}
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
		Menu presentMenu = this.menuService.get(id);
		logger.debug("{}菜单{}合法{}子节点",presentMenu.getName(),presentMenu.getValid(),!presentMenu.getHasChild());
		if(presentMenu.getValid() && !presentMenu.getHasChild()) {
			Iterator it =  presentMenu.getMenuFilms().iterator();
			List menuFilms = new ArrayList();
			MenuFilm menuFilm = null;
			Film film = null;
			while(it.hasNext()) {
				menuFilm = (MenuFilm) it.next();
				film = (Film) menuFilm.getFilm();
				logger.debug("{}下电影{}",presentMenu.getName(),film.getTitle());
				FilmVo filmVo = new FilmVo();
				filmVo.setId(film.getId());
				filmVo.setTitle(film.getTitle());
				filmVo.setReleaseYear(film.getReleaseYear());
				menuFilms.add(filmVo);
			}
			
			logger.debug("栏目{}下电影数目{}",presentMenu.getName(),presentMenu.getMenuFilms().size());
			modelMap.put("MenuFilm", menuFilms);
		}
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
		Film film = (Film) this.filmService.get(id);
		this.logger.info("影片{}海报视频文件数目{}",film.getTitle(),film.getFiles().size());
		FilmVo filmVo = new FilmVo();
		if(film != null){
			filmVo.setId(film.getId());
			filmVo.setTitle(film.getTitle());
			filmVo.setCountry(film.getCountry());
			filmVo.setDescription(film.getDescription());
			filmVo.setRatings(film.getRatings());
			filmVo.setLastUpdate(film.getLastUpdate());
			filmVo.setLength(film.getLength());
			List<FileVo> fileVos = new ArrayList();
			Iterator it = film.getFiles().iterator();
			logger.info("电影的文件个数{}",film.getFiles().size());
			while(it.hasNext()){
				FileVo fileVo = new FileVo();
				File file = (File) it.next();
				fileVo.setId(file.getId());
				fileVo.setFileName(file.getFileName());
				//fileVo.setCategory(file.getCategory());
				fileVo.setFileSize(file.getFileSize());
				fileVo.setLastUpdate(file.getLastUpdate());
				fileVo.setRemark(file.getRemark());
				fileVos.add(fileVo);
				this.logger.info("影片{}海报视频文件{}",film.getTitle(),fileVo.getFileName());
			}
			filmVo.setFileVo(fileVos);
		}
		modelMap.put("FilmVo", filmVo);
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