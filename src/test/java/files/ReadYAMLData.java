package files;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Map;

import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlReader;

public class ReadYAMLData {

	public static void main(String[] args) throws FileNotFoundException, YamlException {
		
		String filepath = System.getProperty("user.dir") + "//src//test//java//files//testdata.yml";
		FileReader file = new FileReader(filepath);
		
		YamlReader reader = new YamlReader(file);
		
		Map testData = (Map) reader.read();
		
		List testcases = (List) testData.get("people");
		System.out.println(testcases);
		
		Map loginTestData = (Map) testcases.get(0);
		System.out.println(loginTestData.get("testName"));
		
		List loginTestData1 = (List) loginTestData.get("data");
		System.out.println(loginTestData1);
		
	}

}
