package tests.repeatWAA;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
    public void itShouldDisplayActionByDefineVariables(){
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
        String enteredMessage ="vonku prsi";
        // 2. najdi element textoveho pola         // 3. vpis don premennu
        driver.findElement(By.cssSelector("input.form-control")).sendKeys(enteredMessage);
        //3. click hit mebutton
        driver.findElement(By.id("hitme")).click();
        //4. over pozadovanu hlasku so skutocnou
        Assert.assertEquals(driver.findElement(By.xpath("//h2/span")).getText(), "you entered " + enteredMessage);
    }
    @After
    public void tearDown() {
        //ukoncit session
        driver.quit();
    }
}




