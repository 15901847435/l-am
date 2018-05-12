package com.example.admin.configure.basics;

import com.example.admin.configure.result.TableResult;

/**
 * Create by gutongwei
 * 2018/4/23
 */
public class BaseController extends HttpController {


    /**
     * 返回table 数据结构
     *
     * @param data
     * @param count
     * @return
     */
    protected TableResult successTable(int count, Object data) {
        return new TableResult(0, count, data, null);
    }

    /**
     * 列表错误
     *
     * @return
     */
    protected TableResult errorTable() {
        return new TableResult(500, 0, null, "服务器异常");
    }
}
