package com.thinking.machines.school.servlets.startup;
import com.thinking.machines.school.model.*;
import com.thinking.machines.school.beans.*;
import com.thinking.machines.school.dl.*;
import java.util.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Startup extends HttpServlet
{
public void init()
{
try
{
System.out.println("--------------------------------------------------------------Ram Sonti- LOADING------------------------------------");
List<CityBean>cityList=new LinkedList<>();
List<SubjectBean> subjectList=new LinkedList<>();
Connection c=DAOConnection.getConnection();
Statement s=c.createStatement();
ResultSet r=s.executeQuery("select * from city");
CityBean city;
while(r.next())
{
city=new CityBean();
int code=r.getInt("code");
String name=r.getString("name");                                             
city.setCode(code);
city.setName(name);
System.out.println(name);
cityList.add(city);
}
System.out.println("-------------------------------------------------------------");
SubjectBean subject;
r=s.executeQuery("select * from subject");
while(r.next())
{
subject=new SubjectBean();
int code=r.getInt("code");
String name=r.getString("name");
subject.setCode(code);
subject.setName(name);
System.out.println(name);
subjectList.add(subject);
}
//----------------------------------------------------------------------------------------------------------------
ServletContext sc1;
sc1=getServletContext();
StudentBean studentBean1;
studentBean1=new StudentBean();
sc1.setAttribute("studentBean",studentBean1);
//---------------------------------------------------------------------------------------------------------
DataModel dm=new DataModel();
dm.cities=cityList;
dm.subjects=subjectList;
ServletContext sc;
sc=getServletContext();
sc.setAttribute("dataModel",dm);
System.out.println("--------------------------------------------------------------Ram Sonti- LOADED------------------------------------");
s.close();
c.close();
}
catch(Exception e)
{
e.printStackTrace();
}
}
}
