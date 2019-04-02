package com.homework.yandex.tests;

import com.homework.yandex.Utils.TestBase;
import org.testng.annotations.Test;

public class MovingLetter extends TestBase {
    @Test()
    public void testMovingLetter(){
        app.getStartPage("https://ya.ru/");
        app.logIn("89023930349", "757414bagaev");
    }

}
