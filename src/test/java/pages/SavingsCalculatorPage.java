package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SavingsCalculatorPage {

    WebDriver driver;

    public SavingsCalculatorPage(WebDriver driver) {
        this.driver = driver;
    }


    public WebElement lastNote() {
        return driver.findElement(By.xpath("//ul/li[1]/div"));
    }


    public WebElement buttonApply() {
        return driver.findElement(By.cssSelector("button.btn-success"));
    }

    public WebElement fundSelect(){
        return driver.findElement(By.id("fundSelect"));
    }

    public WebElement emailInput() {
        return driver.findElement(By.id("emailInput"));
    }

    public WebElement yearsImput() {
        return driver.findElement(By.id("yearsInput"));
    }
    public WebElement OneTimeInvestment() {
        return driver.findElement(By.id("oneTimeInvestmentInput"));
    }
}
