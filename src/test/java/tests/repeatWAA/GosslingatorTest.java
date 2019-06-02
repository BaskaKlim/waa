package tests.repeatWAA;

import javassist.bytecode.SyntheticAttribute;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GosslingatorTest {
    String actualNumberOfRyans;
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
        actualNumberOfRyans = driver.findElement(By.id("ryanCounter")).getText();
        // porovnam ci mi prida cislo na vysledku ake ocakavam, musim to dat do textu, porovnavam stringy
        Assert.assertEquals("1", actualNumberOfRyans);
    }

    // prida mi 2 ryanov
    @Test
    public void itShoudlAddTwoRyans() {
        WebElement addRyanBtn = driver.findElement(By.id("addRyan"));

        addRyanBtn.click();
        addRyanBtn.click();
        actualNumberOfRyans = driver.findElement(By.id("ryanCounter")).getText();
        Assert.assertEquals("2", actualNumberOfRyans);

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

    @Test
    public void itShouldDisplayWarningMessage() {
        // nadefinujem si premenne
        WebElement addRyanBtn = driver.findElement(By.id("addRyan"));

        for (int i = 0; i < 50; i++) {
            addRyanBtn.click();
            String actualNumberOfRyans = driver.findElement(By.id("ryanCounter")).getText();
            //porovnam skutocnu hodnotu zo stranky s hodnotou indexu +1
            //index si musim premenit na String aby som ich mohol porovnat
            Assert.assertEquals(String.valueOf(i + 1), actualNumberOfRyans);
            // podmienky if
            String actualDescription = driver.findElement(By.cssSelector("div.ryan-counter h3")).getText();
            if (i + 1 == 1) {
                Assert.assertEquals("ryan", actualDescription);
            }
            if (i + 1 >= 2) {
                Assert.assertEquals("ryans", actualDescription);
            }
            // vypysat index a pocet ryanov
            System.out.println("hodnota indexu je " + i);
            System.out.println("pocet ryanov je: " + actualNumberOfRyans);
        }

        // overim, ci mi vyhodi hlasku ak dam too many ryans

        Assert.assertEquals("NUMBER OF\n" +
                        "RYANS\n" +
                        "IS TOO DAMN\n" +
                        "HIGH",
                driver.findElement(By.cssSelector("h1.tooManyRyans.ryan-title")).getText());


    }

    @Test
    public void itShouldDisplayWarningMessageUsingWhileCycle() {
        WebElement addRyanButton = driver.findElement(By.id("addRyan"));
        String actualNumberOfRyans = driver.findElement(By.id("ryanCounter")).getText();
        //while cyklus sa vykona vzdy ak je podmienka "true"
        int clicksLimit = 30;
        int clicks = 0;
        while (!actualNumberOfRyans.equals("50") && clicks < clicksLimit) {
            addRyanButton.click();
            actualNumberOfRyans = driver.findElement(By.id("ryanCounter")).getText();
            clicks++;
        }
    }


    @Test
    public void itShouldDisplayTitle() {
        driver.findElement(By.cssSelector("h1.ryan-title"));
        Assert.assertEquals("GOSLINGATE ME", driver.findElement(By.cssSelector("h1.ryan-title")).getText());
        System.out.println("Title is:" + driver.findElement(By.cssSelector("h1.ryan-title")).getText());

    }

    @Test
    //otestujte, ze po otvoreni stranky gosslingator, nie je zobrazeny ani jeden ryan
    public void itShouldBeDisplayedNoRyan() {
        // nadefinujem si premenne
        int numberOfRyanImages = driver.findElements(By.cssSelector("img")).size();
        Assert.assertEquals(numberOfRyanImages, 0);
    }

    @After
    public void tearDown() {
        //ukoncit session
        driver.quit();
    }
}





