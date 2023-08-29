package TestNG;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.internal.annotations.IListeners;

import Listeners.IListenerclass;

//dependsOnGroups
@Listeners(IListenerclass.class)
public class TestGroupDependency {
	@Test(groups= "smoke")
	public void test1() {
		System.out.println("smoke");
	}
	@Test(groups= "smoke")
	public void test2() {
		System.out.println("smoke");
	}
	@Test(groups= "smoke")
	public void test3() {
		System.out.println("smoke");
	}
	@Test(groups= "sanity")
	public void test4() {
		System.out.println(5/0);
	}
	@Test(groups= "sanity")
	public void test5() {
		System.out.println("sanity");
	}
    @Test(groups= {"regression"})
	public void test6() {
			System.out.println("regression");
	}
    @Test(dependsOnGroups="smoke", alwaysRun =true)
    public void test0() {
		System.out.println("main test");
}
}
