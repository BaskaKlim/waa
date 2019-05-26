package tests.preskusavanieSa;

import base.TestBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.PokemonPage;

public class PokemonTest extends TestBase {
    private PokemonPage pokemonPage;

    @Before
    public void openPage() {
        driver.get(BASE_URL + "/vybersi.php");
        pokemonPage = new PokemonPage(driver);
    }


    @Test
    public void itShouldSelectPokemons() {
        // zadefinujem si premmenu pole s moznostami
        String[] selectedPokemons = {"Pikachu", "Bulbasaur", "Charmander", "Diglett", "Geodude"};

        // cyklus for a podmienky
        // pre premennu pokemon z mojho definovaneho pola pokemonov

        for (String pokemon : selectedPokemons) {
            //vyberiem pokemona  cez metodu co si zavolam
            pokemonPage.selectPokemon(pokemon);
            //overim hlasku
            //porovnaj
            Assert.assertEquals(getExpectedMessage(pokemon), pokemonPage.getActualMessage());
        }
    }

    private String getExpectedMessage(String pokemonName) {
        return String.format("I choose you %s !", pokemonName);
    }
}
