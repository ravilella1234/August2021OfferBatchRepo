package pageobjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	
	
	@FindBy(linkText="Sign in") public  WebElement signIn;
	@FindBy(id="email")public WebElement userEmail;
	@FindBy(id="passwd")public WebElement userPassword;
	@FindBy(id="SubmitLogin")public WebElement submitLogin;
	@FindBy(xpath="//li[contains(text(),'Authentication failed.')]")public WebElement getuserAuthentication;
	
	

	public LoginPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	public void customerLogin()
	{
		signIn.click();
		userEmail.sendKeys("qatest9595@gmail.com");
		userPassword.sendKeys("password");
		submitLogin.click();
	}
	
	public String verifyUser()
	{
		return getuserAuthentication.getText();
	}


}
