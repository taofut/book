function init(id,name,number) {
    layui.use(['form','jquery'], function(){
        var form = layui.form;
        var $ = layui.$;
        $("#typeId").val(id);
        $("#typeName").val(name);
        $("#number").val(number);

        //保存
        form.on('submit(save_update)', function(data){
            var json=JSON.stringify(data.field);
            $.ajax({
                url: "/book/readerType/save_update",
                data: {"json":json},
                type: "post",
                success: function (res) {
                    if (res.status == 200) {
                        layer.alert("操作成功！",{icon: 1}, function () {
                            //关闭窗口
                            layer.close(layer.index);
                            //刷新表格
                            window.parent.location.reload();
                        });
                    }else{
                        layer.alert(res.msg,{icon: 5});
                    }
                },
                error:function () {
                    layer.alert("操作失败！",{icon: 5});
                }
            });
            return false;
        });

        //关闭
        $("#close").click(function () {
            //当你在iframe页面关闭自身时
            var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
            parent.layer.close(index); //再执行关闭
        });

        //禁用回车事件
        document.onkeydown = function (ev) {
            var event = ev || event;
            if (event.keyCode == 13) {
                return false;
            }
        }
    });


}

