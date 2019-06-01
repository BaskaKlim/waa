package tests.hodiny;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

public class ZenaAleboMuzTest {
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        // 0. spustit prehliadac
        driver = new ChromeDriver();
        //1.otvorit stranku
        driver.get("http://localhost:8888/zenaalebomuz.php");


    }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
        System.out.println("s panom bohom");
    }

    @Test
    public void ItShouldBeNotSelected () {


        Assert.assertFalse(driver.findElement(By.xpath("//input[@value='wurst']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//input[@value='conchita']")).isSelected());
    }

    @Test
    public void ItShouldBeMan(){
        driver.findElement(By.xpath("//input[@value='wurst']")).click();
        Assert.assertTrue( "It's wurst", true);

    }

    @Test
    public void ItShouldNotBeWoman(){
        driver.findElement(By.xpath("//input[@value='wurst']")).click();
        Assert.assertFalse(driver.findElement(By.xpath("//input[@value='conchita']")).isSelected());

    }

    @Test
    public void ItShouldImageIsDisplayed (){
        Assert.assertTrue(driver.findElement(By.cssSelector("img")).isDisplayed());

    }
}