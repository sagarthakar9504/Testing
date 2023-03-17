package testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonfunctionality.BrowserLaunch;
import pages.LoginPage;

public class LoginPageTest extends BrowserLaunch {
public static ExtentReports report;
public static ExtentTest test;
	@BeforeTest
public static void startTest() {
	  report=new ExtentReports("Result/Result.html",true);
	}

	@Test(description="Verify that user should not able to login with invalid credentials",priority=1)
	public void TC1() {
		test=report.startTest("Verify that user should not able to login in  with invalid credentilas");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.login("Admin", "admin");
		if((loginpage.getInvalidMassageLable().size()>0)) {
			test.log(LogStatus.PASS, "User is not able to login");
			
		}else {
			test.log(LogStatus.FAIL, "user is able to login with invalid credential");
		}
		
		
	}
	@AfterClass(alwaysRun=true)
	public void endTest() {
		report.endTest(test);
		report.flush();
	}
	
	
}
