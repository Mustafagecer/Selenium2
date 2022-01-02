package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Exercise02 {

     static WebDriver driver;


    @BeforeClass
    public static void setup() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }
    @Test
    public void shopping(){
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.xpath("(//*[@class='inventory_item_name'])[3]")).click();
        System.out.println(driver.findElement(By.xpath("//*[@class='inventory_details_price']")).getText());

        WebElement alianacakUrun= driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
        alianacakUrun.click();



    }

    @AfterClass
    public static void close(){
        driver.close();

    }

}
