<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
    <title>Céges Ticket / User Rendszer</title>
    <style>
        body { font-family: Arial, sans-serif; padding: 20px; }
        table { border-collapse: collapse; inline-size: 50%; margin-block-start: 20px; }
        th, td { border: 1px solid #dddddd; text-align: start; padding: 8px; }
        th { background-color: #f2f2f2; }
    </style>
</head>
<body>

    <h2>Rendszerben lévő felhasználók (JSP Frontend)</h2>
    
    <table>
        <tr>
            <th>ID</th>
            <th>Név</th>
            <th>Email</th>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.email}</td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>