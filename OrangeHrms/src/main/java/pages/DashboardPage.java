package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	public WebDriver driver;
	DashboardPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(tagName="h6")
	List<WebElement> Dashboardlable;
	
	public List<WebElement> getDashboardlabel() {
		return Dashboardlable;
	}
}
