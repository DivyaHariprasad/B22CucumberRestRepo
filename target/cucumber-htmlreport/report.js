$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("com/basic/compareEntireJson/comparejson.feature");
formatter.feature({
  "line": 1,
  "name": "compare entire json",
  "description": "",
  "id": "compare-entire-json",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "Test my Delete request",
  "description": "",
  "id": "compare-entire-json;test-my-delete-request",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "user compare two json string",
  "keyword": "Given "
});
formatter.match({
  "location": "TestCompareJson.user_compare_two_json_string()"
});
formatter.result({
  "duration": 155764195,
  "status": "passed"
});
});