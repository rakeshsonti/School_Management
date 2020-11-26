<%@page import ="com.thinking.machines.school.configuration.*"%>
<!DOCTYPE HTML>
<html lang='en'>
<head>
<meta charset='utf-8'>
<title>School Management System</title>
<link type='text/css' rel='stylesheet' href='/<%=ApplicationSettings.ContextName%>/css/style.css'>
</head>
<body>
<div class='main-container'>
<table border='1' class='header'>
<tr>
<td>
<img class='header-logo' src='/<%=ApplicationSettings.ContextName%>/images/logo1.png'>
</td>
<td>
<span class='header-title'>ABC School Ujjain</span>
</td>
</tr>
<tr class='content'>
<td>
</td>
<td>
<jsp:useBean id='notificationBean' scope='request' class='com.thinking.machines.school.beans.NotificationBean' />
<h2><jsp:getProperty name='notificationBean' property='message' />!</h2>
</td>
</tr>
<tr><td colspan='2'><center>
<a  type='button' href='/<%=ApplicationSettings.ContextName%>/index.jsp' ><h3>Home</h3></a>
</center>
</td>	
</tr>
<tr>
<td colspan='2' class='copyright'>
&copy; Thinking Machines- 2019-2023
</td>
</tr>
</table>
</div>
</body>


