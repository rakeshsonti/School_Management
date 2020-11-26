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
public class ViewStudent extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
doPost(request,response);
}
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
try
{
List<StudentsBean> students=new LinkedList<>();
Connection connection=DAOConnection.getConnection();
ResultSet resultSet1;
Statement statement=connection.createStatement();
resultSet1=statement.executeQuery("select * from student");
int cityCode;
while(resultSet1.next())
{
StudentsBean student=new StudentsBean();
student.setRollNumber(resultSet1.getInt("roll_number"));
student.setName(resultSet1.getString("name"));
student.setMobileNumber(resultSet1.getString("mobile_number"));
student.setGender(resultSet1.getString("gender"));
student.setIsIndian(resultSet1.getString("is_indian"));
student.setDateOfBirth(resultSet1.getString("date_of_birth"));
cityCode=resultSet1.getInt("city_code");
PreparedStatement prepareStatement2;
prepareStatement2=connection.prepareStatement("select * from city where code=?");
prepareStatement2.setInt(1,cityCode);
ResultSet resultSet2;
resultSet2=prepareStatement2.executeQuery();
resultSet2.next();
CityBean city=new CityBean();
city.setCode(resultSet2.getInt("code"));
city.setName(resultSet2.getString("name").trim());
resultSet2.close();
prepareStatement2.close();
student.setCity(city);
List<SubjectBean>subjects;
subjects=new LinkedList<SubjectBean>();
PreparedStatement prepareStatement3;
prepareStatement3=connection.prepareStatement("select * from student_subject where roll_number=?");
prepareStatement3.setInt(1,student.getRollNumber());
ResultSet resultSet3;
resultSet3=prepareStatement3.executeQuery();
while(resultSet3.next())
{
int subjectCode=resultSet3.getInt("subject_code");
PreparedStatement prepareStatement4;
prepareStatement4=connection.prepareStatement("select * from subject where code=?");
prepareStatement4.setInt(1,subjectCode);
ResultSet resultSet4;
resultSet4=prepareStatement4.executeQuery();
resultSet4.next();
SubjectBean subject=new SubjectBean();
subject.setCode(resultSet4.getInt("code"));
subject.setName(resultSet4.getString("name").trim());
resultSet4.close();
prepareStatement4.close();
subjects.add(subject);
}
resultSet3.close();
prepareStatement3.close();
student.setSubjects(subjects);
students.add(student);
}
resultSet1.close();
statement.close();
connection.close();
request.setAttribute("list",students);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/StudentViewForm.jsp");
requestDispatcher.forward(request,response);
}
catch(Exception e)
{
System.out.println(e);
}
}
}