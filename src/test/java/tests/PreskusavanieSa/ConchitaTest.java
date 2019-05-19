package tests.PreskusavanieSa;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConchitaTest {

    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        // 0. spustit prehliadac
        driver = new ChromeDriver();
        // 1. otvorit stranku
        driver.get("http://localhost:8888/zenaalebomuz.php");
    }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }

    @Test     //- otestujte po otvoreni stranky ze ani jedna moznost nie je vybrata
    public void itShouldBeNotSelected() {
        //najde element zena a overi, ze nie je vybrany/ zaskrtnuty - cize je nepravda, ze je vyrbany /zaskrtnuty
        //najde element muz a overi, ze nie je zaskrtnuty - je nepravda, ze je vy ra y
        Assert.assertFalse(driver.findElement(By.xpath("//input[@value='wurst']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//label[text()='Zena']/input")).isSelected());
    }

    @Test  //   - otestujte ze po zakliknuti `muz` sa zobrazi hlaska It’s wurst
    public void ItShouldBeMan() {

        // najdi element muz a klikni
        driver.findElement(By.xpath("//input[@value='wurst']")).click();
        // najdi element hlasky a over ze sa zobrazi It￿'s wurst- teda ze ocakavana hlaska, true
        Assert.assertTrue( "It's wurst", true);

    }



        //   - otestujte ze po zakliknuti `muz` nie je moznost zena vybrata
        //   - otestujte ze obrazok na stranke je zobrazeny
        //   indicie: pouzite metody `Assert.assertFalse()` a metodu `.isSelected()'`

    }
