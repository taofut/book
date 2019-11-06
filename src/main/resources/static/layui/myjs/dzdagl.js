layui.use(['table', 'laypage','jquery'], function(){
    var table = layui.table;
    var $ = layui.$;
    //第一个实例
    table.render({
        elem: '#readInfo'
        ,height: 400
        ,url: '/book/readerInfo/queryReaderInfo' //数据接口
        ,page: true //开启分页
        ,toolbar: 'default'
        ,cols: [[ //表头
            {type: 'checkbox', width:'5%',fixed: 'left'}
            ,{title: '序号', width:'5%', type: 'numbers', fixed: 'left'}
            ,{field: 'barcode',title: '条形码', align:'center',style:'text-align:left',width:'15%'}
            ,{field: 'name', title: '姓名', align:'center',style:'text-align:left',width:'10%'}
            ,{field: 'typeName', title: '读者类型', align:'center',style:'text-align:left', width:'10%'}
            // ,{field: 'paperType', title: '证件类型', align:'center',style:'text-align:left', width:'10%'}
            ,{field: 'paperNO', title: '证件号码', align:'center',style:'text-align:left', width:'15%'}
            ,{field: 'tel', title: '电话', align:'center',style:'text-align:left', width:'15%'}
            ,{field: 'email', title: 'Email', align:'center',style:'text-align:left', width:'15%'}
            ,{field: 'createTime', title: '创建时间', align:'center',style:'text-align:left', width:'10%'}
        ]]
    });

    //绑定搜索按钮
    $("#btn_search").click(function () {
        var readName = $("#name").val();
        var barcode = $("#barcode").val();
        var paperNO = $("#paperNO").val();
        //表格重载
        table.reload('readInfo', {
            where: {
                readName: readName,
                barcode: barcode,
                paperNO: paperNO
            }
            , page: {
                curr: 1 //重新从第 1 页开始
            }
        });
    });

    //重置
    $("#btn_reset").click(function () {
        $("#name").val('');
        $("#barcode").val('');
        $("#paperNO").val('');
    });

    //监听头工具栏事件
    table.on('toolbar(readInfo_toolbar)', function(obj){
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
            offset: 't',
            title: '档案添加',
            area: ['1030px', '420px'],
            fix: false,
            content: 'dzdagl_add.html'
        });
    }

});

//js获取项目根路径，如： http://localhost:8080/index/index.html
// function getRootPath(){
//     var curWwwPath=window.document.location.href;
//     var pathName=window.document.location.pathname;
//     var pos=curWwwPath.indexOf(pathName);
//     //获取主机地址，如： http://localhost:7070
//     var localhostPaht=curWwwPath.substring(0,pos);
//     return localhostPaht;
//     //alert(localhostPaht);
//
// }
