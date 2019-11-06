layui.use(['table', 'laypage','jquery'], function(){
    var table = layui.table;
    var laypage = layui.laypage;
    var $ = layui.$;
    //第一个实例
    table.render({
        elem: '#readType'
        ,height: 400
        ,url: '/readerType/queryReaderType' //数据接口
        ,page: true //开启分页
        ,toolbar: 'default'
//            ,page: {
//                layout: ['limit', 'count', 'prev', 'page', 'next', 'skip']
//                , curr: 1
//                , groups: 6
//                , limit: 10
//            }
        ,cols: [[ //表头
            {type: 'checkbox', width:'5%',fixed: 'left'}
            ,{title: '序号', width:'5%', type: 'numbers', fixed: 'left'}
            ,{field: 'id',title: 'ID', align:'center',style:'text-align:left',width:'10%', sort: true}
            ,{field: 'name', title: '类型名称', align:'center',style:'text-align:left',width:'60%'}
            ,{field: 'number', title: '可借数量', align:'center',style:'text-align:left', width:'20%'}
        ]]
    });

    //绑定搜索按钮
    $("#btn_search").click(function () {
        var typeName=$("#name").val();
        //表格重载
        table.reload('readType',{
            where:{
                typeName:typeName
            }
            ,page: {
                curr: 1 //重新从第 1 页开始
            }
        });
    });

    //重置
    $("#btn_reset").click(function () {
        $("#name").val('');
    });

    //监听头工具栏事件
    table.on('toolbar(readType_toolbar)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id)
            ,data = checkStatus.data; //获取选中的数据
        switch(obj.event){
            case 'add':
                add();
                break;
            case 'update':
                if(data.length === 0){
                    layer.msg('请选择一行');
                } else if(data.length > 1){
                    layer.msg('只能同时编辑一个');
                } else {
                    var id=checkStatus.data[0].id;
                    var name=checkStatus.data[0].name;
                    var number=checkStatus.data[0].number;
                    edit(id,name,number);
                }
                break;
            case 'delete':
                if(data.length === 0){
                    layer.msg('请选择一行');
                } else {
                    layer.confirm('确定删除吗？', {
                        btn: ['确定','取消'] //按钮
                    }, function(index){
                        var res=checkStatus.data;
                        del(res);
                    }, function(){
                        //取消事件
                    });
                }
                break;
        };
    });

    //添加
    function add() {
        //页面层
        layer.open({
            type: 2,
            anim: 1,
            resize: false,
            offset: '100px',
            title: '类型添加',
            area: ['465px', '250px'],
            fix: false,
            content: 'dzlxgl_add.html'
        });
    }

    //编辑
    function edit(id, name, number) {
        //页面层
        layer.open({
            type: 2,
            anim: 1,
            resize: false,
            offset: '100px',
            title: '类型修改',
            area: ['465px', '250px'],
            // btn: ['确认', '取消'],
            fix: false,
            content: 'dzlxgl_update.html',
            success: function (layero, index) {
                var iframeWin = window[layero.find('iframe')[0]['name']];
                //调用子页面方法
                iframeWin.init(id, name, number);
            }
        });
    }

    /**
     * 删除
     * @param res
     */
    function del(res) {
        var ids = [];
        for (var i = 0; i < res.length; i++) {
            ids.push(res[i].id);
        }

        $.ajax({
            url: "/readerType/save_del",
            data: {"ids": ids.join(",")},
            type: "post",
            success: function (res) {
                if (res.status == 200) {
                    layer.alert("操作成功！",{icon: 1}, function () {
                        //刷新表格
                        window.location.reload();
                    });
                } else {
                    layer.alert(res.msg,{icon: 5});
                }
            },
            error: function () {
                layer.alert("操作失败！",{icon: 5});
            }
        });
    }
});