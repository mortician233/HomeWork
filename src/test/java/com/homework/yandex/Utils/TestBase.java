package com.homework.yandex.Utils;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {
    protected final ApplicationManager app = new ApplicationManager();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        app.initData();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        app.tearDown();
    }
}

