package test.day16_softAssertion_xmlFiles;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_Softassertion {
    @Test
    public void softAssertionTesti() {
        /*
               TestNG çoklu assertion içeren testlerde 2 alternatif sunuyor:

               1-

               soft assert objesi oluştur.
               tüm aseertion ları soft assertion objesi kullanarak yap
               assertionlar bitince "assertAll" ile raporla
         */

        // test otomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        SoftAssert softAssert = new SoftAssert();
        // bütün assertler SOFTASSERT olacak!!!
        // önce bir softassert objesi oluşturulur.






    }
}
