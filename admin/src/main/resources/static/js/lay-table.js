(function () {
    var $layTable = function (table, elem, url, cols) {
        this.table = table;
        this.tableParam = {};
        this.tableParam.elem = elem;
        this.tableParam.url = url;
        this.tableParam.cols = cols;
    }

    $layTable.prototype = {
        /**
         * 加载table
         * @returns {$layTable}
         */
        init: function () {
            this.table.render({
                elem: "#" + this.tableParam.elem
                , url: this.tableParam.url
                , cols: [this.tableParam.cols]
                , page: true
            });
            return this;
        },
        /**
         * 加载表单插件按钮
         */
        initTool: function (tool) {
            //监听工具条
            this.table.on("tool(" + this.tableParam.elem + ")", function (obj) {
                var data = obj.data;
                for (var name in tool) {
                    if (name === obj.event) {
                        tool[name](obj, data);
                    }
                }
            });
            return this;
        },
        /**
         * 获取选择数据
         */
        getSelectData: function () {
            return this.table.checkStatus(this.tableParam.elem).data;
        },
        /**
         * 获取选择数据数量
         */
        getSelectLength: function () {
            return this.getSelectData(this.tableParam.elem).length;
        },
        /**
         * 是否全选
         * @returns {*}
         */
        isSelectAll: function () {
            var checkStatus = this.table.checkStatus(this.tableParam.elem);
            return checkStatus.isAll;
        },
        /**
         * 重新加载
         */
        reload: function (parameter) {
            this.table.reload(this.tableParam.elem, {
                page: {curr: 1}
                , where: parameter
            });
        }
    }


    window.$layTable = $layTable;
}());


