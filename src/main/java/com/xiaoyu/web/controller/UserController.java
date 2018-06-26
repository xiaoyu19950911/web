package com.xiaoyu.web.controller;

import com.xiaoyu.web.request.RegistRequest;
import com.xiaoyu.web.service.Userservice;
import com.xiaoyu.web.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @program: web
 * @description:
 * @author: XiaoYu
 * @create: 2018-04-11 09:52
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    Userservice userservice;

    @PostMapping("/regist")
    public Result register(@Valid @RequestBody RegistRequest request, BindingResult bindingResult) throws AuthenticationException {
        return userservice.register(request);
    }
}
