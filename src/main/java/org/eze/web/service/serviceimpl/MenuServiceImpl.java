package org.eze.web.service.serviceimpl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.math.NumberUtils;
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
        //  int cnt = count(Wrappers.<Menu>query().lambda().eq(Menu::getName, menu.getName()));
        //  if (cnt > 0) {
        //      throw new GlobalException(ResultCode.MENU_ALREADY_EXISTS);
        //  }
        menu.setName(RandomStringUtils.randomAlphabetic(10));
        return save(menu);
    }

    /**
     * @return 所有菜单
     */
    @Override
    public List<Menu> menuTree() {
        // 所有菜单
        List<Menu> allMenu = this.list();
        List<Menu> menuTree = allMenu.stream().filter(p -> StringUtils.isBlank(p.getParentId())).collect(Collectors.toList());
        menuTree.forEach(nav -> nav.setChildren(getTree(nav.getId(), allMenu)));
        return menuTree;
    }

    /**
     * @param title  组件名称
     * @param status 组件状态
     * @return 返回查询结果
     */
    @Override
    public List<Menu> findMenu(String title, String status) {
        // TODO 是否可优化
        List<Menu> menu = list(
                Wrappers.<Menu>lambdaQuery().and(!StringUtils.isEmpty(title) || !StringUtils.isEmpty(status), Wrappers -> Wrappers
                        .like(!StringUtils.isEmpty(title), Menu::getTitle, title)
                        .eq(!StringUtils.isEmpty(status), Menu::getStatus, status)));

        if (menu.size() > 1) {
            List<Menu> menuTree = menu.stream().filter(p -> StringUtils.isBlank(p.getParentId())).collect(Collectors.toList());
            menuTree.forEach(nav -> nav.setChildren(getTree(nav.getId(), menu)));
            return menuTree;
        }
        return menu;
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
