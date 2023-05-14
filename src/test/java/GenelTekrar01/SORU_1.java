package GenelTekrar01;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class SORU_1 extends TestBase {
    // Test01 :
    // amazon gidin
    // Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
    // dropdown menude 40 eleman olduğunu doğrulayın

    // Test02
    // dropdown menuden elektronik bölümü seçin
    // arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
    //  sonuc sayisi bildiren yazinin iphone icerdigini test edin
    // ikinci ürüne relative locater kullanarak tıklayin
    // ürünün title'ni ve fiyatını variable’a	assign edip ürünü sepete ekleyelim

    //Test03
    //yeni bir sekme açarak amazon anasayfaya gidin
    //dropdown’dan bebek bölümüne secin
    //bebek puset aratıp bulundan sonuç sayısını yazdırın
    //sonuç yazsının puset içerdiğini test edin
    //üçüncü ürüne relative locater kullanarak tıklayin
    //title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin

    // Test 4
    //sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın

    @Test
    public void test01() throws InterruptedException {
        // amazon gidin
        driver.get("https://amazon.com");

        // Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın

        WebElement dropDownElementi = driver.findElement(By.id("searchDropdownBox"));

        Select slct = new Select(dropDownElementi);

        List<WebElement> dropDownElementList = slct.getOptions();

        System.out.println("DropDown Elementleri : " +
                "\n===================");
        for (WebElement eachDrop : dropDownElementList) {

            System.out.println(eachDrop.getText());
        }
        System.out.println("==============================");

        // dropdown menude 40 eleman olduğunu doğrulayın

        int expectedElementSayisi = 40;

        int actualElementSayisi = dropDownElementList.size();

        Assert.assertEquals(expectedElementSayisi, actualElementSayisi);

        // dropdown menuden elektronik bölümü seçin

        slct.selectByVisibleText("Elektronics");

        Thread.sleep(1500);

        // arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

        searchBox.sendKeys("iphone"+ Keys.ENTER);

        Thread.sleep(1500);

        WebElement searchResult = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));

        System.out.println(searchResult.getText());

        //  sonuc sayisi bildiren yazinin iphone icerdigini test edin

        String expectedText = "iphone";

        String actualText = searchResult.getText();

        Assert.assertTrue(actualText.contains(expectedText));

        // ikinci ürüne relative locater kullanarak tıklayin

        WebElement firstProduct = driver.findElement(By.xpath("(//*[@class='s-image'])[1]"));

        WebElement secondProduct = driver.findElement(with(By.tagName("img")).toRightOf(firstProduct));

        secondProduct.click();

        Thread.sleep(1500);

        // ürünün title'ni ve fiyatını variable’a	assign edip ürünü sepete ekleyelim

        String secondProductTitle = driver.getTitle();

        String secondProductPrice = driver.findElement(By.xpath("//*[@class='a-section a-spacing-micro']")).getText();

        driver.findElement(By.id("add-to-cart-button")).click();

        Thread.sleep(2000);

        //yeni bir sekme açarak amazon anasayfaya gidin

        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://amazon.com");

        Thread.sleep(1000);

        //dropdown’dan bebek bölümüne secin

        slct.selectByVisibleText("Baby");

        Thread.sleep(1000);

        //bebek puset aratıp bulundan sonuç sayısını yazdırın

        searchBox.sendKeys("baby stroller" + Keys.ENTER);

        WebElement searchResultt = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));

        System.out.println(searchResultt.getText());

        //sonuç yazsının puset içerdiğini test edin

         expectedText = "stroller";

         actualText = searchResult.getText();

        Assert.assertTrue(actualText.contains(expectedText));

        //üçüncü ürüne relative locater kullanarak tıklayin

        WebElement secondProductt = driver.findElement(By.xpath("(//*[@class='s-image'])[2]"));

        WebElement thirdProductt = driver.findElement(with(By.tagName("img")).below(secondProduct));

        thirdProductt.click();

        Thread.sleep(1000);

        //title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin

        String thirdProductTitle = driver.getTitle();

        String thirdProductPrice = driver.findElement(By.xpath("//*[@class='a-section a-spacing-micro']")).getText();

        driver.findElement(By.id("add-to-cart-button")).click();

        Thread.sleep(2000);

//sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın

        WebElement goToCartElementi = driver.findElement(By.linkText("Go to Cart"));
        Thread.sleep(1000);


        WebElement firstProductPrice = driver.findElement(By.xpath("(//p[@class='a-spacing-mini'])[1]"));

        WebElement secondProductPricee = driver.findElement(By.xpath("(//p[@class='a-spacing-mini'])[2]"));

        WebElement firstProductTitle = driver.findElement(By.xpath("(//span[@class='a-truncate-cut'])[1]"));

        WebElement secondProductTitlee = driver.findElement(By.xpath("(//span[@class='a-truncate-cut'])[2]"));




    }


    }

