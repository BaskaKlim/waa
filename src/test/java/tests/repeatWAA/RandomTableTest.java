package tests.repeatWAA;

import com.sun.tools.internal.xjc.reader.xmlschema.BindYellow;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.lang.model.util.Elements;
import java.util.List;

public class RandomTableTest {
    private WebDriver driver;
    private String BASE_URL = "http://localhost:8888";

    @Before
    //urcim si driver a ovtorim stranku
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
        driver.get(BASE_URL + "/tabulka.php");
    }

    @Test
    //najdem a vypisem posledny riadok
    public void itShouldPrintLastRow() {
        System.out.println(driver.findElement(By.xpath("//table/tbody/tr[last()]")).getText());
    }
    @Test
    //najdem a vypisem meno z predposledneho riadku
            public void itShouldPrintNameOfLastRow() {
        System.out.println(driver.findElement(By.xpath("//table/tbody/tr[last()-1]/td[2]")).getText());
    }

//najdem si vsetky riadky tabulky a pre kazdy z nich si necham vypisat vsetky udaje

    @Test
    public void itShouldPrintEachRow(){
        List<WebElement> tableRows = driver.findElements(By.cssSelector("table tbody tr"));
        for (WebElement tableRow : tableRows) {
            Assert.assertFalse(tableRow.getText().isEmpty());
            System.out.println(tableRow.getText());
        }
    }
    @After
    public void tearDown() {
        //ukoncit session
        driver.quit();
    }
}
