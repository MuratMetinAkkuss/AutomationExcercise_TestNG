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

    }
    private static WebDriver driver;
    public static WebDriver getDriver(){
        /*
            Bundan sonra daha once driver olarak
            TestBase'den alip kullandigimiz
            WebDriver'in yerine

            Driver class'indan getDriver method'unu kullanacagiz
            ANCAK
            mahserin 4 atlisinda kullandigimiz

            driver = new ChromeDriver();
            problem olusturuyor

            CUNKU her calisitiginda yeniden bir WebDriver olusturuyor.

            Bizim istedigimiz su :

            Ben testimi calistirmaya basladigimda ilk kez bu method'u
            kullaninca Chrome Driver olusturusun sonraki kullanimlarda
            olusturmasin

            BUNUN icin driver null kabul edip ona gore yeni driver atamasi
            yapiyoruzz

            null degerini if ile beraber kullaniyoruz.


         */

        /*
            isyerimizde calisiriken testlerimizi farkli browserlar ile calistirmamiz
            istenebilir.
            Dinamik olarak browser kullanabilmek icin
            configuration.properties dosyamizda browser = istenen browser
            seklinde browser'i tanimladik
            Driver class'imizda da configuration.properties'i dosyamizdaki
            bilgiyi okuyup istenen browser'i olusturacak bir yapi hazirlayalim

         */

        if (driver == null) {

            String browser = ConfigReader.getProperty("browser");

            switch (browser){

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
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }


        return driver;
    }

    public static void closeDriver(){
        if (driver != null) {
            driver.close();
            driver = null;
        }
    }
    public static void quitDriver(){
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
