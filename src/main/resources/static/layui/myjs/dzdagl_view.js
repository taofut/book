function init(formData) {
    layui.use(['form','laydate','jquery'], function(){
        var form = layui.form;
        var $ = layui.$;
        var laydate = layui.laydate;

        //初始化表单值
        form.val('dzdaglUpdateForm', {
            "id": formData.id
            ,"barcode": formData.barcode
            ,"name": formData.name
            ,"sex": formData.sex
            ,"tel": formData.tel
            ,"paperno": formData.paperno
            ,"birthday": formData.birthday
            ,"typeid": formData.typeid
            ,"email": formData.email
            ,"remark": formData.remark
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
                $('#typeid').val(formData.typeid);
                form.render();//菜单渲染 把内容加载进去
            }
        });

    });


}

