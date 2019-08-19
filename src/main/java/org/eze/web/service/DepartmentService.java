package org.eze.web.service;


import com.baomidou.mybatisplus.extension.service.IService;
import org.eze.web.entity.Department;

import java.util.List;

/*
 *  Created by Ksdl
 *  2019-08-13 23:31
 */
public interface DepartmentService extends IService<Department> {
    List<Department> menuTree(String deptName);
}
