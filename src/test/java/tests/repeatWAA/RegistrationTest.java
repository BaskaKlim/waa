package tests.repeatWAA;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationTest {
    WebDriver driver;
    String BASE_URL = "http://localhost:8888";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
        driver.get(BASE_URL + "/registracia.php");
    }

    @Test
    //Uspesna registracia
    public void itShouldRegisterValidUser() {

        String email= "baska@email.com";
        String meno = "Baška";
        String priezvisko ="Klimek";
        String heslo = "Heslo123";

        //zadam zakladne udaje
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("name")).sendKeys(meno);
        driver.findElement(By.name("surname")).sendKeys(priezvisko);
        driver.findElement(By.name("password")).sendKeys(heslo);
        driver.findElement(By.name("password-repeat")).sendKeys(heslo);

        //kliknut na checkbox som robot
        driver.findElement(By.name("robot")).click();
        //kliknut na tlacidlo registrovat sa
        driver.findElement(By.cssSelector("button.btn-success")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector ("div.alert.alert-success")).isDisplayed());
    }


    @After
    public void tearDown() {
        driver.close();
        driver.quit();

    }
}
