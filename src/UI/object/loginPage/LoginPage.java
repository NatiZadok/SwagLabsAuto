package UI.object.loginPage;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import Common.utils.Utils;
import UI.object.BasePage;


public class LoginPage extends BasePage {

		//field
		@FindBy(css="#user-name")
		private WebElement fdUsername;
		@FindBy(css="#password")
		private WebElement fdPassword;
		@FindBy(css="#login-button")
		private WebElement btnLogin;	
		@FindBy(css=".login_logo")
		private WebElement titleText;
		
		//error
		@FindBy(css="[data-test='error']")
		private WebElement txtError;
		

		public LoginPage(WebDriver driver) {
			super(driver);				
		}

		public String getTitleText() 
		{
			return titleText.getText();
		}

		public void clickLogin()
		{
			click(btnLogin);
		}

		public void clearUserNameAndPassword()
		{
			fdUsername.clear();
			fdPassword.clear();
		}
		
		
		public void clearUserName()
		{
			fdUsername.clear();
		}
		
		public void clearPassword()
		{
			fdPassword.clear();
		}
		
		public void fillloginUserName(String user) {
			fillText(fdUsername,user);
			fdUsername.sendKeys(Keys.RETURN);
		}

		public void fillloginPassword(String password) {
			fillText(fdPassword,password);
			fdPassword.sendKeys(Keys.RETURN);
		}
		
		public String getErrorMessage() 
		{
			return txtError.getText();
		}
		
		public String getLoginText() 
		{
			return btnLogin.getAttribute("value");
		}

		public void loginEmptyUserPassword() {
			fdUsername.clear();
			fdUsername.sendKeys(Keys.RETURN);
			fdPassword.clear();
			fdPassword.sendKeys(Keys.RETURN);
			fdUsername.sendKeys(Keys.RETURN);
		}

		public void loginEmptyUser() {
			fdUsername.clear();
			fdUsername.sendKeys(Keys.RETURN);
		}
		
		public void loginEmptyPassword() {
			fdPassword.clear();
			fdPassword.sendKeys(Keys.RETURN);
		}
		
		public void filllogin(String user,String password) {
			fillText(fdUsername,user);
			fdUsername.sendKeys(Keys.RETURN);
			fillText(fdPassword,password);
			click(btnLogin);
		}
		
		public void fillloginDeafult() {
			fillText(fdUsername,Utils.readPropStart("user"));
			fdUsername.sendKeys(Keys.RETURN);
			fillText(fdPassword,Utils.readPropStart("password"));
			click(btnLogin);
		}
		
		public void loginWithWrongField(String fieldName, String value) {
			switch (fieldName) {
			case "username":
			{	
				fillText(fdUsername,value);
				fdUsername.sendKeys(Keys.RETURN);

				fillText(fdPassword,Utils.readPropStart("password"));
				fdPassword.sendKeys(Keys.RETURN);
				btnLogin.click();
				break;
			}
			case "password":
			{	
				fillText(fdUsername,Utils.readPropStart("user"));
				fdUsername.sendKeys(Keys.RETURN);

				fillText(fdPassword,value);
				fdPassword.sendKeys(Keys.RETURN);

				btnLogin.click();
				break;
			}
			}//switch
		}

		public String getLoginBtnText()
		{
			return btnLogin.getText();
		}
		
		public String getEnterUserNamePlaceholder()
		{
			return fdUsername.getAttribute("placeholder"); 
		}
		
		public String getEnterPasswordPlaceholder()
		{
			return fdPassword.getAttribute("placeholder"); 
		}
		
}
