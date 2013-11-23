package cn.sh.sbl.hotel.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sh.sbl.hotel.beans.Menu;
import cn.sh.sbl.hotel.dao.IMenuHome;
import cn.sh.sbl.hotel.service.IMenuService;

/**
 * @author lufeng 
 * @E-mail: cxxwode@163.com
 * @version 1.0 
 * @date 2013年11月23日10:56:02
 * @description TODO
 */

@Service
public class MenuService implements IMenuService {

	@Autowired
	private Logger logger;
	@Autowired
	private IMenuHome menuHome;
	
	public List<Menu> findAll() {
		return this.menuHome.findAll();
	}

	public Menu get(int id) {
		return this.menuHome.findById(id);
	}

}
