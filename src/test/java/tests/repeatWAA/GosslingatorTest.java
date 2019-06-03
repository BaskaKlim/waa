package tests.repeatWAA;

import base.TestBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class GosslingatorTest extends TestBase {
    String actualNumberOfRyans;

    @Before
       public void openPage(){
        driver.get(BASE_URL + "/gosslingator.php");
    }

    @Test
    //prida mi jedneho ryana
    public void itShoudlAddOneRyan() {
        addRyan();
        actualNumberOfRyans();
        // porovnam ci mi prida cislo na vysledku ake ocakavam, musim to dat do textu, porovnavam stringy
        Assert.assertEquals("1",actualNumberOfRyans());
    }

    // prida mi 2 ryanov
    @Test
    public void itShoudlAddTwoRyans() {
        addRyan();
        addRyan();
        actualNumberOfRyans();
        Assert.assertEquals("2",actualNumberOfRyans());
    }

    // overim, ci mi spravne sklonuje ryan a ryans
    @Test
    public void itShouldCheckDeclension() {
        addRyan();
        // porovnam ci mi prida cislo na vysledku ake ocakavam, musim to dat do textu, porovnavam stringy
        Assert.assertEquals("1", driver.findElement(By.id("ryanCounter")).getText());
        Assert.assertEquals("ryan", getCounterDescription());
        System.out.println("Number of ryan: " + driver.findElement(By.id("ryanCounter")).getText());
        // klikni este raz na button a over ci pribudlo spravne cislo aj sklonovanie
        driver.findElement(By.id("addRyan")).click();
        Assert.assertEquals("2", driver.findElement(By.id("ryanCounter")).getText());
        Assert.assertEquals("ryans", getCounterDescription());
        System.out.println("Number of ryans: " + driver.findElement(By.id("ryanCounter")).getText());
    }

    @Test
    public void itShouldDisplayWarningMessage() {
        // nadefinujem si premenne
        WebElement addRyanBtn = driver.findElement(By.id("addRyan"));

        for (int i = 0; i < 50; i++) {
            addRyan();
            String actualNumberOfRyans = driver.findElement(By.id("ryanCounter")).getText();
            //porovnam skutocnu hodnotu zo stranky s hodnotou indexu +1
            //index si musim premenit na String aby som ich mohol porovnat
            Assert.assertEquals(String.valueOf(i + 1), actualNumberOfRyans);
            // podmienky if
            getCounterDescription();
            if (i + 1 == 1) {
                Assert.assertEquals("ryan", getCounterDescription());
            }
            if (i + 1 >= 2) {
                Assert.assertEquals("ryans", getCounterDescription());
            }

            //otestujte v cykle pocet zobrazenych obrazkov ryana
            int numberOfRyanImages = driver.findElements(By.cssSelector("img")).size();

            Assert.assertEquals(i + 1, numberOfRyanImages);

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
            actualNumberOfRyans();
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
        getNumberOfRyanImages();
        Assert.assertEquals(getNumberOfRyanImages(), 0);
    }


    private void addRyan() {
        WebElement ryanBtn = driver.findElement(By.id("addRyan"));
        ryanBtn.click();
    }


    private String actualNumberOfRyans(){
        return driver.findElement(By.id("ryanCounter")).getText();
    }

    private String getCounterDescription() {
        return driver.findElement(By.cssSelector("div.ryan-counter h3")).getText();
    }

    private int getNumberOfRyanImages() {
        return driver.findElements(By.cssSelector("img")).size();
    }
}





