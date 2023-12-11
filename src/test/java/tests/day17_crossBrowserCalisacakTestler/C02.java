package tests.day17_crossBrowserCalisacakTestler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuFormPage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseCross;

import java.util.List;

public class C02 extends TestBaseCross {
    /*
            Varolan test package altında cross browser çalışacak test yazmamak lazım.
            eğer bir test methodunun cross browser ile çalışacak testlere eklenmesi istenirse
            cross browser package taşıyıp, şu değişiklikleri yapmak lazım.
            1- test base class'a extends edin
            2- driver.getDriver()  yerine, testbasecross dan gelen driver objesi kullanın
            3- page class ları Driver.getDriver() ile tanımlandığı için kullanamayız.
            locateleri test base içinde driver objesi ile yapmalıyız.
     */

    @Test
    public void dropdownTesti() {
        //● https://testotomasyonu.com/form adresine gidin.
        driver.get("https://testotomasyonu.com/form");

        // 1. Dogum tarihi gun seçeneğinden ""index"" kullanarak 5’i secin

        List<WebElement> dropdownMenuElementleriList = driver.findElements(By.xpath("//select[@class='form-control']"));

        Select selectGun = new Select(dropdownMenuElementleriList.get(0));
        selectGun.selectByIndex(5);

        // 2. Dogum tarihi ay seçeneğinden ""value"" kullanarak Nisan’i secin
        Select selectAy = new Select(dropdownMenuElementleriList.get(1));
        selectAy.selectByValue("nisan");

        // 3. Dogum tarihi yil seçeneğinden ""visible text"" kullanarak 1990’i secin
        Select selectYil = new Select(dropdownMenuElementleriList.get(2));
        selectYil.selectByVisibleText("1990");

        // 4. Secilen değerleri konsolda yazdirin
        System.out.println(selectGun.getFirstSelectedOption().getText() + " /" +
                selectAy.getFirstSelectedOption().getText() + " /" +
                selectYil.getFirstSelectedOption().getText());

        // 5. Ay dropdown menüdeki tum değerleri(value) yazdırın
        List<String> aylarListesi = ReusableMethods.stringListeDonustur(selectAy.getOptions());
        System.out.println(aylarListesi);

        // 6. Ay Dropdown menusunun boyutunun 13 olduğunu test edin
        Assert.assertEquals(selectAy.getOptions().size(),13);

        ReusableMethods.bekle(3);


    }
}
