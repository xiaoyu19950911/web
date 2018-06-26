package com.xiaoyu.web.security.transition;

import com.xiaoyu.web.convert.UserConvert;
import com.xiaoyu.web.domain.User;
import com.xiaoyu.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @program: web
 * @description:
 * @author: XiaoYu
 * @create: 2018-04-13 10:50
 **/
public class TransitionUserServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.findByUsername(username);
        if (user==null){
            throw new UsernameNotFoundException("用户名不存在！");
        }
        return UserConvert.UserToTransitionUser(user);
    }
}
