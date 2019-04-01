package com.homework.yandex.tests;


import com.homework.yandex.Pages.Letter;
import com.homework.yandex.Utils.ApplicationTest;
import com.homework.yandex.Utils.LogInData;
import com.homework.yandex.Utils.MailData;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class AppTest extends ApplicationTest {

    @BeforeClass
    public void initData() {
        System.setProperty("webdriver.chrome.driver",
                "lib/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @Test()
    public void testCreateForm() {
        getUrl("https://ya.ru/");
        logIn(new LogInData("89023930349", "757414bagaev"));
        new Letter().sendingLetter(new MailData("mortician233@gmail.com", "Autotest"));

    }


    @AfterClass
    public void tearDown() {
        if (driver != null) driver.quit();
    }

}

