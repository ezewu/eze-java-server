package org.eze.web.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import org.eze.web.base.EzeBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/*
 * Created by Ksdl
 *  2019-04-25 20:03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "sys_user_role")
public class UserRole extends EzeBaseEntity {

    private static final long serialVersionUID = 1L;
    // 角色ID
    private String roleId;
    // 用户ID
    private String userId;

}
