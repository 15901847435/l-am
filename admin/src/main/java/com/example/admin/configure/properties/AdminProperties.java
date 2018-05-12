package com.example.admin.configure.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Create by gutongwei
 * 2018/4/26
 */
@Component
@ConfigurationProperties(prefix = "admin")
@Data
public class AdminProperties {

    private String fileUploadPath;

}
