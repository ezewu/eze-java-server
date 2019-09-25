package org.eze.web.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.eze.web.entity.Department;
import org.eze.web.service.DepartmentService;
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
 *  2019-08-13 23:56
 */

@Slf4j
@RestController
@RequestMapping("/department")
@Validated
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    /**
     * 新增
     */
    @PostMapping
    public Result<Boolean> submit(@Valid @RequestBody Department department) {
        return Result.status(departmentService.save(department));
    }

    /**
     * 删除
     */
    @DeleteMapping("/{ids}")
    public Result<Boolean> remove(@Valid @NotBlank(message = "删除ID不能为空") @PathVariable String ids) {
        return Result.status(departmentService.removeByIds(Arrays.asList(StringUtils.split(ids, ","))));
    }

    /**
     * 修改
     */
    @PutMapping
    public Result<Boolean> update(@Valid @RequestBody Department department) {
        return Result.status(departmentService.updateById(department));
    }

    /**
     * 部门列表 可搜索单条
     */
    @GetMapping
    public Result<List<Department>> list(@RequestParam(required = false) String deptName) {
        return Result.data(departmentService.menuTree(deptName));
    }

}
