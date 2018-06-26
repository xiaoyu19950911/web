package com.xiaoyu.web.security.auth;

import com.xiaoyu.web.domain.Role;
import com.xiaoyu.web.domain.User;
import com.xiaoyu.web.enums.ResultEnums;
import com.xiaoyu.web.repository.RoleRepository;
import com.xiaoyu.web.repository.UserRepository;
import com.xiaoyu.web.request.RegistRequest;
import com.xiaoyu.web.utils.Result;
import com.xiaoyu.web.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: web
 * @description:
 * @author: XiaoYu
 * @create: 2018-04-13 11:20
 **/
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    @Transactional
    public Result register(RegistRequest request) {
        User user = new User();
        request.setRoleList(Arrays.asList("user"));
        User user1=userRepository.findByUsername(request.getUsername());
        if (user1!=null){
            return ResultUtils.error(ResultEnums.USERNAME_EXIT);
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = request.getPassword();
        request.setPassword(encoder.encode(rawPassword));
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        List<Role> roleList = request.getRoleList().stream().map(name -> {
            Role role;
            role = roleRepository.findFirstByRoleName(name);
            if (role == null) {
                role = new Role();
                role.setRoleName(name);
            }
            return role;
        }).collect(Collectors.toList());
        user.setRoles(roleList);
        user.setRemark(request.getRemark());
        userRepository.save(user);
        return ResultUtils.success();
    }
}
