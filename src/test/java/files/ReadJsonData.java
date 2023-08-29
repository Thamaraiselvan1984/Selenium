package files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class ReadJsonData {

	public static void main(String[] args) throws IOException, ParseException {
		
	String pathfile = System.getProperty("user.dir") + "//src//test//java//files//sample4.json";
	FileReader file = new FileReader(pathfile);
	
	JSONParser parser = new JSONParser();
	
	JSONObject json = (JSONObject) parser.parse(file);
	
	System.out.println(json.toJSONString());
	
	JSONArray testData = (JSONArray) json.get("people");
	
	
	  System.out.println(testData.toJSONString());
	  
	  JSONObject logintest = (JSONObject) testData.get(0);
	  System.out.println(logintest.toJSONString());
	  System.out.println(logintest.get("testName"));
	  
	  JSONArray LoginTestSet = (JSONArray) logintest.get("data"); JSONObject
	  LoginTestSetdata1 = (JSONObject) LoginTestSet.get(1);
	  System.out.println(LoginTestSetdata1.get("number"));
	 

	for(int i=0; i<testData.size(); i++) {
		
		JSONObject testCase = (JSONObject) testData.get(i);
		System.out.println("Test case name is --" + testCase.get("testName"));
		
		JSONArray  testCaseData = (JSONArray) testCase.get("data");
		for(int j =0; j<testCaseData.size();j++) {
			
			JSONObject  currentTestData = (JSONObject) testCaseData.get(j);
			Set<String> keys = currentTestData.keySet();
			
			Iterator<String> it = keys.iterator();
			
			while(it.hasNext()) {
				String key = it.next();
				String value = (String) currentTestData.get(key);
				System.out.println(key + "--" + value);
			}
		  }
		}
	}
}
