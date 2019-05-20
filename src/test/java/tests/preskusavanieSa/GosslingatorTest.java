package tests.preskusavanieSa;

import base.TestBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class GosslingatorTest extends TestBase {

    private String actualNumberOfRyans;

    @Before
    public void openPage() {
        // 1. otvorit prehliadac
        driver.get(BASE_URL + "/gosslingator.php");
    }


    //@Test

    // public void itShouldAddOneRyan() {

    //2.kliknut na tlacidlo pridat - driver najde element pomocou id a potom . a akcia co s tym elementom
    // driver.findElement(By.id("addRyan")).click();
    // 2.B najdi element pomocou css Selector Assert.assertEquals("1", driver.findElement(By.cssSelector("div.ryan-counter h2")).getText());
    //3.overit pocitanie ryanov - cez prikaz assert assert Equals do zatvoriek ocakavanu hodnotu, ciarka a cesta k tomu ako driver najde element ryan Cpinder a vezme z neho aktualny text /cislo
    // cez ID Assert.assertEquals("1", driver.findElement(By.id("ryanCounter")).getText()); //
    // toto je prvy sposob:  Assert.assertEquals("1", driver.findElement(By.cssSelector("div.ryan-counter h2")).getText());
    // toto druhy sposob - vynatie do premennej
    // actualNumberOfRyans = driver.findElement(By.id("ryanCounter")).getText();

    //  Assert.assertEquals("1", actualNumberOfRyans);

    // 4. overovanie sklonovania ryanov vypisem si do console aktualny pocet z pocitadla ryanov
    //   System.out.println("Number of ryans: " + driver.findElement(By.cssSelector("div.ryan-counter h2")).getText());
    //  Assert.assertEquals("ryan", driver.findElement(By.cssSelector("div.ryan-counter h3")).getText());

    //}

    @Test
    public void itShouldAddOneRyanNew() {
        //2.kliknut na tlacidlo pridat
        addRyan();
        //3.overit pocitanie ryanov
        actualNumberOfRyans = getRyanCounterNumber();
        Assert.assertEquals("1", actualNumberOfRyans);
        // vypisem si do console aktualny pocet z pocitadla ryanov
        System.out.println("Number of ryans: " + driver.findElement(By.cssSelector("div.ryan-counter h2")).getText());
        Assert.assertEquals("ryan", driver.findElement(By.cssSelector("div.ryan-counter h3")).getText());
    }

    //@Test
    // public void itShouldAddTwoRyans() {
    //2. najdi tlacitko pridaj Ryana  cez id a stlač dva krat
    // driver.findElement(By.id("addRyan")).click();
    // driver.findElement(By.id("addRyan")).click();

    //  WebElement addRyanBtn = driver.findElement(By.id("addRyan"));
    //  addRyanBtn.click();
    //  addRyanBtn.click();
    // najdi tlacidlo pridaj Ryana cez css selector  Assert.assertEquals("1", driver.findElement(By.cssSelector("div.ryan-counter h2")).getText());
    // vypisem si do console aktualny pocet z pocitadla ryanov driver.findElement(By.cssSelector("div.ryan-counter h2")).getText());
    //  System.out.println("Number of ryans: " + driver.findElement(By.cssSelector("div.ryan-counter h2")).getText());

    //3.overit pocitanie ryanov cez ID Assert.assertEquals("2", driver.findElement(By.id("ryanCounter")).getText()); over cez css
    // prvy sposob:  Assert.assertEquals("2", driver.findElement(By.id("ryanCounter")).getText());

    //  actualNumberOfRyans = driver.findElement(By.id("ryanCounter")).getText();
    //  String actualRyanDescription = driver.findElement(By.cssSelector("div.ryan-counter h3")).getText();

    // Assert.assertEquals("2", actualNumberOfRyans);
    // Assert.assertEquals("ryans", actualRyanDescription);

    // 4. over sklonovanie ryanov
    // prvy sposob: Assert.assertEquals("ryans", driver.findElement(By.cssSelector("div.ryan-counter h3")).getText());

    //}

    @Test
    public void itShouldTwoRyansNew() {
        //2.kliknut na tlacidlo pridat
        //WebElement addRyanBtn = driver.findElement(By.id("addRyan"));
        // addRyanBtn.click();
        //addRyanBtn.click();
        addRyan();
        addRyan();
        //3.overit pocitanie ryanov
        actualNumberOfRyans = getRyanCounterNumber();
        String actualRyanDescription = driver.findElement(By.cssSelector("div.ryan-counter h3")).getText();

        Assert.assertEquals("2", actualNumberOfRyans);
        Assert.assertEquals("ryans", actualRyanDescription);
    }
    //@Test
    //public void itShouldDisplayTitle() {

    // 2. najde mi dany title cez css selector a vezme z neho text
    //  System.out.println(driver.findElement(By.cssSelector(".ryan-title")).getText());
    //3. porovna ocoakavany text - hlasku Goslingate me s tym, co realne zobrazuje hlaska
    //  Assert.assertEquals("GOSLINGATE ME", driver.findElement(By.cssSelector(".ryan-title")).getText());

    // }

    @Test
    public void itShouldDisplayTitleNew() {
        System.out.println(driver.findElement(By.cssSelector(".ryan-title")).getText());
        Assert.assertEquals("GOSLINGATE ME", driver.findElement(By.cssSelector(".ryan-title")).getText());
    }

    //@Test
    //public void itShouldDisplayWarningMessage() {

    //toto raz bude for cyklus  driver.findElement(By.id("addRyan")).click(); 50x pod sebou napisane
    //  WebElement addRyanButton = driver.findElement(By.id("addRyan"));
    // definovany for cyklus pre integer i , ktore je mensie ako 50, a zvacuje sa po jednom integer i zacina ako 0
    //   for (int i = 0; i < 50; i++) {
    // klikni
    //      addRyanButton.click();
    // definovuj premennu aktualny pocet rajenov (mas ju hore uplne) zavolaj a vloz do nej text / hodnotu
    //     String actualNumberOfRyans = driver.findElement(By.id("ryanCounter")).getText();

    //porovnam skutocnu hodnotu zo stranky s hodnotou indexu +1
    //index si musim premenit na String aby som ich mohol porovnat

    //      Assert.assertEquals(String.valueOf(i + 1), actualNumberOfRyans);

    //overit sklonovanie pomocou podmienky
    // definuj si premmenu a vloz do nej text
    //      String actualDescription = driver.findElement(By.cssSelector("div.ryan-counter h3")).getText();
    // podmienka if opakovanie rovna sa 1 porovnaj hlasky ryanov - ryan a premenna
    //  if (i + 1 == 1) {
    //       Assert.assertEquals("ryan", actualDescription);
    //      }
    // podmienka if opakovanie je viac ako 2, ocakavane bude ryans
    //  if (i + 1 >= 2) {
    //      Assert.assertEquals("ryans", actualDescription);
    //      }
    //      //overim pocet obrazkov ryana
    //  int numberOfRyanImages = driver.findElements(By.cssSelector("img")).size();
    //  Assert.assertEquals(i + 1, numberOfRyanImages);

// vypis index teda hodnotu premennej i - teda pocet opakovani a pocet ryanov
    //  System.out.println("index i = " + i);
    //  System.out.println("pocet ryanov = " + actualNumberOfRyans);

    //}


    //  Assert.assertEquals(
    //         "NUMBER OF\n" +
    //                 "RYANS\n" +
    //                  "IS TOO DAMN\n" +
    //                  "HIGH",
    //          driver.findElement(By.cssSelector("h1.tooManyRyans")).getText()
    //    );

    //}

    @Test
    public void itShouldDisplayWarningMessageNew() {
        //toto raz bude for cyklus

        for (int i = 0; i < 50; i++) {
            addRyan();
            String actualNumberOfRyans = driver.findElement(By.id("ryanCounter")).getText();
            //porovnam skutocnu hodnotu zo stranky s hodnotou indexu +1
            //index si musim premenit na String aby som ich mohol porovnat
            Assert.assertEquals(String.valueOf(i + 1), actualNumberOfRyans);

            //overit sklonovanie pomocou podmienky
            String actualDescription = driver.findElement(By.cssSelector("div.ryan-counter h3")).getText();
            if (i + 1 == 1) {
                Assert.assertEquals("ryan", actualDescription);
            }
            if (i + 1 >= 2) {
                Assert.assertEquals("ryans", actualDescription);
            }

            //overim pocet obrazkov ryana
            int numberOfRyanImages = getNumberOfRyanImages();
            Assert.assertEquals(i + 1, numberOfRyanImages);

            System.out.println("index i = " + i);
            System.out.println("pocet ryanov = " + actualNumberOfRyans);
        }
        Assert.assertEquals(
                "NUMBER OF\n" +
                        "RYANS\n" +
                        "IS TOO DAMN\n" +
                        "HIGH",
                driver.findElement(By.cssSelector("h1.tooManyRyans")).getText()
        );
    }


    //@Test
    //public void itShouldDisplayWarningMessageUsingWhileCycle() {
    // zadefinovanie si premennej buttonu podla id
    //   WebElement addRyanButton = driver.findElement(By.id("addRyan"));
    // zadefinovanie si premennej hodnoty ryanov
    //  String actualNumberOfRyans = driver.findElement(By.id("ryanCounter")).getText();
    //while cyklus sa vykona vzdy ak je podmienka "true"
    // cliklimit 30
    //   int clicksLimit = 30;
    //   int clicks = 0;
    //   while (!actualNumberOfRyans.equals("50") && clicks < clicksLimit) {
    //      addRyanButton.click();
    //      actualNumberOfRyans = driver.findElement(By.id("ryanCounter")).getText();
    //      clicks++;
    //   }

    //  #2priklad: otestujte v cykle pocet zobrazenych obrazkov ryana.


    // }

    //@Test
    //public void itShouldDisplayNoRyanOnPageOpen() {
    //    Assert.assertEquals(
    //           0,
    //           driver.findElements(By.cssSelector("img")).size()
    //  );
    //}

    @Test
    public void itShouldDisplayWarningMessageUsingWhileCycleNEW() {
        WebElement addRyanButton = driver.findElement(By.id("addRyan"));
        String actualNumberOfRyans = getRyanCounterNumber();
        //while cyklus sa vykona vzdy ak je podmienka "true"
        int clicksLimit = 30;
        int clicks = 0;
        while (!actualNumberOfRyans.equals("50") && clicks < clicksLimit) {
            addRyanButton.click();
            actualNumberOfRyans = getRyanCounterNumber();
            clicks++;
        }
    }

    //  #2priklad: otestujte v cykle pocet zobrazenych obrazkov ryana.

    @Test
    public void itShouldDisplayNoRyanOnPageOpenNEW() {
        Assert.assertEquals(
                0,
                getNumberOfRyanImages()
        );
    }
    // pridavam si metodu

    private void addRyan() {
        // najdem si button
        WebElement addRyanButton = driver.findElement(By.id("addRyan"));
        // kliknem si na button
        driver.findElement(By.id("addRyan")).click();
    }

    private String getRyanCounterNumber() {
        //vrat return najdi element, vezmi jeho text /hodnotu/ a vrat mi ju
        return driver.findElement(By.id("ryanCounter")).getText();

    }

    private String getCounterDescription() {
        // metoda, ktora mi overi sklonovanie ryans alebo ryan

        return driver.findElement(By.cssSelector("div.ryan-counter h3")).getText();
    }
    private int getNumberOfRyanImages() {
        return driver.findElements(By.cssSelector("img")).size();
    }
}

