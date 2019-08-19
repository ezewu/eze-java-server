package org.eze.web.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import org.eze.web.base.EzeBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

/*
 * Created by Ksdl
 * 2019-04-19 20:50
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "sys_menu_resource")
public class MenuResource extends EzeBaseEntity {

    private static final long serialVersionUID = 1L;
    // 菜单ID
    @NotBlank(message = "菜单ID不能为空")
    private String menuId;
    // 资源编号
    @NotBlank(message = "资源编号不能为空")
    private String code;
    // 资源名称
    @NotBlank(message = "资源名称不能为空")
    private String menuResourceName;
    // 资源请求方式
    @NotBlank(message = "资源请求方式不能为空")
    private String method;
    // 资源请求路径
    @NotBlank(message = "资源请求路径不能为空")
    private String path;
}
