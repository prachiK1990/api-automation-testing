$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/Features/taxdooApi_testing.feature");
formatter.feature({
  "name": "TaxDoo API Testing",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "API auto",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "User calls the Rest api",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinition.TaxdooApiSteps.callApiandCheckResponse()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Send create user request",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinition.TaxdooApiSteps.createUser()"
});
formatter.result({
  "status": "passed"
});
});