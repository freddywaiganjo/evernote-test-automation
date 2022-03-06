package reusableactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Notes {

    private static WebDriver driver;


    public Notes(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    int y =1;
    public String noteName = "AlexNote"+y++;

    @FindBy(how = How.XPATH, using = "//button[@aria-label='New Note']")
    WebElement lblCreateNote;

    @FindBy(how = How.XPATH, using = "//input[@id='loginButton']")
    WebElement btnLogin;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Test')]")
    WebElement lblOpenNote;

    @FindBy(how = How.XPATH, using = "//en-note[@id='en-note']")
    WebElement lblEditorBody;

    @FindBy(how = How.XPATH, using = "//textarea[@placeholder='Title']")
    WebElement lblEditorTitle;

  @FindBy(how = How.XPATH, using = "//button[@id='qa-NAV_HOME']")
    WebElement lblHome;

  @FindBy(how = How.XPATH, using = "//article[@role='presentation'][1]")
    WebElement lblCreatedNote;

  /*  public void lblCreatedNote(String noteName ){
        WebElement ele = driver.findElement(By.xpath("//span[contains(text(),'" + noteName + "')]"));
        ele.isDisplayed();
        System.out.print("Note: "+ele.getText());
    }*/

    public void createNewNote() throws Exception{
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(lblCreateNote));
        System.out.println("### "+lblCreateNote.getText());
        lblCreateNote.click();
//        btnLogin.click();
        Thread.sleep(5000);
    }


    public void writeNewNote() throws Exception{
        WebElement frame = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("qa-COMMON_EDITOR_IFRAME")));
        driver.switchTo().frame(frame);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(lblEditorTitle));
        lblEditorTitle.click();
        lblEditorTitle.sendKeys(noteName);
        WebDriverWait wait1 = new WebDriverWait(driver, 10);
        wait1.until(ExpectedConditions.visibilityOf(lblEditorBody));
        lblEditorBody.click();
        lblEditorBody.sendKeys("This is my new note. Web Automation is awesome");
        Thread.sleep(10000);
        driver.switchTo().defaultContent();
        lblHome.click();
    }

    public void openCreatedNote() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(lblCreatedNote));
        lblCreatedNote.click();
    }

    public void checkNoteEditor() {
        WebElement frame = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("qa-COMMON_EDITOR_IFRAME")));
        driver.switchTo().frame(frame);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(lblEditorTitle));
        lblEditorTitle.click();
//        lblEditorTitle.isDisplayed();
        System.out.println("Note "+ lblEditorTitle.getText());
        driver.switchTo().defaultContent();
//        Thread.sleep(5000);
    }

}
