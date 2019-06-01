package tests.repeatWAA;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathTrainingTest {

    private WebDriver driver;
    private String BASE_URL = "http://localhost:8888";


    @Before

    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
        driver.get(BASE_URL + "/xpathtrainingcenter.php");
    }


    @Test
    public void itShouldDisplayAction() {
        //1. klikni na element second button
        driver.findElement(By.xpath("//button[contains(.,'Second button')]")).click();
        //2. over hlasku, ktora sa zobrazi v you clicked:
        Assert.assertEquals("you clicked second button", driver.findElement(By.xpath("//h2/span")).getText());
    }

    @After
    public void tearDown() {
        //ukoncit session
        driver.quit();
    }
}




