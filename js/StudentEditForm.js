function validateForm(frm)
{
var firstInvalidComponent=null;
var rollNumber=frm.rollNumber.value.trim();
var rollNumberErrorSection=document.getElementById("rollNumberErrorSection");
var valid=true;
rollNumberErrorSection.innerHTML='';
if(rollNumber.length==0)
{
valid=false;
rollNumberErrorSection.innerHTML="Required";
firstInvalidComponent=frm.rollNumber;
}
else if(rollNumber.length>10)
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
}
 if(valid && parseInt(rollNumber)==0)
{
valid=false;
firstInvalidComponent=frm.rollNumber;
rollNumberErrorSection.innerHTML='Invalid';
}
} 
if(!valid && firstInvalidComponent) firstInvalidComponent.focus();
return valid;
}