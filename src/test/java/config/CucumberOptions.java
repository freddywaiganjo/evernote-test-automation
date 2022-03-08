package config;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@cucumber.api.CucumberOptions(
        features = "resources/features",
        monochrome = true,
        glue = {"stepdefinitions"},
        plugin = {"json:target/cucumber.json",
                "rerun:target/rerun.txt",
                "com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:test-report/report.html"}, //Creates a text file with failed scenarios
        tags = {"@Unsuccessful"})

public class CucumberOptions {
}