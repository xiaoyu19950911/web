package com.xiaoyu.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebApplicationTests {

    @Test
    public void contextLoads() {
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        String s=encoder.encode("123456");
        System.out.println(s);
    }

}
