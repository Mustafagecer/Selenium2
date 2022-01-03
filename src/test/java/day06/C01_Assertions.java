package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C01_Assertions {
    //1) Bir class oluşturun: BestBuyAssertions
    //2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak
    // asagidaki testleri yapin
    //		○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
    //		○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    //		○ logoTest => BestBuy logosunun görüntülendigini test edin
    //		○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

    static WebDriver driver;
    @BeforeClass
    public static void setup(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
    driver.manage().window().maximize();
    driver.get("https://www.bestbuy.com/");

}

    @Test
    public void urlCheck(){
        Assert.assertEquals("Istenen Url bulunamadi","https://www.bestbuy.com/",driver.getCurrentUrl());
    }

    @Test
    public void titleTest(){
        Assert.assertFalse("Istenmeyen kelime title da var",driver.getTitle().contains("Rest"));
        //Baslikta Rest olmadigi icin Test passed verdi

    }
   // @Test
   //    public void titleTest2() {
   //        Assert.assertFalse("Istenmeyen kelime title da var", driver.getTitle().contains("Best"));
   //        //Baslikta Best oldugu icin Test failed verdi
   //    }

    @Test
    public void logoTesti(){
        Assert.assertTrue("Logo goruntelenemedi",driver.findElement(By.xpath("(//*[@class='logo'])[1]")).isDisplayed());
    }
    @Test
    public void fransizcaLinTesti(){
        Assert.assertTrue("Fransizca dil secenegi yok",driver.findElement(By.xpath("(//*[@lang='fr'])[1]")).isDisplayed());

    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }

}
