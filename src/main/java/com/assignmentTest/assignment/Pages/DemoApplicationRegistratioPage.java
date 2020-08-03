package com.assignmentTest.assignment.Pages;

import org.openqa.selenium.WebElement;

import com.assignmentTest.assignment.driver.DriverManager;
import com.assignmentTest.assignment.helper.CommonUtils;
import com.assignmentTest.assignment.helper.LocatorTypes;
import com.aventstack.extentreports.Status;

public class DemoApplicationRegistratioPage extends CommonUtils {

	boolean returnValue = false;

	public boolean secureRegistrationWithCredentials(String email, String passwd) {
		test.log(Status.INFO, "Verify email and password field are displayed");
		WebElement emailEle = findElement(webElemProp.getProperty("EMAIL_ID_ELE"), LocatorTypes.CSS);
		WebElement passwdELe = findElement(webElemProp.getProperty("PASSWD_ELE"), LocatorTypes.CSS);
		returnValue = emailEle.isDisplayed() && passwdELe.isDisplayed();
		if (returnValue) {
			test.log(Status.INFO, "Enter email and password on the respective fields");
			returnValue = setAndVerifyFieldValue(webElemProp.getProperty("EMAIL_ID_ELE"), LocatorTypes.CSS, email);
			enterData(webElemProp.getProperty("PASSWD_ELE"), passwd, LocatorTypes.CSS);

			test.log(Status.INFO, "Verify Jetzt registrieren button is enabled");
			WebElement registration = findElement(webElemProp.getProperty("REGISTRATION_BTN"), LocatorTypes.CSS);
			test.log(Status.INFO, "Click on the button and verify login is successful");
			click(registration);
			waitForElementVisibility(webElemProp.getProperty("PERSONLICHE_ANGABEN"), 30);
			WebElement personalInfoPage = findElement(webElemProp.getProperty("PERSONLICHE_ANGABEN"), LocatorTypes.CSS);
			returnValue &= personalInfoPage.isDisplayed()
					&& personalInfoPage.getText().trim().equals("Persönliche Angaben");

		}

		if (returnValue) {
			test.log(Status.PASS, "The method <b>secureRegistrationWithCredentials passed");
		} else {
			test.log(Status.FAIL, "The method <b>secureRegistrationWithCredentials failed");
		}

		return returnValue;
	}

	/**
	 * enter vorname , nachname and gender
	 * @param vorName
	 * @param nachName
	 * @param gender
	 * @return
	 */
	public boolean enterPersonalDetails(String vorName, String nachName, String gender, String age,
			String telephoneNum) {
		test.log(Status.INFO, "Select a gender");
		WebElement radioBtn = null;
		if (gender.equalsIgnoreCase("Male")) {
			radioBtn = findElement(webElemProp.getProperty("GENDER_RADIO_BTN_MALE"), LocatorTypes.CSS);
		} else {
			radioBtn = findElement(webElemProp.getProperty("GENDER_RADIO_BTN_FEMALE"), LocatorTypes.CSS);
		}
		click(radioBtn);
		test.log(Status.INFO, "Eingeben vorname und nachname");
		returnValue = setAndVerifyFieldValue(webElemProp.getProperty("VORNAME_ELE"), LocatorTypes.CSS, vorName);
		returnValue &= setAndVerifyFieldValue(webElemProp.getProperty("NACHNAME_ELE"), LocatorTypes.CSS, nachName);

		test.log(Status.INFO, "Enter Birthdate , age should be more than 18");
		String birthDate = getDateInAnyPattern("dd.MM.yyyy", Integer.parseInt(age), false);
		returnValue &= setAndVerifyFieldValue(webElemProp.getProperty("BIRTHDATE_ELE"), LocatorTypes.CSS, birthDate);
		returnValue &= setAndVerifyFieldValue(webElemProp.getProperty("TELEPHONE_ELE"), LocatorTypes.CSS, telephoneNum);

		if (returnValue) {
			test.log(Status.PASS, "The method <b>enterPersonalDetails passed");
		} else {
			test.log(Status.FAIL, "The method <b>enterPersonalDetails failed");
		}

		return returnValue;
	}

