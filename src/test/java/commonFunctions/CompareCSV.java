package commonFunctions;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;
import commonFunctions.HTMLWriter;

public class CompareCSV {
	
	public static void CompareFiles(String file1, String file2) throws IOException{

		HashMap<String,String> map1 = new HashMap<String,String>();
		HashMap<String,String> map2 = new HashMap<String,String>();
		HashMap<String,String> map3 = new HashMap<String,String>();
		StringBuilder sb = new StringBuilder();
		
		map1 = ReadFile(file1);
		map2 = ReadFile(file2);

        Set<Entry<String, String>> entrySet1 = map1.entrySet();
        
        for (Entry<String, String> entry : entrySet1) 
        {
            if(! map2.containsValue(entry.getValue())){
            	sb.append(entry.getKey().toString()).append('\n');
            	sb.append(entry.getValue().toString()).append('\n');
            }
            
        }
        
        HTMLWriter.CreateHtml(sb.toString());
	
	}
	
	public static HashMap ReadFile(String file) {
		HashMap<String,String> map = new HashMap<String,String>();
		Path path = Paths.get(file);
		String[] values=null;
		try (BufferedReader br = Files.newBufferedReader(path,StandardCharsets.US_ASCII)) 
		{
			
			String line = br.readLine();
			String[] keys = line.split(",");
			
			while (line != null) {
				
				values = line.split(",");
				line = br.readLine();			
				}
			for(int i =0;i<keys.length;i++){
		        map.put(keys[i], values[i]);
			}
		}
		catch (IOException ioe) {
            ioe.printStackTrace();
        }
		return map;
	}
	}
	
	    



