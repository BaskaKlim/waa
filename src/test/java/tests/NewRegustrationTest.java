package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

public class NewRegustrationTest {
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        // 0. spustit prehliadac
        driver = new ChromeDriver();
        // 1. otvorit stranku
        driver.get("http://localhost:8888/registracia.php");
    }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }

    @Test
    public void itShoulRegisterValidUser() {
        String email = "baska@gmail.com";
        String meno = "baska";
        String priezvisko = "mojseova";
        String heslo = "111111";

        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("name")).sendKeys(meno);
        driver.findElement(By.name("surname")).sendKeys(priezvisko);
        driver.findElement(By.name("password")).sendKeys(heslo);
        driver.findElement(By.name("password-repeat")).sendKeys(heslo);

// kliknut na checkbox som robot
        driver.findElement(By.name("robot")).click();
        // kliknut na tlacidlo registrovat
        driver.findElement(By.cssSelector("button.btn-success")).click();
        // overit uspesnu hlasku
        Assert.assertTrue(driver.findElement(By.cssSelector("div.alert-success")).isDisplayed());

    }

}