package JUnit_FrameWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_testNotasyonu {

    /*
       Bu class icerisinde 3 test calistiralim
       1- google anasayfaya gidip, url'in google icerdigini test edin
       2- wisequarter anasayfaya gidip url'in wisequarter icerdigini test edin
       3- amazon anasayfaya gidip, amazon logosunun gorundugunu test edin
    */
    WebDriver driver;

    @Test
    public void alibabaTest() throws InterruptedException {
        //1- alibaba anasayfaya gidip, url'in alibaba icerdigini test edin

        mahserin4atlisi();

        driver.get("https://www.alibaba.com");

        String expectedIcerik = "alibaba";

        String actualIcerik = driver.getCurrentUrl();

        if (actualIcerik.contains(expectedIcerik)) {
            System.out.println("alibaba testi , PASSEd");
        } else {
            System.out.println("url alibaba içermiyor, alibaba testi FAILED");
        }
        Thread.sleep(2000);
        driver.close();


    }

    @Test
    public void binanceTest() {
        //2- binance anasayfaya gidip url'in wisequarter icerdigini test edin

        mahserin4atlisi();

        driver.get("https://www.binance.com");

        String expectedIcerik = "binance";

        String actualIcerik = driver.getCurrentUrl();

        if (actualIcerik.contains(expectedIcerik)) {

            System.out.println("binance testi , PASSEd");
        } else {
            System.out.println("url binance içermiyor, binance testi FAILED");
        }
        driver.close();
    }

    @Test
    public void amazonTest() {
        //3- amazon anasayfaya gidip, amazon logosunun gorundugunu test edin
        mahserin4atlisi();
        driver.get("https://www.amazon.com");
        WebElement amazonLogoElementi = driver.findElement(By.xpath("//*[@id=\"nav-logo-sprites\"]"));
        if (amazonLogoElementi.isDisplayed()) {
            System.out.println("amazon logo testi PASSED");
        } else {
            System.out.println("amazon logosu görünmüyor test FAILED");
        }
        driver.close();


    }

    public void mahserin4atlisi() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


}
