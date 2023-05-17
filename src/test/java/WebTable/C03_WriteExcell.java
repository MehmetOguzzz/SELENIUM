package WebTable;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C03_WriteExcell {
    @Test
    public void Test01() throws IOException {

        String dosyaYolu=System.getProperty("user.dir")+"/src/test/java/WebTable/ulkeler.xlsx";

        FileInputStream fis=new FileInputStream(dosyaYolu);

        Workbook workbook= WorkbookFactory.create(fis);

        Sheet sheet= workbook.getSheet("Sayfa1");

        //4) 4.hucreye yeni bir cell olusturalim
        //5) Olusturdugumuz hucreye “Nufus” yazdiralim

        sheet.getRow(0).createCell(4).setCellValue("Nufus");

        //6) 2.satir nufus kolonuna 1500000 yazdiralim

        sheet.getRow(1).getCell(4).setCellValue("1500000");

        //7) 10.satir nufus kolonuna 250000 yazdiralim

        sheet.getRow(9).getCell(4).setCellValue("2500000");

        //8) 15.satir nufus kolonuna 54000 yazdiralim

        sheet.getRow(14).getCell(4).setCellValue(54000);

        //9) Dosyayi kaydedelim

        FileOutputStream fos=new FileOutputStream(dosyaYolu);

        workbook.write(fos);

        fis.close();

        fos.close();

        workbook.close();


    }
}
