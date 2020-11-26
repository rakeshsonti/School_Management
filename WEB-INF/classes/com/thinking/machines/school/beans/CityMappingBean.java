package com.thinking.machines.school.beans;
//This file is design for default city selected but does not use in project
public class CityMappingBean implements java.io.Serializable
{
private int code;
private String name;
public CityMappingBean()
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
