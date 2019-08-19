package org.eze.web.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import org.eze.web.base.EzeBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

/*
 * Created by Ksdl
 * 2019-04-19 20:45
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "sys_role")
public class Role extends EzeBaseEntity {

    private static final long serialVersionUID = 1L;
    // 记录ID
    private String recordId;
    // 角色名称
    @NotBlank(message = "角色名称不能为空")
    private String roleName;
    // 排序值
    private BigDecimal sortOrder;
    // 备注
    private String memo;
}
