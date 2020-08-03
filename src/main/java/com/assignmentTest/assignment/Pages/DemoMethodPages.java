package com.assignmentTest.assignment.Pages;

import org.openqa.selenium.WebElement;

import com.assignmentTest.assignment.helper.CommonUtils;
import com.assignmentTest.assignment.helper.LocatorTypes;
import com.aventstack.extentreports.Status;

public class DemoMethodPages extends CommonUtils {

	boolean returnValue = false;

	/**
	 * Navigate to sales funnel page
	 * 
	 * @return
	 */
	public boolean navigateToAngebotePage() {
		test.log(Status.INFO,"Verify Angebote link is dispalyed and is enabled");
		WebElement angeboteEle = findElement(webElemProp.getProperty("ANGEBOTE_LINK"), LocatorTypes.CSS);
		returnValue = angeboteEle.isEnabled() && angeboteEle.isDisplayed();
		if (returnValue) {
			test.log(Status.INFO, "Click on link and verify sales funnel page is displayed");
			click(angeboteEle);
			waitForElementVisibility(webElemProp.getProperty("REQUEST_PAGE_TEXT_ELE"), 30);
			WebElement requestPageText = findElement(webElemProp.getProperty("REQUEST_PAGE_TEXT_ELE"),
					LocatorTypes.CSS);
			returnValue = requestPageText.getText().equals("Was möchtest du absichern?");
		}

		if (returnValue) {
			test.log(Status.PASS, "The method <b>navigateToAngebotePage passed");
		} else {
			test.log(Status.FAIL, "The method <b>navigateToAngebotePage failed");
		}

		return returnValue;

	}

	/**
	 * Page navigation from privathaftplflicht to questioner page
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public boolean navigateFromPrivathaftplflichtPageToSelectCategories() throws InterruptedException {
		test.log(Status.INFO, "Verify privathaftpliflich option is displayed");
		WebElement privathELe = findElement(webElemProp.getProperty("PRIVATHAFTPFLICHT_LINK"), LocatorTypes.CSS);
		returnValue = privathELe.isDisplayed();
		if (returnValue) {
			test.log(Status.INFO, "Click on the link and verify page is navigate further to questioner page");
			click(privathELe);
			waitForElementVisibility(webElemProp.getProperty("WEITER_BTN"), 30);
			test.log(Status.INFO, "Verify privathaftpliflich page is displayed");
			WebElement pageHeader = findElement(webElemProp.getProperty("PRIVATHAFTPFLICHT_PAGE_HEADER"),
					LocatorTypes.CSS);
			returnValue = pageHeader.isDisplayed() && pageHeader.getText().trim().equals("Pri­vat­haft­pflicht");
			test.log(Status.INFO, "Click on Weiter button");
			WebElement weiter = findElement(webElemProp.getProperty("WEITER_BTN"), LocatorTypes.CSS);
			returnValue &= weiter.isEnabled();
			if (returnValue) {
				click(weiter);
				waitForElementVisibility(webElemProp.getProperty("QUESTIONNAIRE_TITLE_ELE"), 30);
				test.log(Status.INFO, "Verify select category page is displayed");
				WebElement categoryHeader = findElement(webElemProp.getProperty("QUESTIONNAIRE_TITLE_ELE"),
						LocatorTypes.CSS);
				returnValue &= categoryHeader.isDisplayed()
						&& categoryHeader.getText().equals("Wen möchtest du versichern?");
				test.log(Status.INFO, "Verify Weiter btn on select category is disabled");
				WebElement weiterBtn = findElement(webElemProp.getProperty("CATEGORY_WEITER_BTN"), LocatorTypes.CSS);
				returnValue &= !weiterBtn.isEnabled();
				// Selecting the first radio button for testing purpose
				test.log(Status.INFO,
						"Click on Mich alleine radio button and verify weiter button is still disabled");
				WebElement radioButtonEle = findElement(webElemProp.getProperty("CATEGORY_RADIO_BTN"),
						LocatorTypes.CSS);
				click(radioButtonEle);
				Thread.sleep(3000);
				returnValue &= !weiterBtn.isEnabled();
				test.log(Status.INFO,
						"Click on Ich bin im öffentlichen Dienst beschäftigt radio button and verify weiter button is still disabled");
				radioButtonEle = findElement(webElemProp.getProperty("CATEGORY_RADIO_BTN"), LocatorTypes.CSS);
				click(radioButtonEle);
				Thread.sleep(3000);
				returnValue &= !weiterBtn.isEnabled();
				test.log(Status.INFO, "Click on damange reduction button");
				radioButtonEle = findElement(webElemProp.getProperty("CATEGORY_RADIO_BTN"), LocatorTypes.CSS);
				click(radioButtonEle);
				Thread.sleep(3000);
				test.log(Status.INFO, "Verify Weiter btn on select category page is enabled");
				returnValue &= weiterBtn.isEnabled();
				test.log(Status.INFO, "Click on weiter btn on category page");
				click(weiterBtn);
				waitForElementVisibility(webElemProp.getProperty("AWESOME_OFFER_PAGE_HEADER"), 30);
				test.log(Status.INFO, "Verify awesome offer page is displayed");
				WebElement offerpageHeader = findElement(webElemProp.getProperty("AWESOME_OFFER_PAGE_HEADER"),
						LocatorTypes.CSS);
				returnValue &= offerpageHeader.getText().trim()
						.equals(webElemProp.getProperty("AWESOME_OFFER_PAGE_HEADER_TEXT"));

			}

		}

		if (returnValue) {
			test.log(Status.PASS, "The method <b>navigateFromPrivathaftplflichtPageToSelectCategories passed");
		} else {
			test.log(Status.FAIL, "The method <b>navigateFromPrivathaftplflichtPageToSelectCategories failed");
		}

		return returnValue;
	}

	/**
	 * Page navigatation from offer to checkout page
	 * 
	 * @return
	 */
	public boolean pageNavigatationFromOfferToCheckout() {

		test.log(Status.INFO, "Click on Zum Angebot button");
		WebElement zumAngebot = findElement(webElemProp.getProperty("ZUM_ANGEBOT_BUTTON"), LocatorTypes.CSS);
		returnValue = zumAngebot.isEnabled();
		click(zumAngebot);
		waitForElementVisibility(webElemProp.getProperty("FINISH_NOW_RECOMMENDED_BTN"), 30);
		test.log(Status.INFO, "Select a liability and click on finish now");
		WebElement recommenedBtn = findElement(webElemProp.getProperty("FINISH_NOW_RECOMMENDED_BTN"), LocatorTypes.CSS);
		returnValue &= recommenedBtn.isDisplayed() && recommenedBtn.isEnabled();
		if (returnValue) {
			click(recommenedBtn);
			waitForElementVisibility(webElemProp.getProperty("CHECKOUT_PAGE_HEADER"), 30);
			test.log(Status.INFO, "Verify checkout page is displayed");
			WebElement checkoutHeader = findElement(webElemProp.getProperty("CHECKOUT_PAGE_HEADER"), LocatorTypes.CSS);
			returnValue = checkoutHeader.isDisplayed()
					&& checkoutHeader.getText().equals(webElemProp.getProperty("CHECKOUT_PAGE_HEADER_TEXT"));
		}

		if (returnValue) {
			test.log(Status.PASS, "The method <b>pageNavigatationFromOfferToCheckout passed");
		} else {
			test.log(Status.FAIL, "The method <b>pageNavigatationFromOfferToCheckout failed");
		}

		return returnValue;
	}

}
