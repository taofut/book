layui.use(['form','jquery'], function(){
    var form = layui.form;
    var $ = layui.$;
    //监听提交
    form.on('submit(save)', function(data){
        var json=JSON.stringify(data.field);
        $.ajax({
            url: "/readerType/save",
            data: {"json":json},
            type: "post",
            success: function (res) {
                if (res.status == 200) {
                    layer.alert("操作成功！", function () {
                        //关闭窗口
                        layer.close(layer.index);
                        //刷新表格
                        window.parent.location.reload();
                    });
                }
                if(res.status == 500){
                    layer.alert();
                }
            }
        });
        return false;
    });
});