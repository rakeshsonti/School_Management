public class compareTo {
public static void main(String args[]) {
String str1 = "A1";
String str2 = "A2";
int var1 = str1.compareTo( str2 );
System.out.println("str1 & str2 comparison: "+var1);


//----------------------------------------------------------------------------------------------------------------












String str3 = "String method tutorial";

int zz;
int x1=5;
int x2=200;
long z1=200;
long z2=200;
double y1=5.0;
double y2=5.9;
String xx,yy;
Integer obj1=new Integer(x1);
Integer obj2=new Integer(x2);
Double obj3=new Double(y1);
Double obj4=new Double(y2);
Long l1=new Long(z1);
Long l2=new Long(z2);
xx=obj1.toString();
yy=obj2.toString();
String zz1=obj2.toString();
String zz2=l1.toString();
int xyz=zz1.compareTo(zz2);
Integer obj9=new Integer(x1);
Integer obj10=new Integer(x2);
int ram = xx.compareTo( yy );
//System.out.println("x & y comparison: "+ram);
int var2 = str1.compareTo( str3 );
//System.out.println("str1 & str3 comparison: "+var2);
int var3 = str2.compareTo("compareTo method example");
//System.out.println("str2 & string argument comparison: "+var3);
//System.out.println("---------------------------------------------------------------");
//System.out.println(xyz);
//System.out.println(obj9.compareTo(obj10));
}
}