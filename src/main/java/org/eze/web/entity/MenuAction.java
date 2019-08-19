package org.eze.web.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import org.eze.web.base.EzeBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

/*
 * Created by Ksdl
 *  2019-04-30 19:51
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "sys_menu_action")
public class MenuAction extends EzeBaseEntity {

    private static final long serialVersionUID = 1L;
    // 菜单ID
    @NotBlank(message = "菜单ID不能为空")
    private String menuId;
    // 动作编号
    @NotBlank(message = "动作编号不能为空")
    private String code;
    // 动作名称
    @NotBlank(message = "动作编号名称不能为空")
    private String name;
}
