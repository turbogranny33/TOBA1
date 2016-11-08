<%@ include file="/includes/header.html" %>
<form action="NewCustomer" method="post">
    <div>
        <label>First Name</label>
        <input name="firstName" type="text" />
    </div>
    <div>
        <label>Last Name</label>
        <input name="lastName" type="text" />
    </div>
    <div>
        <label>Phone Number</label>
        <input name="phone" type="text" />
    </div>
    <div>
        <label>Address</label>
        <input name="address" type="text" />
    </div>
    <div>
        <label>City</label>
        <input name="city" type="text" />
    </div>
    <div>
        <label>State</label>
        <input name="state" type="text" />
    </div>
    <div>
        <label>ZIP Code</label>
        <input name="zipCode" type="text" />
    </div>
    <div>
        <label>Email</label>
        <input name="email" type="text" />
    </div>
    <input type="Submit" value="Submit" />
</form>
<p>${validationMessage}</p>
<%@ include file="/includes/footer.jsp" %>