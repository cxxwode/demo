/**
 * Copyright © 2013, bunco All Rights Reserved.
 * Project: demo
 * cn.sh.sbl.hotel.vo.FilmList.java
 * Create By: bunco
 * Create Date: 2013-11-23 下午5:49:15
 */
package cn.sh.sbl.hotel.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author bunco 
 * @E-mail: bunco.hb@gmail.com
 * @version 1.0 
 * @date 2013-11-23 下午5:49:15
 * @description TODO
 */
@XmlRootElement(name="films")
public class FilmList {
	
	private List<FilmVo> filmVos;
	
	public FilmList() {}
	
	public FilmList(List<FilmVo> filmVos) {
		this.filmVos = filmVos;
	}

	/** 
	 * 获取 filmVos 
	 * @return filmVos filmVos 
	 */
	@XmlElement(name="film")
	public List<FilmVo> getFilmVos() {
		return filmVos;
	}

	/** 
	 * 设置 filmVos 
	 * @param filmVos filmVos 
	 */
	public void setFilmVos(List<FilmVo> filmVos) {
		this.filmVos = filmVos;
	}
}
