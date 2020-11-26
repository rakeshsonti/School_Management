package com.thinking.machines.school.beans;
import java.util.*;
public class StudentsBean implements java.io.Serializable
{
private int rollNumber;
private String name;
private String mobileNumber;
private String dateOfBirth;
private String gender;
private String isIndian;
private CityBean city;
private List<SubjectBean> subjects;
public StudentsBean()
{ 
this.rollNumber=0;
this.name="";
this.mobileNumber="";
this.dateOfBirth="";
this.gender="";
this.isIndian="";
this.city=null;
this.subjects=null;
}
public void setRollNumber(int rollNumber)
{
this.rollNumber=rollNumber;
}
public int getRollNumber()
{
return this.rollNumber;
}
public void setName(String name)
{
this.name=name;
}
public String getName()
{
return this.name;
}
public void setMobileNumber(String mobileNumber)
{
this.mobileNumber=mobileNumber;
}
public String getMobileNumber()
{
return this.mobileNumber;
}
public void setDateOfBirth(String dateOfBirth)
{
this.dateOfBirth=dateOfBirth;
}
public String getDateOfBirth()
{
return this.dateOfBirth;
}
public void setGender(String gender)
{
this.gender=gender;
}
public String getGender()
{
return this.gender;
}
public void setIsIndian(String isIndian)
{
this.isIndian=isIndian;
}
public String getIsIndian()
{
return this.isIndian;
}
public void setCity(CityBean city)
{
this.city=city;
}
public CityBean getCity()
{
return this.city;
}
public void setSubjects(List<SubjectBean>subjects)
{
this.subjects=subjects;
}
public List<SubjectBean> getSubjects()
{
return this.subjects;
}
}