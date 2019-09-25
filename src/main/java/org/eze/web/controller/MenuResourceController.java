package org.eze.web.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.eze.common.enums.ResultCode;
import org.eze.common.exception.GlobalException;
import org.eze.web.entity.MenuResource;
import org.eze.web.service.MenuResourceService;
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
 *  Created by Ksdl
 *  2019-08-07 22:47
 */
@Slf4j
@RestController
@RequestMapping("/menu-resource")
@Validated
public class MenuResourceController {

    private final MenuResourceService menuResourceService;

    public MenuResourceController(MenuResourceService menuResourceService) {
        this.menuResourceService = menuResourceService;
    }

    /**
     * 新增
     */
    @PostMapping
    public Result<Boolean> submit(@Valid @RequestBody MenuResource menuResource) {
        return Result.status(menuResourceService.submit(menuResource));
    }

    /**
     * 删除
     */
    @DeleteMapping("/{ids}")
    public Result<Boolean> remove(@Valid @NotBlank(message = "删除ID不能为空") @PathVariable String ids) {
        return Result.status(menuResourceService.removeByIds(Arrays.asList(StringUtils.split(ids, ","))));
    }

    /**
     * 修改
     */
    @PutMapping
    public Result<Boolean> update(@Valid @RequestBody MenuResource menuResource) {
        return Result.status(menuResourceService.updateById(menuResource));
    }

    /**
     * 当前菜单ID下所有接口列表
     */
    @GetMapping
    public Result<List<MenuResource>> list(@Valid @NotBlank(message = "菜单ID不能为空") @RequestParam String id) {
        List<MenuResource> menuResourceList = menuResourceService.list(Wrappers.<MenuResource>lambdaQuery().eq(MenuResource::getMenuId, id));
        if (menuResourceList.size() == 0) {
            throw new GlobalException(ResultCode.NO_SUCH_MENU_RESOURCE);
        }
        return Result.data(menuResourceList);
    }

}
