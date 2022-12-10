<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="icon" href="logo.ico">
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/details.css">
</head>
<body>

<table border="1">
    <tr>
        <td>书的图片</td>
        <td>书的名称</td>
        <td>书的价格</td>
        <td>书的分类</td>
        <td>书的详情</td>
    </tr>
    <tr>
        <td><img src="/${book.img}"></td>
        <td>${book.name}</td>
        <td>￥${book.price}</td>
        <td>${book.classly}</td>
        <td>${book.detail}</td>
    </tr>
</table>
<table border="1">
    <tr>
<%--        <td>书的图片</td>--%>
        <td>修改</td>
        <td>修改的内容</td>
        <td>是否修改</td>
    </tr>
    <tr>
        <form action="${pageContext.request.contextPath}/admin/modify">
            <input type="hidden" name="img" value=${book.img} >
<%--            <input type="hidden" name="name" value=${book.name}>--%>

            <td>
                <select name="species">
                    <option value="name">书的名称</option>
                    <option value="price">书的价格</option>
<%--                    <option value="classly">书的分类</option>--%>
                    <option value="detail">书的详情</option>
                </select>
            </td>
            <td>
                <input type="text" name="content">
            </td>
            <td>
                <input type="submit" value="修改">
            </td>
        </form>
    </tr>

</table>


<%--<div class="book">--%>
<%--    <img src="/${book.img}">--%>
<%--</div>--%>
<%--<div class="details">--%>
<%--    <p>藏书阁</p>--%>
<%--    &nbsp;&nbsp;${book.detail}--%>
<%--</div>--%>
<%--<div class="price">--%>
<%--    价格:￥${book.price}--%>
<%--</div>--%>



<div class="button">
    <a href="${pageContext.request.contextPath}/admin/index">返回</a>
</div>


</body>
</html>