package org.eze.web.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.eze.web.service.MenuService;
import org.eze.web.entity.Menu;
import org.eze.web.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Arrays;
import java.util.List;

/*
 * Created by Ksdl
 * 2019-04-20 20:25
 */
@Slf4j
@RestController
@RequestMapping("/menu")
@Validated
public class MenuController {


    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    /**
     * 新增
     */
    @PostMapping
    public Result<Boolean> submit(@Valid @RequestBody Menu menu) {
        return Result.status(menuService.submit(menu));
    }

    /**
     * 删除
     */
    @DeleteMapping("/{ids}")
    public Result<Boolean> remove(@PathVariable String ids) {
        return Result.status(menuService.removeByIds(Arrays.asList(StringUtils.split(ids, ","))));
    }

    /**
     * 修改
     */
    @PutMapping
    public Result<Boolean> updateMenu(@Valid @RequestBody Menu menu) {
        return Result.status(menuService.updateById(menu));
    }

    /**
     * 菜单列表 可搜索单条
     */
    @GetMapping
    public Result<List<Menu>> list() {
        return Result.data(menuService.menuTree());
    }

    /**
     * 精确查找
     */
    @GetMapping("/find")
    public Result<List<Menu>> findMenu(@RequestParam(required = false) String title, @RequestParam(required = false) String status) {
        return Result.data(menuService.findMenu(title, status));
    }

    /**
     * 只查询菜单列表
     */
    @GetMapping("/type/{type}")
    public Result<IPage<Menu>> listMenuType(@PathVariable String type, Page<Menu> page) {
        return Result.data(menuService.page(page, Wrappers.<Menu>lambdaQuery().eq(Menu::getType, type)));
    }

    /**
     * 只查询菜单列表
     */
    @GetMapping("/find/type/{type}")
    public Result<IPage<Menu>> findMenuType(@PathVariable String type, @RequestParam @NotBlank(message = "菜单名称不能为空") String title, Page<Menu> page) {
        return Result.data(menuService.page(page, Wrappers.<Menu>lambdaQuery().eq(Menu::getType, type).like(Menu::getTitle, title)));
    }

}
