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
<div class='links'>
<ul>
<li><a href='/<%=ApplicationSettings.ContextName%>/StudentAddForm.jsp'>Add</a></li>
<li><a href='/<%=ApplicationSettings.ContextName%>/StudentEditForm.jsp'>Edit</a></li>
<li><a href='/<%=ApplicationSettings.ContextName%>/StudentDeleteForm.jsp'>Delete</a></li>
<li><a href='/<%=ApplicationSettings.ContextName%>/view'>View</a></li>
</ul>
</div>
</td>
<td>
