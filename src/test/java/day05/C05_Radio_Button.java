package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C05_Radio_Button {

    //1. Bir class oluşturun : RadioButtonTest
    //2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.

    WebDriver driver;


    @Before
    public void setup() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @Test
    public void radioBox() throws InterruptedException {
        //- https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");

        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[.='Allow All Cookies']")).click();



        //- “Create an Account” button’una basin
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

        //- “radio buttons” elementlerini locate edin
        //- Secili degilse cinsiyet butonundan size uygun olani secin
        driver.findElement(By.xpath("(//*[@class='_8esa'])[2]")).click();
        System.out.println("Cinsiyet erkek secildi");


    }
    @After
    public void tearDown(){
        driver.close();
    }

}
