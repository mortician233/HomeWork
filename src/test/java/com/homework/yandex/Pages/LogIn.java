package com.homework.yandex.Pages;

import com.homework.yandex.Utils.UserData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class LogIn extends UserData {
    WebDriver driver;

    public void getUrl(String url) {
        driver.navigate().to(url);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//div[@class='b-inline']")
    private WebElement logInMail;

    @FindBy(xpath = "//*[@data-reactid='24']")
    private WebElement enter;

    @FindBy(id= "passp-field-login")
    private WebElement fieldLogIn;

    @FindBy(xpath = "//*[@type='submit']")
    private WebElement submit;

    @FindBy(xpath = "passp-field-passwd")
    private WebElement fieldPassword;

    public LogIn(String fieldLogIn,String fieldPassword) {
        super(fieldLogIn, fieldPassword);
    }



    public void LogIn(String login, String password) {
        logInMail.click();
        enter.click();
        fieldLogIn.sendKeys(login);
        submit.click();
        driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
        fieldPassword.sendKeys(password);
        submit.click();
        driver.getCurrentUrl().equals("https://mail.yandex.ru/?uid=566972531#inbox");
    }
}
