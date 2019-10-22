function init(name,number) {
    layui.use('jquery', function(){
        var $ = layui.$;
        $("#typeName").val(name);
        $("#number").val(number);

        $("#btn_cancel").click(function () {
            alert(12);
        });
    });


}

