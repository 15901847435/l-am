(function () {
    var $ax = function (url, success, error) {
        this.url = url;
        this.type = "post";
        this.data = {};
        this.dataType = "json";
        this.async = false;
        this.success = success;
        this.error = error;
        this.loadingFlag = false;
        this.contentType = "application/x-www-form-urlencoded";
    };

    $ax.prototype = {
        /**
         * ajax 提交
         */
        start: function () {
            var me = this;
            var index = null;
            if (typeof(layer) != "undefined" && this.loadingFlag && this.async) {
                index = layer.load(1, {shade: [0.1, '#fff'], shadeClose: false});
            }
            $.ajax({
                type: this.type,
                url: this.url,
                dataType: this.dataType,
                async: this.async,
                data: this.data,
                contentType: this.contentType,
                success: function (data) {
                    me.success(data);
                },
                error: function (data) {
                    me.error(data);
                },
                complete: function () {
                    if (index != null) {
                        layer.close(index);
                    }
                }
            });
        },
        /**
         * 显示loading并提交
         */
        startWithLoading: function () {
            this.loadingFlag = true;
            this.async = true;
            this.start();
        },
        /**
         * 修改参数
         * @param data
         * @returns {$ax}
         */
        setData: function (data) {
            this.data = data;
            return this;
        },
        /**
         * 清除数据
         * @returns {$ax}
         */
        clear: function () {
            this.data = {};
            return this;
        },
        /**
         * 设置同步异步
         * @param async
         * @returns {$ax}
         */
        setAsync: function (async) {
            this.async = async;
            return this;
        },
        /**
         * 修改为GET
         * @returns {$ax}
         */
        setGet: function () {
            this.type = "GET";
            return this;
        },
        /**
         * 修改为POST
         * @returns {$ax}
         */
        setPost: function () {
            this.type = "POST";
            return this;
        },
        /**
         * 修改setContentType
         * @param contentType
         * @returns {$ax}
         */
        setContentType: function (contentType) {
            this.contentType = contentType;
            return this;
        }
    };

    window.$ax = $ax;

}());