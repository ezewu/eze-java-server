package org.eze.web.controller;

import org.eze.web.service.MenuService;
import org.eze.web.entity.Menu;
import org.eze.web.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Result<Boolean> remove(@Valid @NotBlank(message = "删除ID不能为空") @PathVariable String ids) {
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

}
