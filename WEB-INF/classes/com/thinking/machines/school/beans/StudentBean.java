package com.thinking.machines.school.beans;
public class StudentBean implements java.io.Serializable
{
private int rollNumber;
private String name;
private String mobileNumber;
private String dateOfBirth;
private String gender;
private String isIndian;
private int cityCode;
private Integer[] subjectGroup;
public StudentBean()
{ 
this.rollNumber=0;
this.name="";
this.mobileNumber="";
this.dateOfBirth="";
this.gender="";
this.isIndian="";
this.cityCode=0;
this.subjectGroup=new Integer[0];
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
public void setCityCode(int cityCode)
{
this.cityCode=cityCode;
}
public int getCityCode()
{
return this.cityCode;
}
public void setSubjectGroup(Integer[] subjectGroup)
{
this.subjectGroup=subjectGroup;
}
public Integer[] getSubjectGroup()
{
return this.subjectGroup;
}
}