function analysisUrl(url){
    $.post("/reptile/analysisUrl.shtm",{url:url},function(data){
        var area = document.getElementById("textarea");
        //area.setAttribute("rows",1);
        //area.setAttribute("cols",1);
        area.innerText = data;
    });
}