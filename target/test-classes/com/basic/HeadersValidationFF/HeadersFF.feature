Feature: First GET Rest Assured test101


Scenario Outline: Test my Get Method101
Given  user start the rest asured test
Then user checks headers at path "<header>" have "<value>" in Json

Examples:
|header                   |value                              |
|Content-Type             |application/json; charset=utf-8    |
|date                     |server                             |