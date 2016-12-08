<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../includes/header.html" %>
<h2>Accounts Registered in the Past Month</h2>
<table>
    <thead>
        <tr>
            <th>User Name</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Registration Date</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="user" items="${sessionScope.users}">
            <tr>
                <td>${user.userName}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.registrationDate}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<p>
    <a href="reports_download">Download Report</a>
</p>
<%@ include file="../includes/footer.jsp" %>