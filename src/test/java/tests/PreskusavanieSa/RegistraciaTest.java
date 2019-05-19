package tests.PreskusavanieSa;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistraciaTest {
    // zadefinujem si webdriver ktory je driver
    WebDriver driver;

    // zadefinujem si co sa stane pred spustenim kazdeho testu v tejto triede
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        //0.spustit prehliadac
        driver = new ChromeDriver();
        //1.otvorit stranku
        driver.get("http://localhost:8888/registracia.php");
    }

    // uadefinujem si co sa stane na konci kazdeho testu v tejto triedeł
    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }

    @Test
    public void itShouldRegisterValidUser() {
        // zadefinujem si prememnne, ktore budem vkladat do textovych poli
        String email = "baska@klimek.sk";
        String meno = "baska";
        String priezvisko = "klimek";
        String heslo = "123456";
        // najdem jednotlive textove polia a vpisem hodnotu zadefinovanej premennej, pozor heslo vpisujem 2x rovnake
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("name")).sendKeys(meno);
        driver.findElement(By.name("surname")).sendKeys(priezvisko);
        driver.findElement(By.name("password")).sendKeys(heslo);
        driver.findElement(By.name("password-repeat")).sendKeys(heslo);
        // najdem a zaskttnem checkbox som robot
        driver.findElement(By.name("robot")).click();
        // najem a kliknem na button registruj sa
        driver.findElement(By.cssSelector("button.btn-success")).click();
        //najdem hlasku a overim hlasku - ked je to uspesne alebo neuspesne tak assert assert true / false cize v kode bude ze porovnaj ci zobrazi tuto hlasku
        Assert.assertTrue(driver.findElement(By.cssSelector("div.alert-success")).isDisplayed());
    }

    @Test
    public void itShouldDisplayErrorMessageWhenInputsAreEmpty(){
        //nevyplnim ziadne pole
        //kliknut na checkbox som robot
        driver.findElement(By.name("robot")).click();
        //kliknut na tlacidlo registrovat sa
        driver.findElement(By.cssSelector("button.btn-success")).click();
        //overit uspesnu hlasku
        Assert.assertTrue(driver.findElement(By.cssSelector("div.alert-danger")).isDisplayed());
    }
}




