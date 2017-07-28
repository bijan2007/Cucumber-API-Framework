package stepDefinition;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import com.jayway.restassured.response.Response;
import static com.jayway.restassured.RestAssured.*;
import commonFunctions.HTMLWriter;
import commonFunctions.WriteToCSV;
import commonFunctions.CompareCSV;
public class Test_Steps {
	
	private String text=null;
	
	@Given("^Karnataka API status code is OK$")
	public Response Karnataka_API_status_code_is_OK() throws Throwable {
		Response resp= when().
			       get("https://data.gov.in/api/datastore/resource.json?resource_id=3f754864-3f5a-436b-84db-1fb407662485&api-key=89140166b07eda38f92b8c9b1268a782");
	Assert.assertEquals(resp.getStatusCode(),200);
	return resp;
	}
	@Given("^Maharashtra API status code is OK$")
	public Response Maharashtra_API_status_code_is_OK() throws Throwable {
		Response resp= when().
			       get("https://data.gov.in/api/datastore/resource.json?resource_id=4013b923-7e4a-466c-82fe-37a6fd142998&api-key=89140166b07eda38f92b8c9b1268a782");
	Assert.assertEquals(resp.getStatusCode(),200);
	return resp;
	}
	@Then("^Store response from Karnataka in CSV$")
	public void Store_response_from_Karnataka_in_CSV() throws Throwable {
		Response resp = Karnataka_API_status_code_is_OK();
		System.out.println(resp.getStatusCode());
		String jsonString = resp.asString();
		System.out.println("The response is: " + jsonString);
		WriteToCSV.Execute(jsonString, "KFile");
	}
	@Then("^Store response from Maharashtra in CSV$")
	public void Store_response_from_Maharashtra_in_CSV() throws Throwable {
		Response resp = Maharashtra_API_status_code_is_OK();
		System.out.println(resp.getStatusCode());
		String jsonString = resp.asString();
		System.out.println("The response is: " + jsonString);
		WriteToCSV.Execute(jsonString, "MFile");
	}
	@Given("^Compare response files$")
	public void Compare_response_files() throws Throwable {
		text = CompareCSV.CompareFiles("KFile.csv", "MFile.csv");
	}
	@Then("^Write results to html file$")
	public void Write_results_to_html_file() throws Throwable{
		HTMLWriter.CreateHtml(text);
	}

}
