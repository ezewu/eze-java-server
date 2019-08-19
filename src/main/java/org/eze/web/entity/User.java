package org.eze.web.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.eze.web.base.EzeBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/*
 * Created by Ksdl
 * 2019-04-20 18:16
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "sys_user")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User extends EzeBaseEntity {

    private static final long serialVersionUID = 1L;

    // 记录 ID
    private String recordId;
    // 用户名
    @NotBlank(message = "用户名不能为空")
    private String username;
    // 密码
    @NotBlank(message = "密码不能为空")
    private String password;
    // 真实姓名
    @NotBlank(message = "姓名不能为空")
    private String realName;
    // 邮箱
    private String email;
    // 手机号
    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp = "^[1][3-9][0-9]{9}$", message = "手机号格式有误")
    private String phone;
    // 状态 正常0 冻结1
    private Integer status;
    // 头像
    private String avatar;
    // 所属于公司 所属公司ID
    private String departmentId;
}
