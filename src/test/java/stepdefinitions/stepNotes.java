package stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import reusableactions.Login;
import reusableactions.Notes;

public class stepNotes {

    private SharedDriver sharedDriver;
    private WebDriver driver;
    private Login login;
    private Notes notes;

    public stepNotes(SharedDriver sharedDriver) {
        this.sharedDriver = sharedDriver;
        this.notes = new Notes(sharedDriver.getDriver());
    }

    @Given("^i have logged in to Evernote portal with username \"([^\"]*)\" and  password \"([^\"]*)\"$")
    public void iHaveLoggedInToEvernotePortalWithUsernameAndPassword(String username, String password) throws Exception {
        driver = sharedDriver.getDriver();
        login = new Login(driver);
        login.driveAndUrlUp();
        login.enterUsername(username);
        login.enterPassword(password);
    }

    @Then("^i click on open test note$")
    public void iClickOnOpenTestNote() {
        notes.openCreatedNote();
    }

    @And("^i confirm notes are visible$")
    public void iConfirmNotesAreVisible() {
        notes.checkNoteEditor();
    }

    @Then("^i write a note$")
    public void iWriteANote() throws Exception {
        notes.writeNewNote();
    }
}