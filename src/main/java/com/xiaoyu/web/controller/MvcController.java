package com.xiaoyu.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

/**
 * @program: web
 * @description:
 * @author: XiaoYu
 * @create: 2018-04-16 17:03
 **/
@Controller
public class MvcController {

    @GetMapping("/redirect/{url}")
    public ModelAndView getindex_v148b2(@PathVariable String url) {
        return new ModelAndView("hplus/" + url);
    }
}
