package com.thinking.machines.school.tags;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.util.*;
public class IteratorTagHandler extends BodyTagSupport
{
private Object object;
private int index;
private Iterator iterator;
String name;
public void setCollection(Object object)
{
this.object=object;
}
public Object getCollection()
{
return this.object;
}
public void setName(String name)
{
this.name=name;
}
public String getName()
{
return this.name;
}
public IteratorTagHandler()
{
reset();
}
private void reset()
{
this.object=null;
this.name=null;
this.index=0;
this.iterator=null;
}
public int doStartTag()
{
if(!(object instanceof Map|| object instanceof Set|| object instanceof List)) return super.SKIP_BODY;
Collection collection;
if(object instanceof Map)
{
collection=new ArrayList(((Map)object).values());
}
else
{
collection=(Collection)object;
}
iterator=collection.iterator();
if(iterator.hasNext()==false) return super.SKIP_BODY;
pageContext.setAttribute(name,iterator.next(),PageContext.REQUEST_SCOPE);
this.index=0;
pageContext.setAttribute(name+"Index",new Integer(index),PageContext.REQUEST_SCOPE);
return super.EVAL_BODY_INCLUDE;
}
public int doAfterBody()
{
if(iterator.hasNext()==false)return super.SKIP_BODY;
pageContext.setAttribute(name,iterator.next(),PageContext.REQUEST_SCOPE);
this.index++;
pageContext.setAttribute(name+"Index",new Integer(index),PageContext.REQUEST_SCOPE);
return super.EVAL_BODY_AGAIN;
}
public int doEndTag()
{
reset();
return super.EVAL_PAGE;
}
}
