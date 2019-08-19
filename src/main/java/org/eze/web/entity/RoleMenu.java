package org.eze.web.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import org.eze.web.base.EzeBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/*
 * Created by Ksdl
 *  2019-04-25 19:56
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "sys_role_menu")
public class RoleMenu extends EzeBaseEntity {

    private static final long serialVersionUID = 1L;
    // 菜单表ID
    private String menuId;
    // 角色表ID
    private String roleId;
    // 动作编号（多个以英文逗号分隔）
    private String action;
    // 资源编号（多个以英文逗号分隔）
    private String resource;
}
