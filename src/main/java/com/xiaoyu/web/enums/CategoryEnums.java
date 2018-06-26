package com.xiaoyu.web.enums;

/**
 * @program: rry
 * @description:
 * @author: XiaoYu
 * @create: 2018-03-26 17:01
 **/
public enum CategoryEnums {

    USER("001","用户分类"),
    MODULE("002","底部模块分类"),
    VIP("003","VIP"),
    NULL_VIP("003000","非vip"),
    NORMAL_VIP("003001","普通vip"),
    SUPER_VIP("003002","超级vip"),
    TRIAL_VIP("003003","试用vip"),
    PROPORTION("004000","抽取比例"),
    PROMOTION("005","课程/专栏推广");

    String code;

    String message;

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    CategoryEnums(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
