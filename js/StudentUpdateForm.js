function validateForm(frm)
{
var firstInvalidComponent=null;
var name=frm.name.value.trim();
var mobileNumber=frm.mobileNumber.value.trim();
var dateOfBirth=frm.dateOfBirth.value.trim();
var nameErrorSection=document.getElementById("nameErrorSection");
var mobileNumberErrorSection=document.getElementById("mobileNumberErrorSection");
var dateOfBirthErrorSection=document.getElementById("dateOfBirthErrorSection");
var genderErrorSection=document.getElementById("genderErrorSection");
var cityCodeErrorSection=document.getElementById("cityCodeErrorSection");
var subjectGroupErrorSection=document.getElementById("subjectGroupErrorSection");
var valid=true;
nameErrorSection.innerHTML='';
mobileNumberErrorSection.innerHTML='';
genderErrorSection.innerHTML='';
cityCodeErrorSection.innerHTML='';
subjectGroupErrorSection.innerHTML='';
dateOfBirthErrorSection.innerHTML='';
 if(name.length==0)
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