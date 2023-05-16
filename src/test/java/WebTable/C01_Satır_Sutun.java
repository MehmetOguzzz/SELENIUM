package WebTable;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class C01_Satır_Sutun extends TestBase {

        @Test
        public void test01() throws InterruptedException {
            //1."https://www.amazon.com" adresine gidin

            driver.get("https://amazon.com");

            //2.Sayfanin en altina inin

            Actions actions = new Actions(driver);

            actions.sendKeys(Keys.END).perform();

            //3.Web table tum body’sini yazdirin

            Thread.sleep(5000);

            WebElement tumTableElement = driver.findElement(By.tagName("tbody"));

            System.out.println(tumTableElement.getText());

            // tum Body'yi tek element olarak locate etmek
            // body icinde gecen bir metnin varligini test etmek gibi gorevler icin kullanilabilir

            //4.Web table’daki satir sayisinin 9 oldugunu test edin

            List<WebElement> satirSayisiList = driver.findElements(By.xpath("//tbody/tr"));

            int expectedSatirSayisi = 9;

            int actualSatirSayisi = satirSayisiList.size();

            Assert.assertEquals(expectedSatirSayisi, actualSatirSayisi);

            //5.Tum satirlari yazdirin

            System.out.println("==============");

            for (WebElement eachList : satirSayisiList
            ) {
                System.out.println(eachList.getText());

                System.out.println("===================");
            }
            //6. Web table’daki sutun sayisinin 13 olduğunu test edin

            List<WebElement> sutunList = driver.findElements(By.xpath("//tbody/tr[1]/td"));

            int expectedSutunSayisi = 13;

            int actualSutunSayisi = sutunList.size();

            Assert.assertEquals(expectedSutunSayisi, actualSutunSayisi);

            //7. 5.sutunu yazdirin

            System.out.println("=================");

            List<WebElement> besinciSutunElementleri =
                    driver.findElements(By.xpath("//tbody/tr/td[5]"));

            for (WebElement eachListBesinciSutun : besinciSutunElementleri
            ) {
                System.out.println(eachListBesinciSutun.getText());
            }

            //8.Satir ve sutun sayisini parametre olarak alip,
            //  hucredeki bilgiyi döndüren bir method olusturun

            System.out.println("................................");
            System.out.println(dataGetir(1,9));
        }

        private String dataGetir(int satirNo, int sutunNo) {

        // //tbody/tr[5]/td[9]

        String dinamikXpath = "//tbody/tr["+satirNo+"]/td["+sutunNo+"]";

        WebElement istenenDataElementi= driver.findElement(By.xpath(dinamikXpath));

        return istenenDataElementi.getText();


        }



}
