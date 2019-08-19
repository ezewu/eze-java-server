package org.eze.config.mybatisplus;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/*
 *  Created by Ksdl
 *  2019-07-31 22:59
 */
@Component
public class MetaHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        // TODO 填充默认值
        setFieldValByName("createdAt", LocalDateTime.now(), metaObject);
        setFieldValByName("updatedAt", LocalDateTime.now(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        setFieldValByName("updatedAt", LocalDateTime.now(), metaObject);
    }
}
