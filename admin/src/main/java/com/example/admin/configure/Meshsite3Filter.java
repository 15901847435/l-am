package com.example.admin.configure;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;
import org.springframework.stereotype.Component;

/**
 * Meshsite3配置
 * Create by gutongwei
 * 2018/4/23
 */
@Component
public class Meshsite3Filter extends ConfigurableSiteMeshFilter {


    @Override
    protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
        builder.addDecoratorPath("/*", "/decorator")//拦截规则
                .addExcludedPath("/static/**").
                addExcludedPath("/index").//首页
                addExcludedPath("/login").//登录页
                addExcludedPath("/main").//登录页
                addExcludedPath("");//首页
    }
}
