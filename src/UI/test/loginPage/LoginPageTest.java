package UI.test.loginPage;


import static org.testng.Assert.assertEquals;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Common.utils.Utils;
import UI.object.loginPage.LoginPage;
import UI.test.BaseTest;
import io.qameta.allure.Description;

public class LoginPageTest extends BaseTest{

	public static String errorLogin="Epic sadface: Username and password do not match any user in this service";

	@Test(description ="verify 'Swag Labs' title text")
	public void T01_verifySwagLabsTitle()
	{
		LoginPage login = new LoginPage(driver);
		Assert.assertEquals(login.getTitle(), Utils.readPropStart("productTitle"));
	}

	@Test(description ="verify enter user name placholder text ")
	public void T02_verifyEnterUserNamePlacholder()
	{
		LoginPage login = new LoginPage(driver);
		Assert.assertEquals(login.getEnterUserNamePlaceholder(),"Username");
	}

	@Test(description ="verify enter user password placholder text ")
	public void T03_verifyEnterPasswordPlacholder()
	{
		LoginPage login = new LoginPage(driver);
		Assert.assertEquals(login.getEnterPasswordPlaceholder(), "Password");
	}

	@Test(description ="verify login btn text ")
	public void T04_verifyLoginBtnText()
	{
		LoginPage login = new LoginPage(driver);
		Assert.assertEquals(login.getLoginText(), "Login");
	}

	
	@Test(description ="test empty user name")
	public void T05_testEmptyUsername() 
	{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.fillloginPassword(Utils.readPropStart("password"));
		loginPage.clickLogin();
		loginPage.clearUserNameAndPassword();
		Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username is required");
	}
	
	@Test(description ="test Invalid Username")
	public void T06_testInvalidUsername()
	{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clearUserNameAndPassword();
		loginPage.loginWithWrongField("username", "invalidUsername");
		Assert.assertEquals(loginPage.getErrorMessage(), errorLogin);
	}
	
	@Test(description ="test empty password")
    public void T07_testEmptyPassword() 
    {
    	LoginPage loginPage = new LoginPage(driver);
    	loginPage.clearUserNameAndPassword();
        loginPage.fillloginUserName(Utils.readPropStart("user"));
        loginPage.clearPassword();
        loginPage.clickLogin();
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Password is required");
    }
	
	@Test(description ="test invalid password")
	public void T08_testInvalidPassword() 
	{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginWithWrongField("password", "invalidPassword");
		Assert.assertEquals(loginPage.getErrorMessage(),errorLogin);
		loginPage.clearPassword();
		loginPage.clearUserName();
	}
	
	@Test(description ="test empty password and user")
    public void T09_testEmptyUsernameAndPassword() 
	{
		LoginPage loginPage = new LoginPage(driver);
        loginPage.clearUserName();
        loginPage.clearPassword();
        loginPage.clickLogin();
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username is required");
    }

	@Test(description ="test invalid password and user")
    public void T10_testInvalidUsernameAndPassword() 
	{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginWithWrongField("password", "invalidPassword");
		loginPage.loginWithWrongField("username", "invalidUsername");
        loginPage.clickLogin();
        Assert.assertEquals(loginPage.getErrorMessage(), errorLogin);
    }

   
}
