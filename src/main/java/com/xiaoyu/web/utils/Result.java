package com.xiaoyu.web.utils;

import lombok.Data;

/**
 * @Author: xiaoyu
 * @Descripstion:
 * @Date:Created in 2018/2/1 13:48
 * @Modified By:
 */
@Data
public class Result<T> {
    private Integer code;

    private String msg;

    private T result;
}
