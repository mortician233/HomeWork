package com.homework.yandex.Utils;


import com.homework.yandex.Pages.LetterHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ApplicationManager {
    private final LetterHelper letterHelper = new LetterHelper();
    String baseUrl;

    public void initData() {
        System.setProperty("webdriver.chrome.driver",
                "lib/chromedriver.exe");
        letterHelper.driver = new ChromeDriver();
        letterHelper.driver.manage().window().maximize();
        baseUrl = "https://ya.ru/";
    }

    public void getStartPage(String baseUrl) {
        letterHelper.driver.get(baseUrl);
    }

    public void logIn(String login, String password) {
        letterHelper.click(By.xpath("//div[@class='b-inline']"));
        letterHelper.waitLoad(8);
        letterHelper.click(By.xpath("//*[@data-reactid='24']"));
        letterHelper.waitLoad(8);
        letterHelper.driver.findElement(By.id("passp-field-login")).sendKeys(login);
        letterHelper.click(By.xpath("//*[@type='submit']"));
        letterHelper.waitLoad(8);
        letterHelper.checkEnableElement(By.xpath("//*[@class= 'passp-current-account__display-name' and text()='89023930349']"));
        letterHelper.driver.findElement(By.id("passp-field-passwd")).sendKeys(password);
        letterHelper.click(By.xpath("//*[@type='submit']"));
        letterHelper.waitLoad(8);
        letterHelper.checkEnableElement(By.xpath("//*[@class= 'mail-User-Name' and text()='mortician233']"));
        letterHelper.driver.getCurrentUrl().equals("https://mail.yandex.ru/?uid=566972531#inbox");
    }

    public LetterHelper getLetterHelper() {
        return letterHelper;
    }

    public void shouldHaveText(By locator, String text){
        $(locator).shouldHave(text(text));
    }


    public void tearDown() {
        if (letterHelper.driver != null) letterHelper.driver.quit();
    }
}

