package stepDefinitions;

import java.io.IOException;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;

import com.assignmentTest.assignment.Pages.DemoApplicationRegistratioPage;
import com.assignmentTest.assignment.Pages.DemoMethodPages;
import com.assignmentTest.assignment.helper.CommonUtils;
import com.assignmentTest.assignment.helper.LaunchWebUrl;
import com.aventstack.extentreports.Status;

import MyRunner.TestRunner;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DemoTestStepDefinition extends CommonUtils {

	public DemoTestStepDefinition() {
		getElementsPath("checkoutPageProperty.properties");
		getElementsPath("homePageProperty.properties");
	}

	boolean testResult = false;
	LaunchWebUrl launchUrl = new LaunchWebUrl();
	DemoMethodPages demoPageMethod = new DemoMethodPages();
	DemoApplicationRegistratioPage registrationPage = new DemoApplicationRegistratioPage();	
	
	@Given("^User is in home page$")
	public void user_is_in_home_page() {
		 test = TestRunner.getExtent().createTest("Test Step : user_is_in_home_page");
		try {
			testResult = launchUrl.loadAppUrl();

		} catch (Exception e) {
			test.log(Status.WARNING, "Error occured !!!" + e);
			testResult &= false;
		}

		Assert.assertEquals(true, testResult);

	}

	@When("^User Clicks on Angebote link$")
	public void user_Clicks_on_Angebote_link() throws Throwable {
		test = TestRunner.getExtent().createTest("Test Step : user_Clicks_on_Angebote_link");
		try {
			testResult = demoPageMethod.navigateToAngebotePage();

		} catch (Exception e) {
			test.log(Status.WARNING, "Error occured !!!" + e);
			testResult &= false;
		}
		if(!testResult) {
			test.log(Status.FAIL, "Execution of <b>user_Clicks_on_Angebote_link failed");
		}
		Assert.assertEquals(true, testResult);

	}

	@Then("^User Clicks on privathaftpliflich option and proceeds by clicking on other radio buttons$")
	public void user_Clicks_on_privathaftpliflich_option_and_proceeds_by_clicking_on_other_radio_buttons() {
		test = TestRunner.getExtent().createTest("Test Step : user_Clicks_on_privathaftpliflich_option_and_proceeds_by_clicking_on_other_radio_buttons");
		try {
			testResult = demoPageMethod.navigateFromPrivathaftplflichtPageToSelectCategories();

		} catch (Exception e) {
			test.log(Status.WARNING, "Error occured !!!" + e);
			testResult &= false;
		}
		if(!testResult) {
			test.log(Status.FAIL, "Execution of <b>user_Clicks_on_privathaftpliflich_option_and_proceeds_by_clicking_on_other_radio_buttons failed");
		}
		Assert.assertEquals(true, testResult);

	}

	@When("^User Clicks on Zum angebote and selects a liability and click on finish now$")
	public void user_Clicks_on_Zum_angebote_and_selects_a_liability_and_click_on_finish_now() {
		test = TestRunner.getExtent().createTest("Test Step : user_Clicks_on_Zum_angebote_and_selects_a_liability_and_click_on_finish_now");
		try {
			testResult = demoPageMethod.pageNavigatationFromOfferToCheckout();

		} catch (Exception e) {
			test.log(Status.WARNING, "Error occured !!!" + e);
			testResult &= false;
		}
		if(!testResult) {
			test.log(Status.FAIL, "Execution of <b>user_Clicks_on_Zum_angebote_and_selects_a_liability_and_click_on_finish_now failed");
		}
		Assert.assertEquals(true, testResult);

	}

	@Then("^Checout page is opened and user enters email and passwd and click on register button$")
	public void checout_page_is_opened_and_user_enters_email_and_passwd_and_click_on_register_button(
			DataTable mapData) {
		test = TestRunner.getExtent().createTest("Test Step : checout_page_is_opened_and_user_enters_email_and_passwd_and_click_on_register_button");
		
		try {
			for (Map<String, String> data : mapData.asMaps(String.class, String.class)) {
				String uniqueUserName = "Clark" + RandomStringUtils.randomAlphanumeric(3);
				testResult = registrationPage.secureRegistrationWithCredentials(
						uniqueUserName + data.get("Email Address"), data.get("Password"));
			}

		} catch (Exception e) {
			test.log(Status.WARNING, "Error occured !!!" + e);
			testResult &= false;
		}
		if(!testResult) {
			test.log(Status.FAIL, "Execution of <b>checout_page_is_opened_and_user_enters_email_and_passwd_and_click_on_register_button failed");
		}
		Assert.assertEquals(true, testResult);

	}

	@Then("^User Enter personal info and proceeds$")
	public void user_Enter_personal_info_and_proceeds(DataTable mapData) {
		test = TestRunner.getExtent().createTest("Test Step : user_Enter_personal_info_and_proceeds");
		
		try {
			for (Map<String, String> data : mapData.asMaps(String.class, String.class)) {
				testResult = registrationPage.enterPersonalDetails(data.get("VorName"), data.get("NachName"),
						data.get("Gender"), data.get("Age"), data.get("TelePhone"));
				testResult &= registrationPage.enterMailingAddress(data.get("Street"), data.get("HausNum"),
						data.get("Pin"), data.get("Place"));
				testResult &= registrationPage.clickOnNextOnPersonalInfoPage();
			}

		} catch (Exception e) {
			test.log(Status.WARNING, "Error occured !!!" + e);
			testResult &= false;
		}
		if(!testResult) {
			test.log(Status.FAIL, "Execution of <b>user_Enter_personal_info_and_proceeds failed");
		}
		Assert.assertEquals(true, testResult);

	}

	@Then("^User Enter IBAN and accept TNC checkbox and proceeds$")
	public void user_Enter_IBAN_and_accept_TNC_checkbox_and_proceeds(DataTable mapData) throws IOException {
		test = TestRunner.getExtent().createTest("Test Step : user_Enter_IBAN_and_accept_TNC_checkbox_and_proceeds");
		

		try {
			for (Map<String, String> data : mapData.asMaps(String.class, String.class)) {
				testResult = registrationPage.enterIBanAndProceed(data.get("IBAN"));
			}

		} catch (Exception e) {
			test.log(Status.WARNING, "Error occured !!!" + e);
			testResult &= false;
		}
		if(!testResult) {
			test.log(Status.FAIL, "Execution of <b>user_Enter_IBAN_and_accept_TNC_checkbox_and_proceeds failed");
		}

		Assert.assertEquals(true, testResult);

	}

	@Then("^User clicks on next and navigate to the final quote page$")
	public void user_clicks_on_next_and_navigate_to_the_final_quote_page(DataTable mapData) throws Throwable {
		test = TestRunner.getExtent().createTest("Test Step : user_clicks_on_next_and_navigate_to_the_final_quote_page");
		
		try {
			for (Map<String, String> data : mapData.asMaps(String.class, String.class)) {
				testResult = registrationPage.pageNavigationToCheckoutPage(data.get("VorName"));
				testResult &= registrationPage.verifyContractDetailsOnManagerRoute(data.get("Coverage Name"),
						data.get("Contract Name"));
			}

		} catch (Exception e) {
			test.log(Status.WARNING, "Error occured !!!" + e);
			testResult &= false;
		}
		if(!testResult) {
			test.log(Status.FAIL, "Execution of <b>user_clicks_on_next_and_navigate_to_the_final_quote_page failed");
		}
		Assert.assertEquals(true, testResult);

	}

}
