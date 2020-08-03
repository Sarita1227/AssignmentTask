package com.assignmentTest.assignment.helper;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.assignmentTest.assignment.driver.DriverManager;
import com.assignmentTest.assignment.driver.DriverManagerFactory;
import com.assignmentTest.assignment.driver.DriverType;

public class LaunchWebUrl extends CommonUtils {

	DriverManager webDr;

	public boolean loadAppUrl() throws Exception {
		boolean returnValue = false;
		webDr = DriverManagerFactory.getManager(DriverType.CHROME);
		DriverManager.driver = webDr.getDriver();
		DriverManager.driver.manage().deleteAllCookies();
		DriverManager.driver.navigate().to("https://staging.clark.de/de/app/contracts?cv=2");
		waitForPageLoaded();
		WebElement loginPageELement = findElement(webElemProp.getProperty("PAGE_HEADER"), LocatorTypes.CSS);
		returnValue = loginPageELement.isDisplayed();
		
		returnValue &= DriverManager.driver.getTitle().equalsIgnoreCase(webElemProp.getProperty("HOME_PAGE_HEADER_NAME"));

		if (returnValue) {
			Assert.assertTrue("Successfully loaded the Page URL", true);
		} else {
			Assert.fail();
		}
		return returnValue;

	}

}
