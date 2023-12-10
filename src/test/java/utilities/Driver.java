package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {

    private Driver(){
        /*
            POM'de Driver Class'ındaki getDriver() ve closeDriver'ın static yolla kullanılması öngörülmüştür.
            Obje oluşturma ile bu method'ların kullanılmaması
            veya obje oluşturularak farklı uygulamaların POM içinde kullanılmasını engellemek için
            SingeltonPattern tercih edilmiştir.
         */
    }

    /*Çağırıldığı yere bir WebDriver objesi döndürecek
            getDriver() method'u oluşturalım.

     getDriver() her seferinde, driver = new ChromeDriver(); satırını çalıştırırsa,
     her kullanımda yeni bir webdriver objesi oluşur.

     Biz ilk kullanımda (yani null iken) yeni webdriver oluştursun,
     sonraki kullanımlarda atanmış değeri kullansın

     */

    static WebDriver driver; // java, default olarak null değer verir.

    public static WebDriver getDriver() {
        String browser = ConfigReader.getProperty("browser");

        if (driver == null) {

            switch (browser) {
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return driver;
    }

    public static void closeDriver() {


        if (driver != null) {
            driver.close();
            driver = null;
        }
    }

    public static void quitDriver() {

        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}