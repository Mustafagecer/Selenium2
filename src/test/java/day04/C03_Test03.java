package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C03_Test03 {
    public static void main(String[] args) {
//        	1. “https://www.saucedemo.com” Adresine gidin
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
//
//        	2. Username kutusuna “standard_user” yazdirin
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
//
//        	3. Password kutusuna “secret_sauce” yazdirin
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

//        	4. Login tusuna basin
        driver.findElement(By.id("login-button")).click();
//        	5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement ilkUrun=driver.findElement(By.id("item_4_title_link"));
        String ilkUrununadi=ilkUrun.getText();
        System.out.println(ilkUrun.getText());
        ilkUrun.click();

//        	6. Add to Cart butonuna basin
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

//        	7. Alisveris sepetine tiklayin

        driver.findElement(By.id("shopping_cart_container")).click();
//        	8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        WebElement sepettekiUrun=driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div"));

        if (ilkUrununadi.equals(sepettekiUrun.getText())){
            System.out.println("Secilen urun ile sepetteki urun ayni");
        }else {
            System.out.println("Secilen urun ile sepetteki urun ayni degil");
            System.out.println("Secilen urun"+ilkUrun+ " sepetteki urun "+sepettekiUrun);
        }

//        	9. Sayfayi kapatin
        driver.close();
    }
}
