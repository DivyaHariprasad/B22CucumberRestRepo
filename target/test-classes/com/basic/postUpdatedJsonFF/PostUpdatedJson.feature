Feature: First Rest Assured test POST 


Scenario Outline: Test my POST request test11
Given  user hit the rest asured test
Then user checks data at path "<name>" having value "<job>" in jason
Then user validate the id is not null 
Examples:
	| name																				|  job   			| 
	|Kshipra     															  	|  QA lead    |
	|Anagha                                     	| QA manager  |
	|Madhura                                      | QA manager  |
	|Divya                                        |QA lead      |

#Scenario: Test my POST request test22
#Given  user hit the post request with "Pratha" name
#Then user validate the id is not null 

#Scenario: Test my POST request test 
#Given  user hit the post request with "Pragya" name
#Then user validate the id is not null 



 

