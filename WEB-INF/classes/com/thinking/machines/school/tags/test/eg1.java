import java.util.*;
import java.util.Map.*;
public class eg1
{
public static void main(String args[])
{
ArrayList<Object> array=new ArrayList();
array.add(1);
array.add("Sonti");
array.add("Gurjar");
Collection collection=(Collection)array;
if(collection instanceof ArrayList)
{
System.out.println("Belong to arrayList  ");
for(Object oo:collection)
{
System.out.println(oo);
System.out.println(collection.contains(oo));
}
}
System.out.println("----------------------------------------------------------------------------------------------------------------");
HashMap<Integer,String > hashMap=new HashMap<Integer,String>();
hashMap.put(1,"Bhayya");
hashMap.put(1,"Radhe");
hashMap.put(2,"Bhyya");
hashMap.put(3,"Pujari");
if(hashMap instanceof HashMap)
{
for(Map.Entry mapElement:hashMap.entrySet())
{
System.out.println(mapElement.getKey());
System.out.println(mapElement.getValue());
}
Iterator<Entry<Integer,String>>it=hashMap.entrySet().iterator();
while(it.hasNext())
{
Map.Entry<Integer,String>set=(Map.Entry<Integer,String>)it.next();
System.out.println(set.getKey()+"  "+set.getValue());
}
System.out.println("-----------------------------------------------------------------------------");

System.out.println("Belong to Hash Map");
}
System.out.println("-----------------------------------------------------------------------------");
Set<String> hashSet=new HashSet<String>();
hashSet.add("BOYS");
hashSet.add("GIRLS");
hashSet.add("GENDER");
hashSet.add("BEFIKRE");
if(hashSet instanceof Set)
{
System.out.println("Belong to Set");
for(String oo:hashSet)
{
System.out.println(oo);
}
}
}
}


