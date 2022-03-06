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

public class Login {

    private static WebDriver driver;

    public Login(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(how = How.XPATH, using = "//input[@id='username']")
    WebElement txtBoxUsername;

    @FindBy(how = How.XPATH, using = "//input[@id='loginButton']")
    WebElement btnLogin;

    @FindBy(how = How.XPATH, using = "//input[@id='password']")
    WebElement txtBoxPassword;

    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Incorrect password')]")
    WebElement lblLoginError;

    @FindBy(how = How.XPATH, using = "//div[@id='qa-HOME_TITLE']")
    WebElement lblHomeTitle;

    @FindBy(how =How.XPATH, using = "//a[contains(text(),'Forgot Password?')]")
    WebElement resetPassword;

    public void driveAndUrlUp() {
        String baseURL = "null";
            baseURL = ReadConfig.readConfig("baseUrl");

        if (driver.toString().equalsIgnoreCase("null")) {
            SharedDriver sharedDriver = new SharedDriver();
            driver = sharedDriver.getDriver();
        }


        driver.get(baseURL);
        driver.manage().window().maximize();

    }

    public void enterUsername(String username) throws Exception{
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(txtBoxUsername));
        txtBoxUsername.click();
        txtBoxUsername.sendKeys(username);
        btnLogin.click();
        Thread.sleep(5000);
    }

    public void enterPassword(String password) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(txtBoxPassword));
        txtBoxPassword.click();
        txtBoxPassword.sendKeys(password);
        btnLogin.click();
//        Thread.sleep(30000);
    }

    public void homePage() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(lblHomeTitle));
        lblHomeTitle.isDisplayed();
        System.out.println("### "+lblHomeTitle.getText());
    }

    public void login(String username) throws Exception {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(txtBoxUsername));

            WebDriverWait wait1 = new WebDriverWait(driver, 30);
            wait1.until(ExpectedConditions.visibilityOf(resetPassword));
                txtBoxUsername.click();
                txtBoxUsername.sendKeys(username);
                btnLogin.click();
                Thread.sleep(5000);

        }


    public void inLoginPage() throws Exception {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.visibilityOf(txtBoxUsername));
        } catch (Exception e) {
            throw new Exception("<<<<<<<<   <<<<<< LOGIN PAGE DID NOT LOAD >>>>>>>>>>>>>>");
        }
    }

    public void invalidLoginCredentialMessage() throws Exception {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(lblLoginError));
//            Assert.assertEquals("The Username or Password you entered is not valid",String.valueOf(lblLoginError.getText()));
        } catch (Exception e) {
            throw new Exception("<<<<<<<<<<<<<< LOGIN PAGE DID NOT LOAD >>>>>>>>>>>>>>");
        }
    }
}
