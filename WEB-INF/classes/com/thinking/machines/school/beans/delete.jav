package com.thinking.machines.school.beans;
import java.util.*;
import java.util.stream.*;
public class StudentBean implements java.io.Serializable //implements Comparable<StudentBean >
{
private int rollNumber;
private String name;
private String mobileNumber;
private String dateOfBirth;
private String gender;
private String isIndian;;
private int cityCode;
private int[] subjectGroup;
public StudentBean ()
{
rollNumber=0;
name="";
mobileNumber="";
dateOfBirth="";
gender="";
isIndian="";
cityCode=0;
}
public StudentBean (int rollNumber,String name)
{
this.rollNumber=rollNumber;
this.name=name;
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
public void setSubjectCode(int [] subjectCode)
{
this.subjectGroup=subjectCode;
}
public int[] getSubjectCode()
{
return this.subjectGroup;
}

public static void main(String [] args)
{
List<StudentBean>list=new LinkedList<>();
list.add(new StudentBean (101,"Sameer"));
list.add(new StudentBean (102,"Ram"));
list.add(new StudentBean (103,"Sanjna"));
list.add(new StudentBean (104,"Sonu"));
list.add(new StudentBean (105,"Sruti"));
list.add(new StudentBean (106,"Darsika"));
list.add(new StudentBean (107,"Dipa"));
list.add(new StudentBean (108,"Radhika"));
list.add(new StudentBean (109,"jai"));
list.add(new StudentBean (110,"Abdul"));
list.add(new StudentBean (111,"Arun"));
//-----------------------------------------------------------------------------------------------------------------------------------
/*
Collection.sort(list,(left,right)->{
return left.getName().toUpperCase().compareTo(rightName().toUpperCase());
});
*/
//-----------------------------------------------------------------------------------------------------------------------------------
list=list.stream().sorted((left,right)->{
return left.getName().toUpperCase().compareTo(right.getName().toUpperCase());
}).collect(Collectors.toList());
list.forEach((s)->{System.out.println(s.getRollNumber()+","+s.getName());
});
}
}
