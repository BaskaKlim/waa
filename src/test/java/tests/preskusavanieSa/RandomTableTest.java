package tests.preskusavanieSa;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RandomTableTest {

    WebDriver driver;

    @Before
    public void openPage() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        //0.spustit prehliadac
        driver = new ChromeDriver();
        //1.otvorit stranku
        driver.get("http://localhost:8888/tabulka.php");
    }

    @After
    public void closePage() {
        driver.close();
        driver.quit();
    }

    @Test
    public void itShouldPrintLastRow() { // zobraz mi posledny riadok s tabulky

        // najdem a vypisem poseldny riadok

        for (WebElement tableRow : getRows()) {

            Assert.assertFalse(tableRow.getText().isEmpty());
        }
    }

    @Test
    public void itShouldContainNameForEachRow() {
        List<WebElement> tableRows = getRows();
        for (WebElement tableRow : tableRows) {
            tableRow.findElement(By.cssSelector("td:nth-child(2)"));
            WebElement rowName = tableRow.findElement(By.xpath("./td[2]"));
            Assert.assertFalse(rowName.getText().isEmpty());

        }
    }
    private List<WebElement> getRows() {
        return driver.findElements(By.cssSelector("table tbody tr"));
    }
}



