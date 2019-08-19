package org.eze.web.service.serviceimpl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.eze.common.enums.ResultCode;
import org.eze.common.exception.GlobalException;
import org.eze.web.mapper.MenuMapper;
import org.eze.web.entity.Menu;
import org.eze.web.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
 *  Created by Ksdl
 *  2019-08-06 19:15
 */
@Service
@Slf4j
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

    @Override
    public boolean submit(Menu menu) {
        int cnt = count(Wrappers.<Menu>query().lambda().eq(Menu::getName, menu.getName()));
        if (cnt > 0) {
            throw new GlobalException(ResultCode.MENU_ALREADY_EXISTS);
        }
        return save(menu);
    }

    @Override
    public List<Menu> menuTree(String title) {
        List<Menu> allMenu = list(
                Wrappers.<Menu>lambdaQuery().like(!StringUtils.isEmpty(title), Menu::getTitle, title));
        if (allMenu.size() == 0) {
            throw new GlobalException(ResultCode.NO_SUCH_REMUS);
        }

        if (!StringUtils.isEmpty(title)) {
            return allMenu;
        }
        // 所有菜单
        List<Menu> menuTree = allMenu.stream().filter(p -> StringUtils.isBlank(p.getParentId())).collect(Collectors.toList());
        menuTree.forEach(nav -> nav.setChildren(getTree(nav.getId(), allMenu)));
        return menuTree;
    }

    //递归遍历树
    private List<Menu> getTree(String id, List<Menu> allMenu) {
        List<Menu> tree = new ArrayList<>();
        allMenu.forEach(nav -> {
            if (StringUtils.equals(id, nav.getParentId())) {
                tree.add(nav);
                nav.setChildren(getTree(nav.getId(), allMenu));
            }
        });
        return tree;
    }
}
