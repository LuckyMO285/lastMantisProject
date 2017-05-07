package com.spbstu.Entities;

import com.spbstu.pageObjectsFactory.entities.Issues;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by luck on 09.04.17.
 */

//TODO
public class WriteAnIssue {

    @FindBy(xpath = "//*[@id=\"category_id\"]/option[.='[All Projects] General']")
    WebElement category;

    @FindBy(xpath = "//*[@id=\"reproducibility\"]/option[.='always']")
    WebElement reproducibility;

    @FindBy(xpath = "//*[@id=\"severity\"]/option[.='block']")
    WebElement severity;

    @FindBy(xpath = "//*[@id=\"priority\"]/option[.='urgent']")
    WebElement priority;

    @FindBy(id = "platform")
    WebElement platform;

    @FindBy(id = "os")
    WebElement OS;

    @FindBy(id = "os_build")
    WebElement OSVersion;

    @FindBy(xpath = "//*[@id=\"handler_id\"]/option[.='dev1']")
    WebElement orderToUser;

    @FindBy(id = "summary")
    WebElement summary;

    @FindBy(id = "description")
    WebElement description;

    @FindBy(id = "steps_to_reproduce")
    WebElement stepsToReproduce;

    @FindBy(id = "additional_info")
    WebElement additionalInfo;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement submitIssue;

    @FindBy(xpath = "//*[@id=\"navbar-container\"]/div[2]/ul/li[1]/div/a[1]")
    WebElement ReportIssueFromTop;

    public void clickOnReportIssueFromTop(){
        this.ReportIssueFromTop.click();
    }

    public void writeAnIssue(Issues issue){
        this.category.click();
        this.reproducibility.click();
        this.severity.click();
        this.priority.click();
        this.platform.sendKeys(issue.getPlatform());
        this.OS.sendKeys(issue.getOS());
        this.OSVersion.sendKeys(issue.getOSVersion());
        this.orderToUser.click();
        this.summary.sendKeys(issue.getSummary());
        this.description.sendKeys(issue.getDescription());
        this.stepsToReproduce.sendKeys(issue.getStepsToReproduce());
        this.additionalInfo.sendKeys(issue.getAdditionalInfo());
    }

    public void submitIssue(){
        this.submitIssue.click();
    }
}
