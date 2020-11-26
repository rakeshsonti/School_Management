function validForm(frm)
{
var firstInvalidComponenet=null;
var rollNumber=frm.rollNumber.value.trim();
var name=frm.name.value.trim();
var mobileNumber=frm.mobileNumber.value.trim();
var datOfBirth=frm.dateOfBirth.value.trim();
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
valid=false;
rollNumberErrorSection.innerHTML="Required";
firstInvalidComponent=frm.rollNumber;
}
else
{
if(rollNumber.length>10)
{
valid=false;
rollNumberErrorSection.innerHTML="can not exceed 9999999999";
firstInvalidComponent=frm.rollNumber;
}
else
{
var vc='0123456789';
for(var e=0;e<rollNumber.length;e++)
{
if(vc.indexOf(rollNumber.charAt(e))==-1)
{
 valid=false;
firstInvalidComponent=frm.rollNumber;
rollNumberErrorSection.innerHTML='Invalid';
break;
}
}
}
}

if(name.length==0)
{
valid=false;
nameErrorSection.innerHTML=" name Required";
if(firstInvalidComponent==null) firstInvalidComponent=frm.name;
}
else
{
if(name.length>35)
{
valid=false;
if(firstInvalidComponent==null)firstInvalidComponent=frm.name;
nameErrorSection.innerHTML="name can not exceed 35 characters";
}
}
if(mobileNumber.length==0)
{
valid=false;
if(firstInvalidComponent==null)firstInvalidComponent=frm.mobileNumber;
mobileNumberErrorSection.innerHTML="Mobile numberRequired";
}
else
{
if(mobileNumber>15)
{
valid=false;
if(firstInvalidComponent==null)firstInvalidComponent=frm.mobileNumber;
mobileNumberErrorSection.innerHTML="Mobile number can not exceed 15";
}
else
{
var vc="0123456789-+";
for(var e=0;e<mobileNumber.length;e++)
{
if(vc.indexOf(mobileNumber.charAt(e)==-1))
{
valid=false;
mobileNumberErrorSection.innerHTML="Invalid Mobilenumber";
if(firstComponent==null)firstInvalidComponent=frm.mobileNumber;
break;
}
}
}
}
if(dateOfBirth.length==0)
{
valid=false;
if(firstInvalidComponent==null)firstInvalidComponent=frm.dateOfBirth;
dateOfBirthErrorSection.innerHTML='date of birth required';
}
else
{
if(isValidDate(dateOfBirth)==false)
{
valid=false;
if(firstInvalidComponent==null) firstInvalidComponent=frm.dateOfBirth;
dateOfBirthErrorSection.innerHTML="invalid date of birth";
}
}
if(frm.sex[0].checked==false&&frm.sex[1].checked==false)
{
valid=false;
genderErrorSection.innerHTML="gender required";
}
if(frm.cityCode.selectedIndex==0)
{
valid=false;
cityCodeErrorSection.innerHTML="City required";
if(firstInvalidComponent==null)firstInvalidComponent=frm.cityCode;
}
var subjectGroup=frm.subjectCode;
var selectedSubjectCount=0;
subjectGroup.forEach(function(subject){
if(subject.checked)selectedSubjectsCount++;
});
if(selectedSubjectsCount==0)
{
valid=false;
subjectsErrorSection.innerHTML="required";
}
if(!valid)firstInvalidComponent.focus();
return valid;
}
