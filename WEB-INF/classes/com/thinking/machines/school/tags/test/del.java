import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.util.*;
public class del extends TagSupport
{
public int start()
{
del oo=new del();
System.out.println(oo.ram());
return  oo.ram();
}
public int ram()
{
return SKIP_BODY;
}
public static void main(String gg[])
{
del uu=new del();
uu.start();
}
}