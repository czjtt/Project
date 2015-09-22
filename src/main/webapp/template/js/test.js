/**
 * Created by NS on 2015/9/16.
 */

//$(document).ready(function () {
//
//});

function finduser(value){
    $.post("/test/print.shtm",{userId:value},function(user){
        $("#print1").val(user[0].realname + ":print1");
        $("#print2").html(user[0].toString() + ":print2");
        $("#print3").html(user[0].password + ":print3");
    })
}