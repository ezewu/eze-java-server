package org.eze.web.service.serviceimpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.eze.web.mapper.RoleMapper;
import org.eze.web.entity.Role;
import org.eze.web.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/*
 *  Created by Ksdl
 *  2019-08-05 22:11
 */
@Slf4j
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
}
