package testng.Yaml;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Map;
/*
 * This is a Yaml Reader File 
 */
import org.yaml.snakeyaml.Yaml;
public class ReadYamlFile {
	public static void main(String...strings) throws FileNotFoundException
	   {
		   Reader docReader=new FileReader("resource\\user.yaml");
		   Yaml ymlobject=new Yaml();
		   Map <String,Object > obj =  (Map <String,Object >) ymlobject.load(docReader);
		   System.out.println(obj.toString());
		  String  token = "address.zip";
		  String []s=token.split("\\.");
		  System.out.println(s[1]);
		System.out.println(parseMap(obj,token).get(s[s.length-1]).toString());
		  
	   }
	    public static  Map<String ,Object> parseMap(Map<String ,Object>object,String token)
	   {
		   if(token.contains("."))
		   {
				  String []s=token.split("\\.");
				  object=parseMap((Map<String ,Object>) object.get(s[0]),token.replace(s[0]+".",""));

		   }
		   return object;
	   }
}