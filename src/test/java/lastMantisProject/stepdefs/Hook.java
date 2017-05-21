package lastMantisProject.stepdefs;

import com.spbstu.MantisSite;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import lastMantisProject.helper.LoadFromResources;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

/**
 * Created by luck on 23.04.17.
 */
public class Hook {
    WebDriver driver;

    @Before
    public void before(Scenario scenario){
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("start-maximized");
        options.addArguments("--disable-impl-side-painting");
        driver = new ChromeDriver(options);

        /*System.setProperty("webdriver.chrome.driver", "/home/luck/Documents/selenium/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();*/
        driver.navigate().to("http://www.google.com");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        MantisSite.init(driver);
    }

    @After
    public void after(Scenario scenario){

        MantisSite.deleteIssue.clickViewIssues();
        MantisSite.deleteIssue.clickViewIssuesButton();

        try {
            MantisSite.deleteIssue.markToDelete(LoadFromResources.getIssue("Issue").getSummary());
        } catch (Exception e){
            e.printStackTrace();
        }
        MantisSite.deleteIssue.clickOnDelete();
        MantisSite.deleteIssue.clickOnDeleteIssues();
        Assert.assertFalse(MantisSite.testAfterDeleting.isContains("theme"));
        //driver.close();
        driver.quit();
    }

}
