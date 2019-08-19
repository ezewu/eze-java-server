package org.eze.web.service.serviceimpl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.eze.common.enums.ResultCode;
import org.eze.common.exception.GlobalException;
import org.eze.web.entity.Menu;
import org.eze.web.entity.MenuAction;
import org.eze.web.mapper.MenuActionMapper;
import org.eze.web.mapper.MenuMapper;
import org.eze.web.service.MenuActionService;
import org.springframework.stereotype.Service;

/*
 *  Created by Ksdl
 *  2019-08-13 23:08
 */
@Service
public class MenuActionServiceImpl extends ServiceImpl<MenuActionMapper, MenuAction> implements MenuActionService {

    private final MenuMapper menuMapper;

    public MenuActionServiceImpl(MenuMapper menuMapper) {
        this.menuMapper = menuMapper;
    }

    @Override
    public boolean submit(MenuAction menuAction) {
        int menuCnt = menuMapper.selectCount(Wrappers.<Menu>query().lambda().eq(Menu::getId, menuAction.getMenuId()));
        if (menuCnt == 0) {
            throw new GlobalException(ResultCode.NO_SUCH_MENU);
        }
        int cnt = count(Wrappers.<MenuAction>query().lambda().eq(MenuAction::getMenuId, menuAction.getMenuId()).eq(MenuAction::getCode, menuAction.getCode()));
        if (cnt > 0) {
            throw new GlobalException(ResultCode.ACTION_NUMBER_OCCUPIED);
        }
        return save(menuAction);
    }
}
