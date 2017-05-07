package com.spbstu.pageObjectsFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by luck on 09.04.17.
 */

public class FactoryDeleteIssue {

    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[1]/a")
    WebElement myView;

    @FindBy(xpath = "//*[@id=\"recent_mod\"]/div[1]/div[2]/div/a")
    WebElement viewIssues;

    @FindAll({
            @FindBy(xpath = "//td[@class='column-summary']")
            })
   List<WebElement> checkSummary;

    @FindBy(xpath = "//input[@type='submit' and @value='Delete']")
    WebElement pressDelete;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement pressDeleteIssues;

    public void clickViewIssues(){
        myView.click();
    }

    public void clickViewIssuesButton(){
        viewIssues.click();
    }

    public void markToDelete(String str) throws Exception {
        checkSummary.stream()
                .filter(row -> row.findElement(By.xpath("//td[@class='column-summary']")).getText().equals(str))
                .findFirst()
                .orElseThrow(Exception::new)
                .findElement(By.xpath("//td[@class='column-id']"))
                .click();
    }

    public void clickOnDelete(){
        pressDelete.click();
    }

    public void clickOnDeleteIssues(){
        pressDeleteIssues.click();
    }

}
