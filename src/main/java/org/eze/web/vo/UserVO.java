package org.eze.web.vo;

import org.eze.web.entity.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

/*
 *  Created by Ksdl
 *  2019-08-01 22:25
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserVO extends User {
    private static final long serialVersionUID = 1L;
    // 角色名
    private String roleName;
    // 部门名
    private String deptName;
}
