package org.eze.web.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.eze.common.enums.ResultCode;
import org.eze.common.exception.GlobalException;
import org.eze.web.entity.Role;
import org.eze.web.service.RoleService;
import org.eze.web.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Arrays;

/*
 *  Created by Ksdl
 *  2019-08-05 22:14
 */
@Slf4j
@RestController
@RequestMapping("/role")
@Validated
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    /**
     * 新增
     */
    @PostMapping
    public Result<Boolean> submit(@Valid @RequestBody Role role) {
        return Result.status(roleService.save(role));
    }

    /**
     * 删除
     */
    @DeleteMapping("/{ids}")
    public Result<Boolean> remove(@Valid @NotBlank(message = "删除ID不能为空") @PathVariable String ids) {
        return Result.status(roleService.removeByIds(Arrays.asList(StringUtils.split(ids, ","))));
    }

    /**
     * 修改
     */
    @PutMapping
    public Result<Boolean> update(@Valid @RequestBody Role user) {
        return Result.status(roleService.updateById(user));
    }


    /**
     * 分页角色列表
     */
    @GetMapping
    public Result<IPage<Role>> list(@RequestParam(required = false) String roleName, Page<Role> page) {
        IPage<Role> pages = roleService.page(page,
                Wrappers.<Role>lambdaQuery().like(!StringUtils.isEmpty(roleName), Role::getRoleName, roleName));
        if (pages.getRecords().size() == 0) {
            throw new GlobalException(ResultCode.NO_SUCH_ROLE);
        }
        return Result.data(pages);
    }
}
