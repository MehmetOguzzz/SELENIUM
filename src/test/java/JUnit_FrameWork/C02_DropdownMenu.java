package JUnit_FrameWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.sql.Driver;
import java.time.Duration;
import java.util.List;

public class C02_DropdownMenu {
    //● https://the-internet.herokuapp.com/dropdown adresine gidin.
    //	1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    //	2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    //	3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    //	4.Tüm dropdown değerleri(value) yazdırın
    //	5. Dropdown’un boyutunun 4 olduğunu test edin

    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/dropdown");

    }

    @After
    public void terndown() {
        //driver.close();

    }

    @Test
    public void dropDownTest() throws InterruptedException {
        //	1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın

        WebElement dropDownElementi = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select = new Select(dropDownElementi);
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());

        Thread.sleep(3000);
        //	2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın

        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());

        Thread.sleep(3000);

        //	3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());
        //	4.Tüm dropdown değerleri(value) yazdırın
        List<WebElement>optionsList=select.getOptions();
        for (WebElement eachElement:optionsList
             ) {
            System.out.println(eachElement.getText());
        }

        //	5. Dropdown’un boyutunun 4 olduğunu test edin
        int expectedBoyut=4;
        int actualBoyut=optionsList.size();
        Assert.assertEquals(expectedBoyut,actualBoyut);
        Thread.sleep(3000);
    }


}



