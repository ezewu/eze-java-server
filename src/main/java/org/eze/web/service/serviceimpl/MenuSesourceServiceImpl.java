package org.eze.web.service.serviceimpl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.eze.common.enums.ResultCode;
import org.eze.common.exception.GlobalException;
import org.eze.web.mapper.MenuMapper;
import org.eze.web.mapper.MenuResourceMapper;
import org.eze.web.entity.Menu;
import org.eze.web.entity.MenuResource;
import org.eze.web.service.MenuResourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


/*
 *  Created by Ksdl
 *  2019-08-07 22:52
 */
@Slf4j
@Service
public class MenuSesourceServiceImpl extends ServiceImpl<MenuResourceMapper, MenuResource> implements MenuResourceService {

    private final MenuMapper menuMapper;

    public MenuSesourceServiceImpl(MenuMapper menuMapper) {
        this.menuMapper = menuMapper;
    }

    @Override
    public boolean submit(MenuResource menuResource) {
        int menuCnt = menuMapper.selectCount(Wrappers.<Menu>query().lambda().eq(Menu::getId, menuResource.getMenuId()));
        if (menuCnt == 0) {
            throw new GlobalException(ResultCode.NO_SUCH_MENU);
        }
        int cnt = count(Wrappers.<MenuResource>query().lambda().eq(MenuResource::getMenuId, menuResource.getMenuId()).eq(MenuResource::getCode, menuResource.getCode()));
        if (cnt > 0) {
            throw new GlobalException(ResultCode.RESOURCE_NUMBER_OCCUPIED);
        }
        return save(menuResource);
    }

}
