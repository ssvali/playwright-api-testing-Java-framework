package tests;

import org.example.core.PlaywrightFactory;
import org.testng.annotations.AfterSuite;

public class BaseTest {

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        PlaywrightFactory.close();
    }
}
