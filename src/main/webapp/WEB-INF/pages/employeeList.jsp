<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Sovket
  Date: 6/8/2021
  Time: 11:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<table id="employeeData" class="display" style="width:100%">
    <thead>
    <tr>
        <th>#</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Father name</th>
        <th>Organization</th>
        <th>Sector</th>
        <th>Position</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${employeeList}" var="el">
        <tr>
            <td>${el.id}</td>
            <td>${el.name}</td>
            <td>${el.surname}</td>
            <td>${el.father_name}</td>
            <td>${el.org_name}</td>
            <td>${el.sector_name}</td>
            <td>${el.position_name}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
