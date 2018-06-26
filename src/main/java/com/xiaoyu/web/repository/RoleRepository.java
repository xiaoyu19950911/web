package com.xiaoyu.web.repository;

import com.xiaoyu.web.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: web
 * @description:
 * @author: XiaoYu
 * @create: 2018-04-12 19:31
 **/
public interface RoleRepository extends JpaRepository<Role,Integer>  {

    Role findFirstByRoleName(String name);
}
