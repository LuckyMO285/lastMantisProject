package com.spbstu.Entities;

import com.spbstu.pageObjectsFactory.entities.Users;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by luck on 09.04.17.
 */

public class UserAuthorization {
    @FindBy(id = "username")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement submit;

    public void login(Users user){
        this.username.sendKeys(user.getLogin());
        this.password.sendKeys(user.getPassword());
        submit.click();
    }

}
