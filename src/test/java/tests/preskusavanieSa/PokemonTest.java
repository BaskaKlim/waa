package tests.preskusavanieSa;

import base.TestBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PokemonTest extends TestBase {

    @Before
    public void openPage() {
        driver.get(BASE_URL + "/vybersi.php");
    }


    @Test
    public void itShouldSelectPokemons() {
        // zadefinujem si premmenu pole s moznostami
        String[] selectedPokemons = {"Pikachu", "Bulbasaur", "Charmander", "Diglett", "Geodude"};

        // cyklus for a podmienky
        // pre premennu pokemon z mojho definovaneho pola pokemonov

        for (String pokemon : selectedPokemons) {
            //vyberiem pokemona  cez metodu co si zavolam
            selectPokemon(pokemon);
            //overim hlasku
            // zadefinuj si premennu aktualna hlaska, najdi ju a vloz do nej hodnotu
            String actualMessage = getActualMessage();
            // zadefinuj si ocakavanu hlasku
            String expectedMessage = "I choose you " + pokemon + " !";
            String expectedMessageByFormat = getExpectedlMessage(pokemon);
            //porovnaj
            Assert.assertEquals(expectedMessageByFormat, actualMessage);
        }
    }

    private void selectPokemon(String pokemonToSelect) {
        // najprv najst tento element
        WebElement pokemonSelect = driver.findElement(By.cssSelector("select"));
        // vyber  element podla pokemona
        new Select(pokemonSelect).selectByVisibleText(pokemonToSelect);
    }

    private String getActualMessage() {
        return driver.findElement(By.cssSelector("div.pokemon h3")).getText();
    }

    private String getExpectedlMessage(String pokemonName) {
        // metoda mi vrati ocakavanu hlasku "I choose you {{pokemon}}!
        return String.format("I choose you %s !", pokemonName);
    }
}
