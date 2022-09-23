package temptest;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGClass {
	@BeforeSuite
	public void beforeSuit()
	{
		System.out.println("before suit 2");
	}

	@BeforeTest
	public void beforeTest()
	{
		System.out.println("before test 2");
	}
	@BeforeClass
	public void beforClass()
	{
		System.out.println("Before class 2");
	}
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("before method 2");
	}
	@Test	
	public void a()
	{
		System.out.println("Test a");
	}
	@Test	
	public void b() 
	{
		System.out.println("Test b");
	}
		@AfterMethod
	public void afterMethod()
	{
		System.out.println("after method 2");
	}
	@AfterClass
	public void afterClass()
	{
		System.out.println("after class 2");
		
	}
	@AfterTest
	public void afterTest()
	{
		System.out.println("after test 2");
	}
	@AfterSuite
	public void afterSuit()
	{
		System.out.println("after suit 2");
	}

	
	
}
