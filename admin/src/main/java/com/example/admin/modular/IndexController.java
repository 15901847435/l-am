package com.example.admin.modular;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页
 * Create by gutongwei
 * 2018/4/23
 */
@Controller
@RequestMapping("")
public class IndexController extends BaseController {

    /**
     * 登录页面
     *
     * @return
     */
    @RequestMapping(value = {"", "/login"})
    public String login() {
        return "login";
    }


    /**
     * 登录
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/loginByUserName", method = RequestMethod.POST)
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password) {
        if ("admin".equals(username) && "123".equals(password)) {
            return REDIRECT + "index";
        }
        return REDIRECT + "login";
    }

    /**
     * 管理框架页面
     *
     * @return
     */
    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    /**
     * 首页
     *
     * @return
     */
    @RequestMapping("/main")
    public String main() {
        return "main";
    }

    /**
     * 获取菜单
     *
     * @return
     */
    @RequestMapping("/getMenus")
    @ResponseBody
    public Object getMenus() {
        //TODO 填充菜单
        List<MenuModel> menus = new ArrayList<>();
        MenuModel wenti = new MenuModel("Demo管理", "fa-flag", "javascript:;");
        List<MenuModel> wentiSmall = new ArrayList<>();
        wentiSmall.add(new MenuModel("表格查询", "fa-flag", "/demo/list"));
        wentiSmall.add(new MenuModel("表单添加", "fa-flag", "/demo/add"));
        wenti.setChildren(wentiSmall);

        MenuModel baidu = new MenuModel("百度", "fa-flag", "javascript:;");
        List<MenuModel> baiduSmall = new ArrayList<>();
        baiduSmall.add(new MenuModel("百度正文", "fa-flag", "http://www.baidu.com"));
        baiduSmall.add(new MenuModel("百度图片", "fa-flag", "http://image.baidu.com"));
        baiduSmall.add(new MenuModel("百度运", "fa-flag", "https://cloud.baidu.com/index.html?track=cp:npinzhuan|pf:pc|pp:left|ci:|pu:495"));
        baidu.setChildren(baiduSmall);

        menus.add(baidu);
        menus.add(wenti);
        return menus;
    }


    /**
     * 获取siteMesh的layout页面模板
     * 请勿修改删除
     *
     * @return
     */
    @RequestMapping("decorator")
    public String defaultDecorator() {
        return "layout/_layout";
    }
}
