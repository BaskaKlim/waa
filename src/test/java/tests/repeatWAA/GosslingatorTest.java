package tests.repeatWAA;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GosslingatorTest {
    private WebDriver driver;
    private String BASE_URL = "http://localhost:8888";

    @Before
    //urcim si driver a ovtorim stranku
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
        driver.get(BASE_URL + "/gosslingator.php");
    }

    @Test
    //prida mi jedneho ryana
    public void itShoudlAddOneRyan() {
        WebElement addRyanBtn = driver.findElement(By.id("addRyan"));
        //pridanie premennej buttonu (najdem element button pridat Ryana a kliknem)

        // klikknem na button
        addRyanBtn.click();
        // porovnam ci mi prida cislo na vysledku ake ocakavam, musim to dat do textu, porovnavam stringy
        Assert.assertEquals("1", driver.findElement(By.id("ryanCounter")).getText());
    }

    // prida mi 2 ryanov
    @Test
    public void itShoudlAddTwoRyans() {
        WebElement addRyanBtn = driver.findElement(By.id("addRyan"));

        addRyanBtn.click();
        addRyanBtn.click();
        Assert.assertEquals("2", driver.findElement(By.id("ryanCounter")).getText());

    }

    // overim, ci mi spravne sklonuje ryan a ryans
    @Test
    public void itShouldCheckDeclension() {
        WebElement addRyanBtn = driver.findElement(By.id("addRyan"));
        // najdem element button pridat Ryana a kliknem
        addRyanBtn.click();
        // porovnam ci mi prida cislo na vysledku ake ocakavam, musim to dat do textu, porovnavam stringy
        Assert.assertEquals("1", driver.findElement(By.id("ryanCounter")).getText());
        Assert.assertEquals("ryan", driver.findElement(By.cssSelector("div.ryan-counter h3")).getText());
        System.out.println("Number of ryan: " + driver.findElement(By.id("ryanCounter")).getText());
        // klikni este raz na button a over ci pribudlo spravne cislo aj sklonovanie
        driver.findElement(By.id("addRyan")).click();
        Assert.assertEquals("2", driver.findElement(By.id("ryanCounter")).getText());
        Assert.assertEquals("ryans", driver.findElement(By.cssSelector("div.ryan-counter h3")).getText());
        System.out.println("Number of ryans: " + driver.findElement(By.id("ryanCounter")).getText());

    }
    // overim, ci mi vyhodi hlasku ak dam too many ryans

    @Test
    public void itShouldDisplayWarningMessage() {
        // najdem element button pridat Ryana a kliknem
        WebElement addRyanBtn = driver.findElement(By.id("addRyan"));
        addRyanBtn.click();
        addRyanBtn.click();
        addRyanBtn.click();
        addRyanBtn.click();
        addRyanBtn.click();
        addRyanBtn.click();
        addRyanBtn.click();
        addRyanBtn.click();
        addRyanBtn.click();
        addRyanBtn.click();
        addRyanBtn.click();
        addRyanBtn.click();
        addRyanBtn.click();
        addRyanBtn.click();
        addRyanBtn.click();
        addRyanBtn.click();
        addRyanBtn.click();
        addRyanBtn.click();
        addRyanBtn.click();
        addRyanBtn.click();
        addRyanBtn.click();
        addRyanBtn.click();
        addRyanBtn.click();
        addRyanBtn.click();
        addRyanBtn.click();
        addRyanBtn.click();
        addRyanBtn.click();
        addRyanBtn.click();
        addRyanBtn.click();
        addRyanBtn.click();
        addRyanBtn.click();
        addRyanBtn.click();
        addRyanBtn.click();
        addRyanBtn.click();
        addRyanBtn.click();
        addRyanBtn.click();
        addRyanBtn.click();
        addRyanBtn.click();
        addRyanBtn.click();
        addRyanBtn.click();
        addRyanBtn.click();
        addRyanBtn.click();
        addRyanBtn.click();
        addRyanBtn.click();
        addRyanBtn.click();
        addRyanBtn.click();
        addRyanBtn.click();
        addRyanBtn.click();
        addRyanBtn.click();
        addRyanBtn.click();
        addRyanBtn.click();



        Assert.assertEquals("NUMBER OF\n" +
                        "RYANS\n" +
                        "IS TOO DAMN\n" +
                        "HIGH",
                driver.findElement(By.cssSelector("h1.tooManyRyans.ryan-title")).getText());


    }

    @Test
    public void itShouldDisplayTitle() {
        driver.findElement(By.cssSelector("h1.ryan-title"));
        Assert.assertEquals("GOSLINGATE ME", driver.findElement(By.cssSelector("h1.ryan-title")).getText());
        System.out.println("Title is:" + driver.findElement(By.cssSelector("h1.ryan-title")).getText());

    }

    @After
    public void tearDown() {
        //ukoncit session
        driver.quit();
    }
}



