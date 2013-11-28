package cn.sh.sbl.hotel.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sh.sbl.hotel.beans.Menu;
import cn.sh.sbl.hotel.beans.MenuExample;
import cn.sh.sbl.hotel.dao.MenuMapper;
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
	private MenuMapper menuMapper;
	
	public List<Menu> findAll() {
		return this.menuMapper.selectByExample(null);
	}

	public Menu get(int id) {
		return this.menuMapper.selectByPrimaryKey(id);
	}
	
	public List<Menu> getChildrenById(int id){
		MenuExample example = new MenuExample();
		example.createCriteria().andParentEqualTo(id)
			.andValidEqualTo(true)
			.andHasChildEqualTo(true);
		return menuMapper.selectByExample(example);
	}
	
	public void save(Menu menu) {
		logger.debug("insert {} into Menu", menu.getName());
		menuMapper.insert(menu);
	}
	
	public void rename(Menu menu) {
		logger.debug("new Name: {}", menu.getName());
		this.menuMapper.updateByPrimaryKey(menu);
	}
}
