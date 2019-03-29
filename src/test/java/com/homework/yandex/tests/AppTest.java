package com.homework.yandex.tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


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
    public void testCreateForm() {
        driver.navigate().to("https://ya.ru");
        driver.findElement(By.xpath("//div[@class='b-inline']")).click();
        driver.findElement(By.xpath("//*[@data-reactid='24']")).click();
        WebElement elementTel = element.findElement(By.name("login"));
        elementTel.click();
        elementTel.sendKeys("89023930349");
        elementTel.submit();
        WebElement elementPas = element.findElement(By.name("passwd"));
        elementPas.click();
        elementPas.sendKeys("757414bagaev");
        elementPas.submit();
        driver.getCurrentUrl().equals("https://mail.yandex.ru/?uid=566972531#inbox");


    }

    @AfterClass
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}

