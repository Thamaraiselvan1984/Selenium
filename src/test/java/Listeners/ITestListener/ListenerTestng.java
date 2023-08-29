package Listeners.ITestListener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerTestng implements ITestListener
{
	public void onStart(ITestContext context) 
	{
		System.out.println("Onstart Method started");

	}

	public void onFinish(ITestContext context)
	{
		System.out.println("OnFinish method Started");
	}
	
	public void onTestStart(ITestResult result) {
		System.out.println("New Test Started : "+ result.getName());
	}
	
	public void onTestSucess(ITestResult result) {
		System.out.println("OnTestSucessMethod : "+ result.getName());
	}
	
	public void onTestFailure(ITestResult result) {
		System.out.println("OnTestFailureMethod : " + result.getName());
	}
	public void onTestSkipped(ITestResult result) {
		System.out.println("OnTestSkippedMethod : " + result.getName());
	}
	public void onTestFailedButWithinSucessPercentage(ITestResult result) {
		System.out.println("onTestFailedButWithinSucessPercentage : " + result.getName());
	}
}
