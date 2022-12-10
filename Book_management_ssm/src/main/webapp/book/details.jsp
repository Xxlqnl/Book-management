<%--
  Created by IntelliJ IDEA.
  User: XX
  Date: 2022/12/3
  Time: 13:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div class="book">
    书的图片
    <img src="/${img}">
</div>
<div class="details">
    <p>书名:${name}</p>
    <p>藏书阁</p>
    &nbsp;&nbsp;${detail}
</div>
<div class="price">
    价格:￥${price}
</div>
<form action="${pageContext.request.contextPath}/shopping/add?id=${id}" method="post">
    <div class="num">
        <span>数量:</span>
        <!--<input type="text" name="number" class="tb-text mui-amount-input" value="1" maxlength="5" title="请输入购买量">-->
        <input type="text" name="number" class="tb-text mui-amount-input"  maxlength="5" title="请输入购买量">
    </div>
    <div class="button">
        <form> <input type="submit" value="加入购物车"></form>
    </div>
</form>
<div class="shop">
    <a href="/shop/shopping.jsp"><img src="img/购物车.png"></a>
</div>




<%--<div class="book">--%>
<%--    书的图片--%>
<%--    <img src="/${book.img}">--%>
<%--</div>--%>
<%--<div class="details">--%>
<%--    <p>藏书阁</p>--%>
<%--    &nbsp;&nbsp;${book.detail}--%>
<%--</div>--%>
<%--<div class="price">--%>
<%--    价格:￥${book.price}--%>
<%--</div>--%>
</body>
</html>
