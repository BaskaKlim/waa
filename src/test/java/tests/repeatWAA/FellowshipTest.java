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

import static org.openqa.selenium.By.className;

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

    //si vyberte oblubeny tim a vyklikajte ho - overte ze v casti kde su body sa zobrazi napis `Complete`

    @Test
    public void myFavouriteTeamisComplete() {
        // utvorim si list, je to list tringov

        List<String> myFavouriteTeam = new ArrayList<String>();
        // priradim si k elementom hodnoty
        myFavouriteTeam.add("Gandalf");
        myFavouriteTeam.add("Frodo");
        myFavouriteTeam.add("Legolas");
        myFavouriteTeam.add("Aragorn");

        //pridam podmienku ze pre kazdy z elemnt z mojho listu vykonaj

        for (String fellow : myFavouriteTeam) {
            // klikni na kazdy element obsahujuci H1 nadpisy a obsahujuci text z mojho listu
            driver.findElement(By.xpath("//div/h1[contains(text(),'" + fellow + "')]")).click();
        }
        Assert.assertEquals("Complete", driver.findElement(By.cssSelector("div h3")).getText());
    }

    @Test
    public void inicialnyPocetJe25() {
        // utvorim si list, je to list tringov

            String inicialnyPocet = driver.findElement(By.cssSelector("div.points-left h2")).getText();
            Assert.assertTrue(inicialnyPocet.contains("25"));
        }




    @After
    public void tearDown() {
        //ukoncit session
        driver.quit();
    }
}




