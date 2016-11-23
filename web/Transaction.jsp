<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/includes/header.html" %>
<h1>Post a Transaction</h1>
<c:if test="${sessionScope.user == null}">
    <p>Not Logged In</p>
</c:if>
<c:if test="${sessionScope.user != null}">
    <p>${validationMessage}</p>
    <h2>Account Balances</h2>
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
    <br />
    <form action="Transaction" method="post">
        <div>
            <label>From</label>
            <select name="sourceAccount">
                <c:forEach var="account" items="${sessionScope.accounts}">
                    <option value="${account.accountId}">${account.accountType}</option>
                </c:forEach>
            </select>
        </div>
        <div>
            <label>To</label>
            <select name="destinationAccount">
                <c:forEach var="account" items="${sessionScope.accounts}">
                    <option value="${account.accountId}">${account.accountType}</option>
                </c:forEach>
            </select>
        </div>
        <div>
            <label>Amount</label>
            <input name="amount" type="text" />
        </div>
        <input type="submit" value="Transfer" />
    </form>
</c:if>
<%@ include file="/includes/footer.jsp" %>