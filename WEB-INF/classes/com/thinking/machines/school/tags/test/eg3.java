public class eg3
{
 int SKIP_BODY=0;
int EVAL_BODY_INCLUDE=1;
int greaterThan(Comparable leftOperand,Comparable rightOperand)
{
if(leftOperand instanceof Boolean || rightOperand instanceof Boolean) return SKIP_BODY;
 if(leftOperand==null || rightOperand==null) return SKIP_BODY;
String leftClassName=leftOperand.getClass().getName();
String rightClassName=rightOperand.getClass().getName();
if(leftClassName.equals(rightClassName))
{
 if(leftClassName.equals("java.lang.String"))
{
 if(isStringInteger(leftOperand) && isStringInteger(rightOperand))
{
Long left=longValue(leftOperand);
Long right=longValue(rightOperand);
return (left.compareTo(right)>0)?EVAL_BODY_INCLUDE:SKIP_BODY;
}
 if(isStringFractional(leftOperand) && isStringFractional(rightOperand))
{
Double left=doubleValue(leftOperand);
Double right=doubleValue(rightOperand);
return (left.compareTo(right)>0)?EVAL_BODY_INCLUDE:SKIP_BODY;
}
 if(isStringInteger(leftOperand) && isStringFractional(rightOperand))
{
Double left=doubleValue(leftOperand);
Double right=doubleValue(rightOperand);
return (left.compareTo(right)>0)?EVAL_BODY_INCLUDE:SKIP_BODY;
}
 if(isStringFractional(leftOperand) && isStringInteger(rightOperand))
{
Double left=doubleValue(leftOperand);
Double right=doubleValue(rightOperand);
return (left.compareTo(right)>0)?EVAL_BODY_INCLUDE:SKIP_BODY;
}
}
return (leftOperand.compareTo(rightOperand)>0)?EVAL_BODY_INCLUDE:SKIP_BODY;
}
 if(isIntegerCategory(leftOperand) && isIntegerCategory(rightOperand))
{
Long left=longValue(leftOperand);
Long right=longValue(rightOperand);
return (left.compareTo(right)>0)?EVAL_BODY_INCLUDE:SKIP_BODY;
}
 if(isFractionalCategory(leftOperand) && isFractionalCategory(rightOperand))
{
Double left=doubleValue(leftOperand);
Double right=doubleValue(rightOperand);
return (left.compareTo(right)>0)?EVAL_BODY_INCLUDE:SKIP_BODY;
}
 if((isIntegerCategory(leftOperand) && isFractionalCategory(rightOperand)) ||(isIntegerCategory(rightOperand) && isFractionalCategory(leftOperand)))
{
Double left=doubleValue(leftOperand);
Double right=doubleValue(rightOperand);
return (left.compareTo(right)>0)?EVAL_BODY_INCLUDE:SKIP_BODY;
} 
if((isIntegerCategory(leftOperand) && isStringFractional(rightOperand)) ||(isStringFractional(leftOperand) && isIntegerCategory(rightOperand)))
{
Double left=doubleValue(leftOperand);
Double right=doubleValue(rightOperand);
return (left.compareTo(right)>0)?EVAL_BODY_INCLUDE:SKIP_BODY;
} 
if((isIntegerCategory(leftOperand) && isStringInteger(rightOperand)) || (isStringInteger(leftOperand)&& isIntegerCategory(rightOperand)))
{
Long left=longValue(leftOperand);
Long right=longValue(rightOperand);
return (left.compareTo(right)>0)?EVAL_BODY_INCLUDE:SKIP_BODY;
}
 if((isFractionalCategory(leftOperand) && isStringFractional(rightOperand)) ||(isStringFractional(leftOperand) && isFractionalCategory(rightOperand)))
{
Double left=doubleValue(leftOperand);
Double right=doubleValue(rightOperand);
return (left.compareTo(right)>0)?EVAL_BODY_INCLUDE:SKIP_BODY;
} 
if((isFractionalCategory(leftOperand) && isStringInteger(rightOperand)) ||(isStringInteger(leftOperand) && isFractionalCategory(rightOperand)))
{
Double left=doubleValue(leftOperand);
Double right=doubleValue(rightOperand);
return (left.compareTo(right)>0)?EVAL_BODY_INCLUDE:SKIP_BODY;
}
 if((isCharacter(leftOperand) && isString(rightOperand)) || (isString(leftOperand) &&isCharacter(rightOperand)))
{
 char left=getChar(leftOperand);
char right=getChar(rightOperand);
return (left>right)?EVAL_BODY_INCLUDE:SKIP_BODY;
}
 return SKIP_BODY;
}
public char getChar(Object object)
{
 if(object instanceof String)
{
String s=(String)object;
if(s.length()>0) return s.charAt(0); else return (char)0;
}
 if(object instanceof Character)
{
Character c=(Character)object;
return c.charValue();
}
return (char)0;
}
public Long longValue(Object object)
{
 if(object instanceof Long) return (Long)object;
if(object instanceof Integer) return ((Integer)object).longValue();
if(object instanceof Short) return ((Short)object).longValue();
if(object instanceof Byte) return ((Byte)object).longValue();
return Long.parseLong((String)object);
}
public Double doubleValue(Object object)
{ 
if(object instanceof Double) return (Double)object;
if(object instanceof Float) return ((Float)object).doubleValue();
if(object instanceof Long) return ((Long)object).doubleValue();
if(object instanceof Integer) return ((Integer)object).doubleValue();
if(object instanceof Short) return ((Short)object).doubleValue();
if(object instanceof Byte) return ((Byte)object).doubleValue();
return Double.parseDouble((String)object);
}
private static boolean isIntegerCategory(Object object)
{
 if(object instanceof Long) return true;
if(object instanceof Integer) return true;
if(object instanceof Short) return true;
if(object instanceof Byte) return true;
return false;
}
private static boolean isFractionalCategory(Object object)
{
 if(object instanceof Double) return true;
if(object instanceof Float) return true;
return false;
}
private static boolean isStringInteger(Object object)
{
 if(!(object instanceof String)) return false;
try
{
Long.parseLong((String)object);
return true;
}catch(NumberFormatException nfe)
{
return false;
}
}
private static boolean isStringFractional(Object object)
{
 if(!(object instanceof String)) return false;
try
{
Double.parseDouble((String)object);
return true;
}catch(NumberFormatException nfe)
{
return false;
}}
private static boolean isWrapper(Object object)
{
 if(object instanceof Long) return true;
if(object instanceof Integer) return true;
if(object instanceof Short) return true;
if(object instanceof Byte) return true;
if(object instanceof Double) return true;
if(object instanceof Float) return true;
if(object instanceof Character) return true;
if(object instanceof Boolean) return true;
if(object instanceof String) return true;
if(object instanceof java.util.Date) return true;
if(object instanceof java.sql.Date) return true;
return false;
}
private static boolean isString(Object object)
{
return object instanceof String;
}
private static boolean isCharacter(Object object)
{
 try
{
Character c=(Character)object;
return true;
}catch(Throwable t)
{
return false;
}
}
public static void main(String gg[])
{
String oo[]=new String[2];
oo[0]="SKIP_BODY";
oo[1]="EVAL_BODY_INCLUDE";
eg3 a=new eg3();
System.out.println(oo[a.greaterThan('b','a')]);
System.out.println(oo[a.greaterThan(10,20)]);
System.out.println(oo[a.greaterThan("10","5")]);
System.out.println(oo[a.greaterThan(true,false)]);
System.out.println(oo[a.greaterThan(10,"5")]);
System.out.println(oo[a.greaterThan("10",20)]);
// Write many more
}}