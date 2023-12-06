package test.day14_testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class C02_DependsOnMethods {
    /*
            dependsOnMethod, öncelik sırasına karışmaz.

            Eğer sırası gelen bir test, dependsOnMethod ile baska bir method'a bağlı ise
            önce bağlı olunan testin çalışıp, pass olmasını kontrol eder.

            Bağlı olunan test çalışmazsa veya çalışır ama FAILED olursa,
            bu durumda, bağlı olan test method'u çalışmaz, ignore olarak işaretlenir.

            Normalde her bir test method'u, bağımsız olarak çalıştırılabilir.
            Ancak, dependsOnMethods ile bağlı olan iki method'dan bağlı olan run edilirse
            öncelikle bağlı olunan test methodunun çalışmasını sağlar.
            Bağlı olunan method çalışıp passed olursa, bağlı olan kendisi de çalışır.

     */

    @Test(dependsOnMethods = "testOtomasyonuTesti")
    public void amazonTesti() {
        System.out.println("Amazon testi passed");
    }

    @Test
    public void testOtomasyonuTesti() {
        //Assert.assertTrue(false);
        System.out.println("Test Otomasyonu testi passed");
    }

    @Test(dependsOnMethods = "amazonTesti")
    public void wiseQuarterTesti() {
        System.out.println("Wise Quarter testi passed");
    }
}
    git init
    git add .
        git commit -m "ilk ders"
        git remote add origin https://github.com/KevserY/TestNG.git
        git push