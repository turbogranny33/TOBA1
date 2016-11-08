<%@ include file="/includes/header.html" %>
<form action="Login" method="post">
    <div>
        <label>Username</label>
        <input name="userName" type="text" />
    </div>
    <div>
        <label>Password</label>
        <input name="password" type="password" />
    </div>
    <input type="submit" value="Login" />
</form>
<p>
    <a href="New_customer.jsp">New customer</a> |  <a href="password_reset.jsp">Reset password</a>
</p>
<%@ include file="/includes/footer.jsp" %>