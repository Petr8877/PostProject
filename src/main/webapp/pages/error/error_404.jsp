<%@ page isErrorPage="true" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error 404 Page</title>
</head>
<body>
    Request from ${pageContext.errorData.requestURI} is failed <br/>
    Servlet name: ${pageContext.errorData.servletName} <br/>
    Status code: ${pageContext.errorData.statusCode} <br/>
    Exception: ${pageContext.exception} <br/>

    <br/><br/><br/>
    Message from exception: ${error_msg}
    <a href="${pageContext.request.contextPath}/index.jsp">Back to main</a>
</body>
</html>