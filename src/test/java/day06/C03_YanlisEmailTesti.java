package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C03_YanlisEmailTesti {
    //Bir Class olusturalim YanlisEmailTesti
    //http://automationpractice.com/index.php sayfasina gidelim
    //Sign in butonuna basalim
    //Email kutusuna @isareti olmayan bir mail yazip enter’a bastigimizda
    //    “Invalid email address” uyarisi ciktigini test edelim



    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");
    }
    @Ignore
    public void signIn(){

        driver.findElement(By.xpath("//*[@class='login']")).click();

    }
    @Test
    public void emailTest() throws InterruptedException {
        driver.findElement(By.xpath("//*[@class='login']")).click();
        WebElement emailBox=driver.findElement(By.xpath("(//*[@type='text'])[2]"));
        WebElement sitedekiUyari=driver.findElement(By.xpath("//*[@id='create_account_error']"));
        emailBox.sendKeys("aliveli"+ Keys.ENTER);

        Thread.sleep(3000);

        Assert.assertTrue("Mesaj gorunmedi",sitedekiUyari.isDisplayed());

    }

}
