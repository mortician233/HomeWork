package com.homework.yandex.tests;


import com.homework.yandex.Utils.TestBase;
import org.testng.annotations.Test;

public class Tests extends TestBase {

    @Test()
    public void testSendingLetter() {
        app.getStartPage("https://ya.ru/");
        app.logIn("89023930349", "757414bagaev");
        app.getLetterHelper().sendingLetter("mortician234@gmail.com", "TestTest","Привет, я сам себя отправил");
        app.tearDown();
    }

    @Test(dependsOnMethods = "testSendingLetter")
    public void testDeletingLetter(){
        app.initData();
        app.getStartPage("https://ya.ru/");
        app.logIn("89023930349", "757414bagaev");
        app.getLetterHelper().deletingLetter();
        app.tearDown();
    }

    @Test(dependsOnMethods = "testDeletingLetter")
    public void testMovingLetter(){
        app.initData();
        app.getStartPage("https://ya.ru/");
        app.logIn("89023930349", "757414bagaev");
        app.getLetterHelper().movingLetter();
        app.tearDown();
    }
}