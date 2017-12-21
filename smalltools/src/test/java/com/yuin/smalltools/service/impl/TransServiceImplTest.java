package com.yuin.smalltools.service.impl;



import com.yuin.smalltools.service.TransService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class) // SpringJUnit支持，由此引入Spring-Test框架支持！
@SpringBootTest
public class TransServiceImplTest {

    @Autowired
    TransService transService;
    @Test
    public void sendUrl() throws Exception {
       String[] urls =  transService.sendUrl(  "https://www.youtube.com/watch?v=auVqxpwHkVs");
       for (String s : urls)
       System.out.println(s);
    }

}