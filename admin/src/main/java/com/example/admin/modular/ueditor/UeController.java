package com.example.admin.modular.ueditor;

import com.baidu.ueditor.ActionEnter;
import com.example.admin.configure.properties.AdminProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Create by gutongwei
 * 2018/4/26
 */
@Controller
public class UeController {

    @Autowired
    private AdminProperties adminProperties;

    @RequestMapping(value="/static/ueditor/config")
    public void config(HttpServletRequest request, HttpServletResponse response) {

        response.setContentType("application/json");
        String rootPath = request.getSession().getServletContext().getRealPath("/");
        System.out.println("ContextPath:" + request.getSession().getServletContext().getContextPath());
        try {
            String exec = new ActionEnter(request, "", adminProperties.getFileUploadPath()).exec();
            System.out.println("EXEC:" + exec);
            PrintWriter writer = response.getWriter();
            writer.write(exec);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
