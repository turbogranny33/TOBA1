<%@ include file="/includes/header.html" %>
<form action="ResetPassword" method="post">
   <div>
       <label>Password</label>
       <input name="password" type="password" value="${user.password}" />
   </div>
   <input type="submit" value="Reset" />
</form>
<%@ include file="/includes/footer.jsp" %>