package tests.repeatWAA;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GosslingatorTest {


    @Test
    public void itShoudlAddOneRyan() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        //0.spustit prehliadac
        WebDriver driver = new ChromeDriver();
        //1.otvorit stranku
        driver.get("http://localhost:8888/gosslingator.php");
        driver.findElement(By.id("addRyan")).click();
        Assert.assertEquals("1", driver.findElement(By.id("ryanCounter")).getText());
        driver.close();
        //ukoncit session
        driver.quit();
    }

}



