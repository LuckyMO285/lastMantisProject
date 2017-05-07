package com.spbstu.pageObjectsFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by luck on 16.04.17.
 */
public class FactoryLogOut {
    @FindBy(xpath = "//span[@class='user-info']")
    WebElement roleSpan;

    @FindBy(xpath = "//i[@class='ace-icon fa fa-sign-out']")
    WebElement logOut;

    public void clickOnLogOutSpan(){
        roleSpan.click();
        logOut.click();
    }

}
