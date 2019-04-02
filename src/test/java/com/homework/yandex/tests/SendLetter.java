package com.homework.yandex.tests;


import com.homework.yandex.Utils.TestBase;
import org.testng.annotations.Test;


public class SendLetter extends TestBase {

    @Test()
    public void testSendingLetter() {
        app.getStartPage("https://ya.ru/");
        app.logIn("89023930349", "757414bagaev");
        app.getLetterHelper().sendingLetter("mortician234@gmail.com", "Autotest");
    }
}

