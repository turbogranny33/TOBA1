<%-- 
    Document   : New_customer
    Created on : Oct 26, 2016, 9:21:33 PM
    Author     : brian_000
--%>

<html>
    <head>
        <title>Titan Online Banking Application - New Customer</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="style.css" type="text/css"/>
    </head>
    <body>
        <form action="NewCustomer" method="post">
            <div>
                <label>First Name</label>
                <input name="FirstName" type="text" />
            </div>
            <div>
                <label>Last Name</label>
                <input name="LastName" type="text" />
            </div>
            <div>
                <label>Phone Number</label>
                <input name="Phone" type="text" />
            </div>
            <div>
                <label>Address</label>
                <input name="Address" type="text" />
            </div>
            <div>
                <label>City</label>
                <input name="City" type="text" />
            </div>
            <div>
                <label>State</label>
                <input name="State" type="text" />
            </div>
            <div>
                <label>ZIP Code</label>
                <input name="Zipcode" type="text" />
            </div>
            <div>
                <label>Email</label>
                <input name="Email" type="text" />
            </div>
            <input type="Submit" value="Submit" />
        </form>
        <p>${validationMessage}</p>
    </body>
</html>
