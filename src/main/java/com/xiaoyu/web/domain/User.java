package com.xiaoyu.web.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @Author: xiaoyu
 * @Descripstion:
 * @Date:Created in 2018/2/22 10:20
 * @Modified By:
 */
@Data
@Entity
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    private String password;

    private String email;

    private Date lastPassWordResetDate;

    private String remark;

    /**
     * CascadeType.REFRESH:级联刷新
     * fetch = FetchType.EAGER:关系类在主类加载的时候同时加载
     */
    @ManyToMany(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    private List<Role> roles;

}
