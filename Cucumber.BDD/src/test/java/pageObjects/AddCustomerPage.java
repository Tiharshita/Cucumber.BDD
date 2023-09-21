package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {
	
public WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver) {
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	By lnkCustomers_menu= By.xpath("//nav/ul/li[4]/a");
	By customerMenu=By.xpath("//nav/ul/li[4]/ul/li[1]/a");
	
	By addNewCustomer= By.xpath("//form[1]/div/div/a");
	
	By enterEmail=By.id("Email");
	By enterPassword=By.id("Password");
	By enterFirstName=By.id("FirstName");
	By enterLastName=By.id("LastName");
	By genderMale=By.xpath("//*[@id=\"customer-info\"]/div[2]/div[5]/div[2]/div/div[1]");
	By genderFemale=By.id("//*[@id=\"customer-info\"]/div[2]/div[5]/div[2]/div/div[2]");
	By dateofBirth=By.xpath("//*[@id=\"DateOfBirth\"]");
	By companyName=By.id("Company");
	
	By Newsletter1=By.xpath("//*[@id=\"SelectedNewsletterSubscriptionStoreIds_listbox\"]/li[1]");
	By Newsletter2=By.xpath("//*[@id=\"SelectedNewsletterSubscriptionStoreIds_listbox\"]/li[2]");
	
	By txtcustomerRole=By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']");
	By lstitemAdministrators= By.xpath("//li[contains(text(),'Administrators')]");
	By lstitemForumModerators= By.xpath("//li[contains(text(),'Forum Moderators')]");
	By lstitemGuests= By.xpath("//li[normalize-space()='Guests']");
	By lstitemRegistered= By.xpath("//li[contains(text(),'Registered')]");
	By lstitemVendors= By.xpath("//li[contains(text(),'Vendors')]");
	
//	By cutomerRoles1=By.xpath("//*[@id=\"SelectedCustomerRoleIds\"]/option[1]");
//	By cutomerRoles2=By.xpath("//*[@id=\"SelectedCustomerRoleIds\"]/option[2]");
//	By cutomerRoles3=By.xpath("//*[@id=\"SelectedCustomerRoleIds\"]/option[3]");
//	By cutomerRoles4=By.xpath("//*[@id=\"SelectedCustomerRoleIds\"]/option[4]");
//	By cutomerRoles5=By.xpath("//*[@id=\"SelectedCustomerRoleIds\"]/option[5]");
	
	By manageofVendor=By.xpath("//*[@id=\"customer-info\"]/div[2]/div[11]/div[2]/span");
	By adminComment=By.xpath("//*[@id=\"AdminComment\"]");

	By btnSave= By.xpath("//div[1]/div/button[1]");
	
	
	
	public String getPageTitle() {
		return ldriver.getTitle();
		
		
	}
	
	public void clickONCustomerMenu() {
		ldriver.findElement(lnkCustomers_menu).click();
		
	}
	public void clickONCustomerMenuItem() {
		ldriver.findElement(customerMenu).click();
	}
	public void clickOnAddNew() {
		ldriver.findElement(addNewCustomer).click();
		
	}
	
	public void setEmail(String email) {
		ldriver.findElement(enterEmail).sendKeys(email);
		
	}
	
	public void setPassword(String password) {
		ldriver.findElement(enterPassword).sendKeys(password);
	}
	
	public void setCustomerRoles(String role) {
		if(!role.equals("Vendors"))
		{
			ldriver.findElement(By.xpath("//div[@class='input-group-append input-group-required']//input[@role='listbox']"));
		}
		ldriver.findElement(txtcustomerRole).click();
		
		WebElement listitem = null;
		
		if(role.equals("Administrators")) {
			listitem=ldriver.findElement(lstitemAdministrators);
		}
		else if (role.equals("Forum Moderators")) {
			listitem=ldriver.findElement(lstitemForumModerators);
			
		}else if (role.equals("Guests")) {
			listitem=ldriver.findElement(lstitemGuests);
		}
		else if (role.equals("Registered")) {
			listitem=ldriver.findElement(lstitemRegistered);
		}
		else if (role.equals("vendors")) {
			listitem=ldriver.findElement(lstitemVendors);
		}
			
		listitem.click();
		
		JavascriptExecutor js=(JavascriptExecutor)ldriver;
		js.executeScript("arguments[0].click();",listitem);
		
	}
	
	public void setNewsletter(String newsletter) {
		if(newsletter.equals("Your store name")) {
			ldriver.findElement(Newsletter1).click();
			
		}else if(newsletter.equals("Test store 2")) {
			ldriver.findElement(Newsletter2).click();
		}
	}
	
	public void setmanagerOfVendor(String value) {
		
		Select drp=new Select(ldriver.findElement(manageofVendor));
		drp.selectByVisibleText(value);
	}
	
	public void setGender(String gender) {
		
		if(gender.equals("Male")) {
			ldriver.findElement(genderMale).click();
		}
		else if(gender.equals("Female")) {
			ldriver.findElement(genderFemale).click();
		}
		else {
		ldriver.findElement(genderMale).click();
		}
		}
	
	
	public void setFName(String fname) {
		ldriver.findElement(enterFirstName).sendKeys(fname);
		
	}
	public void setLName(String lname) {
		ldriver.findElement(enterLastName).sendKeys(lname);
		
	}
	
	public void setDob(String dob) {
		ldriver.findElement(dateofBirth).sendKeys(dob);
	}
	public void setCompanyName(String comname) {
		ldriver.findElement(companyName).sendKeys(comname);
		
	}
	public void setAdminContent(String content) {
		ldriver.findElement(adminComment).sendKeys(content);
	}
	
	public void clickOnSave() {
		ldriver.findElement(btnSave).click();
		
	}
 

}
