<%--
  Created by IntelliJ IDEA.
  User: XX
  Date: 2022/12/1
  Time: 23:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>添加账户信息表单</h2>
<form name="accountForm" action="${pageContext.request.contextPath}/account/save" method="post">
    账户信息：<input type="text" name="name"><br>
    账户金额：<input type="text" name="money"><br>
    <input type="submit" value="提交"><br>
</form>
</body>
</html>
