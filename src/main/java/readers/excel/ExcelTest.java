package readers.excel;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelTest {

    String file;
    FileInputStream fileInputStream;
    Workbook workbook;
    Sheet sheet;

    @Test
    public void read1() throws IOException {
        file = "src/test/resources/datafiles/ExcelB.xlsx";
        fileInputStream = new FileInputStream(file);
        workbook = WorkbookFactory.create(fileInputStream);
        sheet = workbook.getSheetAt(0);

        int numRows = sheet.getPhysicalNumberOfRows();
        for (int i = 0; i < numRows; i++) {
            Row row = sheet.getRow(i);

            int numCells = row.getPhysicalNumberOfCells();

            for (int j = 0; j < numCells; j++) {
                Cell cell = row.getCell(j);
                System.out.print(cell + "\t");
            }
            System.out.println();
        }

        workbook.close();
        fileInputStream.close();

    }
}
