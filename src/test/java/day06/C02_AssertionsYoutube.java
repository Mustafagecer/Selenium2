package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C02_AssertionsYoutube {
    //1) Bir class oluşturun: YoutubeAssertions
    //2) https://www.youtube.com adresine gidin
    //3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin



    //	○ wrongTitleTest	=> Sayfa basliginin “youtube” olmadigini dogrulayin

    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.youtube.com/");
        driver.findElement(By.xpath("//*[text()='I Agree']")).click();

        }
    //	○ titleTest 	=> Sayfa başlığının “YouTube” oldugunu test edin
    @Test
    public void dogruBaslikTesti(){
        Assert.assertEquals("YouTube",driver.getTitle());
    }
    //	○ imageTest 	=> YouTube resminin görüntülendiğini (isDisplayed()) test edin
    @Test
    public void YoutubeLogo(){
        Assert.assertTrue("Logo yok",driver.findElement(By.xpath("//*[@id='logo-icon'][1]")).isDisplayed());
    }

    //	 ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())

    @Test
    public void searchBoxEnable(){
        Assert.assertTrue("Search box is not enable",
                driver.findElement(By.xpath("(//*[@id='search'])[1]")).isEnabled());
    }


    //	○ wrongTitleTest	=> Sayfa basliginin “youtube” olmadigini dogrulayin

    @Test
    public void yanlisBaslikTesti(){
        Assert.assertNotEquals("youtube",driver.getTitle());
    }






    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }

    }
