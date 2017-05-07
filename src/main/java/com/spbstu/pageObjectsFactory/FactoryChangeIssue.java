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

    @FindBy(xpath = "//*[@id=\"main-container\"]/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr[5]/td[1]")
    WebElement reporter;

    @FindBy(xpath = "//*[@id=\"main-container\"]/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr[6]/td[1]")
    WebElement assignedTo;

    @FindBy(xpath = "//*[@id=\"main-container\"]/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr[7]/td[3]")
    WebElement reproducibility;

    @FindBy(xpath = "//*[@id=\"main-container\"]/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr[7]/td[2]")
    WebElement severity;

    @FindBy(xpath = "//*[@id=\"main-container\"]/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr[9]/td[1]")
    WebElement platform;

    @FindBy(xpath = "//*[@id=\"main-container\"]/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr[9]/td[2]")
    WebElement os;

    @FindBy(xpath = "//*[@id=\"main-container\"]/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr[9]/td[3]")
    WebElement osVersion;

    @FindBy(xpath = "//*[@id=\"main-container\"]/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr[8]/td[1]")
    WebElement status;

    @FindBy(xpath = "//*[@id=\"main-container\"]/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr[12]/td")
    WebElement summary;

    @FindBy(xpath = "//*[@id=\"main-container\"]/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr[13]/td")
    WebElement description;

    @FindBy(xpath = "//*[@id=\"main-container\"]/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr[14]/td")
    WebElement stepsToReproduce;

    @FindBy(xpath = "//*[@id=\"main-container\"]/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr[15]/td")
    WebElement additionalInformation;

    @FindBy(xpath = "//*[@id=\"main-container\"]/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr[8]/td[2]")
    WebElement resolution;

    @FindBy(xpath = "//*[@id=\"main-container\"]/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div/table/tfoot/tr/td/div/div[3]/form/select/option[.='resolved']")
    WebElement statusResolved;

    @FindBy(xpath = "//*[@id=\"main-container\"]/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div/table/tfoot/tr/td/div/div[3]/form/select/option[.='closed']")
    WebElement statusClosed;

    @FindBy(xpath = "//*[@id=\"main-container\"]/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div/table/tfoot/tr/td/div/div[3]/form/input[1]")
    WebElement changeStatusbotton;

    @FindBy(xpath = "//*[@id=\"bug-change-status-form\"]/fieldset/div/div[2]/div[2]/input")
    WebElement resolveIssue;

    @FindBy(xpath = "//*[@id=\"bug-change-status-form\"]/fieldset/div/div[2]/div[2]/input")
    WebElement closeIssue;

    @FindBy(xpath = "//*[@id=\"recent_mod\"]/div[1]/div[2]/div/a")
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
