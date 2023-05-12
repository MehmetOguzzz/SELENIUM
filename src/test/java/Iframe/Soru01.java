package Iframe;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Soru01 extends TestBase {
            /*
            1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
            2) sayfadaki iframe sayısını bulunuz.
            3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
            4) ilk iframe'den çıkıp ana sayfaya dönünüz
            5) ikinci iframe'deki (Jmeter Made Easy) linke
            (https://www.guru99.com/live-selenium-project.html) tıklayını
             */

    @Test
    public void Test01() throws InterruptedException {

        //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz

        driver.get("http://demo.guru99.com/test/guru99home/");

        //2) sayfadaki iframe sayısını bulunuz.

        WebElement iframeSayisi= driver.findElement(By.tagName("iframe"));

        System.out.println(iframeSayisi.getText());

        driver.switchTo().frame(0);

        //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.

        driver.findElement(By.xpath("//a[@class='ytp-impression-link']")).click();

        Thread.sleep(2000);

    }

}
