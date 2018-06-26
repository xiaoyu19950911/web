package com.xiaoyu.web.service;

import com.xiaoyu.web.request.RegistRequest;
import com.xiaoyu.web.utils.Result;

/**
 * @program: web
 * @description:
 * @author: XiaoYu
 * @create: 2018-04-12 11:45
 **/
public interface Userservice {
    Result register(RegistRequest request);
}
