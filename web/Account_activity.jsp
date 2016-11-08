<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/includes/header.html" %>
<h1>Account Activity</h1>
<c:if test="${sessionScope.user != null}">
    <p>Welcome ${sessionScope.user.firstName} ${sessionScope.user.lastName}</p>
</c:if>
<c:if test="${sessionScope.user == null}">
    <p>Not Logged In</p>
</c:if>
<%@ include file="/includes/footer.jsp" %>