package commonfunctionality;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BrowserLaunch {
	public static WebDriver driver;
	public static Properties property;
	@BeforeSuite (alwaysRun=true)
	public void browserInitialization() {
		BrowserLaunch bl=new BrowserLaunch();
		bl.readPrperty();
		String Browser=property.getProperty("Browsername");
		if (Browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(Browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "");
			driver=new FirefoxDriver();
		}
		else {
			System.setProperty("webdriver.edge.driver","");
		}
	
		driver.get(property.getProperty("Url"));
	}
	public void readPrperty() {
		property=new Properties();
		try {
			property.load(new FileInputStream(".\\src\\main\\resources\\config.properties"));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
