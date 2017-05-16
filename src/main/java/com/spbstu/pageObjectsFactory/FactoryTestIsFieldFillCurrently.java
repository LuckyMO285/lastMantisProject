package com.spbstu.pageObjectsFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by luck on 16.04.17.
 */
public class FactoryTestIsFieldFillCurrently {

    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[2]/a/i")
    WebElement ViewIssues;

    @FindAll({
            @FindBy (xpath = "//td[@class='column-summary']")
    })
    List<WebElement> checkSummary;

    @FindBy(xpath = "//td[@class='column-status']")
    WebElement status;

    @FindBy(xpath = "//td[@class='column-category']")
    WebElement category;

    @FindBy(xpath = "//td[@class='column-severity']")
    WebElement severity;

    public void clickOnViewIssues(){
        this.ViewIssues.click();
    }

    public boolean isContains(String summary, String category, String status, String username, String severity) throws Exception {

       return checkSummary.stream()
                .filter(row -> row.findElement(By.xpath("//td[@class='column-summary']")).getText().equals(summary))
                .findFirst()
                .orElseThrow(Exception::new)
                .findElement(By.xpath("//td[@class='column-status']")).getText().equals(status+" ("+username+")")
               && checkSummary.stream()
               .filter(row -> row.findElement(By.xpath("//td[@class='column-summary']")).getText().equals(summary))
               .findFirst()
               .orElseThrow(Exception::new)
               .findElement(By.xpath("//td[@class='column-category']")).getText().equals(category)
               && checkSummary.stream()
               .filter(row -> row.findElement(By.xpath("//td[@class='column-summary']")).getText().equals(summary))
               .findFirst()
               .orElseThrow(Exception::new)
               .findElement(By.xpath("//td[@class='column-severity']")).getText().equals(severity);

    }
}
