Feature: Generate Insurance Quote

Scenario: Propose Insurnace Quote for User

Given User is in home page
When User Clicks on Angebote link
Then User Clicks on privathaftpliflich option and proceeds by clicking on other radio buttons
When User Clicks on Zum angebote and selects a liability and click on finish now
Then Checout page is opened and user enters email and passwd and click on register button
|Email Address   | Password          |
|@clark.de       | We-L0ve-Insurance |
Then User Enter personal info and proceeds
|VorName |NachName |Gender |Age |TelePhone    |Street        |HausNum  |Pin   |Place     |
|John	 |Snow 	   |Male   |20  |015229320777 |1 Main St     |12       |60306 |Frankfurt |
Then User Enter IBAN and accept TNC checkbox and proceeds
|IBAN    				 |
|DE55500105174529223988  |
Then User clicks on next and navigate to the final quote page
|Coverage Name      | Contract Name |VorName |
|Privathaftpflicht  | DBV           |John    |



