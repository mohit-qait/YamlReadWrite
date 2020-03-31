package testng.Yaml;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator.Feature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
//import com.fasterxml.jackson.dataformat.yaml.snakeyaml.Yaml;

public class WriteYamlFile 
{
	public static void main(String...strings) throws JsonGenerationException, JsonMappingException, IOException
	{
		ObjectMapper	mapper = new ObjectMapper(new YAMLFactory());
		List<OrderLine> lines = new ArrayList<OrderLine>();
		lines.add(new OrderLine("Copper Wire (200ft)", 1, 
		  new BigDecimal(50.67).setScale(2, RoundingMode.HALF_UP)));
		lines.add(new OrderLine("Washers (1/4\")", 24, 
		  new BigDecimal(.15).setScale(2, RoundingMode.HALF_UP)));
		Order order = new Order(
		  "B-9910", 
		  LocalDate.parse("2019-04-18", DateTimeFormatter.ISO_DATE),
		  "Customer, Jane", 
		  lines);
		mapper.writeValue(new File("resource/write.yaml"), order);
		
	}
	
}

 
