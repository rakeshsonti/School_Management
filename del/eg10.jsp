<%@ page import="com.thinking.machines.school.model.*"%>
<%@ page import="com.thinking.machines.school.configuration.*"%>
<%@taglib uri='/WEB-INF/tlds/tmtags.tld' prefix='tm'%>
<script>
function validForm(frm)
{
var firstInvalidComponenet=null;
var rollNumber=frm.rollNumber.value.trim();
var name=frm.name.value.trim();
var mobileNumber=frm.mobileNumber.value.trim();
var dateOfBirth=frm.dateOfBirth.value.trim();
var rollNumberErrorSection=document.getElementById("rollNumberErrorSection");
var nameErrorSection=document.getElementById("nameErrorSection");
var mobileNumberErrorSection=document.getElementById("mobileNumberErrorSection");
var dateOfBirthErrorSection=document.getElementById("dateOfBirthErrorSection");
var genderErrorSection=document.getElementById("genderErrorSection");
var cityCodeErrorSection=document.getElementById("cityCodeErrorSection");
var subjectsErrorSection=document.getElementById("subjectsErrorSection");
var valid=true;
if(rollNumber.length==0)
{
document.getElementById("rollNumberErrorSection").innerHTML="Required";
frm.rollNumber.focus();
return false;
}
else
{
if(rollNumber.length>10)
{
document.getElementById("rollNumberErrorSection").innerHTML="can not exceed 9999999999";
frm.rollNumber.focus();
return false;
}
else
{
var vc='0123456789';
for(var e=0;e<rollNumber.length;e++)
{
if(vc.indexOf(rollNumber.charAt(e))==-1)
{
document.getElementById("rollNumberErrorSection").innerHTML="Invalid roll Number";
frm.rollNumber.focus();
return false;
break;
}
}
}
}
document.getElementById("rollNumberErrorSection").innerHTML="";
if(name.length==0)
{
document.getElementById("nameErrorSection").innerHTML="name required";
frm.name.focus();
return false;
}
else
{
if(name.length>35)
{
document.getElementById("nameErrorSection").innerHTML="name can not exceed 35 characters";
frm.name.focus();
return false;
}
}
document.getElementById("nameErrorSection").innerHTML="";
if(mobileNumber.length==0)
{
document.getElementById("mobileNumberErrorSection").innerHTML="mobileNumber required";
frm.mobileNumber.focus();
return false;
}
else
{
if(mobileNumber.length>15)
{
document.getElementById("mobileNumberErrorSection").innerHTML="mobileNumber can not be exceed more than 15 character";
frm.mobileNumber.focus();
return false;
}
else
{
var vc='0123456789';
for(var e=0;e<mobileNumber.length;e++)
{
if(vc.indexOf(mobileNumber.charAt(e))==-1)
{
document.getElementById("mobileNumberErrorSection").innerHTML="Invalid mobile Number";
frm.mobileNumber.focus();
return false;
break;
}
}
}
}
document.getElementById("mobileNumberErrorSection").innerHTML="";
if(dateOfBirth.length==0)
{
document.getElementById("dateOfBirthErrorSection").innerHTML="date of birth required";
frm.dateOfBirth.focus();
return false;
}
else
{
if(dateOfBirth.length<8||dateOfBirth.length>10)
{
document.getElementById("dateOfBirthErrorSection").innerHTML="date of birth 1 Invalid";
frm.dateOfBirth.focus();
return false;
}
var c=0;
for(var i=0;i<dateOfBirth.length;i++)if(dateOfBirth.charAt(i)=='/')c++;
if(c!=2)
{
document.getElementById("dateOfBirthErrorSection").innerHTML="date of birth 3 Invalid";
frm.dateOfBirth.focus();
return false;
}
if((dateOfBirth.length==8)&&(dateOfBirth.charAt(1)!='/'||dateOfBirth.charAt(3)!='/'))
{
document.getElementById("dateOfBirthErrorSection").innerHTML="date of birth  Invalid";
frm.dateOfBirth.focus();
return false;
}
if((dateOfBirth.length==10)&&(dateOfBirth.charAt(2)!='/'||dateOfBirth.charAt(5)!='/'))
{
document.getElementById("dateOfBirthErrorSection").innerHTML="date of birth  Invalid";
frm.dateOfBirth.focus();
return false;
}
if(dateOfBirth.length==9)
{
if(dateOfBirth.charAt(4)!='/')
{
document.getElementById("dateOfBirthErrorSection").innerHTML="date of birth  Invalid0";
frm.dateOfBirth.focus();
return false;
}
if(!(dateOfBirth.charAt(1)=='/'||dateOfBirth.charAt(2)=='/'))
{
document.getElementById("dateOfBirthErrorSection").innerHTML="date of birth  Invalid1";
frm.dateOfBirth.focus();
return false;
}
if(dateOfBirth.charAt(1)=='/'&&dateOfBirth.charAt(2)=='/')
{
document.getElementById("dateOfBirthErrorSection").innerHTML="date of birth  Invalid2";
frm.dateOfBirth.focus();
return false;
}
}
var pcs=dateOfBirth.split('/');
var day=parseInt(pcs[0]);
var month=parseInt(pcs[1]);
var year=parseInt(pcs[2]);
if(year<1990)
{
document.getElementById("dateOfBirthErrorSection").innerHTML="date of birth  galat hai 1990";
frm.dateOfBirth.focus();
return false;
}
if(month<1||month>12)
{
document.getElementById("dateOfBirthErrorSection").innerHTML="date of birth  galat hai 1-12";
frm.dateOfBirth.focus();
return false;
}
var days=[31,28,31,30,31,30,31,31,30,31,30,31];
if((year%400)||((year%4==0)&&(year%100!=0)))
{
days[1]=29;
}
if(day<1||day>days[month-1])
{
document.getElementById("dateOfBirthErrorSection").innerHTML="date of birth  galat hai 31-0";
frm.dateOfBirth.focus();
return false;
}
}
document.getElementById("dateOfBirthErrorSection").innerHTML="";
if(frm.sex[0].checked==false && frm.sex[1].checked==false)
{
document.getElementById("genderErrorSection").innerHTML="gender required";
return false;
}
document.getElementById("genderErrorSection").innerHTML="";
if(frm.cityCode.selectedIndex==0)
{
document.getElementById("cityErrorSection").innerHTML="city required";
return false;
}
document.getElementById("cityErrorSection").innerHTML="";
var subjectGroup=frm.subjectCode;
var selectedSubjectCount=0;
subjectGroup.forEach(function(subject){
if(subject.checked)selectedSubjectsCount++;
});
if(selectedSubjectsCount==0)
{
frm.subjectCode.focus();
document.getElementById("genderErrorSection").innerHTML="gender required";
return false;
}
return true;
}
</script>
<jsp:useBean id='studentBean' scope='request' class='com.thinking.machines.school.beans.StudentBean'/>
<jsp:useBean id='errorBean' scope='request' class='com.thinking.machines.school.beans.ErrorBean'/>
<jsp:getProperty name='errorBean' property='error'/>
<jsp:include page='/MasterPageTopSection.jsp' />
<center>
<form action="/addStudent" onsubmit='return validForm(this)'>
<table border='0'>
<tr><td>
<tm:Equals leftOperand="0" rightOperand="${studentBean.rollNumber}">
RollNumber
<input type='text' name='rollNumber' id='rollNumber' value=''>
<span id='rollNumberErrorSection'></span>
</tm:Equals>
<tm:NotEquals leftOperand="0" rightOperand="${studentBean.rollNumber}">
RollNumber
<input type='text' name='rollNumber' id='rollNumber' value='${studentBean.rollNumber}'>
<span id='rollNumberErrorSection'></span>
</tm:NotEquals>
</td></tr>
<tr><td>
Name
<input type='text' name='name' id='name' value='${studentBean.name}'>
<span id='nameErrorSection'></span>
</td></tr>
<tr><td>
MobileNumber<input type='text' name='mobileNumber' id='mobileNumber' value='${studentBean.mobileNumber}'>
<span id='mobileNumberErrorSection'></span>
</td></tr>
<tr><td>
Date of Birth
<input type='text' name='dateOfBirth' id='dateOfBirth' value='${studentBean.dateOfBirth}'>
<span id='dateOfBirthErrorSection'></span>
</td></tr>
<tr><td>
<tm:Equals leftOperand="" rightOperand="${studentBean.gender}">
Male<input type='radio' name='sex' id='male' value='M'>
Female<input type='radio' name='sex' id='female' value='F'>
<span id='genderErrorSection'></span>
</tm:Equals>
<tm:Equals leftOperand="M" rightOperand="${studentBean.gender}">
Male<input type='radio' name='sex' id='male' value='M' checked>
Female<input type='radio' name='sex' id='female' value='F'>
<span id='genderErrorSection'></span>
</tm:Equals>
<tm:Equals leftOperand="F" rightOperand="${studentBean.gender}">
Male<input type='radio' name='sex' id='male' value='M'>
Female<input type='radio' name='sex' id='female' value='F' checked>
<span id='genderErrorSection'></span>
</tm:Equals>
</td></tr>
<tr><td>
<tm:Equals leftOperand='on' rightOperand='${studentBean.isIndian}'>
Indian
<input type='checkbox' name='isIndian' id='isIndian' checked>
<span id='isIndianErrorSection'></span>
</tm:Equals>
<tm:NotEquals leftOperand="on" rightOperand="${studentBean.isIndian}">
Indian
<input type='checkbox' name='isIndian' id='isIndian'>
<span id='isIndianErrorSection'></span>
</tm:NotEquals>
</td></tr>
<tr><td>
Select city
<select name='cityCode' id='cityCode'>
<option value='-1'>&lt;Select&gt;</option>
<tm:Iterator collection='${dataModel.cities}' name='city'>
<tm:Equals leftOperand="${city.code}" rightOperand='${studentBean.cityCode}'>
<option value='${city.code}' selected>${city.name}</option>
<span id='cityErrorSection' ></span>
</tm:Equals>
<tm:NotEquals leftOperand="${city.code}" rightOperand='${studentBean.cityCode}'>
<option value='${city.code}'>${city.name}</option>
<span id='cityErrorSection' ></span>
</tm:NotEquals>
</tm:Iterator>
<span id='cityErrorSection'></span>
</select>
</td></tr>
<tr><td>
Select Subjects
<tm:Iterator collection='${dataModel.subjects}' name='subject'>
<input type='checkbox' name='subjectCode' id='subject${subject.code}' value='${subject.code}'>${subject.name} 
<span id='subjectsErrorSection'></span>
<tm:Contains collection='${subject.code}' item='${studentMappingBean.subjectCode}'>
<input type='checkbox' name='subjectCode' id='subject${subject.code}' value='${subject.code}' checked>${subject.name}
<span id='subjectsErrorSection'></span>
</tm:Contains>
<tm:DoesNotContains collection='${subject.code}' item='${studentBean.subjectCode}'>
<input type='checkbox' name='subjectCode' id='subject${subject.code}' value='${subject.code}'>${subject.name}
<span id='subjectsErrorSection'></span>
</tm:DoesNotContains>
</tm:Iterator>
</td></tr><tr>
<td colspan='2' align='center'>
<input type='submit' value='Add'></td>
</tr>
</table>
</form>
</center>
${errorBean.error}
<jsp:include page='/MasterPageBottomSection.jsp' />
