package tests.preskusavanieSa;

import base.TestBase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.NotePage;
import pages.RegistrationPage;

public class RegistraciaTest extends TestBase {

    @Before
    public void openPage() {
        driver.get(BASE_URL + "/888/registracia.php");
    }

    @Test
    public void itShouldRegisterValidUser() {
        // zadefinujem si prememnne, ktore budem vkladat do textovych poli
        String email = "baska@klimek.sk";
        String meno = "baska";
        String priezvisko = "klimek";
        String heslo = "123456";
        // najdem jednotlive textove polia a vpisem hodnotu zadefinovanej premennej, pozor heslo vpisujem 2x rovnake
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.enterData(email, meno, priezvisko, heslo);
        // najdem a zaskttnem checkbox som robot
        driver.findElement(By.name("robot")).click();
        // najem a kliknem na button registruj sa
        driver.findElement(By.cssSelector("button.btn-success")).click();
        //najdem hlasku a overim hlasku - ked je to uspesne alebo neuspesne tak assert assert true / false cize v kode bude ze porovnaj ci zobrazi tuto hlasku
        Assert.assertTrue(driver.findElement(By.cssSelector("div.alert-success")).isDisplayed());
    }

    @Test
    public void itShouldDisplayErrorMessageWhenInputsAreEmpty(){
        //nevyplnim ziadne pole
        //kliknut na checkbox som robot
        driver.findElement(By.name("robot")).click();
        //kliknut na tlacidlo registrovat sa
        driver.findElement(By.cssSelector("button.btn-success")).click();
        //overit uspesnu hlasku
        Assert.assertTrue(driver.findElement(By.cssSelector("div.alert-danger")).isDisplayed());
    }
}




