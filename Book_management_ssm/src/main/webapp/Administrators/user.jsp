<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户管理</title>
    <link rel="stylesheet" type="text/css" href="css/index-css.css">
</head>
<body>
<div class="header">
    <h1>图书后台管理</h1>
    <p>藏书阁</p>
</div>


<div class="left">
    <ul>
        <li><a href="${pageContext.request.contextPath}/admin/index">图书管理</a></li>
        <li><a href="${pageContext.request.contextPath}/admin/addBook">图书上架</a></li>
        <li class="main"><a href="${pageContext.request.contextPath}/admin/userManagement">用户管理</a></li>
        <li><a href="${pageContext.request.contextPath}/user/login">退出登录</a></li>
    </ul>
</div>


<div class="tab">
    <table border="1" cellspacing="0">
        <tr class="tab-header">
            <td class="id">编号</td>
            <td class="name">账号</td>
            <td class="classly">密码</td>
<%--            <td class="classly">修改密码的账号</td>--%>
            <td class="classly">修改密码的新密码</td>
            <td class="classly">是否修改密码</td>
<%--            <td class="classly">删除账户的名称</td>--%>
            <td class="operating">是否删除账号</td>
        </tr>
        <c:forEach items="${userList}" var="user" varStatus="u">
            <tr>
                <td>${u.count}</td>
                <td>${user.username}</td>
                <td>${user.password}</td>
                <form action="${pageContext.request.contextPath}/admin/changePassword">
                    <input type="hidden" name="username" value=${user.username} readonly="readonly">
                    <td><input type="text" name="new_password" value=${user.password}></td>
                    <td><input type="submit" value="修改"></td>
                </form>
                <form action="${pageContext.request.contextPath}/admin/deleteUser">
                    <input type="hidden" name="username" value=${user.username} readonly="readonly">
                    <td><input type="submit" value="删除"></td>
                </form>
<%--                <td>--%>
<%--                    <a href="${pageContext.request.contextPath}/returnUserServlet?id=${users.id}&username=${users.username}&password=${users.password}">--%>
<%--                        <span class="iconfont">&#xe619;</span>--%>
<%--                    </a>--%>
<%--                    <a href="${pageContext.request.contextPath}/deleteUserServlet?id=${users.id}">--%>
<%--                        <span class="iconfont">&#xe852;</span>--%>
<%--                    </a>--%>
<%--                </td>--%>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>