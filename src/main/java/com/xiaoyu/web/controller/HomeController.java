package com.xiaoyu.web.controller;

import com.hero.fitness.utils.Result;
import com.hero.fitness.utils.ResultUtils;
import com.xiaoyu.web.response.LearnResourceResponse;
import com.xiaoyu.web.service.LearnResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @program: web
 * @description:
 * @author: XiaoYu
 * @create: 2018-04-08 19:39
 **/
@Controller
@RequestMapping("/learn")
public class HomeController {

    @Autowired
    LearnResourceService learnResourceService;


    @GetMapping("/querylearnresourcelist")
    public ModelAndView getLearnResourceList(@PageableDefault Pageable pageable) {
        LearnResourceResponse result = learnResourceService.queryLearnResourceList(pageable);
        ModelAndView modelAndView = new ModelAndView("template");
        modelAndView.addObject("learnList", result.getLearnResourceList());
        return modelAndView;
    }

    public Result test1(){
        return ResultUtils.success();
    }

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "test";
    }

    @GetMapping("/touristsLogin")
    public ModelAndView getLearnResourceList() {
        ModelAndView modelAndView = new ModelAndView("hplus/index");
        modelAndView.addObject("nickname", "黄蓉");
        modelAndView.addObject("role", "游客");
        return modelAndView;
    }



    @GetMapping("/userLogin")
    public ModelAndView userLogin() {
        ModelAndView modelAndView = new ModelAndView("hplus/index");
        //Oauth2 oauth2 = learnResourceService.;
        modelAndView.addObject("nickname", "黄蓉");
        modelAndView.addObject("role", "游客");
        return modelAndView;
    }



}
