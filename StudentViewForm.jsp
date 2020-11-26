<%@page import="com.thinking.machines.school.configuration.*" %>
<%@page import="com.thinking.machines.school.beans.*" %>
<%@page import="java.util.*" %>
<%@taglib uri='/WEB-INF/tlds/tmtags.tld' prefix='tm' %>
<jsp:include page='/MasterPageTopSection.jsp' />
<div class='module'>
<jsp:useBean id='studentsBean' scope='request' class='com.thinking.machines.school.beans.StudentsBean' />
<jsp:useBean id='studentBean' scope='request' class='com.thinking.machines.school.beans.StudentBean' />
<jsp:useBean id='errorBean' scope='request' class='com.thinking.machines.school.beans.ErrorBean' />
<h3><center>Student (View Module)</center></h3>
<jsp:getProperty name='errorBean' property='error' />
<body>
<center>
<table border='1'>
<thead>
<tr><th>S.No.</th><th>Roll Number</th><th>Name</th><th>Mobile Number</th><th>Gender</th><th>City</th><th>Indian</th><th>DOB</th><th>subjects</th><th>Update</th><th>Delete</th>
</tr>
</thead>
<tr>
<%
int sno=1;
List<StudentsBean> list=(LinkedList<StudentsBean>)request.getAttribute("list");
%>
<tm:Iterator collection='${list}' name='student'>
<td><%=sno%><%sno++;%></td>
<td>${student.getRollNumber()}</td>
<td>${student.getName()}</td>
<td>${student.getMobileNumber()}</td>
<td>${student.getGender()}</td>
<td>${student.getCity().getName()}</td>
<td>${student.getIsIndian()}</td>
<td>${student.getDateOfBirth()}</td>
<td>
<tm:Iterator collection='${student.getSubjects()}' name='subject'>
${subject.getName()}
</tm:Iterator>
</td>
<jsp:setProperty name='studentBean' property='rollNumber' value='${student.getRollNumber()}'/>
<td><a href='/<%=ApplicationSettings.ContextName%>/StudentUpdateForm.jsp?rollNumber=${student.getRollNumber()}&kalu=1'>edit</a></td>
<td><a href='/<%=ApplicationSettings.ContextName%>/GetStudentDeleteConfirmation.jsp?rollNumber=${student.getRollNumber()}&kalu=1'>delete</a></td>
</tr>
</tm:Iterator>
<tr><td colspan='11'><center>
<a  type='button' href='/<%=ApplicationSettings.ContextName%>/index.jsp' ><h3>Home</h3></a>
</center></td></tr>
</table>
</center>
</body>
</div>
<jsp:include page='/MasterPageBottomSection.jsp' />