package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C02_Test01 {
    public static void main(String[] args) throws InterruptedException {

//        1-Test01 isimli bir class olusturun
//        2- https://www.youtube.com/ adresine gidin

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("https://www.lidl.de/");
//        3- Browseri tam sayfa yapin
        driver.manage().window().maximize();


        Thread.sleep(3000);

//        4-Sayfayi “refresh” yapin
        driver.navigate().refresh();


//        5- Sayfa basliginin “Save” ifadesi icerdigini control edin
        if (driver.getTitle().contains("Save")){
            System.out.println("The title contains Save");
        }else{
            System.out.println("The title does not contain Save");
        }

//        6-Sayfa basliginin “Walmart.com | Save Money.Live Better” a esit
//        oldugunu control ediniz

        if (driver.getTitle().equals("Walmart.com | Save Money.Live Better")){
            System.out.println("The Title is Walmart.com | Save Money.Live Better");
        }else{
            System.out.println("The Title is not Walmart.com | Save Money.Live Better");
            System.out.println("Current Title is: "+driver.getTitle());
        }
//        7- URL in walmart.com icerdigini control edin

        if (driver.getCurrentUrl().contains("lidl.com")){
            System.out.println("The url is lidl.com");
        }else{
            System.out.println("The url does not contain lidl.com");
            System.out.println("Current url is: "+driver.getCurrentUrl());
        }

        WebElement searchElement=driver.findElement(By.xpath("//*[@id=\"s-search-input-field\"]"));
//        8-”notebook” icin arama yapiniz
        searchElement.sendKeys("notebook");
        searchElement.click();

        //9- Kac tane sonuc cikardigina bak
        WebElement numberOfResult=driver.findElement(By.xpath("//*[@id=\"s-main-container\"]/section/span"));

//        10- ilk sonuca tikla
        WebElement ilkUrun=driver.findElement(By.xpath("//*[@id=\"s-results\"]/li[1]/a/div[2]/div[2]/img"));
        System.out.println(ilkUrun.getText());
        ilkUrun.click();
        System.out.println("The Current Url is: "+driver.getCurrentUrl());

//        111-Sayfayi kapatin
        driver.close();
    }
}
