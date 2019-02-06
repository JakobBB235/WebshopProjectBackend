package com.webshopproject.webshopprojectbackend.experiments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestBean {
    public String name;
    public String name2;

    @Autowired
    public TestBean(TestBean2 testBean2){
        this.name2 = testBean2.name;
    }
}
