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
                        var index = parent.layer.getFrameIndex(window.name);
                        parent.layer.close(index);//关闭当前页
                    });
                }
            }
        });
        return false;
    });
});