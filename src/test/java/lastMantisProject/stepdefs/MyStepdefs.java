package lastMantisProject.stepdefs;

import com.spbstu.MantisSite;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lastMantisProject.helper.LoadFromResources;

/**
 * Created by luck on 23.04.17.
 */
public class MyStepdefs {
    @Given("^Log in as \"([^\"]*)\"$")
    public void logInAs(String userKey) throws Throwable {
        MantisSite.open();
        MantisSite.homePage.login(LoadFromResources.getUser(userKey));
    }

    @And("^Log out$")
    public void logOut() throws Throwable {
        MantisSite.logOut.clickOnLogOutSpan();
    }

    @And("^Click on ReportIssue at the top$")
    public void clickOnReportIssueAtTheTop() throws Throwable {
        MantisSite.createAnIssue.clickOnReportIssueFromTop();
    }

    @When("^Fill the form from example \"([^\"]*)\"$")
    public void fillTheFormFromExample(String issueID) throws Throwable {
        MantisSite.createAnIssue.writeAnIssue(LoadFromResources.getIssue(issueID));
    }

    @And("^Click on SubmitIssue$")
    public void clickOnSubmitIssue() throws Throwable {
        MantisSite.createAnIssue.submitIssue();
    }

    @And("^Click on ViewIssue$")
    public void clickOnViewIssue() throws Throwable {
        MantisSite.testIsFieldFillCurrently.clickOnViewIssues();
    }

    @Then("^Check that the IssueList contains \"([^\"]*)\" with \"([^\"]*)\" by \"([^\"]*)\"$")
    public void checkThatTheIssueListContainsWithBy(String issue, String status, String user) throws Throwable {
        MantisSite.testIsFieldFillCurrently.isContains(LoadFromResources.getIssue(issue).getSummary(), LoadFromResources.getIssue(issue).getCategory(), status, LoadFromResources.getUser(user).getLogin(), LoadFromResources.getIssue(issue).getSeverity());
    }

    @Given("^Open \"([^\"]*)\"$")
    public void open(String issue) throws Throwable {
        MantisSite.changeIssue.clickOnTheIssue(LoadFromResources.getIssue(issue).getSummary());
    }

    @And("^Task fields contain info from \"([^\"]*)\" with reporter by \"([^\"]*)\", status by \"([^\"]*)\", resolution by \"([^\"]*)\"$")
    public void taskFieldsContainInfoFromWithReporterByStatusByResolutionBy(String issue, String reporter, String status, String resolution) throws Throwable {
        MantisSite.changeIssue.isIssueContainsDetails(reporter, LoadFromResources.getIssue(issue).getOrder(),
                LoadFromResources.getIssue(issue).getReproducibility(), LoadFromResources.getIssue(issue).getSeverity(),
                LoadFromResources.getIssue(issue).getPlatform(), LoadFromResources.getIssue(issue).getOS(),
                LoadFromResources.getIssue(issue).getOSVersion(), status, LoadFromResources.getIssue(issue).getSummary(),
                LoadFromResources.getIssue(issue).getDescription(), LoadFromResources.getIssue(issue).getStepsToReproduce(),
                LoadFromResources.getIssue(issue).getAdditionalInfo(), resolution);
    }

    @Then("^Change status to \"([^\"]*)\"$")
    public void changeStatusTo(String button) throws Throwable {
        MantisSite.changeIssue.chooseStatus(button);
    }

    @And("^Click on \"([^\"]*)\" button$")
    public void clickOnButton(String button) throws Throwable {
        MantisSite.changeIssue.clickOnButton(button);
    }

    @And("^Click on MyView$")
    public void clickOnMyView() throws Throwable {
        MantisSite.checkThatTheIssueIsClosed.clickOnMyViewButton();
    }
}
