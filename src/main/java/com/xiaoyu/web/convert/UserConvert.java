package com.xiaoyu.web.convert;

import com.xiaoyu.web.security.transition.TransitionUser;
import com.xiaoyu.web.domain.Role;
import com.xiaoyu.web.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: web
 * @description:
 * @author: XiaoYu
 * @create: 2018-04-13 10:53
 **/
@Slf4j
public class UserConvert {

    public static TransitionUser UserToTransitionUser(User user){
        return new TransitionUser(user.getId().toString(),user.getUsername(),user.getPassword(),mapToGrantedAuthorities(user.getRoles()));
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Role> authorities) {
        authorities.forEach(a-> log.info("当前用户角色为"+a.getRoleName()));
        return authorities.stream()
                .map(e->new SimpleGrantedAuthority(e.getRoleName()))
                .collect(Collectors.toList());
    }
}
