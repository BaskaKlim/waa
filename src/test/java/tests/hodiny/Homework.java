package tests.hodiny;

import base.TestBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework extends TestBase {

    @Before
    public void openPage() {
        driver.get(BASE_URL + "/kalkulacka.php");
    }
    @Test

    public void itShouldOppenKalkulacka () {
        System.setProperty("webdriver.chrome.driver","chromedriver");

        // 0. spustit prehliadac
        WebDriver driver = new ChromeDriver();
        // 1. otvorit stranku
        driver.get("http://localhost:8888/kalkulacka.php");
        //2. zatvorit prehliadac
        driver.close();
        //.3. ukoncit session
        driver.quit();
    }


}