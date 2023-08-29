package files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CreateReadWriteTxt {

	public static void main(String[] args) throws IOException {
		//READ
		String TestFile = "E:\\java selenium\\test.txt";
		File FC = new File(TestFile);
		FC.createNewFile();
		//WRITE
		FileWriter FW = new FileWriter(TestFile);
		BufferedWriter BW = new BufferedWriter(FW);
		BW.write("THIS IS THE FIRST LINE");
		BW.newLine();
	    BW.write("THIS IS THE SECOND LINE");
	    BW.close();
	    //READ
	    FileReader FR = new FileReader(TestFile);
	    BufferedReader BR = new BufferedReader(FR);
	    String Content = "";
	    
	    while((Content = BR.readLine()) != null)
        {
	    	System.out.println(Content);
	    }   
	}
}
