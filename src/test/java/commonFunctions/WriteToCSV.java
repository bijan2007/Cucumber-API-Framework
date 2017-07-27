package commonFunctions;

import java.io.IOException;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WriteToCSV {
	
	public static void Execute(String jsonString,String fileName){
		
		JSONObject output;
        try {
            output = new JSONObject(jsonString);
            JSONArray docs = output.getJSONArray("records");
            File file=new File(fileName + ".csv");
            String csv = CDL.toString(docs);
            FileUtils.writeStringToFile(file, csv);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }        
		
	}

}
