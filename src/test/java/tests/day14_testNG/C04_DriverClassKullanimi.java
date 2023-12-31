package tests.day14_testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Driver;

public class C04_DriverClassKullanimi {

    @Test
    public void test01() throws InterruptedException {
        /*
            POM hazırlayanlar, Web Driver objesini TestBase'den almak yerine,
            'extends' keyword'üne ihtiyaç duymadan kullanabileceğimiz,
            static bir method'da oluşturmayı tercih etmiştir.
         */

        // testotomasyonu anasayfasına gidin
        Driver.getDriver().get("https://www.testotomasyonu.com");

        // arama kutusuna phone yazıp, aratalım.
        WebElement aramaKutusu = Driver.getDriver().findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        // arama sonuçlarını yazdırın
        WebElement aramasonucElementi = Driver.getDriver().findElement(By.className("product-count-text"));
        System.out.println(aramasonucElementi.getText());


        Thread.sleep(3000);

        Driver.closeDriver();





    }

}
