package tests.repeatWAA;

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

public class FellowshipTest {
    private WebDriver driver;
    private String BASE_URL = "http://localhost:8888";

    @Before
    //urcim si driver a ovtorim stranku
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
        driver.get(BASE_URL + "/fellowship.php");
    }

    @Test
    //najdem vsetky DIV elementy ktore reprezentuju jednotlivych "fellows" a ulozim ich do listu
    public void allDivElementsFellows() {
        List<WebElement> fellows = driver.findElements(By.cssSelector("UL.row.list-of-fellows li"));
        //ramci listu iterujem a pre kazdeho fellow hladam element ktory reprezentuje jeho meno
        for (WebElement fellow : fellows) {
            Assert.assertFalse(fellow.findElement(By.cssSelector("h1")).getText().isEmpty());
            System.out.println(fellow.getText());
        }

    }
    @Test
    public void itShouldContainNameForEachFellow() {
        List<WebElement> fellows = driver.findElements(By.cssSelector("UL.row.list-of-fellows li"));
        for (WebElement fellow : fellows) {
        Assert.assertFalse(fellow.findElement(By.cssSelector("h1")).getText().isEmpty());
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
    @After
    public void tearDown() {
        //ukoncit session
        driver.quit();
    }
}




