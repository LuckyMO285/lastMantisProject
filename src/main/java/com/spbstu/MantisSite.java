package com.spbstu;

import com.spbstu.Entities.WriteAnIssue;
import com.spbstu.pageObjectsFactory.*;
import com.spbstu.Entities.UserAuthorization;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by luck on 09.04.17.
 */
public class MantisSite {

    public static WriteAnIssue createAnIssue;
    public static UserAuthorization homePage;
    public static FactoryDeleteIssue deleteIssue;
    public static FactoryTestAfterDeleting testAfterDeleting;
    public static FactoryLogOut logOut;
    public static FactoryTestIsFieldFillCurrently testIsFieldFillCurrently;
    public static FactoryChangeIssue changeIssue;
    public static FactoryCheckThatTheIssueIsClosed checkThatTheIssueIsClosed;
    private static WebDriver driver;

    public static void init(WebDriver driver){
        MantisSite.createAnIssue = PageFactory.initElements(driver, WriteAnIssue.class);
        MantisSite.homePage = PageFactory.initElements(driver, UserAuthorization.class);
        MantisSite.deleteIssue = PageFactory.initElements(driver, FactoryDeleteIssue.class);
        MantisSite.testAfterDeleting = PageFactory.initElements(driver, FactoryTestAfterDeleting.class);
        MantisSite.logOut = PageFactory.initElements(driver, FactoryLogOut.class);
        MantisSite.testIsFieldFillCurrently = PageFactory.initElements(driver, FactoryTestIsFieldFillCurrently.class);
        MantisSite.changeIssue = PageFactory.initElements(driver,FactoryChangeIssue.class);
        MantisSite.checkThatTheIssueIsClosed = PageFactory.initElements(driver,FactoryCheckThatTheIssueIsClosed.class);
        MantisSite.driver = driver;
    }

    public static void open() {
        driver.navigate().to("http://127.0.0.1/mantisbt");
    }

    public static WebDriver getDriver(){
        return driver;
    }
}