package com.xiaoyu.web.service.impl;

import com.xiaoyu.web.repository.RoleRepository;
import com.xiaoyu.web.repository.UserRepository;
import com.xiaoyu.web.request.RegistRequest;
import com.xiaoyu.web.service.Userservice;
import com.xiaoyu.web.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: web
 * @description:
 * @author: XiaoYu
 * @create: 2018-04-12 11:46
 **/
@Service
public class UserserviceImpl implements Userservice {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public Result register(RegistRequest request) {
       return null;
    }
}
