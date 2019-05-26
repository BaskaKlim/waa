package tests.preskusavanieSa;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//uloha2

public class XpathTrainingTest {
    // zadefinujem si webdriver ktory je driver
    WebDriver driver;
    // zadefinujem si co sa stane pred spustenim kazdeho testu v tejto triede
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        //0.spustit prehliadac
        driver = new ChromeDriver();
        //1.otvorit stranku
        driver.get("http://localhost:8888/xpathtrainingcenter.php");
    }
    // uadefinujem si co sa stane na konci kazdeho testu v tejto triedeł
    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }

    @Test
    public void itShouldDisplayAction() {
        // zadefinujem si premennu text z buttonu
        String buttonText = "One more button";
        // najdem element - text buttonu - cez lokator skrz xpath  a kliknem
        clickOnButton(buttonText);
        // porovnam hlasku s tym, co cakam ze napise, bacha musim dat ocakavanu hlasku (moju premennu 2) do lowecase
        Assert.assertEquals(
                "you clicked " + buttonText.toLowerCase(),
                getActualMessage()
        );
    }

    @Test
    public void itShouldDisplayEnteredMessage() {

        // zadefinujem si premennu - vkladajucu hlasku
        String message = "vonku prsi";
        // najdem element - textove pole, kde sa pisu hlasky a vpisem hlasku
        driver.findElement(By.cssSelector("input")).sendKeys(message);

        // stlacim button hit me
        driver.findElement(By.id("hitme")).click();

        // zadefinujem si premennu zobrazenu hlasku - //precitam hodnotu zo stranky a ulozim ju do premennej


        // overim zobrazenu hlasku s vkladajucou hlaskou
        Assert.assertEquals(
                "you entered " + message,
                getActualMessage()
        );
    }
    private String getActualMessage() {
        return driver.findElement(By.cssSelector("div.output h2 span")).getText();
    }

    private void clickOnButton(String buttonText) {
        driver.findElement(By.xpath("//button[contains(text(),'" + buttonText + "')]")).click();
    }

}