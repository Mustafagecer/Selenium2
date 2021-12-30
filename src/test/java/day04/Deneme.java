package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Deneme {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.techproeducation.com");

        driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[2]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//*[@class='course-card-thumb'])[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"__next\"]/section[1]/div/div[2]/div[1]/div/div[1]/a/img")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/section[1]/div/div/div[1]/div/div/div[2]/div[2]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@type='email']")).sendKeys("alimalikali@yandex.com");
        driver.findElement(By.xpath("(//*[@class='appsMaterialWizToggleRadiogroupOffRadio exportOuterCircle'])[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//*[@class='appsMaterialWizToggleRadiogroupOffRadio exportOuterCircle'])[2]")).click();
        Thread.sleep(2000);





        Thread.sleep(5000);
        driver.close();

    }
}
