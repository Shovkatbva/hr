<%@ page import="java.util.List" %>
<%@ page import="az.nakhInternet.hr.model.Role" %>
<%--
  Created by IntelliJ IDEA.
  User: Sovket
  Date: 6/1/2021
  Time: 11:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% List<Role> roleList = (List<Role>) request.getAttribute("roleList");%>
<html>
<head>
    <title>Role List</title>
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <link rel="stylesheet" type="text/css" href="css/reset.css">
</head>
<body>
<div id="container">
    <jsp:include page="/static/header.jsp"></jsp:include>
    <jsp:include page="/static/menu.jsp"></jsp:include>
    <div id="tableContainer">
        <table border="1" id="tableDesign">
            <thead>
            <tr>
                <th>#</th>
                <th>Role</th>
                <th>Description</th>
            </tr>
            </thead>
            <tbody>
            <% for (Role role : roleList) {%>
            <tr>
                <td><%= role.getR()%>
                </td>
                <td><%= role.getRole_name()%>
                </td>
                <td><%=role.getDescription()%>
                </td>
            </tr>
            <%}%>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
