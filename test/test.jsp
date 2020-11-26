<%@taglib uri='/WEB-INF/tlds/tmtags.tld' prefix='tm'%>
<!DOCTYPE HTML>
<html lang='en'>
<head>
<meta charset='utf-8'>
<title>Iterator test case</title>
</head>
<body>
Usage one<br>
<tm:Iterator collection='${dataModel.subjects}' name='subject'>${subjectIndex},${subject.code},${subject.name}<br>
</tm:Iterator>
Usage two<br>
Select city
<select id='cityCode'>
<tm:Iterator collection='${dataModel.cities}' name='city'>
<option value='${city.code}'>${city.name}</option>
</tm:Iterator>
</select>
Usage three<br>
Select city
<tm:Iterator collection='${dataModel.cities}' name='city'>
<input type='checkbox' id='city ${city.code}'>${city.name}<br>
</tm:Iterator>
</body>