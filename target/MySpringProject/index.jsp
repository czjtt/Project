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
</head>
<body onload="document.f.j_username.focus();">
  welcome to home page.
  <br>
  <a href="/print.shtm">print page.</a>
  <br>
  <a href="/hello.htm">hello page.</a>
  <br>
  <a href="/vm.shtm">velocity_index page.</a>
  <br>
  <a href="/vm_hello.shtm">velocity_hello_index page.</a>
  <br/>
<h3>Login with username and password</h3>
<form name="f" method="post" action="/j_spring_security_check">
  <table>
    <tr>
      <td>User:</td>
      <td><input type="text" name="j_username" value=""></td>
    </tr>
    <tr>
      <td>Password:</td>
      <td><input type="password" name="j_password"></td>
    </tr>
    <tr><td colspan="2"><input name="submit" type="submit" ></td></tr>
    <tr><td colspan="2"><input name="reset" type="reset"></td></tr>
  </table>
</form>

</body>
</html>
