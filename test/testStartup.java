import com.thinking.machines.school.beans.*;
import com.thinking.machines.school.model.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
public class testStartup extends HttpServlet
{
public testStartup()
{
ServletContext sc=getServletContext();
DataModel ct=(DataModel)sc.getAttribute("dataModel");
List<CityBean> City=ct.cities;
CityBean cc=new CityBean();
for(int i=0;i<City.size();i++)
{
cc=City.get(i);
System.out.println(cc.getCode()+" "+cc.getName());
}
}
public static void main(String gg[])
{
testStartup ts=new testStartup();
}
}
