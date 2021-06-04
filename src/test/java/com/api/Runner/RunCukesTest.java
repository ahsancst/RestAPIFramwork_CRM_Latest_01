package com.api.Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(strict = false,

		features = {
				"src/test/resources/Features/TC_001_Get_Token.feature",
				 "src/test/resources/Features/TC_002_Account_Validation.feature", 
				"src/test/resources/Features/TC_003_Opportunity_Validation.feature",

		},

		glue = "com.api.Step_Definition", plugin = { "html:target/cucumber-html-report", "json:target/jsonReports/cucumber.json",
				"pretty:target/cucumber-pretty.txt", "usage:target/cucumber-usage.json",
				"junit:target/cucumber-results.xml" },

		tags = { "@Regression" })

public class RunCukesTest extends AbstractTestNGCucumberTests {

}
