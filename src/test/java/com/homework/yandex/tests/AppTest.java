package com.homework.yandex.tests;


import com.homework.yandex.Pages.LogIn;
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
        getUrl("");
        new LogIn("89023930349", "757414bagaev");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}

