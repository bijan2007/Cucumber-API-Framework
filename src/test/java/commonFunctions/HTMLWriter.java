package commonFunctions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class HTMLWriter {
	
	public static void CreateHtml(String text) throws IOException{
		
		FileWriter fWriter = null;
		BufferedWriter writer = null;
		try {
		    fWriter = new FileWriter("Diff.html");
		    writer = new BufferedWriter(fWriter);
		    writer.write("<span><<<--Difference in Data Sets for Vehicles Resistration from Maharashtra and Karnataka-->>></span>");
		    writer.write("<span>"+text+"</span>");
		    writer.newLine();
		    writer.close(); 
		} catch (Exception e) {
		 
		}

}
}
