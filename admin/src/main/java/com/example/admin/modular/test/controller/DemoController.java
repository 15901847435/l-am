package com.example.admin.modular.test.controller;

import com.example.admin.configure.basics.BaseController;
import com.example.admin.modular.test.model.TestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by gutongwei
 * 2018/4/23
 */
@RequestMapping("demo")
@Controller
public class DemoController extends BaseController {


    @RequestMapping("/index")
    public String index() {
        return "index";
    }


    @RequestMapping("/add")
    public String add() {
        return "test/add";
    }

    @RequestMapping("/list")
    public String questionList() {
        return "test/list";
    }

    @RequestMapping("/ue")
    public String ue() {
        return "test/ue";
    }

    @RequestMapping("/getQuestionList")
    @ResponseBody
    public Object getQuestionList(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        List<TestModel> result = new ArrayList<>();
        for (int i = 0; i < limit; i++) {
            result.add(new TestModel());
        }
        return successTable(100, result);
    }

}
