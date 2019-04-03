package com.homework.yandex.Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class LetterHelper {
    public WebDriver driver;

    public void sendingLetter(String mailSending, String topicLetter, String message) {
        click(By.xpath("//*[@class='mail-ComposeButton-Text']"));
        waitLoad(8);
        checkEnableElement(By.xpath("//*[@class= '_nb-button-text' and text()='mortician233@yandex.ru']"));
        driver.findElement(By.xpath("//*[@name='to']")).sendKeys(mailSending);
        driver.findElement(By.xpath("//*[@name='subj-892b1db8d4e43159507f60faabd3c2e7cbde85cd']")).sendKeys(topicLetter);
        driver.findElement(By.xpath("//*[@class='cke_source cke_reset cke_enable_context_menu cke_editable cke_editable_themed cke_contents_ltr']")).sendKeys(message);
        click(By.xpath("//*[@title='Отправить письмо (Ctrl + Enter)' and @id='nb-16']"));
        waitLoad(8);
        checkEnableElement(By.xpath("//*[@class= 'mail-Done-Title js-title-info' and text()='Письмо отправлено.']"));
    }

    public void deletingLetter(){
        mailSection("Отправленные");
        waitLoad(8);
        selectCheckBox(By.xpath("//*[@class= '_nb-checkbox-flag _nb-checkbox-normal-flag']"));
        click(By.xpath("//*[@class= 'mail-Toolbar-Item-Text js-toolbar-item-title js-toolbar-item-title-delete' and text()='Удалить']"));
        checkEnableElement(By.xpath("//*[@class='b-messages__placeholder-item' and text()='В папке «Отправленные» нет писем.']"));
    }

    public void movingLetter(){
        mailSection("Удалённые");
        selectCheckBox(By.xpath("//*[@class= '_nb-checkbox-flag _nb-checkbox-normal-flag']"));
        waitLoad(8);
        folderSelection("Входящие");
        mailSection("Входящие");
        selectCheckBox(By.xpath("//*[@class= '_nb-checkbox-flag _nb-checkbox-normal-flag']"));
        folderSelection("Спам");
        mailSection("Спам");
    }

    public void mailSection(String mailSection){
        driver.findElement(By.xpath("//*[@class='mail-NestedList-Item-Name js-folders-item-name' and text()='" + mailSection + "']")).click();
    }

    public void folderSelection(String folderSelection){
        driver.findElement(By.xpath("//*[@data-params='source=toolbar' and @title='В папку (m)']")).click();
        String parentWindowHandler = driver.getWindowHandle();
        String subWindowHandler = null;
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()){
            subWindowHandler = iterator.next();
        }
        driver.switchTo().window(subWindowHandler); // switch to pop up с списком папок
        driver.findElement(By.xpath("//*[@class='b-folders__folder__link js-action' and @title='"+folderSelection+"']")).click();
        driver.switchTo().window(parentWindowHandler);
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

    public void logOut(){
        driver.findElement(By.xpath("//*[@data-statlog='login.exit']")).click();
    }

}
