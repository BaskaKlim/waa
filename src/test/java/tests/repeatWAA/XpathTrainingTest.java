package tests.repeatWAA;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import javax.xml.parsers.SAXParser;

public class XpathTrainingTest {

    private WebDriver driver;
    private String BASE_URL = "http://localhost:8888";


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
        driver.get(BASE_URL + "/xpathtrainingcenter.php");
    }


    @Test
    public void itShouldDisplayAction() {
        //1. klikni na element second button
        driver.findElement(By.xpath("//button[contains(.,'Second button')]")).click();
        //2. over hlasku, ktora sa zobrazi v you clicked:
        Assert.assertEquals("you clicked second button", driver.findElement(By.xpath("//h2/span")).getText());
    }


    @Test
    public void itShouldDisplayActionByDefineVariables() {
        // zadefinovnie si premennych

        String buttonText = "One more button";
        //1. najdi a klikni na element second button - sposob ked mam zadefinovanu premennu buttonText
        driver.findElement(By.xpath("//button[contains(text(),'" + buttonText + "')]")).click();
        // zadefinovnie si premennych
        String actualMessage = driver.findElement(By.xpath("//h2/span")).getText();
        // porovnaj

        Assert.assertEquals(
                "you clicked " + buttonText.toLowerCase(),
                actualMessage
        );
    }

    @Test

    public void itShouldDisplayEnteredMessage() {
        //1. zadefinovanie si premennej - entered message
        String enteredMessage = "vonku prsi";
        // 2. najdi element textoveho pola         // 3. vpis don premennu
        driver.findElement(By.cssSelector("input.form-control")).sendKeys(enteredMessage);
        //3. click hit mebutton
        driver.findElement(By.id("hitme")).click();
        //4. over pozadovanu hlasku so skutocnou
        Assert.assertEquals(driver.findElement(By.xpath("//h2/span")).getText(), "you entered " + enteredMessage);
    }

    // DOMACA ULOHA test ktory prejde cez kazdy button, klikne nan a overi hlasku - vyuzite `pole` a `iteraciu` cez toto pole

    // DOMACA ULOHA test ktory vyberie kazdu moznost zo selectu a overi hlasku - vyuzite `for cyklus`
    @Test

    public void itShouldChoosEachOption() {
        // definujem si pole s moznostami
        String[] selectedOptions = {"Moznost 1","Moznost 2", "Moznost 3", "Moznost 4", "Moznost 5", "Moznost 6"};
        //najdem si tento select element
      WebElement select = driver.findElement(By.cssSelector("div > select:nth-child(1)"));
        //vyberem moznost  z tohto selektora

        for (String option :selectedOptions) {
           new Select(select).selectByVisibleText(option);

            //overim hlasku
            String actualMessage = driver.findElement(By.cssSelector(" div > h2 > span")).getText();
            String expectedMessage = "you have chosen " + option.toLowerCase();
            Assert.assertEquals(expectedMessage,actualMessage);
        }
        }
    // DOMACA ULOHA test ktory vyberie kazdu moznost zo selectu c.2, obdobne ako v predch, priklade
    @Test
    public void itShouldChoosEachOption2() {
        // definujem si pole s moznostami
        String[] selectedOptions2 = {"Option 1", "Option 2", "Option 3", "Option 4", "Option 5", "Option 6"};
        //najdem si tento select element
        WebElement select = driver.findElement(By.cssSelector("div > select:nth-child(2)"));
        //vyberem moznost  z tohto selektora

        for (String option2 :selectedOptions2) {
            new Select(select).selectByVisibleText(option2);

            //overim hlasku
            String actualMessage = driver.findElement(By.cssSelector(" div > h2 > span")).getText();
            String expectedMessage = "you have chosen " + option2.toLowerCase();
            Assert.assertEquals(expectedMessage,actualMessage);
        }
    }


    @After
    public void tearDown() {
        //ukoncit session
        driver.quit();
    }
}




