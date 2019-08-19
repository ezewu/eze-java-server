package org.eze.web.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import org.eze.web.base.EzeBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import java.util.List;

/*
 *  Created by Ksdl
 *  2019-07-31 20:35
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "sys_menu")
public class Menu extends EzeBaseEntity {
    private static final long serialVersionUID = 1L;
    // 记录 ID
    private String recordId;
    // 菜单权限名称
    @NotBlank(message = "菜单name不能为空")
    private String name;
    // 前端组件地址
    private String component;
    // 页面路径 前端组件URL
    private String path;
    // 菜单标题
    @NotBlank(message = "菜单名称不能为空")
    private String title;
    // 菜单图标
    @NotBlank(message = "菜单图标不能为空")
    private String icon;
    // 排序值
    private Integer sortOrder;
    // 父ID 上级菜单ID
    private String parentId;
    // 层级
    private Integer level;
    // 是否禁用或启用 正常0 冻结1
    private Integer status;
    // 菜单为网页连接 是URL
    private String url;
    // 子菜单
    @TableField(exist = false)
    private List<Menu> children;
    // 页面拥有的权限集合
    @TableField(exist = false)
    private List<MenuResource> resources;
    // 页面动作权限集合
    @TableField(exist = false)
    private List<MenuAction> actions;
}
