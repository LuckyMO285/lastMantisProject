package com.spbstu.pageObjectsFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

/**
 * Created by luck on 09.04.17.
 */
public class FactoryTestAfterDeleting {

    @FindAll({
            @FindBy(xpath = "//td[@class='column-summary']")
    })
    private List<WebElement> checkSummary2;

    public boolean isContains(String summary) {
        return checkSummary2.stream()
                .anyMatch(row -> row.findElement(By.xpath("//td[@class='column-summary']"))
                        .getText()
                        .equals(summary));
    }

}
