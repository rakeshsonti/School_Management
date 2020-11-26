package com.thinking.machines.school.dl;
import java.sql.*;
public class DAOConnection
{
private static Connection c;
private DAOConnection()
{
c=null;
}
public static Connection getConnection()
{
try
{
Class.forName("org.apache.derby.jdbc.ClientDriver");
c=DriverManager.getConnection("jdbc:derby://localhost:1527/schooldb");
}
catch(Exception exception)
{
exception.printStackTrace();
}
return c;
}
}
