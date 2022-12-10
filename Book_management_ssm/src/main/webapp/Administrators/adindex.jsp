<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>图书后台管理</title>
    <link rel="stylesheet" href="css/index-css.css">
    <link rel="icon" href="img/logo.ico">
</head>
<body>
<div class="header">
    <h1>图书后台管理</h1>
    <p>藏书阁</p>
</div>

<div class="left">
    <ul>
        <li class="main"><a href="${pageContext.request.contextPath}/admin/index">图书管理</a></li>
        <li><a href="${pageContext.request.contextPath}/admin/addBook">图书上架</a></li>
        <li><a href="${pageContext.request.contextPath}/admin/userManagement">用户管理</a></li>
        <li><a href="${pageContext.request.contextPath}/user/login">退出登录</a></li>
    </ul>
</div>

<div class="top">
</div>

<div class="tab">
    <table border="1" cellspacing="0">
        <tr class="tab-header">
            <td class="id">编号</td>
            <td class="name">书名</td>
            <td class="price">价格</td>
            <td class="classly">分类</td>
            <td class="detail">详情及修改操作</td>
            <td>删除该书</td>
<%--            <td class="operating">操作</td>--%>
        </tr>
        <c:forEach items="${booksList}" var="books" varStatus="b">
            <tr>
                <td>${b.count}</td>
                <td>${books.name}</td>
                <td>￥${books.price}</td>
                <td>${books.classly}</td>
                <from>
                    <td><a href="${pageContext.request.contextPath}/admin/bookManagement?name=${books.name}">详情</a></td>
                </from>
                <from>
                    <td><a href="${pageContext.request.contextPath}/admin/deletBook?name=${books.name}">删除</a></td>
                </from>
<%--                <td>--%>
<%--                    <a href="${pageContext.request.contextPath}/returnServlet?name=${books.name}">--%>
<%--                        <span class="iconfont">&#xe619;</span>--%>
<%--                    </a>--%>
<%--                    <a href="${pageContext.request.contextPath}/deleteBooksServlet?name=${books.name}">--%>
<%--                        <span class="iconfont">&#xe852;</span>--%>
<%--                    </a>--%>
<%--                </td>--%>
            </tr>
        </c:forEach>

    </table>
</div>
</body>
</html>