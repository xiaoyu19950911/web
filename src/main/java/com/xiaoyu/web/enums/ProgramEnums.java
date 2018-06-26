package com.xiaoyu.web.enums;

/**
 * @program: rry
 * @description:
 * @author: XiaoYu
 * @create: 2018-04-08 11:37
 **/
public enum ProgramEnums {
    STATUS_USING(1, "正在使用"),
    STATUS_DISABLED(0, "已停用"),
    STATUS_CERTIFIED(2, "已认证"),
    CLASS_SOON(0, "即将开课"),
    CLASS_PAST(1, "往期课程"),
    PLAY_LIVE(0, "直播"),
    PLAY_RECORD(1, "录播");

    Integer code;

    String message;

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    ProgramEnums(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
