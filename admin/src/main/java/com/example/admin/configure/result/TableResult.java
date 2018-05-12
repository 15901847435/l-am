package com.example.admin.configure.result;

import lombok.Data;

import java.io.Serializable;

/**
 * Create by gutongwei
 * 2018/4/23
 */
@Data
public class TableResult implements Serializable {

    public TableResult() {
    }

    public TableResult(int code, int count, Object data, String msg) {
        this.code = code;
        this.count = count;
        this.data = data;
        this.msg = msg;
    }

    private int code;

    private int count;

    private Object data;

    private String msg;

}
