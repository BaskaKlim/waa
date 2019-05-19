package tests.PreskusavanieSa;

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
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        //0.spustit prehliadac
        driver = new ChromeDriver();
        //1.otvorit stranku
        driver.get("http://localhost:8888/vybersi.php");
    }
    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }

    @Test
    public void itShouldSelectPokemons() {
        // zadefinujem si premmenu pole s moznostami
        String[] selectedPokemons = {"Pikachu", "Bulbasaur", "Charmander", "Diglett", "Geodude"};

        //najdem element select
        WebElement pokemonSelect = driver.findElement(By.cssSelector("select"));

        // cyklus for a podmienky
        // pre premennu pokemon z mojho definovaneho pola pokemonov

        for (String pokemon : selectedPokemons) {
         //vyberiem pokemona
            new Select(pokemonSelect).selectByVisibleText(pokemon);
        //overim hlasku
            // zadefinuj si premennu aktualna hlaska, najdi ju a vloz do nej hodnotu
            String actualMessage = driver.findElement(By.cssSelector("div.pokemon h3")).getText();
            // zadefinuj si ocakavanu hlasku
            String expectedMessage = "I choose you " + pokemon + " !";
            String expectedMessageByFormat = String.format("I choose you %s !", pokemon);
            //porovnaj
            Assert.assertEquals(expectedMessageByFormat, actualMessage);
        }
    }
}
