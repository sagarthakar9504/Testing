package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	public WebDriver driver;
	public LoginPage(WebDriver driver){
		this.driver=driver;
	}
	public WebElement getUsername() {
		return driver.findElement(By.xpath("//input[@placeholder='Username']"));
		
	}
	public WebElement getPassword() {
		return driver.findElement(By.xpath("//input[@placeholder='Password']"));
		
	}
	public WebElement getButton() {
		return driver.findElement(By.xpath("//button[@type='submit']"));
	}
	public List<WebElement> getInvalidMassageLable() {
		return driver.findElements(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']"));
	}
	public void login(String username ,String password) {
		LoginPage obj=new LoginPage(driver);
		obj.getUsername().sendKeys(username);
		obj.getPassword().sendKeys(password);
		obj.getButton().click();

	}
}
