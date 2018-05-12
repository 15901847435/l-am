package com.example.admin.modular;

import lombok.Data;

import java.util.List;

/**
 * Create by gutongwei
 * 2018/4/27
 */
@Data
public class MenuModel {

    public MenuModel() {
    }

    public MenuModel(String title, String icon, String href) {
        this.title = title;
        this.icon = icon;
        this.href = href;
    }

    private String title;

    private String icon;

    private String href;

    private boolean spread;

    private List<MenuModel> children;

}