	/**
	 * Enter mailing address
	 * 
	 * @return
	 */
	public boolean enterMailingAddress(String street, String hausNum, String pin, String place) {
		

		test.log(Status.INFO, "Enter Street name and haus number");
		returnValue = setAndVerifyFieldValue(webElemProp.getProperty("STREET_NUM_ELE"), LocatorTypes.CSS, street);
		returnValue &= setAndVerifyFieldValue(webElemProp.getProperty("HAUSE_NUM_ELE"), LocatorTypes.CSS, hausNum);

		test.log(Status.INFO, "Enter Plz and Ort");
		returnValue &= setAndVerifyFieldValue(webElemProp.getProperty("PINCODE_ELE"), LocatorTypes.CSS, pin);
		returnValue &= setAndVerifyFieldValue(webElemProp.getProperty("PLACE_ELE"), LocatorTypes.CSS, place);

		if (returnValue) {
			test.log(Status.PASS, "The method <b>enterMailingAddress passed");
		} else {
			test.log(Status.FAIL, "The method <b>enterMailingAddress failed");
		}

		return returnValue;

	}

	/**
	 * Click on next on personal info page
	 * @return
	 */
	public boolean clickOnNextOnPersonalInfoPage() {

		test.log(Status.INFO, "Verify weiter button is enabled");
		WebElement weiter = findElement(webElemProp.getProperty("PERSONAL_INFO_NEXT_BTN"), LocatorTypes.CSS);
		returnValue = weiter.isEnabled();
		if (returnValue) {
			test.log(Status.INFO, "Click on weiter button");
			click(weiter);
			waitForElementVisibility(webElemProp.getProperty("IBAN_PAGE_HEADER"), 60);
			WebElement header = findElement(webElemProp.getProperty("IBAN_PAGE_HEADER"), LocatorTypes.CSS);
			test.log(Status.INFO, "Verify Iban page is displayed");
			returnValue &= header.isDisplayed() && header.getText().trim().equals("Zahlungsdaten");
		}

		if (returnValue) {
			test.log(Status.PASS, "The method <b>clickOnNextOnPersonalInfoPage passed");
		} else {
			test.log(Status.FAIL, "The method <b>clickOnNextOnPersonalInfoPage failed");
		}

		return returnValue;
	}
	
	/**
	 * Enter IBAN page details and proceed
	 * 
	 * @return
	 * @throws Exception 
	 */
	public boolean enterIBanAndProceed(String iBan) throws Exception {
		test.log(Status.INFO, "Verify tarif bestellen button is disabled");
		WebElement tarifBestellen = findElement(webElemProp.getProperty("TARIF_BESTELLEN"), LocatorTypes.CSS);
		returnValue = !tarifBestellen.isEnabled();
		test.log(Status.INFO, "Enter IBAN");
		returnValue &= setAndVerifyFieldValue(webElemProp.getProperty("IBAN_INPUT_FIELD"), LocatorTypes.CSS, iBan);
		test.log(Status.INFO, "Click on term and condition checkbox and verify checkbox is checked");
		WebElement checkbox = findElement(webElemProp.getProperty("ACCEPT_CHECKBOX"), LocatorTypes.XPATH);
		scrollToView(checkbox);
		click(checkbox);
		returnValue &= checkbox.getAttribute("class").contains("custom-checkbox__label--active");
		if (returnValue) {
			test.log(Status.INFO, "Verify tarif bestellen button is enabled and click on it");
			Thread.sleep(3000);
			returnValue = tarifBestellen.isEnabled();
			if (returnValue) {
				click(tarifBestellen);
				waitForElementVisibility(webElemProp.getProperty("IBAN_OFFER_PAGE_HEADER"), 60);
				test.log(Status.INFO, "Verify Angaben-Übersicht page is displayed");
				WebElement header = findElement(webElemProp.getProperty("IBAN_OFFER_PAGE_HEADER"), LocatorTypes.CSS);
				returnValue &= header.isDisplayed();
				//Thread.sleep(3000);
				waitForPageLoaded();
			}

		}
		if (returnValue) {
			test.log(Status.PASS, "The method <b>enterIBanAndProceed passed");
		} else {
			test.log(Status.FAIL, "The method <b>enterIBanAndProceed failed");
		}

		return returnValue;
	}

