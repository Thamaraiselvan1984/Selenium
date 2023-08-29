package ExtentReports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

// ADDING INFORMATION TO LOG Reports- TEXT(BOLD, ITALIC), XML, JSON, CollectionData(list, set & map)
// Highlight any message, Exception

public class Chapter5 
{	
	    public static void main(String[] args) throws Exception {
		ExtentReports extentreports = new ExtentReports();
		File file = new File("report.html");
		ExtentSparkReporter sparkreporter = new ExtentSparkReporter("report.html");
		extentreports.attachReporter(sparkreporter);
		
		extentreports
		.createTest("Test 1")
		.log(Status.INFO, "<i>info1</i>")
		.log(Status.INFO, "<i>info2</i>")
		.log(Status.FAIL, "<strong>FAIL</strong>")
		.log(Status.PASS, "<b>PASS</b>");
		
		String xmlData = "<menu id=\"file\" value=\"File\">r\n"
		  +"<popup>\r\n"
		  +  "<menuitem value=\"New\" onclick=\"CreateNewDoc()\" />r\n"
		  +  "<menuitem value=\"Open\" onclick=\"OpenDoc()\" />r\n"
		  +  "<menuitem value=\"Close\" onclick=\"CloseDoc()\" />r\n"
		  +"</popup>\r\n"
		  +"</menu>";

       String jsonData ="{\"menu\": {\r\n"
       		+ "  \"id\": \"file\",\r\n"
       		+ "  \"value\": \"File\",\r\n"
       		+ "  \"popup\": {\r\n"
       		+ "    \"menuitem\": [\r\n"
       		+ "      {\"value\": \"New\", \"onclick\": \"CreateNewDoc()\"},\r\n"
       		+ "      {\"value\": \"Open\", \"onclick\": \"OpenDoc()\"},\r\n"
       		+ "      {\"value\": \"Close\", \"onclick\": \"CloseDoc()\"}\r\n"
       		+ "    ]\r\n"
       		+ "  }\r\n"
       		+ "}}";
		
       extentreports.createTest("XML based Test")
       .info(MarkupHelper.createCodeBlock(xmlData, CodeLanguage.XML));
       
		
       extentreports.createTest("Json based Test")
       .log(Status.INFO, MarkupHelper.createCodeBlock(jsonData, CodeLanguage.JSON));
       
       List<String> listData = new ArrayList<>();
       listData.add("THAMU");
       listData.add("SELVAN");
       listData.add("JOHNSON");
       
       Map<Integer, String> mapData = new HashMap<>();
       mapData.put(101, "THAMU");
       mapData.put(102, "SELVAN");
       mapData.put(103, "Raj");
       
       Set<Integer> setData = mapData.keySet();
       
       extentreports
       .createTest("List based Test")
       .info(MarkupHelper.createOrderedList(listData))
       .info(MarkupHelper.createUnorderedList(listData));
       
       extentreports
       .createTest("Map based Test")
       .info(MarkupHelper.createOrderedList(mapData))
       .info(MarkupHelper.createUnorderedList(mapData));
       
       extentreports
       .createTest("Set based Test")
       .info(MarkupHelper.createOrderedList(setData))
       .info(MarkupHelper.createUnorderedList(setData));
       
       extentreports
       .createTest("Highlight log Test")
       .info("This is not a highlighted message")
       .pass(MarkupHelper.createLabel("passed", ExtentColor.GREEN));
       
       try {
       int i =5/0;
       }
       catch(Exception e) {
       extentreports
       .createTest("Exception Test1")
       .info(e);
       }
	    
       Throwable t = new RuntimeException("This is a Custom Exception");
       extentreports
       .createTest("Exception Test2")
       .info(t);
       
		extentreports.flush();
		Desktop.getDesktop().browse(new File("report.html").toURI());
	}
}
