<%--
  Created by IntelliJ IDEA.
  User: NS
  Date: 2015/9/28
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>reptile index page.</title>
    <script src="/template/js/jquery.min.js"></script>
    <script src="/template/js/jquery.js"></script>
    <script src="/template/js/reptile/cookie.js"></script>
    <script src="/template/js/reptile/analysis.js"></script>
    <script src="/template/js/reptile/init.js"></script>
</head>
<body>
<div>
  <input id="count" value=""/>
  <br/>
    <%--输入URL，点击确定开始分析--%>
  <span>
<input id="keyword" name="keyword" placeholder="请输入正确的URL（例如www.baidu.com）" style="width: 300px">
<input id="submit" type="button" value="确定" onclick="analysisUrl($('#keyword').val())">
    <br/>
  </span>
    <%--返回分析后的数据--%>
<textarea id="textarea" placeholder="hello,first textare." style="width:100%;height: 100%"></textarea>

</div>
</body>
</html>
