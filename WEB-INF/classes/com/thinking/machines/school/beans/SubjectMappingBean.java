package com.thinking.machines.school.beans;
//this file is design for default subject selected but i does not use this approch in project
public class SubjectMappingBean implements java.io.Serializable
{
private int code;
private String name;
public SubjectMappingBean()
{
code=0;
name="";
}
public void setCode(int code)
{
this.code=code;
}
public int getCode()
{
return this.code;
}
public void setName(String name)
{
this.name=name;
}
public String getName()
{
return this.name;
}
}
