package stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import reusableactions.Login;
import reusableactions.Notes;

public class stepLogin {

    private SharedDriver sharedDriver;
    private WebDriver driver;
    private Login login;
    private Notes notes;

    public stepLogin(SharedDriver sharedDriver) {
        this.sharedDriver = sharedDriver;
        this.notes = new Notes(sharedDriver.getDriver());
    }

    @And("^i confirm i'm at login page")
    public void im_at_login_page() throws Exception {
        login.inLoginPage();
    }


    @Given("^i did login in \"([^\"]*)\" with \"([^\"]*)\" an invalid user$")
    public void iDidLoginInWithAnInvalidSer(String username) throws Exception {
        driver = sharedDriver.getDriver();
        login = new Login(driver);
        login.driveAndUrlUp();
        login.login(username);
    }

    @Then("^i should get invalid login credentials$")
    public void iShouldGetInvalidLoginCredentials() throws Exception {
        login.invalidLoginCredentialMessage();
    }

    @Then("^i enter \"([^\"]*)\" an invalid password$")
    public void iEnterAnInvalidPassword(String password) {
        login.enterPassword(password);
    }

    @Then("^i enter \"([^\"]*)\" a valid password$")
    public void iEnterAValidPassword(String password) {
        login.enterPassword(password);
    }

    @Then("^i should be redirected to the dashboard$")
    public void iShouldBeRedirectedToTheDashboard() {
        login.homePage();
    }

    @Given("^i login to Evernote portal with \"([^\"]*)\" a valid email$")
    public void iLoginToEvernotePortalWithAValidEmail(String username) throws Exception {
        driver = sharedDriver.getDriver();
        login = new Login(driver);
        login.driveAndUrlUp();
        login.enterUsername(username);
    }

    @Then("^i click on create new note$")
    public void iClickOnCreateNewNote() throws Exception {
        notes.createNewNote();
    }
}
