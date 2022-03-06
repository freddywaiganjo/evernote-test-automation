package reusableactions;

import config.ReadConfig;
import freemarker.core.Environment;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepdefinitions.SharedDriver;

public class Logout {

    private static WebDriver driver;

    public Logout(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(how = How.XPATH, using = "//div[@id='qa-NAV_USER']")
    WebElement lblUserProfile;

    @FindBy(how = How.XPATH, using = "//a[@id='qa-ACCOUNT_DROPDOWN_LOGOUT']")
    WebElement lblLogout;

    public void logoutUser() throws Exception{
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(lblUserProfile));
        lblUserProfile.click();
        lblLogout.click();
        Thread.sleep(10000);
    }

}
