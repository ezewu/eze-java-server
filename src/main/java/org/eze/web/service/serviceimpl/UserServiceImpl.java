package org.eze.web.service.serviceimpl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.eze.common.enums.ResultCode;
import org.eze.common.exception.GlobalException;
import org.eze.web.mapper.UserMapper;
import org.eze.web.entity.User;
import org.eze.web.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/*
 * Created by Ksdl
 *  2019-04-25 20:26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public boolean submit(User user) {
        // 加密 重设密码
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        int cnt = count(Wrappers.<User>query().lambda().eq(User::getUsername, user.getUsername()));
        if (cnt > 0) {
            throw new GlobalException(ResultCode.USER_ALREADY_EXISTS);
        }
        return save(user);
    }

//    @Override
//    public UserVO getUserDetail(String id) {
//        User user = baseMapper.selectOne(Wrappers.<User>query().lambda().eq(User::getId, id));
//        if (user == null) {
//            throw new GlobalException(ResultCode.NO_SUCH_USER);
//        }
//        UserVO userVO = new UserVO();
//        BeanUtils.copyProperties(user, userVO);
//        // TODO
//        userVO.setRoleName("总经理");
//        userVO.setDeptName("技术部");
//        return userVO;
//    }

}
