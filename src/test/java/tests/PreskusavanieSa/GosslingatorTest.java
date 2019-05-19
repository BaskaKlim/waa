package tests.PreskusavanieSa;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GosslingatorTest {
    @Test

    public void itShouldAddOneRyan() {
        //System.setProperty
        System.setProperty("webdriver.chrome.driver", "chromedriver");

        // 0. spustit prehliadac
        WebDriver driver = new ChromeDriver();
        //1.otvorit stranku
        driver.get("http://localhost:8888/gosslingator.php");
        //2.kliknut na tlacidlo pridat - driver najde element pomocou id a potom . a akcia co s tym elementom
        driver.findElement(By.id("addRyan")).click();
        // 2.B najdi element pomocou css Selector Assert.assertEquals("1", driver.findElement(By.cssSelector("div.ryan-counter h2")).getText());
        //3.overit pocitanie ryanov - cez prikaz assert assert Equals do zatvoriek ocakavanu hodnotu, ciarka a cesta k tomu ako driver najde element ryan Cpinder a vezme z neho aktualny text /cislo
        Assert.assertEquals("1", driver.findElement(By.id("ryanCounter")).getText());
        //4.zatvorit prehliadac
        driver.close();
        //5.ukoncit session
        driver.quit();

    }

    @Test
    public void itShouldAddTwoRyans() {
        //System.setProperty
        System.setProperty("webdriver.chrome.driver", "chromedriver");

        // 0. spustit prehliadac
        WebDriver driver = new ChromeDriver();
        //1.otvorit stranku
        driver.get("http://localhost:8888/gosslingator.php");
        //2. najdi tlacitko pridaj Ryana  cez id a stlač dva krat
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        // najdi tlacidlo pridaj Ryana cez css selector
        // vypisem si do console aktualny pocet z pocitadla ryanov driver.findElement(By.cssSelector("div.ryan-counter h2")).getText());
        System.out.println("Number of ryans: " + driver.findElement(By.cssSelector("div.ryan-counter h2")).getText());
        //3.overit pocitanie ryanov
        Assert.assertEquals("2", driver.findElement(By.id("ryanCounter")).getText());
        // over pocitanie ryanov cez css selector Assert.assertEquals("ryan", driver.findElement(By.cssSelector("div.ryan-counter h3")).getText());
        //4.zatvorit prehliadac
        driver.close();
        //5.ukoncit session
        driver.quit();

    }


}
