package com.xiaoyu.web.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class RegistRequest {


    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;

    private String remark;

    private List<String> roleList;
}
