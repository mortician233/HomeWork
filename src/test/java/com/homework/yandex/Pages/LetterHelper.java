package com.homework.yandex.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class LetterHelper {
    public WebDriver driver;


    public void sendingLetter(String mailSending, String topicLetter) {
        click(By.xpath("//*[@class='mail-ComposeButton-Text']"));
        waitLoad(8);
        checkEnableElement(By.xpath("//*[@class= '_nb-button-text' and text()='mortician233@yandex.ru']"));
        driver.findElement(By.xpath("//*[@name='to']")).sendKeys(mailSending);
        driver.findElement(By.xpath("//*[@name='subj-892b1db8d4e43159507f60faabd3c2e7cbde85cd']")).sendKeys(topicLetter);
        click(By.xpath("//*[@title='Отправить письмо (Ctrl + Enter)' and @id='nb-16']"));
        waitLoad(8);
        checkEnableElement(By.xpath("//*[@class= 'mail-Done-Title js-title-info' and text()='Письмо отправлено.']"));
    }

    public void deletingLetter(){
        click(By.xpath("//*[@class= 'mail-NestedList-Item-Name js-folders-item-name' and text()='Отправленные']"));
        waitLoad(8);
        selectCheckBox(By.xpath("//*[@class= '_nb-checkbox-flag _nb-checkbox-normal-flag']"));
        click(By.xpath("//*[@class= 'mail-Toolbar-Item-Text js-toolbar-item-title js-toolbar-item-title-delete' and text()='Удалить']"));
        checkEnableElement(By.xpath("//*[@class='b-messages__placeholder-item' and text()='В папке «Отправленные» нет писем.']"));
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void checkEnableElement(By locator){
        driver.findElement(locator).isDisplayed();
    }

    public void selectCheckBox(By locator) {
       WebElement checkbox = driver.findElement(locator);
       checkbox.isSelected();
       checkbox.click();
    }

    public void waitLoad(int waitSeconds) {
        driver.manage().timeouts().implicitlyWait(waitSeconds, TimeUnit.SECONDS);
    }
}
