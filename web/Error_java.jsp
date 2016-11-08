<%@ include file="/includes/header.html" %>
<h1>Error</h1>
<p>Java has thrown an exception.</p>
<p>To continue, click the Back button.</p>

<h2>Details</h2>
<p>Type: ${pageContext.exception["class"]}</p>
<p>Message: ${pageContext.exception.message}</p>
<%@ include file="/includes/footer.jsp" %>