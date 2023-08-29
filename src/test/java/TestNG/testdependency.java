package TestNG;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import java.util.*;

//dependsOnMethods
//ignoreMissingDependencies
//alwaysRun=true

public class testdependency {
	static String purchaseorder = null; 
	
	@Test(priority=1)
	public void createpurchaseorder() {
		//System.out.println(5/0);
		System.out.println("Created Purchase order");
		purchaseorder = "ABC3R42";
		}
	@Test(priority = 2, dependsOnMethods = {"createpurchaseorder"}, ignoreMissingDependencies=true)
     public void trackpurchaseorder() throws Exception  {
    	 if(purchaseorder !=null)
    	    System.out.println("Track Purchase Order");
    	 else
             throw new Exception("Invalid Purchase Order");
     }
	@Test(priority=3, dependsOnMethods = {"createpurchaseorder","trackpurchaseorder"})
     public void delivershipment() throws Exception {
    	 if(purchaseorder !=null)
     	    System.out.println("Delivered shipment");
     	 else
             throw new Exception("Invalid Purchase Order");
     }
}
