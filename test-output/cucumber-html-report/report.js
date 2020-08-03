$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/main/java/Features/demoTesting.feature");
formatter.feature({
  "line": 1,
  "name": "Generate Insurance Quote",
  "description": "",
  "id": "generate-insurance-quote",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Propose Insurnace Quote for User",
  "description": "",
  "id": "generate-insurance-quote;propose-insurnace-quote-for-user",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "User is in home page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "User Clicks on Angebote link",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "User Clicks on privathaftpliflich option and proceeds by clicking on other radio buttons",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "User Clicks on Zum angebote and selects a liability and click on finish now",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "Checout page is opened and user enters email and passwd and click on register button",
  "rows": [
    {
      "cells": [
        "Email Address",
        "Password"
      ],
      "line": 10
    },
    {
      "cells": [
        "@clark.de",
        "We-L0ve-Insurance"
      ],
      "line": 11
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "User Enter personal info and proceeds",
  "rows": [
    {
      "cells": [
        "VorName",
        "NachName",
        "Gender",
        "Age",
        "TelePhone",
        "Street",
        "HausNum",
        "Pin",
        "Place"
      ],
      "line": 13
    },
    {
      "cells": [
        "John",
        "Snow",
        "Male",
        "20",
        "015229320777",
        "1 Main St",
        "12",
        "60306",
        "Frankfurt"
      ],
      "line": 14
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 15,
  "name": "User Enter IBAN and accept TNC checkbox and proceeds",
  "rows": [
    {
      "cells": [
        "IBAN"
      ],
      "line": 16
    },
    {
      "cells": [
        "DE55500105174529223988"
      ],
      "line": 17
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 18,
  "name": "User clicks on next and navigate to the final quote page",
  "rows": [
    {
      "cells": [
        "Coverage Name",
        "Contract Name",
        "VorName"
      ],
      "line": 19
    },
    {
      "cells": [
        "Privathaftpflicht",
        "DBV",
        "John"
      ],
      "line": 20
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "DemoTestStepDefinition.user_is_in_home_page()"
});
formatter.result({
  "duration": 7589950056,
  "status": "passed"
});
formatter.match({
  "location": "DemoTestStepDefinition.user_Clicks_on_Angebote_link()"
});
formatter.result({
  "duration": 2167673749,
  "status": "passed"
});
formatter.match({
  "location": "DemoTestStepDefinition.user_Clicks_on_privathaftpliflich_option_and_proceeds_by_clicking_on_other_radio_buttons()"
});
formatter.result({
  "duration": 13005345151,
  "status": "passed"
});
formatter.match({
  "location": "DemoTestStepDefinition.user_Clicks_on_Zum_angebote_and_selects_a_liability_and_click_on_finish_now()"
});
formatter.result({
  "duration": 3103952329,
  "status": "passed"
});
formatter.match({
  "location": "DemoTestStepDefinition.checout_page_is_opened_and_user_enters_email_and_passwd_and_click_on_register_button(DataTable)"
});
formatter.result({
  "duration": 1857144843,
  "status": "passed"
});
formatter.match({
  "location": "DemoTestStepDefinition.user_Enter_personal_info_and_proceeds(DataTable)"
});
formatter.result({
  "duration": 2677781456,
  "status": "passed"
});
formatter.match({
  "location": "DemoTestStepDefinition.user_Enter_IBAN_and_accept_TNC_checkbox_and_proceeds(DataTable)"
});
formatter.result({
  "duration": 4491723185,
  "status": "passed"
});
formatter.match({
  "location": "DemoTestStepDefinition.user_clicks_on_next_and_navigate_to_the_final_quote_page(DataTable)"
});
formatter.result({
  "duration": 7797961583,
  "status": "passed"
});
});