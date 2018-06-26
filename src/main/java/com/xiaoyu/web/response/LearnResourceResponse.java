package com.xiaoyu.web.response;

import com.xiaoyu.web.domain.LearnResource;
import lombok.Data;

import java.util.List;

/**
 * @program: web
 * @description:
 * @author: XiaoYu
 * @create: 2018-04-08 19:55
 **/
@Data
public class LearnResourceResponse {

    private Integer page;

    private Integer totalPages;

    private List<LearnResource> learnResourceList;
}
