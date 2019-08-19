package org.eze.web.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import org.eze.web.base.EzeBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.List;

/*
 *  Created by Ksdl
 *  2019-07-31 20:42
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "sys_department")
public class Department extends EzeBaseEntity {

    private static final long serialVersionUID = 1L;
    // 父ID 上级部门
    private String parentId;
    // 排序值
    private BigDecimal sortOrder;
    // 是否启用 正常0 冻结1
    private Integer status;
    // 公司名称(部门名称)
    private String deptName;
    // 全称
    private String fullName;
    // 层级
    private Integer level;

    @TableField(exist = false)
    private List<Department> children;
}
