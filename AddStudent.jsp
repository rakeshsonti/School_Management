<!DOCTYPE HTML>
<html lang='en'>
<head>
<meta charset='utf-8'>
</head>
<body>
<%@page import="com.thinking.machines.school.configuration.*" %>
<jsp:useBean id='studentBean' scope='request' class='com.thinking.machines.school.beans.StudentBean' />
<%
int rollNumber=Integer.parseInt(request.getParameter("rollNumber"));
String name=request.getParameter("name");
String mobileNumber=request.getParameter("mobileNumber");
String dateOfBirth=request.getParameter("dateOfBirth");
String gender=request.getParameter("gender");
int cityCode=Integer.parseInt(request.getParameter("cityCode"));
String isIndian=request.getParameter("isIndian");
String []sg=request.getParameterValues("subjectGroup");
int siz=sg.length;
int i=0;
Integer [] intArray=new Integer[siz];
for(String str:sg)
{
intArray[i]=Integer.parseInt(str);
i++;
}
%>
<jsp:setProperty name='studentBean' property='rollNumber' value='<%=rollNumber%>'/>
<jsp:setProperty name='studentBean' property='name' value='<%=request.getParameter("name")%>' />
<jsp:setProperty name='studentBean' property='gender' value='<%=request.getParameter("gender")%>' />
<jsp:setProperty name='studentBean' property='mobileNumber' value='<%=request.getParameter("mobileNumber")%>' />
<jsp:setProperty name='studentBean' property='dateOfBirth' value='<%=request.getParameter("dateOfBirth")%>' />
<jsp:setProperty name='studentBean' property='cityCode' value='<%=cityCode%>'/>
<jsp:setProperty name='studentBean' property='isIndian' value='<%=request.getParameter("isIndian")%>' />
<jsp:setProperty name='studentBean' property='subjectGroup' value='<%=intArray%>' />
<jsp:forward page='/add' />
</body>
</html>