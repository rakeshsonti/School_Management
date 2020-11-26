package com.thinking.machines.school.model;
import java.util.*;
import com.thinking.machines.school.beans.*;
public class DataModel
{
public List<CityBean>cities;
public List<SubjectBean>subjects;
public void setCities(List<CityBean>cities)
{
this.cities=cities;
}
public List<CityBean>getCities()
{
return this.cities;
}
public void setSubjects(List<SubjectBean>subjects)
{
this.subjects=subjects;
}
public List<SubjectBean>getSubjects()
{
return this.subjects;
}
}
