package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class PokemonTest {
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        // 0. spustit prehliadac
        driver = new ChromeDriver();
        // 1. otvorit stranku
        driver.get("http://localhost:8888/vybersi.php");
    }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }

    @Test
    public void itShouldSelectPokemons() {
        String selectedPokemon = "Pikachu";
        String[] selectedPokemons = {"Pikachu", "Bulbasaur", "Charmander", "Diglett", "Geodude", "Squirtle"};
        //najdem element select
        WebElement pokemonSelect = driver.findElement(By.cssSelector("select"));

        for (String pokemon : selectedPokemons) {
            //vyberiem pokemona
            new Select(pokemonSelect).selectByVisibleText(selectedPokemon);
            //overim hlasku
            String actualMessage = driver.findElement(By.cssSelector("div.pokemon h3")).getText();
            String expectedMessage = "I choose you " + pokemon + " !";
            String expectedMessagesByFormat = String.format("I choose you %s !", pokemon);
            Assert.assertEquals(expectedMessage, actualMessage);
        }


    }
}