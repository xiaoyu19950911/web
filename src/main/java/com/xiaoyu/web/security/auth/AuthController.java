package com.xiaoyu.web.security.auth;

import com.xiaoyu.web.domain.User;
import com.xiaoyu.web.request.RegistRequest;
import com.xiaoyu.web.service.LearnResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * @program: web
 * @description:
 * @author: XiaoYu
 * @create: 2018-04-13 11:18
 **/
@RequestMapping("/auth")
@Controller
public class AuthController {

    @Autowired
    AuthService authService;

    @Autowired
    LearnResourceService learnResourceService;

    @PostMapping("/regist")
    public ModelAndView register(@Valid RegistRequest request, BindingResult bindingResult) throws AuthenticationException {
        authService.register(request);
        ModelAndView modelAndView = new ModelAndView("hplus/validation");
        modelAndView.addObject("text","注册成功");
        return modelAndView;
    }

    @GetMapping("/login")
    public String login(User user) {
        return learnResourceService.login(user);
    }
}
