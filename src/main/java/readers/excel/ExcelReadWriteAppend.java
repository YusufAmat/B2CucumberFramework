package readers.excel;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReadWriteAppend {

    FileInputStream fileInputStream;

    @Test
    public void readExcel() throws IOException {
        // okunacak excel dosyasi
        String file = "src/test/resources/datafiles/ExcelA.xlsx";

        // javanin dosyayi okumasi icin
        FileInputStream fileInputStream = new FileInputStream(file);

        // okunan dosya excel sayfasi olarak belirlendi
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        // Okunacak sayfa belirlendi
        Sheet sheet = workbook.getSheetAt(0);   // ilk sayfa acilir
        //Sheet sheet = workbook.getSheet("Sheet1");  // "Sheet1" sayfasi acilir


        // sheet icindeki olusturulmus row sayisini verir
        int lastRow = sheet.getPhysicalNumberOfRows();

        // sheet icindeki row okunur
        Row row = sheet.getRow(0);

        // row icindeki hücre sayisini verir
        int lastCell = row.getPhysicalNumberOfCells();

        // row icindeki cell okunur
        Cell cell = row.getCell(0);
        System.out.println(cell);

        cell = row.getCell(1);
        System.out.println(cell);

        cell = row.getCell(2);
        System.out.println(cell);

        workbook.close();
        fileInputStream.close();

    }


}
