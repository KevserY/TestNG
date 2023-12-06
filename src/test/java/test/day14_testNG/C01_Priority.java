package test.day14_testNG;

import org.testng.annotations.Test;

import java.lang.annotation.Target;

public class C01_Priority {
    /*
            TestNG, test method'larını default olarak,
            natural order ile çalıştırır.(harf sırası vs.)

            Ama testlerimizi istediğimiz sırada çalıştırmak istersek,
            priority ile sıralama yapabiliriz.

            - Priority değeri küçük olan önce çalışır
            - Priority değeri aynı olanlar, natural order'a göre çalışır.
            - Herhangi bir method'a priority atamazsak, priority değeri default olarak sıfır olur.
     */
    @Test()
    public void amazonTesti() {
        System.out.println("Amazon testi PASSED");
    }
    @Test (priority =10)
    public void testOtomasyonuTesti() {
        System.out.println("Test Otomasyonu testi PASSED");
    }
    @Test(priority = 5)
    public void wiseQuarterTesti() {
        System.out.println("Wise Quarter testi PASSED");
    }
}
