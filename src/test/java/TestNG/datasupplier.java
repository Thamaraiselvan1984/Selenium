package TestNG;

import org.testng.annotations.DataProvider;

public class datasupplier {
	
	@DataProvider(parallel=true)
    public Object[][] testlogin() {
    	Object[][] data = new Object[6][2];
    	data[0][0] ="selvan.84@gmail.com";
        data[0][1] = "Thamarai@123";
        
        data[1][0]="admin";
        data[1][1]="admin123";
        
        data[2][0] ="test";
        data[2][1] = "testname1";
        
        data[3][0]="login";
        data[3][1]="verify";
        
        data[4][0]="logindege";
        data[4][1]="verifyfe";
        
        data[5][0]="loginabca";
        data[5][1]="verifyre";
        
        return data;
    }

}
