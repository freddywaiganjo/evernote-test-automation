package config;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@cucumber.api.CucumberOptions(features = "resources/features",
        monochrome = true,
        glue = {"stepdefinitions"},
        plugin = {"json:target/cucumber.json",
                "rerun:target/rerun.txt"}, //Creates a text file with failed scenarios
        tags = {"@testAll"})

public class CucumberOptions {
}