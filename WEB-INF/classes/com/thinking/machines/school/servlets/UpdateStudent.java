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
public class UpdateStudent extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
doPost(request,response);
}
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
try
{
StudentBean studentBean=(StudentBean)request.getAttribute("studentBean");
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select * from student where roll_number=?");
int rollNumber=studentBean.getRollNumber();
preparedStatement.setInt(1,rollNumber);
ResultSet resultSet=preparedStatement.executeQuery();
if(resultSet.next())
{
resultSet.close();
preparedStatement.close();
preparedStatement=connection.prepareStatement("select * from student where mobile_number=? and roll_number=?");
String mobileNumber=studentBean.getMobileNumber();
preparedStatement.setString(1,mobileNumber);
int rn=studentBean.getRollNumber();
preparedStatement.setInt(2,rn);
resultSet=preparedStatement.executeQuery();
if(resultSet.next())
{
resultSet.close();
preparedStatement.close();
connection.close();
ErrorBean errorBean=new ErrorBean();
errorBean.setError("Mobile number exists");
request.setAttribute("errorBean",errorBean);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/StudentUpdateForm.jsp");
requestDispatcher.forward(request,response);
return;
}
resultSet.close();
preparedStatement.close();
DataModel dataModel=(DataModel)getServletContext().getAttribute("dataModel");
int cityCode=studentBean.getCityCode();
if(dataModel.cities.stream().anyMatch((city)->{return city.getCode()==cityCode;})==false)
{
ErrorBean errorBean=new ErrorBean();
errorBean.setError("Invalid city");
request.setAttribute("errorBean",errorBean);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/StudentUpdateForm.jsp");
requestDispatcher.forward(request,response);
return;
}
Integer [] subjectCodes=studentBean.getSubjectGroup();
for(int subjectCode:subjectCodes)
{
if(dataModel.subjects.stream().anyMatch((subject)->subject.getCode()==subjectCode)==false)
{
ErrorBean errorBean=new ErrorBean();
errorBean.setError("Invalid subject");
request.setAttribute("errorBean",errorBean);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/StudentUpdateForm.jsp");
requestDispatcher.forward(request,response);
return;
}
}
String name=studentBean.getName().trim();
String gender=studentBean.getGender();
SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
java.util.Date utilDateOfBirth=sdf.parse(studentBean.getDateOfBirth());
java.sql.Date sqlDateOfBirth=new
java.sql.Date(utilDateOfBirth.getYear(),utilDateOfBirth.getMonth(),utilDateOfBirth.getDate());
boolean isIndian=false;
if(studentBean.getIsIndian()!=null)
{
isIndian=(studentBean.getIsIndian().equals("Y"))?true:false;
}
preparedStatement=connection.prepareStatement("update student set name=?,mobile_number=?,date_of_birth=?,gender=?,is_indian=?,city_code=? where roll_number=?");
preparedStatement.setString(1,name);
preparedStatement.setString(2,mobileNumber);
preparedStatement.setDate(3,sqlDateOfBirth);
preparedStatement.setString(4,gender);
preparedStatement.setBoolean(5,isIndian);
preparedStatement.setInt(6,cityCode);
preparedStatement.setInt(7,rollNumber);
preparedStatement.executeUpdate();
preparedStatement=connection.prepareStatement("delete from student_subject where roll_number=?");
preparedStatement.setInt(1,rollNumber);
preparedStatement.executeUpdate();
preparedStatement.close();
for(int subjectCode:subjectCodes)
{
preparedStatement=connection.prepareStatement("insert into student_subject values(?,?)");
preparedStatement.setInt(1,rollNumber);
preparedStatement.setInt(2,subjectCode);
preparedStatement.executeUpdate();
preparedStatement.close();
}
connection.close();
NotificationBean notificationBean;
notificationBean=new NotificationBean();
notificationBean.setMessage("Student updated");
notificationBean.setTitle("Student (Add Module)");
notificationBean.setHasButton1(true);
notificationBean.setHasButton2(true);
notificationBean.setButton1Text("Yes");
notificationBean.setButton2Text("No");
notificationBean.setButton1Action("StudentUpdateForm.jsp");
notificationBean.setButton2Action(HomePage);
request.setAttribute("notificationBean",notificationBean);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/Notification.jsp");
requestDispatcher.forward(request,response);
}
else
{
resultSet.close();
preparedStatement.close();
connection.close();
ErrorBean errorBean=new ErrorBean();
errorBean.setError("Roll number does not EXISTS");
request.setAttribute("errorBean",errorBean);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/StudentUpdateForm.jsp");
requestDispatcher.forward(request,response);
return;
}
}
catch(Exception exception)
{
exception.printStackTrace();
}
}
}