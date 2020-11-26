function isValidDate(dt)
{
if(dt.length<8||dt.length>10)return false;
var c=0;
for(var i=0;i<dt.length;i++)if(dt.charAt(i)=='/')c++;
if(c!=2)return false;
if((dt.length==8)&&(dt.charAt(1)!='/'||dt.charAt(3)!='/'))return false;
if((dt.length==10)&&(dt.charAt(2)!='/'||dt.charAt(5)!='/'))return false;
if(dt.length==9)
{
if(dt.charAt(4)!='/')return false;
if(!(dt.charAt(1)=='/'||dt.charAt(2)=='/'))return false;
if(dt.charAt(1)=='/'&&dt.charAt(2)=='/')return false;
}
var pcs=dt.split('/');
var day=parseInt(pcs[0]);
var month=parseInt(pcs[1]);
var year=parseInt(pcs[2]);
if(year<1990)return false;
if(month<1||month>12)return false;
var days=[31,28,31,30,31,30,31,31,30,31,30,31];
if((year%400)||((year%4==0)&&(year%100!=0)))
{
days[1]=29;
}
if(day<1||day>days[month-1])return false;
return true;
}