package tests.exam;

import base.TestBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SavingsCalculator extends TestBase {


    @Before
    public void openPage() {
        driver.get(BASE_URL + "/savingscalculator.php");
    }

    @Test
    public void itShouldEnableApplyButton() {
        //najdi a vypln polia
        // zacinam emailom bo je lahky
        String email = "baska@mail.com";
        driver.findElement(By.id("emailInput")).sendKeys(email);
        //najdem si pole s fundoami a kliknem a selektor dropdown si zadefingujem
        driver.findElement(By.id("fundSelect")).click();
        WebElement dropdown = driver.findElement(By.id("fundSelect"));
        //z tohto dropdownu vytiahnem moznost, ktora obsahuje ten prvy fund a kliknem
        dropdown.findElement(By.xpath("//option[. = 'Handelsbanken Aktiv 100']")).click();
        // najdem si dalsie pole a vpisem don jednu z moznosti ktoru som si sipkami nasla (asi hranicna hodnota) a kliknem
        driver.findElement(By.id("oneTimeInvestmentInput")).sendKeys("1000");
        driver.findElement(By.id("oneTimeInvestmentInput")).click();
        //najdem si pole (element) rokov a opat vpisem hodnotu co som si nasla ze berie a kliknem
        driver.findElement(By.id("yearsInput")).sendKeys("1");
        driver.findElement(By.id("yearsInput")).click();
        //overim ci sa da na tlacidlo kliknit - ak sa da na tlacidlo kliknut tak je enable

        // driver.findElement(By.cssSelector(".btn")).click();
        // ale overit sa to da aj cez isEnabled
        Assert.assertTrue(driver.findElement(By.cssSelector("button.btn-success")).isEnabled());

    }

    @Test
    public void itShouldContainIncomes() {
        //najdi a vypln polia
        //najdem si pole s fundoami a kliknem a selektor dropdown si zadefingujem
        driver.findElement(By.id("fundSelect")).click();
        WebElement dropdown = driver.findElement(By.id("fundSelect"));
        //z tohto dropdownu vytiahnem moznost, ktora obsahuje ten prvy fund a kliknem
        dropdown.findElement(By.xpath("//option[. = 'Handelsbanken Aktiv 100']")).click();
        // najdem si dalsie pole a vpisem don jednu z moznosti ktoru som si sipkami nasla (asi hranicna hodnota) a kliknem
        driver.findElement(By.id("oneTimeInvestmentInput")).sendKeys("1000");
        driver.findElement(By.id("oneTimeInvestmentInput")).click();
        //najdem si pole (element) rokov a opat vpisem hodnotu co som si nasla ze berie a kliknem
        driver.findElement(By.id("yearsInput")).sendKeys("1");
        driver.findElement(By.id("yearsInput")).click();
        // zacinam emailom bo je lahky
        String email = "baska@mail.com";
        driver.findElement(By.id("emailInput")).sendKeys(email);

        WebElement container = driver.findElement(By.cssSelector("div.result"));
        System.out.println(container.findElement(By.xpath("./div[1]/p")).getText());
        System.out.println(container.findElement(By.xpath("./div[2]/p")).getText());
    }
}
