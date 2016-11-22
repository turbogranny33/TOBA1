<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/includes/header.html" %>
<h1>Account Activity</h1>
<c:if test="${sessionScope.user != null}">
    <p>Welcome ${sessionScope.user.firstName} ${sessionScope.user.lastName}</p>
    
    <table>
        <tbody>
            <tr>
                <th>User Name</th>
                <td>${sessionScope.user.userName}</td>
            </tr>
            <tr>
                <th>First Name</th>
                <td>${sessionScope.user.firstName}</td>
            </tr>
            <tr>
                <th>Last Name</th>
                <td>${sessionScope.user.lastName}</td>
            </tr>
            <tr>
                <th>Phone Number</th>
                <td>${sessionScope.user.phoneNumber}</td>
            </tr>
            <tr>
                <th>Address</th>
                <td>${sessionScope.user.address}</td>
            </tr>
            <tr>
                <th>City</th>
                <td>${sessionScope.user.city}</td>
            </tr>
            <tr>
                <th>State</th>
                <td>${sessionScope.user.state}</td>
            </tr>
            <tr>
                <th>ZIP Code</th>
                <td>${sessionScope.user.zipCode}</td>
            </tr>
            <tr>
                <th>Email Address</th>
                <td>${sessionScope.user.email}</td>
            </tr>
            <tr>
                <th>Password</th>
                <td>${sessionScope.user.password}</td>
            </tr>
        </tbody>
    </table>
</c:if>
<c:if test="${sessionScope.user == null}">
    <p>Not Logged In</p>
</c:if>
<%@ include file="/includes/footer.jsp" %>