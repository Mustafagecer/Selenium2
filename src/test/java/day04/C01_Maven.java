package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class C01_Maven {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("https://www.amazon.com/");



        WebElement search=driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));
        search.sendKeys("Samsung headphones"+ Keys.ENTER);


       // WebElement sonucYazisiElemeti=driver.findElement(By.className("sg-col-inner"));
        //yukaridakinde bulamama ihtimali var
        WebElement sonucYazisiElemeti=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonucYazisiElemeti.getText());

        //Cikan ilk sonuca gitmek icin Relativ xpath yadigimizda karsimiza azni sonuctan 22 tane cikiyor
        //yani //span[@class='a-size-medium a-color-base a-text-normal'] bundan 22 tane var.
        //ilkini secmek icin bunu parantez icine alip en sonunanada koseli parantez icinde 1 yazmaliyiz
        //yani (//span[@class='a-size-medium a-color-base a-text-normal'])[1]

        WebElement ilkUrunElementi=driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]"));
        System.out.println("Cikan ilk urun: "+ilkUrunElementi.getText());
        ilkUrunElementi.click();

        //Sayfadaki tum basliklari yazdiralim
        //Bu yapmak icin biraz once cikan 22 sinifi buraya eklemeliyiz

        driver.navigate().back();

        List<WebElement> baslikElementleri=driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));

        int cikanUrunler=1;
        for (WebElement w:baslikElementleri
             ) {
            System.out.println(cikanUrunler+": "+w.getText());
            cikanUrunler++;

        }



        driver.close();

    }
}
