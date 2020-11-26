function validateForm(frm)
{
var firstInvalidComponent=null;
var rollNumber=frm.rollNumber.value.trim();
var name=frm.name.value.trim();
var mobileNumber=frm.mobileNumber.value.trim();
var dateOfBirth=frm.dateOfBirth.value.trim();
var rollNumberErrorSection=document.getElementById("rollNumberErrorSection");
var nameErrorSection=document.getElementById("nameErrorSection");
var mobileNumberErrorSection=document.getElementById("mobileNumberErrorSection");
var dateOfBirthNumberErrorSection=document.getElementById("dateOfBirthErrorSection");
var genderErrorSection=document.getElementById("genderErrorSection");
var cityCodeErrorSection=document.getElementById("cityCodeErrorSection");
var subjectGroupErrorSection=document.getElementById("subjectGroupErrorSection");
var valid=true;
rollNumberErrorSection.innerHTML='';
nameErrorSection.innerHTML='';
mobileNumberErrorSection.innerHTML='';
dateOfBirthErrorSection.innerHTML='';
genderErrorSection.innerHTML='';
cityCodeErrorSection.innerHTML='';
subjectGroupErrorSection.innerHTML='';
if(rollNumber.length==0)
{
alert("ram2");
rollNumberErrorSection.innerHTML='Roll number required';
firstInvalidComponent=rollNumber;
valid=false;
}
else
{
alert("ram3");
if(rollNumber.length>10)
{
rollNumberErrorSection.innerHTML='Roll number length can not be greater than 10';
firstInvalidComponent=rollNumber;
valid=false;
}
else
{
var vc='0123456789';
for(var i=0;i<rollNumber.length;i++)
{
if(vc.indexOf(charAt(i))==-1)
{
rollNumberErrorSection.innerHTML='invalid rollNumber';
firstInvalidComponent=rollNumber;
valid=false;
break;
}
}
}
if(valid && parseInt(rollNumber)==0)
{
rollNumberErrorSection.innerHTML='invalid rollNumber';
firstInvalidComponent=rollNumber;
valid=false;
}
}
alert("name");
if(name.length==0)
{
nameErrorSection.innerHTML=' name required';
valid=false;
if(firstInvalidComponent==null) firstInvalidComponent=name;
}
else
{
if(name.length>35)
{
nameErrorSection.innerHTML=' name can not exceed 35 character';
valid=false;
if(firstInvalidComponent==null) firstInvalidComponent=name;
}
}
if(mobileNumber.length==0)
{
mobileNumberErrorSection.innerHTML='mobile number required';
if(firstInvalidComponent==null) firstInvalidComponent=mobileNumber;
valid=false;
}
else
{
if(mobileNumber.length>15)
{
mobileNumberErrorSection.innerHTML='mobile number length can not be greater than 15';
if(firstInvalidComponent==null)firstInvalidComponent=mobileNumber;
valid=false;
}
else
{
var vc="0123456789-+";
for(var i=0;i<mobileNumber.length;i++)
{
if(vc.indexOf(charAt(i))==-1)
{
mobileNumberErrorSection.innerHTML='invalid mobileNumber';
if(firstInvalidComponent==null)firstInvalidComponent=mobileNumber;
valid=false;
break;
}
}
}
if(valid && parseInt(mobileNumber)==0)
{
mobileNumberErrorSection.innerHTML='invalid mobileNumber';
if(firstInvalidComponent==null)firstInvalidComponent=mobileNumber;
valid=false;
}
}
if(dateOfBirth.length==0)
{
valid=false;
dateOfBirthErrorSection.innerHTML="date of birth required";
if(firstInvalidComponent==null)firstInvalidComponent=dateOfBirth;
}
else
{
if(isValidDate(dateOfBirth)==false)
{
valid=false;
dateOfBirthErrorSection.innerHTML="dateOfBirth Invalid";
if(firstInvalidComponent==null)firstInvalidComponent=dateOfBirth;
}
}
if(frm.gender[0].checked==false&& frm.gender[1].checked==false)
{
valid=false;
genderErrorSection.innerHTML="gender required";
}
if(frm.cityCode.selectedIndex==0)
{
valid=false;
cityCodeErrorSection.innerHTML="city required";
if(firstInvalidComponent==null)firstInvalidComponent=frm.cityCode;
}
var subjectGroup=frm.subjectGroup;
var selectedSubjectsCount=0;
subjectGroup.forEach(function(subject)
{
if(subject.checked)selectedSubjectCount++;
});
if(selectedSubjectsCount==0)
{
valid=false;
subjectGroupErrorSection.innerHTML="Required";
}
if(!valid&&firstInvalidComponent)firstInvalidComponent.focus();
return valid;
}