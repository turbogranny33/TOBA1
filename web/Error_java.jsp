<%-- 
    Document   : Error_java
    Created on : Oct 24, 2016, 9:05:35 PM
    Author     : brian_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css" type="text/css"/>
        <title>Titan Online Banking Application - Error</title>
    </head>
    <body>
        <h1>Error</h1>
        <p>Java has thrown an exception.</p>
        <p>To continue, click the Back button.</p>
        
        <h2>Details</h2>
        <p>Type: {pageContext.exception["class"]}</p>
        <p>Message: {pageContext.exception.message}</p>
    </body>
</html>
