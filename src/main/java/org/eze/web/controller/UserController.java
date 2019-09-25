package org.eze.web.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.eze.common.enums.ResultCode;
import org.eze.common.exception.GlobalException;
import org.eze.web.entity.User;
import org.eze.web.service.UserService;
import org.eze.web.vo.Result;
import lombok.extern.slf4j.Slf4j;
import javax.validation.constraints.NotBlank;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
/*
 *  Created by Ksdl
 *  2019-07-05 21:44
 */

@Slf4j
@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 新增
     */
    @PostMapping
    public Result<Boolean> submit(@Valid @RequestBody User user) {
        return Result.status(userService.submit(user));
    }

    /**
     * 删除
     */
    @DeleteMapping("/{ids}")
    public Result<Boolean> remove(@Valid @NotBlank(message = "删除ID不能为空") @PathVariable String ids) {
        return Result.status(userService.removeByIds(Arrays.asList(StringUtils.split(ids, ","))));
    }

    /**
     * 修改
     */
    @PutMapping
    public Result<Boolean> update(@Valid @RequestBody User user) {
        return Result.status(userService.updateById(user));
    }

    /**
     * 分页用户列表
     */
    @GetMapping
    public Result<IPage<User>> list(@RequestParam(required = false) String username, @RequestParam(required = false) String realName,
                                    @RequestParam(required = false) String phone, Page<User> page) {
        IPage<User> pages = userService.page(page,
                Wrappers.<User>lambdaQuery().like(!StringUtils.isEmpty(username), User::getUsername, username).like(!StringUtils.isEmpty(realName),
                        User::getRealName, realName).like(!StringUtils.isEmpty(phone), User::getPhone, phone));

        if (pages.getRecords().size() == 0) {
            throw new GlobalException(ResultCode.NO_SUCH_USER);
        }
        return Result.data(pages);
    }

}
