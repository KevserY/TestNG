package test.day15_configuration_driver_Kullanimi;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Collection;

public class C05_SingletonPattern {

    @Test
    public void test01() {
        /*  SINGLETON PATTERN, bir class'dan obje oluşturulmasını önlemek için kullanılan yöntemlerden biridir.

            SINGLETON PATTERN kullanmak için obje oluşturulmasını engellemek istediğimiz class'da
            görünür bir constructor oluşturur ve bu constructor'ın access modifier'ını PRIVATE yaparız.

        Driver driver = new Driver();
        driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        ReusableMethods.bekle(5);
        driver.closeDriver();

         */
    }
}
