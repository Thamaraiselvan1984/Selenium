package Listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.basetest;

@Listeners(IListenerclass.class)
public class ITestListenerClass extends basetest implements ITestListener{

	@Test
	public void onTestFailure(ITestResult result) {
		CaptureScreenShot(result.getMethod().getMethodName()+".jpg");
	}
}
