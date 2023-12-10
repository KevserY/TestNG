package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utilities.Driver;

public class ZeroPage {
    // önce default cons. görünür yap ve driver'ı tanıt.

    public ZeroPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "signin_button")
    public WebElement signInLinki;

    @FindBy(id ="user_login")
    public WebElement usernameKutusu;

    @FindBy(id = "user_password")
    public WebElement passwordKutusu;

    @FindBy(xpath = "//*[@class='btn btn-primary']")
    public WebElement signInButonu;

    @FindBy(xpath = "//strong[text()='Online Banking']")
    public WebElement onlineBankingLinki;

    @FindBy(id = "pay_bills_link")
    public WebElement payBillsLinki;

    @FindBy(linkText = "Purchase Foreign Currency")
    public WebElement purchaseForeignCurrencyLinki;

    @FindBy(id = "pc_currency")
    public WebElement pcCurrencyDropdownElementi;





}
