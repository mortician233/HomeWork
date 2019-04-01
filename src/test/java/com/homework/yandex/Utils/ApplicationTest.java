package com.homework.yandex.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class ApplicationTest {


    public WebDriver driver;
    public WebElement element;

    public MailData mailData;


    public MailData getMailData() {
        return mailData;
    }

    public void getUrl(String Url) {
        driver.get(Url);
    }

    public void logIn(LogInData logInData) {
        driver.findElement(By.xpath("//div[@class='b-inline']")).click();
        driver.findElement(By.xpath("//*[@data-reactid='24']")).click();
        driver.findElement(By.id("passp-field-login")).sendKeys(logInData.login);
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.findElement(By.id("passp-field-passwd")).sendKeys(logInData.password);
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.getCurrentUrl().equals("https://mail.yandex.ru/?uid=566972531#inbox");
    }


}
