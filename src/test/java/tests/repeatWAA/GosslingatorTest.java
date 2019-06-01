package tests.repeatWAA;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GosslingatorTest {
    private WebDriver driver;
    private String BASE_URL = "http://localhost:8888";

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
        driver.get(BASE_URL + "/gosslingator.php");
    }


    @Test
    public void itShoudlAddOneRyan() {

        driver.findElement(By.id("addRyan")).click();
        Assert.assertEquals("1", driver.findElement(By.id("ryanCounter")).getText());
    }


    @Test
    public void itShoudlAddTwoRyans() {
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        Assert.assertEquals("2", driver.findElement(By.id("ryanCounter")).getText());

    }

    @After
    public void tearDown() {
        //ukoncit session
        driver.quit();
    }
}



