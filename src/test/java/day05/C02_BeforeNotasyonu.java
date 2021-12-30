package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C02_BeforeNotasyonu {
    //amazon sayfasina gidip 3 farkli test methodu hazirlayin
    //her methodda farkli aramalar yap

    static WebDriver driver;
    //Methodlarin hepsinde driver a ulasmamiz icin burada static driver olusturduk


    @BeforeClass //BeforeClass mutlaka static olmalidir
    public static void setup() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();


        }
        @Test
        public void amazonTest () {
        driver.get("https://www.amazon.com/");
        System.out.println(driver.getTitle());
        }
        @Test
        public void techproedTest () {
            driver.get("https://www.techproed.com/");
            System.out.println(driver.getTitle());

        }
        @Test
        public void facebookTest () {
            driver.get("https://www.facebook.com/");
            System.out.println(driver.getTitle());

        }

        @AfterClass
        public static void tearDown () {
            driver.close();
        }

    }