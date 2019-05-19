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
        // cez ID Assert.assertEquals("1", driver.findElement(By.id("ryanCounter")).getText()); //
        Assert.assertEquals("1", driver.findElement(By.cssSelector("div.ryan-counter h2")).getText());
        // 4. overovanie sklonovania ryanov vypisem si do console aktualny pocet z pocitadla ryanov
        System.out.println("Number of ryans: " + driver.findElement(By.cssSelector("div.ryan-counter h2")).getText());
        Assert.assertEquals("ryan", driver.findElement(By.cssSelector("div.ryan-counter h3")).getText());
        //5.zatvorit prehliadac
        driver.close();
        //6.ukoncit session
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
        // najdi tlacidlo pridaj Ryana cez css selector  Assert.assertEquals("1", driver.findElement(By.cssSelector("div.ryan-counter h2")).getText());
        // vypisem si do console aktualny pocet z pocitadla ryanov driver.findElement(By.cssSelector("div.ryan-counter h2")).getText());
        System.out.println("Number of ryans: " + driver.findElement(By.cssSelector("div.ryan-counter h2")).getText());

        //3.overit pocitanie ryanov cez ID Assert.assertEquals("2", driver.findElement(By.id("ryanCounter")).getText()); over cez css
        Assert.assertEquals("2", driver.findElement(By.id("ryanCounter")).getText());
        // 4. over sklonovanie ryanov
        Assert.assertEquals("ryans", driver.findElement(By.cssSelector("div.ryan-counter h3")).getText());

        //5.zatvorit prehliadac
        driver.close();
        //6.ukoncit session
        driver.quit();

    }

    @Test
    public void itShouldDisplayTitle() {
        //System.setProperty
        System.setProperty("webdriver.chrome.driver", "chromedriver");

        // 0. spustit prehliadac
        WebDriver driver = new ChromeDriver();
        //1.otvorit stranku
        driver.get("http://localhost:8888/gosslingator.php");
        // 2. najde mi dany title cez css selector a vezme z neho text
        System.out.println(driver.findElement(By.cssSelector(".ryan-title")).getText());
        //3. porovna ocoakavany text - hlasku Goslingate me s tym, co realne zobrazuje hlaska
        Assert.assertEquals("GOSLINGATE ME", driver.findElement(By.cssSelector(".ryan-title")).getText());
        //4.zatvorit prehliadac
        driver.close();
        //5.ukoncit session
        driver.quit();
    }


    @Test
    public void itShouldDisplayWarningMessage() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        //0.spustit prehliadac
        WebDriver driver = new ChromeDriver();

        //1.otvorit stranku
        driver.get("http://localhost:8888/gosslingator.php");
        //toto raz bude for cyklus
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();

        Assert.assertEquals(
                "NUMBER OF\n" +
                        "RYANS\n" +
                        "IS TOO DAMN\n" +
                        "HIGH",
                driver.findElement(By.cssSelector("h1.tooManyRyans")).getText()
        );
        //4.zatvorit prehliadac
        driver.close();
        //5.ukoncit session
        driver.quit();
        //CTRL+D
    }
}

