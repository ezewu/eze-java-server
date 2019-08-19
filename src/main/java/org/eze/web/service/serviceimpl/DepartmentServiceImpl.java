package org.eze.web.service.serviceimpl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.eze.common.enums.ResultCode;
import org.eze.common.exception.GlobalException;
import org.eze.web.entity.Department;
import org.eze.web.mapper.DepartmentMapper;
import org.eze.web.service.DepartmentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
 *  Created by Ksdl
 *  2019-08-13 23:44
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentService {


    @Override
    public List<Department> menuTree(String deptName) {
        List<Department> allDepartment = list(
                Wrappers.<Department>lambdaQuery().like(!StringUtils.isEmpty(deptName), Department::getDeptName, deptName));
        if (allDepartment.size() == 0) {
            throw new GlobalException(ResultCode.NO_SUCH_DEPARTMENT);
        }
        if (!StringUtils.isEmpty(deptName)) {
            return allDepartment;
        }
        // 所有菜单
        List<Department> menuTree = allDepartment.stream().filter(p -> StringUtils.isBlank(p.getParentId())).collect(Collectors.toList());
        menuTree.forEach(nav -> nav.setChildren(getTree(nav.getId(), allDepartment)));
        return menuTree;
    }

    //递归遍历树
    private List<Department> getTree(String id, List<Department> allMenu) {
        List<Department> tree = new ArrayList<>();
        allMenu.forEach(nav -> {
            if (StringUtils.equals(id, nav.getParentId())) {
                tree.add(nav);
                nav.setChildren(getTree(nav.getId(), allMenu));
            }
        });
        return tree;
    }


}
