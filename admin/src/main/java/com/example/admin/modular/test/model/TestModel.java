package com.example.admin.modular.test.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Random;

/**
 * Create by gutongwei
 * 2018/4/23
 */

@Data
public class TestModel implements Serializable {

    public TestModel() {
        int id=new Random().nextInt();
        this.id=id;
        this.username="userName"+id;
        this.sex="sex"+id;
        this.city="city"+id;
        this.sign="sign"+id;
        this.experience=id;
        this.score=id;
        this.wealth=id;
        this.classify="zhiye"+id;

    }


    private int id;

    private String username;

    private String sex;

    private String city;

    private String sign;

    private  int experience;
    private  int score;
    private  int wealth;
    private  String classify;


}
