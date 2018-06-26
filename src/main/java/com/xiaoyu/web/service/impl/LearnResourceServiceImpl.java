package com.xiaoyu.web.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xiaoyu.web.domain.LearnResource;
import com.xiaoyu.web.domain.User;
import com.xiaoyu.web.repository.LearnResourceRepository;
import com.xiaoyu.web.response.LearnResourceResponse;
import com.xiaoyu.web.service.LearnResourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @program: web
 * @description:
 * @author: XiaoYu
 * @create: 2018-04-08 19:59
 **/
@Service
@Slf4j
public class LearnResourceServiceImpl implements LearnResourceService {

    @Autowired
    LearnResourceRepository learnResourceRepository;

    @Override
    public LearnResourceResponse queryLearnResourceList(Pageable pageable) {
        Page<LearnResource> learnResourcePage=learnResourceRepository.findAll(pageable);
        LearnResourceResponse result=new LearnResourceResponse();
        result.setTotalPages(learnResourcePage.getTotalPages());
        result.setPage(learnResourcePage.getNumber());
        result.setLearnResourceList(learnResourcePage.getContent());
        return result;
    }

    @Override
    public String login(User user) {
        String url="http://www.xiaoyuwlr.com/oauth/token?grant_type=password&scope=read&client_id=client_2&client_secret=123456&username="+(user.getUsername()!=null?user.getUsername():"tourists")+"&password="+(user.getPassword()!=null?user.getPassword():"123456");
        RestTemplate restTemplate = new RestTemplate();
        log.info(url);
        try {
            String str=restTemplate.getForObject(url,String.class);
            JSONObject jsonObject = JSON.parseObject(str);
            log.info("请求到的Access Token:{}", jsonObject.toJSONString());
            return "redirect:/learn/touristsLogin?access_token="+jsonObject.get("access_token");
        }catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
            return "redirect:/redirect/validation";
        }
        //System.out.println(str);
        // 通过https方式请求获得web_access_token
        //String response = HttpsUtil.httpsRequestToString("http://localhost/oauth/token?grant_type=password&scope=read&client_id=client_2&client_secret=123456&username="+user.getUsername()+"&password="+user.getPassword(),"post", null);
    }
}
