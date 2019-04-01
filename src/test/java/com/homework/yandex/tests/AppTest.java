package com.homework.yandex.tests;


import com.homework.yandex.Utils.TestBase;
import org.testng.annotations.Test;


public class AppTest extends TestBase {

    @Test()
    public void testCreateForm() {
        app.getStartPage("https://ya.ru/");
        app.logIn("89023930349", "757414bagaev");
        app.getLetterHelper().sendingLetter("mortician234@gmail.com", "757414bagaev");
    }
}

