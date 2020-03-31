package testng.Yaml;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

//import com.fasterxml.jackson.dataformat.yaml.snakeyaml.Yaml;

public class Readerrr
{
   public static void main(String...strings) throws FileNotFoundException
   {
	   Reader doc=new FileReader("resource\\user.yaml");
	   Yaml ym=new Yaml();
	   Map <String,Object > obj =  (Map <String,Object >) ym.load(doc);
	   System.out.println(obj.toString());
	   System.out.println(obj.get("name").toString());
   }

}
