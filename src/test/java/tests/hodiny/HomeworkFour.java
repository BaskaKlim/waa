package tests.hodiny;

import base.TestBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import java.util.ArrayList;
import java.util.List;

public class HomeworkFour extends TestBase {

    @Before
    public void openPage() {
        driver.get(BASE_URL + "/fellowship.php");
    }


    @Test
    public void itShouldDisplayMessageComplete() {
        List<String> fellowsToSelect = new ArrayList<String>();
        fellowsToSelect.add("Gandalf");
        fellowsToSelect.add("Aragorn");
        fellowsToSelect.add("Legolas");
        fellowsToSelect.add("Frodo");

        for (String fellowToSelect : fellowsToSelect) {
            driver.findElement(By.xpath("//h1[contains(text(),'" + fellowToSelect + "')]")).click();
        }
        Assert.assertEquals("Complete", driver.findElement(By.cssSelector("div.points-left h3")).getText());

    }
}