	/**
	 * Navigate to Final page
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public boolean pageNavigationToCheckoutPage(String username) throws InterruptedException {
		test.log(Status.INFO, "Click on Jetzt verbindlich kaufen");
		WebElement jetztKaufen = findElement(webElemProp.getProperty("IBAN_OFFER_PAGE_NEXT_BTN"), LocatorTypes.CSS);
		returnValue = jetztKaufen.isEnabled();
		click(jetztKaufen);
		waitForElementVisibility(webElemProp.getProperty("CONFIRMATATION_PAGE_HEADER"), 60);
		test.log(Status.INFO, "Verify Confirmation page is displayed");
		WebElement header = findElement(webElemProp.getProperty("CONFIRMATATION_PAGE_HEADER"), LocatorTypes.CSS);
		returnValue &= header.isDisplayed()
				&& header.getText().trim().equals(webElemProp.getProperty("CONFIRMATATION_PAGE_HEADER_TEXT"));
		test.log(Status.INFO, "Click on Zurück zur Übersicht button");
		WebElement zuruk = findElement(webElemProp.getProperty("CONFIRMATATION_NEXT_BTN"), LocatorTypes.CSS);
		returnValue &= zuruk.isEnabled();
		if (returnValue) {
			click(zuruk);
			waitForElementVisibility(webElemProp.getProperty("ALERT_POPUP"), 60);
			test.log(Status.INFO, "Close the feedback popup and verify the final page is displayed");
			WebElement closeIcon = findElement(webElemProp.getProperty("FEEDBACK_POPUP_CLOSE_ICON"), LocatorTypes.CSS);
			click(closeIcon);
			Thread.sleep(3000);
			WebElement pageHeader = findElement(webElemProp.getProperty("FINAL_PAGE_HEADER"), LocatorTypes.CSS);
			returnValue = pageHeader.isDisplayed()
					&& pageHeader.getText().trim().equals("Hallo " + username + ", wie möchtest du starten?");
			test.log(Status.INFO, "Verify final Page URL ");
			returnValue &= DriverManager.driver.getCurrentUrl().equals(webElemProp.getProperty("URL"));
		}

		if (returnValue) {
			test.log(Status.PASS, "The method <b>pageNavigationToCheckoutPage passed");
		} else {
			test.log(Status.FAIL, "The method <b>pageNavigationToCheckoutPage failed");
		}

		return returnValue;
	}

	/**
	 * Verify the contract section displays proper data
	 * @param coverageName
	 * @param contractProvider
	 * @return
	 */
	public boolean verifyContractDetailsOnManagerRoute(String coverageName, String contractProvider) {
		test.log(Status.INFO, "Verify Deine Verträge is displayed");
		WebElement yourContract = findElement(webElemProp.getProperty("YOUR_CONTRACT_HEADER"), LocatorTypes.CSS);
		returnValue = yourContract.isDisplayed() && yourContract.getText().trim().equals("Deine Verträge");
		test.log(Status.INFO, "Verify selected coverage is displayed");
		WebElement coverage = findElement(webElemProp.getProperty("COVERAGE_NAME"), LocatorTypes.CSS);
		returnValue &= coverage.isDisplayed() && coverage.getText().trim().equals(coverageName);

		test.log(Status.INFO, "Verify the contract start date is one after the policy is created");
		String getFutureDate = getDateInAnyPattern("dd.MM.yyyy", 1, true);
		WebElement contractStartDate = findElement(webElemProp.getProperty("CONTRACT_START_DATE"), LocatorTypes.CSS);
		returnValue &= contractStartDate.getText().trim().equals("gültig ab: " + getFutureDate);

		if (returnValue) {
			test.log(Status.PASS, "The method <b>verifyContractDetailsOnManagerRoute passed");
		} else {
			test.log(Status.FAIL, "The method <b>verifyContractDetailsOnManagerRoute failed");
		}

		return returnValue;
	}
}
