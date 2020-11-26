<%@page import="com.thinking.machines.school.configuration.*" %>
<%@taglib uri='/WEB-INF/tlds/tmtags.tld' prefix='tm' %>
<jsp:include page='/MasterPageTopSection.jsp' />
<div class='module'>
<script type="text/javascript" src="/<%=ApplicationSettings.ContextName%>/js/StudentDeleteForm.js"></script>
<jsp:useBean id='studentBean' scope='request' class='com.thinking.machines.school.beans.StudentBean' />
<jsp:useBean id='errorBean' scope='request' class='com.thinking.machines.school.beans.ErrorBean' />
<h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Student (Delete Module)</h3>
<jsp:getProperty name='errorBean' property='error' />
<form action='/<%=ApplicationSettings.ContextName%>/DeleteStudent1.jsp' onsubmit='return validateForm(this)'>
<center>
<table>
<tr>
<td>
Roll number
</td>
<td>
<tm:Equals leftOperand='${studentBean.rollNumber}' rightOperand='0'>
<input type='text' name='rollNumber' id='rollNumber'>
</tm:Equals>
<tm:LessThan leftOperand='0' rightOperand='${studentBean.rollNumber}'>
<input type='text' name='rollNumber' id='rollNumber' value='${studentBean.rollNumber}'>
</tm:LessThan>
<span id='rollNumberErrorSection' class='error'></span>
</td>
</tr>
<tr>
<td colspan='2' align='left'>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<button type='submit'>Delete</button>
</td>
</tr>
</table>
</center>
</div>
<jsp:include page='/MasterPageBottomSection.jsp' />