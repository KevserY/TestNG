package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class WebuniversityPage {

    public WebuniversityPage(){ // ilk önce default constructor'ı görünür hale getiriyoruz.
        PageFactory.initElements(Driver.getDriver(),this);//driver'ımızı bu class'a (this) tanıtıyoruz.
    }
    //şimdi testelerimizi yürütebilmemiz için kullanacağımız tüm locate'lerimizi bu class'a kaydedelim.

    @FindBy(xpath = "//*[text()='LOGIN PORTAL']")
    public WebElement loginPortalLinki;

    @FindBy(xpath = "//*[@id='text']")
    public WebElement usernameKutusu;

    @FindBy(xpath = "//*[@id='password']")
    public WebElement passwordKutusu;

    @FindBy(xpath = "//*[@id='login-button']")
    public WebElement loginButonu;

}
