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
    //testujte po otvoreni stranky ze ani jedna moznost nie je vybrata

    @Test
    public void NoOptionIsSeleced() {
        Assert.assertFalse(driver.findElement(By.xpath("//input[@value='wurst']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//label[text()='Zena']/input")).isSelected());
    }

    @Test
    //otestujte ze po zakliknuti `muz` sa zobrazi hlaska It’s wurst
    public void itShouldBeWurts(){
        driver.findElement(By.xpath("//input[@value='wurst']")).click();
        Assert.assertEquals("It's wurst",driver.findElement(By.cssSelector("h1.description.text-center")).getText());
    }

    @Test
    //zadelene premenne
    public void itShouldSelectMale() {
        driver.findElement(By.xpath("//input[@value='wurst']")).click();
        //overit hlasku
        String expectedMessage = "It's wurst";
        String actualMessage = driver.findElement(By.cssSelector("h1.description")).getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    //otestujte ze po zakliknuti `muz` nie je moznost zena vybrata
    public void itShoudlntBeWomen(){
        driver.findElement(By.xpath("//input[@value='wurst']")).click();
        Assert.assertFalse(driver.findElement(By.xpath("//label[text()='Zena']/input")).isSelected());
    }

    //otestujte ze obrazok na stranke je zobrazeny
    @Test
    public void imgShoudlBeDisplayed(){
        Assert.assertTrue(driver.findElement(By.cssSelector("img")).isDisplayed());
    }


    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}

