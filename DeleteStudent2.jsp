<!DOCTYPE HTML>
<html lang='en'>
<head>
<meta charset='utf-8'>
</head>
<body>
<%@page import="com.thinking.machines.school.configuration.*" %>
<jsp:useBean id='studentBean' scope='request' class='com.thinking.machines.school.beans.StudentBean' />
<%
int rollNumber=Integer.parseInt(request.getParameter("rollNumber"));
%>
<jsp:setProperty name='studentBean' property='rollNumber' value='<%=studentBean.getRollNumber()%>'/>
<input type='hidden' name='rollNumber' id='rollNumber' value='${rollNumber}'>
<jsp:forward page='/delete2' />
</body>
</html>