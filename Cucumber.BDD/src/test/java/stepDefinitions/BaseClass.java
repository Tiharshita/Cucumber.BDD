package stepDefinitions;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;


public class BaseClass {
	
	public static WebDriver driver;
	public LoginPage loginpage;
	public AddCustomerPage addcustpage;
	public SearchCustomerPage searchcustpage;
	public static Logger log=Logger.getLogger(TestSteps.class);;
	
	
	//created for generating random string for email ID
	public static String randomstring() {
		
		String generatedString= RandomStringUtils.randomAlphabetic(5);
		return (generatedString);
	}
}
