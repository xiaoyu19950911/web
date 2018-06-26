package com.xiaoyu.web.enums;

/**
 * @Author: xiaoyu
 * @Descripstion:
 * @Date:Created in 2018/2/1 14:58
 * @Modified By:
 */
public enum ResultEnums {

    UNKNOW_ERROR(-1,"未知错误!"),
    SUCCESS(101,"成功!"),
    PARAMETERS_ERROR(102,"参数错误!"),
    EXCEPTION_ERROR(103,"内部异常!"),
    NO_PERMISSION(104,"权限不足"),
    USERNAME_NULL(105,"用户名不能为空！"),
    USERNAME_EXIT(106,"用户名已存在！"),
    WX_USER_ERROR(107,"未绑定微信账号！"),
    AMOUNT_ERROR(108,"提现金额超出限制！")
    ;

    private Integer code;

    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    ResultEnums(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}

