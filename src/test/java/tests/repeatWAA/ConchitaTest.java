package tests.repeatWAA;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConchitaTest {
    //otestujte po otvoreni stranky ze ani jedna moznost nie je vybrata

    WebDriver driver;
    String BASE_URL = "http://localhost:8888";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chore.driver", "chromedriver");
        driver = new ChromeDriver();
        driver.get(BASE_URL + "/zenaalebomuz.php");
    }

    @Test
    public void NoOptionIsSeleced() {
        Assert.assertFalse(driver.findElement(By.xpath("//input[@value='wurst']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//label[text()='Zena']/input")).isSelected());
    }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}

