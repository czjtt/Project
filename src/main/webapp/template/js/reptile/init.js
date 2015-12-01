$(document).ready(function(){
    var temp;
    if(getCookie("num")==null || getCookie("num")=="undefined"){
        temp = 1
        setCookie("num",temp);
    }else{
        temp = parseInt(getCookie("num"))+1;
        setCookie("num",temp)
    }
    $("#count").val(temp);

    // 绑定keyword输入框中回车执行确定按钮
    $('#keyword').bind('keyup', function(event) {
        if (event.keyCode == "13") {
            //回车执行查询
            $('#submit').click();
        }
    });
});