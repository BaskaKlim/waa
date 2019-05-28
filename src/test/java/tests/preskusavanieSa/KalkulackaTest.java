package tests.preskusavanieSa;

import base.TestBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

// mam svoju klasu ktora vyuziva testbase
public class KalkulackaTest extends TestBase {

    // otvorim si stranku - konkretnu zalozku
    @Before
    public void openPage() {
        driver.get(BASE_URL + "/kalkulacka.php");
    }

    @Test
    // spocitavanie
    public void itShouldAddTwoNummbers() {
        // najdi element - textove pole a vloz do elementu cislo

        driver.findElement(By.id("firstInput")).sendKeys("1");
        // najdi druhy element - textove pole a vloz do elementu cislo
        driver.findElement(By.id("secondInput")).sendKeys("2");
        // najdi button spocitaj a klikni nanho
        driver.findElement(By.id("count")).click();
        // over vysledok
        driver.findElement(By.cssSelector("ul.latest-results li")).getText();
        Assert.assertEquals("1+2 = 3", driver.findElement(By.cssSelector("ul.latest-results li")).getText());

    }

    @Test
    // odcitanie
    public void itShoulDeductTwoNummbers() {
        // najdi element - textove pole a vloz do elementu cislo

        driver.findElement(By.id("firstInput")).sendKeys("1");
        // najdi druhy element - textove pole a vloz do elementu cislo
        driver.findElement(By.id("secondInput")).sendKeys("2");
        // najdi button spocitaj a klikni nanho
        driver.findElement(By.id("deduct")).click();
        // over vysledok
        driver.findElement(By.cssSelector("ul.latest-results li")).getText();
        Assert.assertEquals("1-2 = -1", driver.findElement(By.cssSelector("ul.latest-results li")).getText());

    }
}
