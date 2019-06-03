package tests.repeatWAA;

import base.TestBase;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.sql.Timestamp;

public class NoteTest extends TestBase {

    @Before
    public void openPage() {
        driver.get(BASE_URL + "/odkazovac.php");
    }

    //otestovat pridanie noveho odkazu bez hashtgatov

    @Test
    public void itShouldAddNewOdkaz() throws InterruptedException {
        //1. zadat informacie
        String titulok = "Nova sprava test";
        String komu = "Tebe";
        String sprava = "Testa";

        Integer numberOfNotes = Integer.valueOf(driver.findElement(By.cssSelector("h3.sin-header span")).getText());

        driver.findElement(By.name("title")).sendKeys(titulok);
        driver.findElement(By.name("author")).sendKeys(komu);
        driver.findElement(By.name("message")).sendKeys(sprava);

        //2. kliknut na button +

        driver.findElement(By.cssSelector("BUTTON.btn.btn-block")).click();

        // 3. overit, ze sa pridal novy odkaz
        WebElement listItem = driver. findElement(By.cssSelector("ul.list-of-sins li:last-child"));

        Assert.assertTrue(listItem.getText().contains(titulok));

        //overenie linku
        Assert.assertTrue(listItem.findElement(By.cssSelector("div.description a")).isDisplayed());
        Assert.assertEquals("detail", listItem.findElement(By.cssSelector("div.description a")).getText());

        Assert.assertEquals(
                Integer.valueOf(numberOfNotes + 1),
                Integer.valueOf(driver.findElement(By.cssSelector("h3.sin-header span")).getText())
        );
        listItem.click();
        //overim detail zaznamu
        Thread.sleep(1000);
        WebElement detail = driver.findElement(By.cssSelector("div.content"));
        Assert.assertEquals(titulok, detail.findElement(By.cssSelector("h4.title")).getText());
        Assert.assertEquals( komu, detail.findElement(By.cssSelector("h4.recipent")).getText());
        Assert.assertEquals( sprava, detail.findElement(By.cssSelector("p")).getText());
    }

    @Test
    public void itShouldAddNewNote2() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Fairy fairy = Fairy.create();
        Person person = fairy.person();
        String title = "Title " + timestamp.getTime();

        driver.findElement(By.name("title")).sendKeys(title);
        driver.findElement(By.name("author")).sendKeys(person.getFirstName());
        driver.findElement(By.name("message")).sendKeys("Ahoj ako sa mas");

        driver.findElement(By.cssSelector("button.btn-block")).click();

        WebElement lastNoteAdded = driver.findElement(By.xpath("//ul[contains(@class,'list-of-sins')]/li[last()]"));
        Assert.assertTrue(lastNoteAdded.getText().contains(title));
    }

    @Test
    public void itShouldAddNewNoteWithTags() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Fairy fairy = Fairy.create();
        Person person = fairy.person();
        String title = "Title " + timestamp.getTime();

        driver.findElement(By.name("title")).sendKeys(title);
        driver.findElement(By.name("author")).sendKeys(person.getFirstName());
        driver.findElement(By.name("message")).sendKeys("Ahoj ako sa mas");
        driver.findElement(By.xpath("//input[@value='sport']")).click();
        driver.findElement(By.cssSelector("button.btn-block")).click();

        WebElement lastNoteAdded = driver.findElement(By.xpath("//ul[contains(@class,'list-of-sins')]/li[last()]"));
        Assert.assertTrue(lastNoteAdded.getText().contains(title));
    }
}
