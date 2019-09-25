package org.eze.web.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.eze.common.enums.ResultCode;
import org.eze.common.exception.GlobalException;
import org.eze.web.entity.MenuAction;
import org.eze.web.service.MenuActionService;
import org.eze.web.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Arrays;
import java.util.List;

/*
 *  Created by Ksdl
 *  2019-08-13 22:17
 */

@Slf4j
@RestController
@RequestMapping("/menu-action")
@Validated
public class MenuActionController {

    private final MenuActionService menuActionService;

    public MenuActionController(MenuActionService menuActionService) {
        this.menuActionService = menuActionService;
    }


    /**
     * 新增
     */
    @PostMapping
    public Result<Boolean> submit(@Valid @RequestBody MenuAction menuAction) {
        return Result.status(menuActionService.submit(menuAction));
    }

    /**
     * 删除
     */
    @DeleteMapping("/{ids}")
    public Result<Boolean> remove(@Valid @NotBlank(message = "删除ID不能为空") @PathVariable String ids) {
        return Result.status(menuActionService.removeByIds(Arrays.asList(StringUtils.split(ids, ","))));
    }

    /**
     * 修改
     */
    @PutMapping
    public Result<Boolean> update(@Valid @RequestBody MenuAction menuAction) {
        return Result.status(menuActionService.updateById(menuAction));
    }


    /**
     * 当前菜单ID下所有动作列表
     */
    @GetMapping
    public Result<List<MenuAction>> list(@Valid @NotBlank(message = "菜单ID不能为空") @RequestParam String id) {
        List<MenuAction> menuActionList = menuActionService.list(Wrappers.<MenuAction>lambdaQuery().eq(MenuAction::getMenuId, id));
        if (menuActionList.size() == 0) {
            throw new GlobalException(ResultCode.NO_SUCH_MENU_ACTION);
        }
        return Result.data(menuActionList);
    }
}
