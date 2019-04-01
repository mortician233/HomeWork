package com.homework.yandex.Pages;

import com.homework.yandex.Utils.ApplicationTest;
import com.homework.yandex.Utils.MailData;
import org.openqa.selenium.By;

public class Letter extends ApplicationTest {

    public void sendingLetter(MailData mailData) {
        driver.findElement(By.xpath("//*[@class='mail-ComposeButton-Text']")).click();
        driver.findElement(By.xpath("//*[@name='to']")).sendKeys(mailData.getMailSending());
        driver.findElement(By.xpath("//*[@name='subj-892b1db8d4e43159507f60faabd3c2e7cbde85cd']")).sendKeys(mailData.getTopicLetter());
        driver.findElement(By.xpath("//*[@title='Отправить письмо (Ctrl + Enter)' and @id='nb-16']")).click();
    }

}