package com.thinking.machines.school.beans;
public class CityBean implements java.io.Serializable
{
private int code;
private String name;
public CityBean()
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