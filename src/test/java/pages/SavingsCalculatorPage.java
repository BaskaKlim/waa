package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SavingsCalculatorPage {

    @FindBy(xpath="//ul/li[1]/div")
    private WebElement lastNoteElement;


    @FindBy(css ="button.btn-success")
    private WebElement buttonElement;

    @FindBy(id= "fundSelect")
    private WebElement fundSelectElement;

    @FindBy(id ="emailInput")
    private WebElement emailInputElement;

    @FindBy(id = "yearsInput")
    private WebElement yearsInputElement;


    @FindBy (id= "oneTimeInvestmentInput")
    private WebElement oneTimeInvestment;


    WebDriver driver;

    public SavingsCalculatorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public WebElement lastNote() {
        return  lastNoteElement;
    }


    public WebElement buttonApply() {
        return buttonElement;
    }

    public WebElement fundSelect(){
        return fundSelectElement;
    }

    public WebElement emailInput() {
        return emailInputElement;
    }

    public WebElement yearsImput() {
        return yearsInputElement;
    }
    public WebElement OneTimeInvestment() {
        return oneTimeInvestment;
    }
}
