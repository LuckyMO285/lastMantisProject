package com.spbstu.pageObjectsFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by luck on 07.05.17.
 */
public class FactoryCheckThatTheIssueIsClosed {

    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[1]/a/span")
    WebElement myView;

    public void clickOnMyViewButton(){
        this.myView.click();
    }

}
