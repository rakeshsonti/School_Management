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
public class DeleteStudent2 extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
doPost(request,response);
}
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
try
{
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
int rollNumber=Integer.parseInt(request.getParameter("rollNumber"));
preparedStatement=connection.prepareStatement("select * from student where roll_number=?");
preparedStatement.setInt(1,rollNumber);
ResultSet resultSet=preparedStatement.executeQuery();
preparedStatement=connection.prepareStatement("delete from student_subject where roll_number=?");
preparedStatement.setInt(1,rollNumber);
preparedStatement.executeUpdate();
preparedStatement=connection.prepareStatement("delete from student where roll_number=?");
preparedStatement.setInt(1,rollNumber);
preparedStatement.executeUpdate();
preparedStatement.close();
connection.close();
NotificationBean notificationBean;
notificationBean=new NotificationBean();
notificationBean.setMessage("Student deleted");
notificationBean.setTitle("Student (delete Module)");
notificationBean.setHasButton1(true);
notificationBean.setHasButton2(true);
notificationBean.setButton1Text("Yes");
notificationBean.setButton2Text("No");
notificationBean.setButton1Action("StudentDeleteForm.jsp");
notificationBean.setButton2Action(HomePage);
request.setAttribute("notificationBean",notificationBean);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/Notification.jsp");
requestDispatcher.forward(request,response);
}catch(Exception exception)
{
exception.printStackTrace();
}
}
}