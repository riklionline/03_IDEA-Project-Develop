<%--
  Created by IntelliJ IDEA.
  Author: FAT-Remcal
  Date: 10/28/2019
  Time: 7:26 PM
  Signature: “闲庭书阁飞玉箫，Coding诗酒醉年华。”
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>学生列表</title>
</head>
<body>
<h1>学生列表</h1>
<table border="1" align="center" width="100%">
    <tr>
        <td>学号</td>
        <td>密码</td>
        <td>姓名</td>
        <td>性别</td>
        <td>出生日期</td>
    </tr>
    <c:forEach items="${pageBean.data}" var="stu"> <%--接取web/servlet中向request中设置的pageBean属性带参数--%>
        <tr>
            <td>${stu.studentNo}</td>
            <td>${stu.loginPwd}</td>
            <td>${stu.studentName}</td>
            <td>${stu.sex}</td>
            <td>${stu.bornDate}</td>
        </tr>
    </c:forEach>


</table>
<div>
    <a href="${pageContext.request.contextPath}/liststudent?pageNum=${1}">首页</a>
    <a href="${pageContext.request.contextPath}/liststudent?pageNum=${pageBean.pageNum-1}">上一页</a>
    <a href="${pageContext.request.contextPath}/liststudent?pageNum=${pageBean.pageNum+1}">下一页</a>
    <a href="${pageContext.request.contextPath}/liststudent?pageNum=${pageBean.pageCount}">尾页</a>
</div>
</body>
</html>
