<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Sovket
  Date: 6/8/2021
  Time: 11:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
</script>
<table id="roleData" class="display" style="width:100%">
    <thead>
    <tr>
        <th>#</th>
        <th>Role</th>
        <th>Description</th>
        <c:if test="${login.role.role_name eq 'ROLE_ADMIN'}">
            <th>Edit</th>
            <th>Delete</th>
        </c:if>

    </tr>
    </thead>
    <tbody>
    <c:forEach items="${roleList}" var="rl">
        <tr>
            <td>${rl.r}</td>
            <td>${rl.role_name}</td>
            <td>${rl.description}</td>
            <c:if test="${login.role.role_name eq 'ROLE_ADMIN'}">
                <td><a href="javascript: editRole('${rl.id}');">Edit</a></td>
                <td><a href="javascript: deleteRole('${rl.id}', '${rl.role_name}');">Delete</a></td>
            </c:if>
        </tr>
    </c:forEach>
    </tbody>
</table>
