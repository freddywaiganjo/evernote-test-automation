package stepdefinitions;

import com.vimalselvam.cucumber.listener.Reporter;
import config.ReadConfig;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class SharedDriver {

    private static boolean initialized = false;
    private WebDriver driver;

    @Before
    public void setUp() {

        if (!initialized) {


            String browser = ReadConfig.readConfig("default.browser");
            String headless = ReadConfig.readConfig("headless.active");

            if (browser.equalsIgnoreCase("chrome") && (headless.equalsIgnoreCase("false"))) {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                driver = new ChromeDriver(options);
            }

            if (browser.equalsIgnoreCase("chrome") && (headless.equalsIgnoreCase("true"))) {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--no-sandbox");
                options.addArguments("--headless");
                options.addArguments("--disable-gpu");
                options.addArguments("--window-size=1366,768");
                driver = new ChromeDriver(options);
            }

        }


    }

    public WebDriver getDriver() {
        return driver;
    }

    @After
    public void afterScenario() {
/*        Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
        Reporter.setSystemInfo("user", System.getProperty("user.name"));
        Reporter.setSystemInfo("os", "Mac OSX");
        Reporter.setTestRunnerOutput("Sample test runner output message");*/
        initialized = false;
        driver.quit();

    }

    @AfterClass
    public static void teardown() {
        Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
        Reporter.setSystemInfo("user", System.getProperty("user.name"));
        Reporter.setSystemInfo("os", "Mac OSX");
        Reporter.setTestRunnerOutput("Sample test runner output message");
    }

}
