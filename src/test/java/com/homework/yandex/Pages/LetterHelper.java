package com.homework.yandex.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LetterHelper {
    public WebDriver driver;


    public void sendingLetter(String mailSending, String topicLetter) {
        click(By.xpath("//*[@class='mail-ComposeButton-Text']"));
        driver.findElement(By.xpath("//*[@name='to']")).sendKeys(mailSending);
        driver.findElement(By.xpath("//*[@name='subj-892b1db8d4e43159507f60faabd3c2e7cbde85cd']")).sendKeys(topicLetter);
        click(By.xpath("//*[@title='Отправить письмо (Ctrl + Enter)' and @id='nb-16']"));
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }
}
