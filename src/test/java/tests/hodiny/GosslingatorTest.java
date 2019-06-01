package tests.hodiny;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import base.TestBase;
import pages.GosslingatorPage;


public class GosslingatorTest extends TestBase {
    private String actualNumberOfRyans; //private = viditelna len pre triedu

    @Before
    public void openPage() {
        //1.otvorit stranku
        driver.get(BASE_URL + "/gosslingator.php");
    }

    @Test
    public void itShouldAddOneRyan() {
        GosslingatorPage gossPage = new GosslingatorPage(driver);
        //2.kliknut na tlacidlo pridat
        gossPage.addRyan();
        //3.overit pocitanie ryanov
        Assert.assertEquals("1", gossPage.getRyanCounterNumber());
        // vypisem si do console aktualny pocet z pocitadla ryanov
        Assert.assertEquals("ryan", gossPage.getCounterDescription());
    }

}
