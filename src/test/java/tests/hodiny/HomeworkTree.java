package tests.hodiny;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HomeworkTree {
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        // 0. spustit prehliadac
        driver = new ChromeDriver();
        // 1. otvorit stranku
        driver.get("http://localhost:8888/xpathtrainingcenter.php");
    }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }

    @Test
    public void itShouldClickAllButtons() {
        // najdi mi button podla mena - button ktory obsahuje konkretny text a klikni
        // na to si vytvorim si pole premennych (buttonov)//
        String[] buttonsToClick = {"First one", "Danger", "Success", "Warning"};
        // for cyklus pre konkretne pole - stlacim iter a tabulator a pomenujem si string napr. button//
        for (String button : buttonsToClick) {
        // medzi kucerave zatvorky vkladam vsetko co chcem pre kazdy vyraz z pola vykonat//
            driver.findElement(By.xpath("//button[contains(text(),' "+ button + "')]")).click();

            //over mi hlasku
            Assert.assertEquals("you clicked " + button.toLowerCase(),
                    driver.findElement(By.cssSelector("div.output span")).getText());


    }
    }

    @Test
    public void itShouldSelectAllOptions() {
        // najdi pole kde su vsetky moznosti - definujem si elementt z ktoreho budem vyberat
        WebElement selectBox = driver.findElement(By.cssSelector("select"));

            for (int i = 0; i < 6; i++) {
                //zavolam si tu triedu, poviem jej odkial ma vybrat, poviem jej co ma vybrat
                new Select(selectBox).selectByVisibleText("Moznost " + (i + 1));

                //over mi hlasku
                Assert.assertEquals( "you have chosen moznost " + (i +1),
                        driver.findElement(By.cssSelector("div.output span")).getText());
            }
        }

    }

