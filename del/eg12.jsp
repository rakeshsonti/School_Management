<%@ page import="com.thinking.machines.school.model.*"%>
<%@ page import="com.thinking.machines.school.configuration.*"%>
<%@taglib uri='/WEB-INF/tlds/tmtags.tld' prefix='tm'%>
<script type='text/javascript' src="js/studentAddForm.js"></script>
<script type='text/javascript' src="js/tmcommon.js"></script>
<jsp:useBean id='studentBean' scope='request' class='com.thinking.machines.school.beans.StudentBean'/>
<jsp:useBean id='errorBean' scope='request' class='com.thinking.machines.school.beans.ErrorBean'/>
<jsp:getProperty name='errorBean' property='error'/>
<jsp:include page='/MasterPageTopSection.jsp' />
<center>
<form action="addStudent" onsubmit='return validForm(this)'>
<table border='0'>
<tr><td>
<tm:Equals leftOperand="0" rightOperand="${studentBean.rollNumber}">
RollNumber
&nbsp;&nbsp;&nbsp;&nbsp;
<input type='text' name='rollNumber' id='rollNumber' value=''>
<span id='rollNumberErrorSection'></span>
</tm:Equals>
<tm:NotEquals leftOperand="0" rightOperand="${studentBean.rollNumber}">
RollNumber
&nbsp;&nbsp;&nbsp;&nbsp;
<input type='text' name='rollNumber' id='rollNumber' value='${studentBean.rollNumber}'>
<span id='rollNumberErrorSection'></span>
</tm:NotEquals>
</td></tr>
<tr><td>
Name
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type='text' name='name' id='name' value='${studentBean.name}'>
<span id='nameErrorSection'></span>
</td></tr>
<tr><td>
MobileNumber&nbsp;<input type='text' name='mobileNumber' id='mobileNumber' value='${studentBean.mobileNumber}'>
<span id='mobileNumberErrorSection'></span>
</td></tr>
<tr><td>
Date of Birth
&nbsp;&nbsp;&nbsp;
<input type='text' name='dateOfBirth' id='dateOfBirth' value='${studentBean.dateOfBirth}'>
<span id='dateOfBirthErrorSection'></span>
</td></tr>
<tr><td>
<tm:Equals leftOperand="" rightOperand="${studentBean.gender}">
Male<input type='radio' name='gender' id='male' value='M'>
Female<input type='radio' name='gender' id='female' value='F'>
<span id='genderErrorSection'></span>
</tm:Equals>
<tm:Equals leftOperand="M" rightOperand="${studentBean.gender}">
Male<input type='radio' name='gender' id='male' value='M' checked>
Female<input type='radio' name='gender' id='female' value='F'>
<span id='genderErrorSection'></span>
</tm:Equals>
<tm:Equals leftOperand="F" rightOperand="${studentBean.gender}">
Male<input type='radio' name='gender' id='male' value='M'>
Female<input type='radio' name='gender' id='female' value='F' checked>
<span id='genderErrorSection'></span>
</tm:Equals>
</td></tr>
<tr><td>
<tm:Equals leftOperand='on' rightOperand='${studentBean.isIndian}'>
Indian
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type='checkbox' name='isIndian' id='isIndian' checked>
<span id='isIndianErrorSection'></span>
</tm:Equals>
<tm:NotEquals leftOperand="on" rightOperand="${studentBean.isIndian}">
Indian
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type='checkbox' name='isIndian' id='isIndian'>
<span id='isIndianErrorSection'></span>
</tm:NotEquals>
</td></tr>
<tr><td>
Select city
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<select name='cityCode' id='cityCode'>
<option value='-1'>&lt;Select&gt;</option>
<tm:Iterator collection='${dataModel.cities}' name='city'>
<tm:Equals leftOperand="{city.code}" rightOperand='${studentBean.cityCode}'>
<option value='${city.code}' selected>${city.name}</option>
</tm:Equals>
<tm:NotEquals leftOperand="{city.code}" rightOperand='${studentBean.cityCode}'>
<option value='${city.code}' >${city.name}</option>
</tm:NotEquals>
<span id='cityCodeErrorSection' ></span>
</tm:Iterator>
</select>
</td></tr>
<tr><td>
Select Subjects
<tm:Iterator collection='${dataModel.subjects}' name='subject'>
<tm:Equals leftOperand='${subject.code}' rightOperand='${studentBean.subjectCode}'>
<input type='checkbox' name='subjectCode' id='subject${subject.code}' value='${subject.code}' checked>${subject.name} 
</tm:Equals>
<tm:NotEquals leftOperand='${subject.code}' rightOperand='${studentBean.subjectCode}'>
<input type='checkbox' name='subjectCode' id='subject${subject.code}' value=${subject.code}>${subject.name}
</tm:NotEquals>
</tm:Iterator>
<span id='subjectsErrorSection'></span>
</td></tr><tr>
<td colspan='2' align='center'>
<input type='submit' value='Add'></td>
</tr>
</table>
</form>
</center>
${errorBean.error}
<jsp:include page='/MasterPageBottomSection.jsp' />
