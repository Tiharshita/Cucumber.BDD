package stepDefinitions;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import extentlisteners.ExtentListeners;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;



public class TestSteps extends BaseClass{
	
	
	
	
	@Given("^User Launch Chrome browser$")
	public void user_Launch_Chrome_browser() {
	   
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers/chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\home\\Downloads\\Harshita\\chromedriver.exe");
		driver=new ChromeDriver();
		loginpage=new LoginPage(driver);
		driver.manage().window().maximize();
	
		
	}

	@When("^User opens URL \"([^\"]*)\"$")
	public void user_opens_URL(String url) {
		driver.get(url);
		
	   
	}
	@When("^User enters Email as \"([^\"]*)\" and Password as \"([^\"]*)\"$")
	public void user_enters_Email_as_and_Password_as(String email, String password) {
	    
		loginpage.setUserName(email);
		loginpage.setPassword(password);
		 
		log.info("Typing in an Element : " + email + "Entering a value : " + password);
		//ExtentListeners.test.info("Typing in an Element : " + email + "Entering a value : " + password);
	}

	@When("^Click on Login$")
	public void click_on_Login() {
	    loginpage.clickLogin();
	}

	@Then("^Page Title should be \"([^\"]*)\"$")
	public void page_Title_should_be(String title){
		if(driver.getPageSource().contains("Login was unsuccessful.")) {
			driver.close();
			Assert.assertTrue(false);
			
		}else {
		
			Assert.assertEquals(title, driver.getTitle());
		}
		log.info("Getting Title of the page : " + title);
		ExtentListeners.test.info("Getting Title of the page :" +title);
	}
	  

	@When("^User click on Logout link$")
	public void user_click_on_Logout_link() {
		loginpage.clickLogout();
		
		log.info("clicking on logout button");
	}

	@Then("^close browser$")
	public void close_browser() {
	    driver.quit();
	    log.info("closing browser");
	}
	
	
	//Add New Customer Feature
	
	@Then("^User can view Dashboard$")
	public void user_can_view_dashboard() throws InterruptedException {
		addcustpage=new AddCustomerPage(driver);
		Thread.sleep(2000);
		Assert.assertEquals("Dashboard / nopCommerce administration",addcustpage.getPageTitle());
		log.info("view Dshlet");
		
	}
	
	
	@When("^User click on customer Menu$")
	public void user_click_on_customer_menu() throws InterruptedException {
		Thread.sleep(1000);
		addcustpage.clickONCustomerMenu();
		log.info("clicking on customer menu");

	}
	
	@When("^click on customer Menu Item$")
	public void click_on_customer_menu_item() throws InterruptedException {
		Thread.sleep(1000);
		addcustpage.clickONCustomerMenuItem();
		
		log.info("cliking on customer menu item");
		

	}
	
	@When("^click on Add new button$")
	public void click_on_add_new_button() {
		addcustpage.clickOnAddNew();
		
		log.info("clicking on Add New Customer button");
	}
	
	@Then("^User can view Add new customer page$")
	public void user_can_view_add_new_customer_page() {
	    Assert.assertEquals("Add a new customer / nopCommerce administration", addcustpage.getPageTitle());
	    
	    log.info("View Add New Customer Page");
	}
	
	@When("^User enter customer info$")
	public void user_enter_customer_info() throws InterruptedException {
		String email=randomstring()+"@gmail.com";
		addcustpage.setEmail(email);
		addcustpage.setPassword("admin123");
		//Thread.sleep(3000);
		
		//addcustpage.setCustomerRoles("Administrators");
		
		
		//addcustpage.setNewsletter("Test store 2");
		Thread.sleep(1000);
		//addcustpage.setmanagerOfVendor("Vendor 2");
		//Thread.sleep(1000);
		
		addcustpage.setFName("Alpha");
		addcustpage.setLName("user");
		addcustpage.setGender("Male");
		addcustpage.setCompanyName("TestCompany");
		addcustpage.setDob("9/17/2023");
		addcustpage.setAdminContent("testtestcontent");
	    
		log.info("Entering customer info");
	}
	
	@When("^click on Save button$")
	public void click_on_save_button() throws InterruptedException {
		Thread.sleep(3000);
		addcustpage.clickOnSave();
		
		log.info("Saving customer details");
	}
	
	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String msg) {
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully."));
		
		
		log.info("customer must be added");
	}

	//Search customer by email
	

	@When("Enter customer Email")
	public void enter_customer_email() {
		
		searchcustpage=new SearchCustomerPage(driver);
		searchcustpage.setEmail("victoria_victoria@nopCommerce.com");
		
		log.info("Entering customer email");
	}
	
	@When("Click on search button")
	public void click_on_search_button() throws InterruptedException {

		searchcustpage.searchBtn();
		Thread.sleep(4000);

	}
	
	@Then("User should found Email in the Search table")
	public void user_should_found_email_in_the_search_table() throws InterruptedException {
		boolean status= searchcustpage.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
		Assert.assertEquals(true, status);
		Thread.sleep(3000);

	}

	//Search customer by name
	
	
	@When("Enter customer FirstName")
	public void enter_customer_first_name() throws InterruptedException {
	
		searchcustpage=new SearchCustomerPage(driver);
		searchcustpage.setFirstName("Victoria");
		Thread.sleep(3000);
		
	}
	
	@When("Enter customer LastName")
	public void enter_customer_last_name() throws InterruptedException {
		
		searchcustpage.setLastName("Terces");
		Thread.sleep(2000);
		
	}
	
	
	@Then("User should found Name in the Search table")
	public void user_should_found_name_in_the_search_table() throws InterruptedException {
	    
		boolean namestatus= searchcustpage.searchCustomerByName("Victoria Terces");
		Assert.assertEquals(true, namestatus);
		Thread.sleep(3000);
	}

}