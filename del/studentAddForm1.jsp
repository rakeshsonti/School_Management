
<%@ taglib uri='/WEB-INF/tlds/equaltags.tld' prefix='tm' %>
<jsp:include page='/MasterPageTopSection.jsp' />
<script type="text/javascript" src="styletwo/js/studentAddForm.js"></script>
<jsp:useBean id='studentBean' scope='request' class='com.thinking.school.beans.StudentBean'/>
<jsp:useBean id='errorBean' scope='request' class='com.thinking.machines.school.beans.ErrorBean.java'/>
<jsp:getProperty name='errorBean' prorperty='error'/></label>
<form action='/styletwo/addStudentForm.jsp' onsubmit='return validateForm(this)'>
RollNumber<input type='text' name='rollNumber' id='rollNumber' value='${studentBean.rollNumber}'>rollNumberErrorSection
Name<input type='text' name='name' id='name' value='${studentBean.name}'>nameErrorSection
MobileNumber<input type='text' name='mobileNumber' id='mobileNumber' value='${studentBean.mobileNumber}'>mobileNumberErrorSection
<tm:Equals leftOperand="${studentBean.gender}" rightOperand="M">
Male<input type='radio' id='male' name='gender' value='M' checked>
Female<input type='radio' id='female' name='gender' value='F' >
</tm:Equals>
<tm:Equals leftOperand="${studentBean.gender}" rightOperand="F">
Male<input type='radio' id='male' name='gender' value='M' >
Female<input type='radio' id='female' name='gender' value='F' checked>
</tm:Equals>
DateOfBirth<input type='text' name='dateOfBirth' id='dateOfBirth' value='${studentBean.dateOfBirth}'>dateOfBirthErrorSection
<tm:Equals leftOperand="${studentBean.isIndian}" rightOperand="true">
Indian<input type='checkbox' id='indian' name='indian' value='true' checked>
</tm:Equals>
<tm:Equals leftOperand="${studentBean.isIndian}" rightOperand="false">
Indian<input type='checkbox' id='indian' name='indian' value='true' >
</tm:Equals>
//-----------------------------------------------------------------
IsIndian</td><td>
<tm:Equals leftOperand='on' rightOperand='${studentBean.isIndian}'>
<input type='checkbox' name='isIndian' id='isIndian' checked >
</tm:Equals>
<tm:NotEquals leftOperand='on' rightOperand='${studentBean.isIndian}'>
<input type='checkbox' name='isIndian' id='isIndian'  >
</tm:NotEquals>
//----------------------------------------------------------


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


//-----------------------------------------------------
Select Subject<br>
<table>
<tm:iterator collection='${dataModel.subjects}' name='subject'>
<tr>
<tm:DoesNotContainItem='${subject.code}'collection'${studentBean.subjectCode'} value='${subject.code}>
<td>input type='checkbox' id='subjectGroup' name='subject'
</tm>
<tm:Contains item='${subject:code}'collection='${studentBean.subjectCode'} value='${subject.code}'>
<td>input type='checkbox' id='subjectGroup' name='subject'
</tm>
<td>${subject.name}</td>
</tr>
<jsp:include page='/MasterPageBottomSection.jsp'/>












