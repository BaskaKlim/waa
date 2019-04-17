package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GosslingatorTest {

    @Test

    public void itShouldAddOneRyan () {
        System.setProperty("webdriver.chrome.driver","chromedriver");

        // 0. spustit prehliadac
        WebDriver driver = new ChromeDriver();
        // 1. otvorit stranku
        driver.get("http://localhost:8888/gosslingator.php");
        // 2. n￿ájdi, potom kliknut na tlacidlo Ryon!
        driver.findElement(By.id("addRyan")).click();
        // 3. najdi, citaj text, overit pocitanie Ryanov
        Assert.assertEquals ( "1", driver.findElement(By.id("ryanCounter")).getText());
        //4. zatvorit prehliadac
        driver.close();
        //.5. ukoncit session
        driver.quit();
    }

    @Test

    public void itShouldAddOneRyan2 () {
        System.setProperty("webdriver.chrome.driver","chromedriver");

        // 0. spustit prehliadac
        WebDriver driver = new ChromeDriver();
        // 1. otvorit stranku
        driver.get("http://localhost:8888/gosslingator.php");
        // 2. n￿ájdi, potom kliknut na tlacidlo Ryon!
        driver.findElement(By.id("addRyan")).click();
        // 3. najdi, citaj text, overit pocitanie Ryanov
        Assert.assertEquals ( "1", driver.findElement(By.id("ryanCounter")).getText());
        //4. zatvorit prehliadac
        driver.close();
        //.5. ukoncit session
        driver.quit();
    }

}
