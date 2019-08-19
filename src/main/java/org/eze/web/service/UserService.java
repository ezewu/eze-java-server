package org.eze.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.eze.web.entity.User;

/*
 * Created by Ksdl
 *  2019-04-25 20:23
 */
public interface UserService extends IService<User> {
    boolean submit(User user);
}
