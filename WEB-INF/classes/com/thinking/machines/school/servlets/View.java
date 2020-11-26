package com.thinking.machines.school.servlets;
import java.text.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.util.*;
import static com.thinking.machines.school.configuration.ApplicationSettings.*;
import com.thinking.machines.school.dl.*;
import com.thinking.machines.school.beans.*;
import com.thinking.machines.school.model.*;
import java.sql.*;
public class View extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
doPost(request,response);
}
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
 try
{
List<StudentsBean> studentsBean=(List<StudentsBean>)request.getAttribute("list");
 for(StudentsBean sb:studentsBean)
{ 
int rollNumber=sb.getRollNumber();
String name=sb.getName();
String gender=sb.getGender();
String mobileNumber=sb.getMobileNumber();
CityBean cityBean=sb.getCity();
String city=cityBean.getName();
String indian=sb.getIsIndian();
List<SubjectBean> subjectBean=sb.getSubjects();
for(SubjectBean sbb:subjectBean)
{
System.out.println(sbb.getName());

}
System.out.println("-------------------------------------------------");
System.out.println(rollNumber+name+gender+mobileNumber+city+indian);
System.out.println("-----------------record finish--------------------------------");
}
}
catch(Exception exception)
{
exception.printStackTrace();
}
}
}
