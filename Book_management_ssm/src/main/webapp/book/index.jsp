<%--
  Created by IntelliJ IDEA.
  User: XX
  Date: 2022/12/3
  Time: 12:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="top clearfix">
    <h2>藏书阁欢迎你的到来！</h2>
    <h5></h5>
    <h5><a href="${pageContext.request.contextPath}/shopping/shoppingCat">购物车</a></h5>
    <h5><a href="${pageContext.request.contextPath}/Login/login.jsp">退出</a> <a href="${pageContext.request.contextPath}/user/registered">注册新用户</a></h5>
</div>
<div class="left">
    <h2>图书分类</h2>
    <ul>
        <li><a href="${pageContext.request.contextPath}/book/index?classly=儿童读物">儿童读物</a></li>
        <li><a href="${pageContext.request.contextPath}/book/index?classly=青年读物">青年读物</a></li>
        <li><a href="${pageContext.request.contextPath}/book/index?classly=科普百科">科普百科</a></li>
        <li><a href="${pageContext.request.contextPath}/book/index?classly=卡通动漫">卡通动漫</a></li>
        <li><a href="${pageContext.request.contextPath}/book/index?classly=名著宝藏">名著宝藏</a></li>
    </ul>
</div>
<div class="body">
    <h2>展示账户数据列表</h2>



    <c:forEach items="${booksList}" var="book" varStatus="b">
          <div class="movie-item">
                <div class="poster">
                    <a href="${pageContext.request.contextPath}/book/details?id=${book.id}">
                        <img src="/${book.img}">
                    </a>
                </div>
                <div class="name">
                    <a href="${pageContext.request.contextPath}/details.jsp?id=${book.id}">
                            ${book.name}
                    </a>
                </div>
                <div class="score">￥${book.price}</div>
          </div>
    </c:forEach>
</body>
</html>
