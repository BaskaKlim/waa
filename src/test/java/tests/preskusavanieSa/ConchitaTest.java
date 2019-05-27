package tests.preskusavanieSa;

import base.TestBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.ConchitaPage;

public class ConchitaTest extends TestBase {
    ConchitaPage conchitaPage;


    @Before
    public void openUp () {

        driver.get(BASE_URL + "/zenaalebomuz.php");
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
        conchitaPage = new ConchitaPage(driver);
        conchitaPage.selectWurst();
        // najdi element hlasky a over ze sa zobrazi It￿'s wurst- teda ze ocakavana hlaska, true
       // prvy sposob: Assert.assertTrue( "It's wurst", true);

        //overit hlasku druhy sposob cez premenne
        String expectedMessage = "It's wurst";
        String actualMessage = driver.findElement(By.cssSelector("h1.description")).getText();
        Assert.assertEquals(expectedMessage, actualMessage);


        //   otestujte ze po zakliknuti `muz` nie je moznost zena vybrata
        Assert.assertFalse(driver.findElement(By.xpath("//label[text()='Zena']/input")).isSelected());
    }

    @Test
        public void ItShouldImageIsDisplayed (){

            Assert.assertTrue(driver.findElement(By.cssSelector("img")).isDisplayed());

        }
    }
    //   - otestujte ze obrazok na stranke je zobrazeny








        //   indicie: pouzite metody `Assert.assertFalse()` a metodu `.isSelected()'`


