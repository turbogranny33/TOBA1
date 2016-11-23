<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/includes/header.html" %>
<h1>Account Activity</h1>
<c:if test="${sessionScope.user != null}">
    <p>Welcome ${sessionScope.user.firstName} ${sessionScope.user.lastName}</p>
    
    <h2>Account Information</h2>
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
                <td>${sessionScope.user.phone}</td>
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
    <h2>Accounts</h2>
    <table>
        <thead>
            <tr>
                <th>Account Type</th>
                <th>Balance</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="account" items="${sessionScope.accounts}">
                <tr>
                    <td>${account.accountType}</td>
                    <td><fmt:formatNumber type="currency" currencySymbol="$" value="${account.balance}" /></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <h2>Transactions</h2>
    <table>
        <thead>
            <tr>
                <th>Date</th>
                <th>Account</th>
                <th>Amount</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="account" items="${sessionScope.accounts}">
                <c:forEach var="transaction" items="${account.transactions}">
                    <tr>
                        <td>${transaction.transactionDate}</td>
                        <td>${account.accountType}</td>
                        <td><fmt:formatNumber type="currency" currencySymbol="$" value="${transaction.amount}" /></td>
                    </tr>
                </c:forEach>
            </c:forEach>
        </tbody>
    </table>
    <a href="Transaction.jsp">Post a transaction</a>
</c:if>
<c:if test="${sessionScope.user == null}">
    <p>Not Logged In</p>
</c:if>
<%@ include file="/includes/footer.jsp" %>