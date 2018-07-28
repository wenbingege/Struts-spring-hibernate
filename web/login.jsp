<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: wenbin
  Date: 2018/7/27
  Time: 18:03
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<s:form method="POST" action="UserAction!login.action" >
    <table align="center">
        <caption>
            <h3>用户登录</h3>
        </caption>
        <tr>
            <!-- 用户名的表单域 -->
            <td>用户名：<input type="text" name="user.username" /></td>
        </tr>
        <tr>
            <!-- 密码的表单域 -->
            <td>密&nbsp;&nbsp;码：<input type="password" name="user.password" /></td>
        </tr>
        <tr align="center">
            <td colspan="2"><input type="submit" value="登录"/></td>
        </tr>
    </table>
</s:form>
</body>
</html>
