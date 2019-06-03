package tests.exam;

import base.TestBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.SavingsCalculatorPage;

public class SavingsCalculatorTest extends TestBase {
    private SavingsCalculatorPage savingPage;

    @Before
    public void openPage() {
        driver.get(BASE_URL + "/savingscalculator.php");
        savingPage = new SavingsCalculatorPage (driver);
    }

    @Test
    public void itShouldEnableApplyButton() {
        //najdi a vypln polia
        // zacinam emailom bo je lahky
        String email = "baska@mail.com";
        savingPage.emailInput().sendKeys(email);
        //najdem si pole s fundoami a kliknem a selektor dropdown si zadefingujem
        savingPage.fundSelect().click();
        WebElement dropdown = savingPage.fundSelect();
        //z tohto dropdownu vytiahnem moznost, ktora obsahuje ten prvy fund a kliknem
        dropdown.findElement(By.xpath("//option[. = 'Handelsbanken Aktiv 100']")).click();
        // najdem si dalsie pole a vpisem don jednu z moznosti ktoru som si sipkami nasla (asi hranicna hodnota) a kliknem
        savingPage.OneTimeInvestment().sendKeys("1000");
        savingPage.OneTimeInvestment().click();
        //najdem si pole (element) rokov a opat vpisem hodnotu co som si nasla ze berie a kliknem
        savingPage.yearsImput().sendKeys("1");
        savingPage.yearsImput().click();
        //overim ci sa da na tlacidlo kliknit - ak sa da na tlacidlo kliknut tak je enable driver.findElement(By.cssSelector(".btn")).click();
        // ale overit sa to da aj cez isEnabled
        Assert.assertTrue(savingPage.buttonApply().isEnabled());

    }

    @Test
    public void itShouldContainIncomes() {
        //najdi a vypln polia
        //najdem si pole s fundoami a kliknem a selektor dropdown si zadefingujem
        savingPage.fundSelect().click();
        WebElement dropdown = savingPage.fundSelect();
        //z tohto dropdownu vytiahnem moznost, ktora obsahuje ten prvy fund a kliknem
        dropdown.findElement(By.xpath("//option[. = 'Handelsbanken Aktiv 100']")).click();
        // najdem si dalsie pole a vpisem don jednu z moznosti ktoru som si sipkami nasla (asi hranicna hodnota) a kliknem
        savingPage.OneTimeInvestment().sendKeys("1000");
        savingPage.OneTimeInvestment().click();
        //najdem si pole (element) rokov a opat vpisem hodnotu co som si nasla ze berie a kliknem
        savingPage.yearsImput().sendKeys("1");
        savingPage.yearsImput().click();
        // zacinam emailom bo je lahky
        String email = "baska@mail.com";
        savingPage.emailInput().sendKeys(email);

        WebElement container = driver.findElement(By.cssSelector("div.result"));
        System.out.println(container.findElement(By.xpath("./div[1]/p")).getText());
        System.out.println(container.findElement(By.xpath("./div[2]/p")).getText());
        Assert.assertFalse(container.findElement(By.xpath("./div[2]/p")).getText().isEmpty());
    }

    @Test
    public void itShouldContainRisk() {
        //najdi a vypln polia
        //najdem si pole s fundoami a kliknem a selektor dropdown si zadefingujem
        savingPage.fundSelect().click();
        WebElement dropdown = savingPage.fundSelect();
        //z tohto dropdownu vytiahnem moznost, ktora obsahuje ten prvy fund a kliknem
        dropdown.findElement(By.xpath("//option[. = 'Handelsbanken Aktiv 100']")).click();
        // najdem si dalsie pole a vpisem don jednu z moznosti ktoru som si sipkami nasla (asi hranicna hodnota) a kliknem
        savingPage.OneTimeInvestment().sendKeys("1000");
        savingPage.OneTimeInvestment().click();
        //najdem si pole (element) rokov a opat vpisem hodnotu co som si nasla ze berie a kliknem
        savingPage.yearsImput().sendKeys("1");
        savingPage.yearsImput().click();
        // zacinam emailom bo je lahky
        String email = "baska@mail.com";
        savingPage.emailInput() .sendKeys(email);

        WebElement container = driver.findElement(By.cssSelector("div.result"));
        System.out.println(container.findElement(By.xpath("./div[3]/p")).getText());
        Assert.assertFalse(container.findElement(By.xpath("./div[3]/p")).getText().isEmpty());
    }


    @Test

    public void itShouldAddNewNote() {
        //najdi a vypln polia
        //najdem si pole s fundoami a kliknem a selektor dropdown si zadefingujem
        savingPage.fundSelect().click();
        WebElement dropdown = savingPage.fundSelect();
        //z tohto dropdownu vytiahnem moznost, ktora obsahuje ten prvy fund a kliknem
        dropdown.findElement(By.xpath("//option[. = 'Handelsbanken Aktiv 100']")).click();
        // najdem si dalsie pole a vpisem don jednu z moznosti ktoru som si sipkami nasla (asi hranicna hodnota) a kliknem
        savingPage.OneTimeInvestment().sendKeys("1000");
        savingPage.OneTimeInvestment().click();
        //najdem si pole (element) rokov a opat vpisem hodnotu co som si nasla ze berie a kliknem
        savingPage.yearsImput().sendKeys("1");
        savingPage.yearsImput().click();
        // zacinam emailom bo je lahky
        String email = "baska@mail.com";
        savingPage.emailInput().sendKeys(email);
        // kliknem
        savingPage.buttonApply().click();

        Assert.assertTrue(savingPage.lastNote().isDisplayed());
        Assert.assertTrue(savingPage.lastNote().getText().contains("Handelsbanken"));


    }
}
