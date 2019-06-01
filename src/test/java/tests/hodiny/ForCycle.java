package tests.hodiny;

import base.TestBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ForCycle extends TestBase {

    @Before
    public void openPage() {
        driver.get(BASE_URL + "/gosslingator.php");
    }


    @Test

    public void itShouldAddOneRyan() {

        // 2. n￿ájdi, potom kliknut na tlacidlo Ryon!
        driver.findElement(By.id("addRyan")).click();

        // 3. najdi, citaj text, overit pocitanie Ryanov
        Assert.assertEquals("1", driver.findElement(By.id("ryanCounter")).getText());
        //4. zatvorit prehliadac
        driver.close();
        //.5. ukoncit session
        driver.quit();
    }

    @Test


    public void itShouldAddTwoRyan_inySposobHladaniaElementov() {

        // 2. n￿ájdi, potom kliknut na tlacidlo Ryon!
        WebElement addRyanButton = driver.findElement(By.id("addRyan"));
        addRyanButton.click();
        addRyanButton.click();
        // 3. najdi, citaj text, overit pocitanie Ryanov
        String actualNumberOfRyans = driver.findElement(By.id("ryan-Counter")).getText();
        String actualRyanDescription = driver.findElement(By.cssSelector("div.ryan-counter h3")).getText();

        Assert.assertEquals("2", actualNumberOfRyans);
        System.out.println("number of ryans: " + driver.findElement(By.cssSelector("div.ryan-counter h2")).getText());
        Assert.assertEquals("ryans", actualRyanDescription);
        //4. zatvorit prehliadac
        driver.close();
        //.5. ukoncit session
        driver.quit();
    }


    @Test

    public void itShouldDisplayTitle() {

        System.out.println(driver.findElement(By.cssSelector(".ryan-title")).getText());
        Assert.assertEquals("GOSLINGATE ME", driver.findElement(By.cssSelector(".ryan-title")).getText());
        // 2. n￿ájdi,
        // 3. najdi, citaj text, overit pocitanie Ryanov

        //4. zatvorit prehliadac
        driver.close();
        //.5. ukoncit session
        driver.quit();
    }


    @Test
    public void forCycle() {

        // 2. n￿ájdi, potom kliknut na tlacidlo Ryon! 50krat - toto raz bude forcyklus
        WebElement addRyanButton = driver.findElement(By.id("addRyan"));
        for (int i = 0; i < 50; i++) {
            addRyanButton.click();

            // porovname skutocnu hodntu zo stranky s hodnotou indexu +1
            // index si musim premenit na String aby som ich mohol porovnat
            String actualNumberOfRyans = driver.findElement(By.id("ryanCounter")).getText();
            Assert.assertEquals(String.valueOf(i + 1), actualNumberOfRyans);
            System.out.print("index i= " + 1);
            System.out.print("pocet ryanov = " + actualNumberOfRyans);

            // overit sklonovanie pomocou podmienky
            String actualDescription = driver.findElement(By.cssSelector("div.ryan-counter h3")).getText();
            if (i + 1 == 1) {
                Assert.assertEquals("ryan", actualDescription);
            }
            if (i + 1 >= 2) {
                Assert.assertEquals("ryans", actualDescription);
            }
        }


        // 3. najdi, citaj text, overit pocitanie Ryanov
        Assert.assertEquals("NUMBER OF\n" +
                "RYANS\n" +
                "IS TOO DAMN\n" +
                "HIGH", driver.findElement(By.cssSelector("h1.tooManyRyans")).getText());

        //4. zatvorit prehliadac
        driver.close();
        //.5. ukoncit session
        driver.quit();


    }

    @Test
    public void whileCycle() {

        WebElement adddRyanButton = driver.findElement(By.id("addRyan"));
        String actualNumberOfRyans = driver.findElement(By.id("ryanCounter")).getText();
// while cyklus sa vykona vzdy ak je podmienka true
        // limit na kliky
        int clicksLimit = 30;
        int clicks = 0;

        while (!actualNumberOfRyans.equals("50") && clicks < clicksLimit) {
            adddRyanButton.click();
            actualNumberOfRyans = driver.findElement(By.id("ryanCounter")).getText();
        clicks++;
        }

    }


}