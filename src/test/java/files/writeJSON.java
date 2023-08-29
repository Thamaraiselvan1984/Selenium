package files;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class writeJSON 
{
	public static void main(String[] args) 
	{	
		//put method in JSONObject
		JSONObject student1 = new JSONObject();
		student1.put("StudentName", "John");
		student1.put("Grade", "5th");
		student1.put("Location", "Chennai");
		
		JSONObject student2 = new JSONObject();
		student2.put("StudentName", "antony");
		student2.put("Grade","1st");
		student2.put("Location", "Chennai");
		
		System.out.println(student1.toJSONString());
		System.out.println(student2.toJSONString());
		
		//add method in json array
		JSONArray studentDetails = new JSONArray();
		studentDetails.add(student1);
		studentDetails.add(student2);
		
		System.out.println(studentDetails.toJSONString());
		
		JSONObject details = new JSONObject();
		details.put("studentDetails", studentDetails);
		
		System.out.println(details.toJSONString());
	}
}
