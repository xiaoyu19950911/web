package com.xiaoyu.web.security.auth;

import com.xiaoyu.web.request.RegistRequest;
import com.xiaoyu.web.utils.Result;

/**
 * @program: web
 * @description:
 * @author: XiaoYu
 * @create: 2018-04-13 11:19
 **/
public interface AuthService {
    Result register(RegistRequest request);
}
