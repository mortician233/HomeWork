package com.homework.yandex.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver driver;
    String baseUrl;

    @BeforeClass
    public void initData() {
        System.setProperty("webdriver.chrome.driver",
                "lib/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        baseUrl = "https://ya.ru/";
    }


    @Test()
    public void testCreateForm() {
        getStartPage(baseUrl);
        logIn("89023930349", "757414bagaev");
        sendingLetter("mortician234@gmail.com", "757414bagaev");
    }

    public void getStartPage(String baseUrl) {
        driver.get(baseUrl);
    }

    public void sendingLetter(String mailSending, String topicLetter) {
        click(By.xpath("//*[@class='mail-ComposeButton-Text']"));
        driver.findElement(By.xpath("//*[@name='to']")).sendKeys(mailSending);
        driver.findElement(By.xpath("//*[@name='subj-892b1db8d4e43159507f60faabd3c2e7cbde85cd']")).sendKeys(topicLetter);
        click(By.xpath("//*[@title='Отправить письмо (Ctrl + Enter)' and @id='nb-16']"));
    }

    public void getUrl(String url) {
        getStartPage(url);
    }

    public void logIn(String login, String password) {
        click(By.xpath("//div[@class='b-inline']"));
        click(By.xpath("//*[@data-reactid='24']"));
        driver.findElement(By.id("passp-field-login")).sendKeys(login);
        click(By.xpath("//*[@type='submit']"));
        waitLoad(6);
        driver.findElement(By.id("passp-field-passwd")).sendKeys(password);
        click(By.xpath("//*[@type='submit']"));
        waitLoad(6);
        driver.getCurrentUrl().equals("https://mail.yandex.ru/?uid=566972531#inbox");
    }

    public void waitLoad(int waitSeconds) {
        driver.manage().timeouts().implicitlyWait(waitSeconds, TimeUnit.SECONDS);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }


    @AfterClass
    public void tearDown() {
        if (driver != null) driver.quit();
    }

}

