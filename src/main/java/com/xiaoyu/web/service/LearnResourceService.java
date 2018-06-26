package com.xiaoyu.web.service;

import com.xiaoyu.web.domain.User;
import com.xiaoyu.web.response.LearnResourceResponse;
import org.springframework.data.domain.Pageable;

/**
 * @program: web
 * @description:
 * @author: XiaoYu
 * @create: 2018-04-08 19:59
 **/
public interface LearnResourceService {
    LearnResourceResponse queryLearnResourceList(Pageable pageable);

    String login(User user);
}
