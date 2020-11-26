package com.thinking.machines.school.beans;
public class NotificationBean implements java.io.Serializable
{
private String message;
private String title;
private boolean hasButton1;
private boolean hasButton2;
private String button1Text;
private String button2Text;
private String button1Action;
private String button2Action;
public NotificationBean()
{
message="";
title="";
hasButton1=false;
hasButton2=false;
button1Text="";
button2Text="";
button1Action="";
button2Action="";
}
public void setMessage(String message)
{
this.message=message;
}
public String getMessage()
{
return this.message;
}
public void setTitle(String title)
{
this.title=title;
}
public String getTitle()
{
return this.title;
}
public void setHasButton1(boolean hasButton1)
{
this.hasButton1=hasButton1;
}
public boolean getHasButton1()
{
return this.hasButton1;
}

public void setHasButton2(boolean hasButton2)
{
this.hasButton2=hasButton2;
}
public boolean getHasButton2()
{
return this.hasButton2;
}

public void setButton1Text(String button1Text)
{
this.button1Text=button1Text;
}
public String getButton1Text()
{
return this.button1Text;
}

public void setButton2Text(String button2Text)
{
this.button2Text=button2Text;
}
public String getButton2Text()
{
return this.button2Text;
}

public void setButton1Action(String buttton1Action)
{
this.button1Action=button1Action;
}
public String getButton1Action()
{
return this.button1Action;
}

public void setButton2Action(String buttton2Action)
{
this.button2Action=button2Action;
}
public String getButton2Action()
{
return this.button2Action;
}
}


