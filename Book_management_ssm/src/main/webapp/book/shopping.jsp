<%--
  Created by IntelliJ IDEA.
  User: XX
  Date: 2022/12/3
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>展示账户数据列表</h2>
<table border="1">
    <tr>
        <th>书的照片</th>
        <th>书的名称</th>
        <th>书的单价</th>
        <th>书的数量</th>
        <th>该书的总价</th>
        <th>修改书的数量</th>
    </tr>
    <c:forEach items="${shoppingList}" var="book">
        <tr>
            <td><img src="/${book.img}"></td>
            <td>${book.name}</td>
            <td>${book.price}</td>
            <td>${book.number}</td>
            <td>${book.price}*${book.number}</td>
            <td>
                <form action="${pageContext.request.contextPath}/shopping/book_num">
                <input type="text" name="name" value=${book.name}>
                <input type="text" name="num_new">
                <input type="submit" value="修改该书的数量（填写整数）">
                </form>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="6">总金额：....(用参数priceAll表示)</td>
    </tr>
</table>

<a href="${pageContext.request.contextPath}/book/index?classly=儿童读物">接着购物</a>

<%--下面这句是向后端发送总金额数据,123是测试金额，正常情况下用参数priceAll代替--%>
${pageContext.session.setAttribute("priceAll",123)}
<a href="${pageContext.request.contextPath}/shopping/pay">去支付</a>
</body>
</html>
