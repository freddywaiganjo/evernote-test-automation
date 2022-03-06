package stepdefinitions;

import cucumber.api.java.en.Then;
import reusableactions.Logout;

public class stepLogout {

    SharedDriver sharedDriver;
    Logout logout;

    public stepLogout(SharedDriver sharedDriver) {
        this.sharedDriver = sharedDriver;
        this.logout = new Logout(sharedDriver.getDriver());
    }




    @Then("^i should be able to logout$")
    public void iShouldBeAbleToLogout() throws Exception {
        logout.logoutUser();
    }
}
