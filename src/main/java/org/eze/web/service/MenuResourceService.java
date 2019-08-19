package org.eze.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.eze.web.entity.MenuResource;

/*
 *  Created by Ksdl
 *  2019-08-07 22:51
 */
public interface MenuResourceService extends IService<MenuResource> {
    boolean submit(MenuResource menuResource);
}
