layui.use(['form','laydate', 'jquery'], function () {
    var form = layui.form;
    var $ = layui.$;
    var laydate = layui.laydate;
    //监听提交
    form.on('submit(save_add)', function (data) {
        var json = JSON.stringify(data.field);
        $.ajax({
            url: "/book/readerInfo/save_add",
            data: {"json": json},
            type: "post",
            success: function (res) {
                if (res.status == 200) {
                    layer.alert("操作成功！", {icon: 1},function () {
                        //关闭窗口
                        layer.close(layer.index);
                        //刷新表格
                        window.parent.location.reload();
                    });
                } else {
                    layer.alert(res.msg,{icon: 5});
                }
            },
            error: function () {
                layer.alert("操作失败！",{icon: 5});
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
    };

    //执行一个laydate实例
    laydate.render({
        elem: '#birthday' //指定元素
    });

    //初始化读者类型-下拉菜单
    $.ajax({
        url:'/book/readerInfo/reader_type',
        dataType:'json',
        type:'post',
        success:function(data){
            $.each(data,function(index,item){
                $('#typeid').append(new Option(item.name,item.id));//往下拉菜单里添加元素
            });
            form.render();//菜单渲染 把内容加载进去
        }
    })

});
