package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.e2eTest.base.TestBase;
import com.e2eTest.pages.HomePage;
import com.e2eTest.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage  homePage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage= new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String Title = loginPage.ValidateLoginPageTitle();
		Assert.assertEquals(Title, "S’identifier sur LinkedIn | LinkedIn");
	}
	
	@Test(priority=2)
	public void loginTest() throws InterruptedException {
	 homePage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));	
	}
	
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	

}
