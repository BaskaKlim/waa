package tests.PreskusavanieSa;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FellowshipTest {

    //pridany test pre overenie mien jednotlivych fellows z ringu

    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        //0.spustit prehliadac
        driver = new ChromeDriver();
        //1.otvorit stranku
        driver.get("http://localhost:8888/fellowship.php");
    }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }

    @Test
    public void
    itShouldContainNameForEachFellow() {
        // definujem si list elementov, ktory najdem podla css seleczora
        List<WebElement> fellowElements = driver.findElements(By.cssSelector("ul.list-of-fellows li"));
        // podmienka: pre kazdy element z tohto zoznamu
        for (WebElement fellowElement : fellowElements) {
            Assert.assertFalse(fellowElement.findElement(By.cssSelector("h1")).getText().isEmpty());
        }
    }

    @Test
    public void itShouldContainSpecifiedFellows() {
        //najdem si zoznam elementov (kachliciek)
        List<WebElement> fellowElements = driver.findElements(By.cssSelector("ul.list-of-fellows li"));
        //predpripravim si zoznam stringov do ktoreho si ulozim jednotlive mena
        List<String> fellowNames = new ArrayList<String>();

        //prejdem zoznam elementov, kachliciek
        for (WebElement fellowElement : fellowElements) {
            System.out.println(fellowElement.findElement(By.cssSelector("h1")).getText());
            //v ramci kazdej kachlicky si najdem meno a to ulozim do zoznamu mien
            fellowNames.add(fellowElement.findElement(By.cssSelector("h1")).getText());
        }
        System.out.println(fellowNames);
        //over ze list obsahuje Gandalf-a, a Aragorn-a
        Assert.assertTrue(fellowNames.contains("Gandalf"));
        Assert.assertTrue(fellowNames.contains("Aragorn"));
        Assert.assertTrue(fellowNames.contains("Frodo"));
    }
}