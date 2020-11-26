<%@ taglib uri='/WEB-INF/tlds/tmtags.tld' prefix='tm' %>
<%@page import ="com.thinking.machines.school.configuration.*"%>
<script type="text/javascript" src="js/StudentAddForm.js"></script>
<script type="text/javascript" src="js/tmcommon.js"></script>
<jsp:include page='/MasterPageTopSection.jsp'/>
<jsp:useBean id='studentBean' scope='request' class='com.thinking.school.beans.StudentBean'/>
<jsp:useBean id='errorBean' scope='request' class='com.thinking.school.beans.ErrorBean'/>
<jsp:getProperty name='errorBean' property='error'/></label>
<div class='module'>
<center>
<title>StudentManager</title>
<h2>Student Manager</h2>
<h4>Student Add Module</h4>
<form action='/addStudentForm.jsp' onsubmit='return validateForm(this)'>
<table border='1'>
<tr><td>
RollNumber </td><td>
<input type='text' name='rollNumber' id='rollNumber' value='${studentBean.rollNumber}'>
<span id='rollNumberErrorSection'></span>
</td></tr>
<tr><td>
Name</td><td>
<input type='text' name='name' id='name' value='${studentBean.name}' >
<span id='nameErrorSection'></span>
</td></tr>
<tr>
<td>
MobileNumber </td><td>
<input type='text' name='mobileNumber' id='mobileNumber' value='${studentBean.mobileNumber}'><span id='mobileNumberErrorSection'></span></td></tr>
<tr><td>Date Of Birth </td><td>
<input type='text' name='dateOfBirth' id='dateOfBirth' value='${studentBean.dateOfBirth}'><span id='dateOfBirthErrorSection'></span></td></tr>
<tr><td>Gender</td><td>
<tm:Equals leftOperand="" rightOperand='${studentBean.gender}'>
Male <input type='radio' id=''Male' name='gender' value='M'>
&nbsp;&nbsp;&nbsp;
Female <input type='radio' id=''Female' name='gender' value='F'>
<span id='genderErrorSection'></span>
</tm:Equals>
<tm:Equals leftOperand="M" rightOperand='${studentBean.gender}'>
Male <input type='radio' id=''Male' name='gender' value='M' checked>
&nbsp;&nbsp;&nbsp;
Female <input type='radio' id=''Female' name='gender' value='F'>
<span id='genderErrorSection'></span>
</tm:Equals>
<tm:Equals leftOperand="F" rightOperand='${studentBean.gender}'>
Male <input type='radio' id=''Male' name='gender' value='M'>
&nbsp;&nbsp;&nbsp;
Female <input type='radio' id=''Female' name='gender' value='F' checked>
<span id='genderErrorSection'></span>
</tm:Equals>
</td></tr><tr><td>
IsIndian</td><td>
<tm:Equals leftOperand='on' rightOperand='${studentBean.isIndian}'>
<input type='checkbox' name='isIndian' id='isIndian' checked >
</tm:Equals>
<tm:NotEquals leftOperand='on' rightOperand='${studentBean.isIndian}'>
<input type='checkbox' name='isIndian' id='isIndian'  >
</tm:NotEquals>
</td></tr><tr><td>
City</td><td>
<select name='cityCode' id='cityCode'>
<option value=-1>Select</option>
<tm:Iterator collection='${dm.cities}' name='city'>
<tm:Equals leftOperand="${city.code}" rightOperand='${studentBean.cityCode}'>
<option value='${city.code}' selected >${city.name}</option>
</tm:Equals>
<tm:NotEquals leftOperand="${city.code}" rightOperand='${studentBean.cityCode}'>
<option value='${city.code}'  >${city.name}</option>
</tm:NotEquals>
</tm:Iterator>
</select>
<span id='cityCodeErrorSection'></span>
</td></tr></tr><tr>
<tr><td colspan='2'>
Select Subjects:
<tm:Iterator collection='${dm.subjects}' name='subject'>
<tm:Contains item='${subject.code}' collection='${studentBean.subjectGroup}'>
<input type='checkbox' name="subjectGroup" id='subject${subject.code}' 
value=${subject.code} >${subject.name} checked  </tm:Contains>
</tm:Iterator>
<span id='subjectsErrorSection'></span></td></tr>
<td colspan='2' align='center'>
<input type='submit' value='Add'></td></tr>
</table>
</form></center>
</div>
<div class='errorSection'>
<center>
${errorBean.error}
</center>
</div>
<jsp:include page='/MasterPageBottomSection.jsp' />