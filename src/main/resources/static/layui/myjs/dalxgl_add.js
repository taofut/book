layui.use(['form', 'jquery'], function () {
    var form = layui.form;
    var $ = layui.$;
    //监听提交
    form.on('submit(save_add)', function (data) {
        var json = JSON.stringify(data.field);
        $.ajax({
            url: "/readerType/save_add",
            data: {"json": json},
            type: "post",
            success: function (res) {
                if (res.status == 200) {
                    layer.alert("操作成功！", function () {
                        //关闭窗口
                        layer.close(layer.index);
                        //刷新表格
                        window.parent.location.reload();
                    });
                } else {
                    layer.alert(res.msg);
                }
            },
            error: function () {
                layer.alert("操作失败！");
            }
        });
        return false;
    });

    //禁用回车事件
    document.onkeydown = function (ev) {
        var event = ev || event;
        if (event.keyCode == 13) {
            return false;
        }
    }
});