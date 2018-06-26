package com.xiaoyu.web.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @Author: xiaoyu
 * @Descripstion:
 * @Date:Created in 2018/2/22 10:29
 * @Modified By:
 */
@Data
@Entity
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    private String roleName;

    public Role(String roleName) {
        this.roleName = roleName;
    }
}
