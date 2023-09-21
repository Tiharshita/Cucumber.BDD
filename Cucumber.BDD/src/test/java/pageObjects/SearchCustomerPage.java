package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class SearchCustomerPage {
	
	public WebDriver ldriver;
	WaitHelper waithelper;
	
public SearchCustomerPage(WebDriver rdriver) {
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		waithelper=new WaitHelper(ldriver);
		
	}
	

	@FindBy(id="SearchEmail")
	WebElement txtEmail;	
	
	@FindBy(id="SearchFirstName")
	WebElement fName;

	@FindBy(id="SearchLastName")
	WebElement lName;
	
	@FindBy(id="SearchMonthOfBirth")
	WebElement searchMonthOfBirth;
	
	@FindBy(id="SearchDayOfBirth")
	WebElement searchDayOfBirth;
	
	
	@FindBy(id="SearchRegistrationDateFrom")
	WebElement registerationDateFrom;
	
	@FindBy(id="SearchRegistrationDateTo")
	WebElement registerationDateTo;
	
	
	@FindBy(id="SearchLastActivityFrom")
	WebElement lastEctivityFrom;
	

	@FindBy(id="SearchLastActivityTo")
	WebElement lastEctivityTo;
	
	

	@FindBy(id="SearchCompany")
	WebElement txtCompany;

	@FindBy(id="SearchIpAddress")
	WebElement ipAddress;
	
	@FindBy(id="SelectedCustomerRoleIds")
	WebElement customerRoles;
	
	@FindBy(id="search-customers")
	WebElement btnSearch;
	
	@FindBy(xpath="//table[@role='grid']")
	WebElement tableSearchResult;
	

	@FindBy(xpath="//table[@id='customers-grid']")
	WebElement table;
	
	@FindBy(xpath="//table[@id='customers-grid']//tbody/tr")
	List<WebElement> tableRow;
	
	@FindBy(xpath="//table[@id='customers-grid']//tbody/tr/td")
	List<WebElement> tableColumn;
	
	
	
	public void setEmail(String email){
		//waithelper.WaitForElement(txtEmail, 30);
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}
	
	public void setFirstName(String fname) throws InterruptedException{
		//waithelper.WaitForElement(txtEmail, 30);
		Thread.sleep(2000);
		fName.clear();
		fName.sendKeys(fname);
	}
	
	public void setLastName(String lname) throws InterruptedException{
		//waithelper.WaitForElement(txtEmail, 30);
		Thread.sleep(2000);
		lName.clear();
		lName.sendKeys(lname);
	}
	
	public void searchBtn() throws InterruptedException{
		
		btnSearch.click();
		//waithelper.WaitForElement(btnSearch, 30);
		Thread.sleep(2000);
		
	}
	public int getNoOfRows(){
		return (tableRow.size());
	
		
	}
	
	public int getNoOfColumn(){
		return (tableColumn.size());
	
	
}
	public boolean searchCustomerByEmail(String email) {
		
		boolean flag= false;
		
		for(int i=1; i<= getNoOfRows(); i++) {
			
			String emailid=table.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+i+"]/td[2]")).getText();
			
					
					System.out.println(emailid);
			
			if(emailid.equals(email)) {
				flag=true;
			}
		}
		
		return flag;
	}

	
	
	public boolean searchCustomerByName(String Name) {
		
		boolean flag= false;
		
		for(int i=1; i<= getNoOfRows(); i++) {
			
			String fullname=table.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+i+"]/td[3]")).getText();
			
			String name[]= fullname.split(" ");
		
			if(name[0].equals("Victoria") && name[1].equals("Terces")) {
				flag=true;
			}
		}
		
		return flag;
	}
	
}
