<%@page import="com.thinking.machines.school.configuration.*" %>
<%@taglib uri='/WEB-INF/tlds/tmtags.tld' prefix='tm' %>
<jsp:include page='/MasterPageTopSection.jsp' />
<div class='module'>
<script type="text/javascript" src="/<%=ApplicationSettings.ContextName%>/js/StudentUpdateForm.js"></script>
<script type="text/javascript" src="/<%=ApplicationSettings.ContextName%>/js/tmcommon.js"></script>
<jsp:useBean id='studentBean' scope='request' class='com.thinking.machines.school.beans.StudentBean' />
<jsp:useBean id='errorBean' scope='request' class='com.thinking.machines.school.beans.ErrorBean' />
<h3>Student (Update Module)</h3>
<jsp:getProperty name='errorBean' property='error' />
<form action='/<%=ApplicationSettings.ContextName%>/UpdateStudent.jsp' onsubmit='return validateForm(this)'>
<input type='hidden' name='rollNumber' id='rollNumber' value=<%=request.getParameter("rollNumber")%>>
<%
int rollNumber=Integer.parseInt(request.getParameter("rollNumber"));
%>
<table>
<tr>
<td>
Roll number
</td>
<td>
<%=request.getParameter("rollNumber")%>
</td>
</tr>
<tr>
<td>
Name
</td>
<td>
<input type='text' name='name' id='name' value='${studentBean.name}'>
<span id='nameErrorSection' class='error'></span>
</td>
</tr>
<tr>
<td>
Mobile number
</td>
<td>
<input type='text' name='mobileNumber' id='mobilNumber' value='${studentBean.mobileNumber}'>
<span id='mobileNumberErrorSection' class='error'></span>
</td>
</tr>
<tr>
<td>
Date of birth
</td>
<td>
<input type='text' name='dateOfBirth' id='mobilNumber' value='${studentBean.dateOfBirth}'>
<span id='dateOfBirthErrorSection' class='error'></span>
</td>
</tr>
<tr>
<td>
Gender
</td>
<td>
<tm:Equals leftOperand='' rightOperand='${studentBean.gender}'>
<input type='radio' id='male' name='gender' value='M'> Male
&nbsp;&nbsp;&nbsp;&nbsp;
<input type='radio' id='female' name='gender' value='F'> Female
<span id='genderErrorSection' class='error'></span>
</tm:Equals>
<tm:Equals leftOperand='M' rightOperand='${studentBean.gender}'>
<input type='radio' id='male' name='gender' value='M' checked> Male
&nbsp;&nbsp;&nbsp;&nbsp;
<input type='radio' id='female' name='gender' value='F'> Female
<span id='genderErrorSection' class='error'></span>
</tm:Equals>
<tm:Equals leftOperand='F' rightOperand='${studentBean.gender}'>
<input type='radio' id='male' name='gender' value='M'> Male
&nbsp;&nbsp;&nbsp;&nbsp;
<input type='radio' id='female' name='gender' value='F' checked> Female
<span id='genderErrorSection' class='error'></span>
</tm:Equals>
</td>
</tr>
<tr>
<td>
Is Indian
</td>
<td>
<tm:Equals leftOperand='Y' rightOperand='${studentBean.isIndian}'>
<input type='checkbox' name='isIndian' id='isIndian' value='Y' checked>
</tm:Equals>
<tm:NotEquals leftOperand='Y' rightOperand='${studentBean.isIndian}'>
<input type='checkbox' name='isIndian' id='isIndian' value='Y'>
</tm:NotEquals>
</td>
</tr>
<tr>
<td>
City
</td>
<td>
<select id='cityCode' name='cityCode'>
<option value='-1'>&lt;Select&gt;</option>
<tm:Iterator collection='${dataModel.cities}' name='city'>
<option value='${city.code}'>${city.name}</option>
</tm:Iterator>
</select>
<span id='cityCodeErrorSection' class='error'></span>
</td>
</tr>
<tr>
<td>
Subjects
</td><td>
<table>
<tm:Iterator collection='${dataModel.subjects}' name='subject'>
<tm:Contains item='${subject.code}' collection='${studentBean.subjectGroup}'>
<input type='checkbox' name='subjectGroup' id='subject${subject.code}' value='${subject.code}' checked>${subject.name}
</tm:Contains>
<tm:DoesNotContain item='${subject.code}' collection='${studentBean.subjectGroup}'>
<input type='checkbox' name='subjectGroup' id='subject${subject.code}' value='${subject.code}'>${subject.name}
</tm:DoesNotContain>
</tm:Iterator>
</table>
<span id='subjectGroupErrorSection' class='error'></span>
</td>
</tr>
<tr>
<td colspan='2' align='center'>
<button type='submit'>update</button>
</td>
</tr>
</table>
</div>
<jsp:include page='/MasterPageBottomSection.jsp' />