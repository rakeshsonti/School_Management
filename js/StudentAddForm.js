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
var dateOfBirthErrorSection=document.getElementById("dateOfBirthErrorSection");
var genderErrorSection=document.getElementById("genderErrorSection");
var cityCodeErrorSection=document.getElementById("cityCodeErrorSection");
var subjectGroupErrorSection=document.getElementById("subjectGroupErrorSection");
var valid=true;
rollNumberErrorSection.innerHTML='';
nameErrorSection.innerHTML='';
mobileNumberErrorSection.innerHTML='';
genderErrorSection.innerHTML='';
cityCodeErrorSection.innerHTML='';
subjectGroupErrorSection.innerHTML='';
dateOfBirthErrorSection.innerHTML='';
if(rollNumber.length==0)
{
valid=false;
rollNumberErrorSection.innerHTML="Required";
firstInvalidComponent=frm.rollNumber;
} else if(rollNumber.length>10)
{
valid=false;
rollNumberErrorSection.innerHTML="Cannot exceed 9999999999";
firstInvalidComponent=frm.rollNumber;
} else
{
var vc='0123456789';
for(var e=0;e<rollNumber.length;e++)
{ if(vc.indexOf(rollNumber.charAt(e))==-1)
{
valid=false;
firstInvalidComponent=frm.rollNumber;
rollNumberErrorSection.innerHTML='Invalid';
break;
}
} if(valid && parseInt(rollNumber)==0)
{
valid=false;
firstInvalidComponent=frm.rollNumber;
rollNumberErrorSection.innerHTML='Invalid';
}} if(name.length==0)
{
valid=false;
nameErrorSection.innerHTML="Required";
if(firstInvalidComponent==null) firstInvalidComponent=frm.name;
} else
{ if(name.length>35)
{
valid=false;
if(firstInvalidComponent==null) firstInvalidComponent=frm.name;
nameErrorSection.innerHTML="Cannot exceed 35 characters";
}} if(mobileNumber.length==0)
{
valid=false;
mobileNumberErrorSection.innerHTML="Required";
if(firstInvalidComponent==null) firstInvalidComponent=frm.mobileNumber;
} else
{ if(mobileNumber.length>15)
{
valid=false;
if(firstInvalidComponent==null) firstInvalidComponent=frm.mobileNumber;
mobileNumberErrorSection.innerHTML="Cannot exceed 15";
} else
{
var vc="0123456789-+ ";
for(var e=0;e<mobileNumber.length;e++)
{ if(vc.indexOf(mobileNumber.charAt(e))==-1)
{
valid=false;
mobileNumberErrorSection.innerHTML='Invalid';
if(firstInvalidComponent==null) firstInvalidComponent=frm.mobileNumber;
break;
}}}} if(dateOfBirth.length==0)
{
valid=false;
if(firstInvalidComponent==null) firstInvalidComponent=frm.dateOfBirth;
dateOfBirthErrorSection.innerHTML="Required";
} else
{ if(isValidDate(dateOfBirth)==false)
{
valid=false;
if(firstInvalidComponent==null) firstInvalidComponent=frm.dateOfBirth;
dateOfBirthErrorSection.innerHTML="Invalid";
}} if(frm.gender[0].checked==false && frm.gender[1].checked==false)
{
valid=false;
genderErrorSection.innerHTML="Required";
} if(frm.cityCode.selectedIndex==0)
{
valid=false;
cityCodeErrorSection.innerHTML="Required";
if(firstInvalidComponent==null) firstInvalidComponent=frm.cityCode;
}
var subjectGroup=frm.subjectGroup;
var selectedSubjectsCount=0;
subjectGroup.forEach(function(subject){
if(subject.checked) selectedSubjectsCount++;
});
if(selectedSubjectsCount==0)
{
valid=false;
subjectGroupErrorSection.innerHTML="Required";
} if(!valid && firstInvalidComponent) firstInvalidComponent.focus();
return valid;
}