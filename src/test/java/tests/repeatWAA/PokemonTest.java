package tests.repeatWAA;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PokemonTest {

    private WebDriver driver;
    private String BASE_URL = "http://localhost:8888";

    @Before
    //urcim si driver a ovtorim stranku
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
        driver.get(BASE_URL + "/vybersi.php");
    }


    @Test
    public void itShouldSelectPokemons() {
        //foreach a vyberanie z comboboxu
        // urcim si pole String [] ktore obsahuje dane moznosti
        String[] selectedPokemons = {"Pikachu", "Bulbasaur", "Charmander", "Diglett", "Geodude"};
        //najdem element select
        WebElement pokemonSelect = driver.findElement(By.cssSelector("select"));
        // vyberiem pokemona z moznosti
        for (String pokemon : selectedPokemons) {
            //vyberiem pokemona
            new Select(pokemonSelect).selectByVisibleText(pokemon);
            //overim hlasku
            String actualMessage = driver.findElement(By.cssSelector("div.pokemon h3")).getText();
            String expectedMessage = "I choose you " + pokemon + " !";
            String expectedMessageByFormat = String.format("I choose you %s !", pokemon);
            Assert.assertEquals(expectedMessageByFormat, actualMessage);
        }
    }

    @After
    public void tearDown() {
        //ukoncit session
        driver.quit();
    }
}
