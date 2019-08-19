package org.eze.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.eze.web.entity.MenuAction;

/*
 *  Created by Ksdl
 *  2019-08-13 23:08
 */
public interface MenuActionService extends IService<MenuAction> {
    boolean submit(MenuAction menuAction);
}
