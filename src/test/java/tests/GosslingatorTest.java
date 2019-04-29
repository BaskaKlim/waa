package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GosslingatorTest {

    @Test

    public void itShouldAddOneRyan() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");

        // 0. spustit prehliadac
        WebDriver driver = new ChromeDriver();
        // 1. otvorit stranku
        driver.get("http://localhost:8888/gosslingator.php");
        // 2. n￿ájdi, potom kliknut na tlacidlo Ryon!
        driver.findElement(By.id("addRyan")).click();

        // 3. najdi, citaj text, overit pocitanie Ryanov
        Assert.assertEquals("1", driver.findElement(By.id("ryanCounter")).getText());
        //4. zatvorit prehliadac
        driver.close();
        //.5. ukoncit session
        driver.quit();
    }


    @Test

    public void itShouldAddTwoRyan_inySposobHladaniaElementov() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");

        // 0. spustit prehliadac
        WebDriver driver = new ChromeDriver();
        // 1. otvorit stranku
        driver.get("http://localhost:8888/gosslingator.php");
        // 2. n￿ájdi, potom kliknut na tlacidlo Ryon!
        WebElement addRyanButton = driver.findElement(By.id("addRyan"));
        addRyanButton.click();
        addRyanButton.click();
        // 3. najdi, citaj text, overit pocitanie Ryanov
        String actualNumberOfRyans = driver.findElement(By.id("ryan-Counter")).getText();
        String actualRyanDescription = driver.findElement(By.cssSelector("div.ryan-counter h3")).getText();

        Assert.assertEquals("2", actualNumberOfRyans);
        System.out.println("number of ryans: " + driver.findElement(By.cssSelector("div.ryan-counter h2")).getText());
        Assert.assertEquals("ryans", actualRyanDescription);
        //4. zatvorit prehliadac
        driver.close();
        //.5. ukoncit session
        driver.quit();
    }


    @Test

    public void itShouldDisplayTitle() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");

        // 0. spustit prehliadac
        WebDriver driver = new ChromeDriver();
        // 1. otvorit stranku
        driver.get("http://localhost:8888/gosslingator.php");
        System.out.println(driver.findElement(By.cssSelector(".ryan-title")).getText());
        Assert.assertEquals("GOSLINGATE ME", driver.findElement(By.cssSelector(".ryan-title")).getText());
        // 2. n￿ájdi,
        // 3. najdi, citaj text, overit pocitanie Ryanov

        //4. zatvorit prehliadac
        driver.close();
        //.5. ukoncit session
        driver.quit();
    }

    public void itShouldAddOne50Ryans() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");

        // 0. spustit prehliadac
        WebDriver driver = new ChromeDriver();
        // 1. otvorit stranku
        driver.get("http://localhost:8888/gosslingator.php");
        // 2. n￿ájdi, potom kliknut na tlacidlo Ryon! 50krat - toto raz bude forcyklus
        WebElement addRyanButton =  driver.findElement(By.id("addRyan"));
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();


        // 3. najdi, citaj text, overit pocitanie Ryanov
        Assert.assertEquals("NUMBER OF\n" +
                "RYANS\n" +
                "IS TOO DAMN\n" +
                "HIGH", driver.findElement(By.cssSelector("h1.tooManyRyans")).getText());

        //4. zatvorit prehliadac
        driver.close();
        //.5. ukoncit session
        driver.quit();
    }


}