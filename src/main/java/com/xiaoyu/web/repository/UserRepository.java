package com.xiaoyu.web.repository;

import com.xiaoyu.web.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: xiaoyu
 * @Descripstion:
 * @Date:Created in 2018/2/23 11:00
 * @Modified By:
 */
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUsername(String username);
}
