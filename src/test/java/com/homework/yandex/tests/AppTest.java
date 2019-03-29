package com.homework.yandex.tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class AppTest {
    private WebDriver driver = null;
    private ChromeOptions options = null;
    private WebElement element = null;


    @BeforeClass
    public void initData() {
        System.setProperty("webdriver.chrome.driver",
                "lib/chromedriver.exe");
        options = new ChromeOptions();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test()
    public void testCreateForm() throws InterruptedException {
        driver.navigate().to("https://ya.ru");
        driver.findElement(By.xpath("//div[@class='b-inline']")).click();
        driver.findElement(By.xpath("//*[@data-reactid='24']")).click();
        driver.findElement(By.id("passp-field-login")).sendKeys("89023930349");
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
        driver.findElement(By.id("passp-field-passwd")).sendKeys("757414bagaev");
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        driver.getCurrentUrl().equals("https://mail.yandex.ru/?uid=566972531#inbox");
        Thread.sleep(10000);

    }

    @AfterClass
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}

