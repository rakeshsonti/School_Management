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
public class EditStudent extends HttpServlet
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
if((resultSet.next())==false)
{
resultSet.close();
preparedStatement.close();
connection.close();
ErrorBean errorBean=new ErrorBean();
errorBean.setError("Roll number Does not exist");
request.setAttribute("errorBean",errorBean);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/StudentEditForm.jsp");
requestDispatcher.forward(request,response);
return;
}
resultSet.close();
preparedStatement.close();
connection.close();
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/StudentUpdateForm.jsp");
requestDispatcher.forward(request,response);
}
catch(Exception exception)
{
exception.printStackTrace();
}
}
}
