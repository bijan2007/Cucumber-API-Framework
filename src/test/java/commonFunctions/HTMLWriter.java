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
		    writer.write("<<<--Difference in Data Sets for Vehicles Registration from Maharashtra and Karnataka-->>>");
		    writer.write("<span>"+text+"</span>");
		    writer.newLine();
		    writer.close(); 
		} catch (Exception e) {
		 
		}

}
}
