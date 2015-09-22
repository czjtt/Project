<%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2015/7/23
  Time: 9:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>welcome</title>
  <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
  <script src="template/js/jquery.min.js"></script>
  <script src="template/js/jquery.js"></script>
  <script type="text/javascript" src="template/js/test.js"></script>
</head>
<body>
<%--<body onload="document.f.j_username.focus();">--%>
  welcome to home page.

  <br/>
  <a href="/hello/index.shtm">index.shtm</a>
  <br>
  <a href="/hello/print.shtm">print page.</a>
  <br>
  <a href="/hello/hello.htm">hello page.</a>
  <br>
  <a href="/hello/vm.shtm">velocity_index page.</a>
  <br>
  <a href="/hello/vm_hello.shtm">velocity_hello_index page.</a>
  <br/>
    <input id="test" name="test" value="6">
    <input type="submit" value="submit" onclick="finduser($('#test').val())">

<input id="print1" name="print1" type="text" />
<br/>
<input id="put1">
<br/>
<a id="print2"></a>
<br/>
<a id="print3"></a>

</body>
<%--<h3>Login with username and password</h3>--%>
<%--<form name="f" method="post" action="/j_spring_security_check">--%>
  <%--<table>--%>
    <%--<tr>--%>
      <%--<td>User:</td>--%>
      <%--<td><input type="text" name="j_username" value=""></td>--%>
    <%--</tr>--%>
    <%--<tr>--%>
      <%--<td>Password:</td>--%>
      <%--<td><input type="password" name="j_password"></td>--%>
    <%--</tr>--%>
    <%--<tr><td colspan="2"><input name="submit" type="submit" ></td></tr>--%>
    <%--<tr><td colspan="2"><input name="reset" type="reset"></td></tr>--%>
  <%--</table>--%>
<%--</form>--%>

<%--</body>--%>
</html>
