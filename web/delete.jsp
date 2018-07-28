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
<s:form method="POST" action="UserAction!delete.action" >
    <table align="center">
        <caption>
            <h3>用户删除</h3>
        </caption>

        <tr>
            <!-- 用户名的表单域 -->
            <td>输入要删除的用户id：<input type="text" name="user.id" /></td>
        </tr>

        <tr align="center">
            <td colspan="2"><input type="submit" value="删除"/></td>
        </tr>
    </table>
</s:form>
</body>
</html>
