package com.spbstu.pageObjectsFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by luck on 07.05.17.
 */
public class FactoryChangeIssue {

    @FindAll({
            @FindBy(xpath = "//td[@class='column-summary']")
    })
    List<WebElement> checkSummary;

    @FindBy(xpath = "//td[@class='bug-reporter']")
    WebElement reporter;

    @FindBy(xpath = "//td[@class='bug-assigned-to']")
    WebElement assignedTo;

    @FindBy(xpath = "//td[@class='bug-reproducibility']")
    WebElement reproducibility;

    @FindBy(xpath = "//td[@class='bug-severity']")
    WebElement severity;

    @FindBy(xpath = "//td[@class='bug-platform']")
    WebElement platform;

    @FindBy(xpath = "//td[@class='bug-os']")
    WebElement os;

    @FindBy(xpath = "//td[@class='bug-os-version']")
    WebElement osVersion;

    @FindBy(xpath = "//td[@class='bug-status']")
    WebElement status;

    @FindBy(xpath = "//td[@class='bug-summary']")
    WebElement summary;

    @FindBy(xpath = "//td[@class='bug-description']")
    WebElement description;

    @FindBy(xpath = "//td[@class='bug-steps-to-reproduce']")
    WebElement stepsToReproduce;

    @FindBy(xpath = "//td[@class='bug-additional-information']")
    WebElement additionalInformation;

    @FindBy(xpath = "//td[@class='bug-resolution']")
    WebElement resolution;

    @FindBy(xpath = "//select[@name='new_status'][1]/option[.='resolved']")
    WebElement statusResolved;

    @FindBy(xpath = "//select[@name='new_status'][1]/option[.='closed']")
    WebElement statusClosed;

    @FindBy(xpath = "//input[@type='submit' and @value='Change Status To:']")
    WebElement changeStatusbotton;

    @FindBy(xpath = "//input[@type='submit' and @value='Resolve Issue']")
    WebElement resolveIssue;

    @FindBy(xpath = "//input[@type='submit' and @value='Close Issue']")
    WebElement closeIssue;

    @FindBy(xpath = "//*[@id=\"recent_mod\"]/div[1]/div[2]")
    WebElement viewIssues;


    public void clickOnTheIssue(String summary) throws Exception {
        checkSummary.stream()
                .filter(row -> row.findElement(By.xpath("//td[@class='column-summary']")).getText().equals(summary))
                .findFirst()
                .orElseThrow(Exception::new)
                .findElement(By.xpath("//td[@class='column-id']"))
                .click();
    }

    public boolean isIssueContainsDetails(String reporterFromMain, String assignedToFromMain, String reproducibilityFromMain,
                                          String severityFromMain, String platformFromMain, String osFromMain,
                                          String osVersionFromMain, String statusFromMain, String summaryFromMain,
                                          String descriptionFromMain, String stepsToReproduceFromMain,
                                          String additionalInformationFromMain, String resolutionFromMain) {


        return (reporter.getText().equals(reporterFromMain) && assignedTo.getText().equals(assignedToFromMain) &&
            reproducibility.getText().equals(reproducibilityFromMain) && severity.getText().equals(severityFromMain) &&
            platform.getText().equals(platformFromMain) && os.getText().equals(osFromMain) &&
            osVersion.getText().equals(osVersionFromMain) && status.getText().equals(statusFromMain) &&
            summary.getText().equals(summaryFromMain) && description.getText().equals(descriptionFromMain) &&
            stepsToReproduce.getText().equals(stepsToReproduceFromMain) &&
            additionalInformation.getText().equals(additionalInformationFromMain) &&
            resolution.getText().equals(resolutionFromMain));
    }

    public void chooseStatus(String button){
        if (button.equals("resolved")) {
            statusResolved.click();
        }
        else{
            statusClosed.click();
        }
    }

    public void clickOnButton(String button){
        if (button.equals("Change Status To:")){
            changeStatusbotton.click();
        }
        else if (button.equals("Resolve Issue")){
            resolveIssue.click();
        }
        else if (button.equals("Close Issue")){
            closeIssue.click();
        }
        else if (button.equals("Recently Modified (30 Days)")){
            viewIssues.click();
        }
    }

}
