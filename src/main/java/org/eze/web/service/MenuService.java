package org.eze.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.eze.web.entity.Menu;

import java.util.List;


/*
 *  Created by Ksdl
 *  2019-08-06 19:30
 */
public interface MenuService extends IService<Menu> {

    boolean submit(Menu menu);

    List<Menu> menuTree(String title);
}
