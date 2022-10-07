package ExcelFileReading;//import java.util.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteInExcel {
    public static void main(String[] args) throws IOException {
        //Path of the Excel file
        String path = "src/relevel_testing/java/ExcelFileReading/test.xlsx";
        FileInputStream fs = new FileInputStream(path);
        Workbook wb = new XSSFWorkbook(fs);
        Sheet sheet1 = wb.getSheetAt(0);
        int lastRow = sheet1.getLastRowNum();
        for(int i=0; i<=lastRow; i++){
            Row row = sheet1.getRow(i);
            Cell cell = row.createCell(2);
            cell.setCellValue("WriteintoExcel");
        }
        FileOutputStream fos = new FileOutputStream(path);
        wb.write(fos);
        fos.close();
    }
}
