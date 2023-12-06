package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {
    /*Çağırıldığı yere bir WebDriver objesi döndürecek
            getDriver() method'u oluşturalım.

     getDriver() her seferinde, driver = new ChromeDriver(); satırını çalıştırırsa,
     her kullanımda yeni bir webdriver objesi oluşur.

     Biz ilk kullanımda (yani null iken) yeni webdriver oluştursun,
     sonraki kullanımlarda atanmış değeri kullansın

     */

    static WebDriver driver; // java, default olarak null değer verir.

    public static WebDriver getDriver() {
        WebDriverManager.chromedriver().setup();
        // eğer null ise değer ata (new ChromeDriver()),  null değilse değer atama!
        if (driver == null) {
            driver = new ChromeDriver(); // biz ise burada ChromeDriver değeri atıyoruz.}
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

    public static void closeDriver() {
        driver.close();
    }

    public static void quitDriver() {
        driver.quit();
    }

}