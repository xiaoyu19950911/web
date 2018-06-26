package com.xiaoyu.web.response;

import lombok.Data;

/**
 * @program: web
 * @description:
 * @author: XiaoYu
 * @create: 2018-04-16 11:29
 **/
@Data
public class Oauth2 {

    private String access_token;

    private String token_type;

    private String refresh_token;

    private Long expires_in;

    private String scope;
}
