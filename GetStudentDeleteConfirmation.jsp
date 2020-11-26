<!DOCTYPE HTML>
<html lang='en'>
<head>
<meta charset='utf-8'>
</head>
<body>
<%@page import="java.text.*" %>
<%@page import="java.util.*" %>
<%@page import="java.io.*" %>
<%@page import="java.net.*" %>
<%@page import="com.thinking.machines.school.configuration.*" %>
<%@page import="java.sql.*"%>
<%@page import="com.thinking.machines.school.dl.*"%>
<jsp:useBean id='studentBean' scope='request' class='com.thinking.machines.school.beans.StudentBean' />
<%
int rollNumber=Integer.parseInt(request.getParameter("rollNumber"));
request.setAttribute("studentBean",studentBean);
try
{
Connection connection=DAOConnection.getConnection();
Statement statement=connection.createStatement();
String sql="select * from student where roll_number="+rollNumber+"";
ResultSet resultSet=statement.executeQuery(sql);
resultSet.next();
String name=resultSet.getString("name");
String gender=resultSet.getString("gender");
String mobileNumber=resultSet.getString("mobile_number");
int cityCode=resultSet.getInt("city_code");
boolean isIndian=resultSet.getBoolean("is_indian");
java.sql.Date dateOfBirth=resultSet.getDate("date_of_birth");
studentBean.setName(name);
studentBean.setGender(gender);
studentBean.setMobileNumber(mobileNumber);
studentBean.setCityCode(cityCode);
String indian=null;
if(isIndian==true) indian="Yes";
else indian="No";
studentBean.setIsIndian(indian);
DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
String dob = df.format(dateOfBirth);
studentBean.setDateOfBirth(dob);
}catch(Exception e)
{
System.out.println(e);
}
%>
<jsp:setProperty name='studentBean' property='rollNumber' value='<%=rollNumber%>'/>
<input type='hidden' name='rollNumber' id='rollNumber' value='${studentBean.getRollNumber()}'>
<jsp:setProperty name='studentBean' property='rollNumber' value='<%=studentBean.getRollNumber()%>'/>
<form action='/<%=ApplicationSettings.ContextName%>/DeleteStudent2.jsp' onsubmit='return validateForm(this)'>
<center>
<table border='1'>
<tr><td>
RollNumber
</td><td>	
<%=studentBean.getRollNumber()%>
<tr><td>
Name
</td><td>
<%=studentBean.getName()%>
</td></tr>
<tr><td>
Gender
</td><td>
<%=studentBean.getGender()%>
</td></tr>
<tr><td>
Mobile Number
</td><td>
<%=studentBean.getMobileNumber()%>
</td></tr>
<tr><td>
Date Of birth
</td><td>
<%=studentBean.getDateOfBirth()%>
</td></tr>
<tr><td>
Indian
</td><td>
<%=studentBean.getIsIndian()%>
</td></tr>
<tr><td>
City
</td><td>
<%=studentBean.getCityCode()%>
</td></tr>
<tr><td colspan='2' align='center'>
<a href='/<%=ApplicationSettings.ContextName%>/delete2?rollNumber=<%=studentBean.getRollNumber()%>'>Delete</a>
</td></tr>
</table>
</center>
</body>
</html>