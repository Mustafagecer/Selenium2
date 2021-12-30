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

public class C04_CheckBox {
   // 1. Bir class oluşturun : CheckBoxTest
   // 2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
   WebDriver driver;


    @Before
    public void setup(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //a. Verilen web sayfasına gidin.
        //https://the-internet.herokuapp.com/checkboxes
        driver.get("https://the-internet.herokuapp.com/checkboxes");

    }
    // b. Checkbox1 ve checkbox2 elementlerini locate edin.
    // c. Checkbox1 seçili değilse onay kutusunu tıklayın
    @Test
    public void checkBox1(){
        WebElement checkBox1=driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
        if (checkBox1.isSelected()){
            System.out.println("checkBox1 is already selected");
        }else {
            System.out.println("checkBox1 was not selected");
            checkBox1.isSelected();
            System.out.println("checkBox1 has been selected");

        }
    }


    // d. Checkbox2 seçili değilse onay kutusunu tıklayın
    @Test
    public void checkBox2(){
        WebElement checkBox2=driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
        if (checkBox2.isSelected()){
            System.out.println("checkBox2 is already selected");
        }else {
            System.out.println("checkBox2 was not selected");
            System.out.println(checkBox2.isSelected()+"checkBox1 has been selected");

        }
    }
    @After
    public void tearDown(){
        driver.close();
    }
}
