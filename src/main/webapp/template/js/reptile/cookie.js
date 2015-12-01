//读取cookie,当指定查找的cookie不存在时返回undefined
function getCookie(name){
    var cookies=document.cookie.split(";");
    for(var i=0,length=cookies.length;i<length;i++){
        var s=cookies[i].split("=");
        if(s[0]==name)return s[1];
    }
}

//设置cookie
function setCookie(name,value,expireTime,path,secure){
    document.cookie=name+"="+value+";"+(expireTime?"expires="+expireTime.toUTCString()+";":"")+
        (path?"path="+path+";":"")+(secure?"secure="+secure+";":"");
}
