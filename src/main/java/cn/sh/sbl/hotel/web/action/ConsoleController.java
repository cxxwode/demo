/**
 * Copyright  2013, samsung All Rights Reserved.
 * Project: demo
 * cn.sh.sbl.hotel.web.action.ConsoleController.java
 * Create By: samsung
 * Create Date: 2013-11-23 下午7:27:07
 */
package cn.sh.sbl.hotel.web.action;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.sh.sbl.hotel.beans.Actor;
import cn.sh.sbl.hotel.beans.Film;
import cn.sh.sbl.hotel.service.IActorService;
import cn.sh.sbl.hotel.service.IFilmService;
import cn.sh.sbl.hotel.service.IMenuService;
import cn.sh.sbl.hotel.vo.ActorVo;

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
	@RequestMapping(value={"/Consoletest"})
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
	
}

