<%@ include file="/includes/header.html" %>
<p>Account successfully created!</p>
<div>
    <label>Username</label>
    <span>${user.userName}</span>
</div>
<div>
    <label>Password</label>
    <span>welcome1</span>
</div>
<div>
    <label>First Name</label>
    <span>${user.firstName}</span>
</div>
<div>
    <label>Last Name</label>
    <span>${user.lastName}</span>
</div>
<div>
    <label>Phone Number</label>
    <span>${user.phone}</span>
</div>
<div>
    <label>City</label>
    <span>${user.city}</span>
</div>
<div>
    <label>State</label>
    <span>${user.state}</span>
</div>
<div>
    <label>ZIP Code</label>
    <span>${user.zipCode}</span>
</div>
<div>
    <label>Email</label>
    <span>${user.email}</span>
</div>
<%@ include file="/includes/footer.jsp" %>