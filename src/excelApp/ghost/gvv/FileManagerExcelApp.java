package excelApp.ghost.gvv;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;

import static excelApp.ghost.gvv.JavaApp.row;

public class FileManagerExcelApp
{
    public static void run() throws IOException {

        // Read XSL file
        FileInputStream inputStream = new FileInputStream(
                new File("D:/JavaFiles/Excelprobe1/Data.xls"));

        // Get the workbook instance for XLS file
        HSSFWorkbook workbook = new HSSFWorkbook(inputStream);

        // Get first sheet from the workbook
        HSSFSheet sheet = workbook.getSheetAt(0);

        // Get iterator to all the rows in current sheet
        Iterator<Row> rowIterator = sheet.iterator();

        int count = 0;
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            // Get iterator to all cells of current row
            Iterator<Cell> cellIterator = row.cellIterator();
            String[] strings = new String[5];

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();

                // Change to getCellType() if using POI 4.x
                CellType cellType = cell.getCellTypeEnum();

                switch (cellType) {
                    case _NONE:
                        strings[count] = "";
                        break;
                    case BOOLEAN:
                        strings[count] = String.valueOf(cell.getBooleanCellValue());
                        break;
                    case BLANK:
                        strings[count] = "";
                        break;
                    case FORMULA:
                        FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
                        strings[count] = cell.getCellFormula() + String.valueOf(evaluator.evaluate(cell).getNumberValue());
                        break;
                    case NUMERIC:
                        strings[count] = String.valueOf(cell.getNumericCellValue());
                        break;
                    case STRING:
                        strings[count] = cell.getStringCellValue();
                        break;
                    case ERROR:
                        strings[count] = "!";
                        break;
                }
                count++;
            }
            count = 0;
            new CableDAO(
                    strings[1],
                    "",
                    strings[0],
                    "",
                    "",
                    ""
            );
            /*
            for (String s: strings)
            {
                System.out.print(s + "  ");
            }
            System.out.println();
            */
        }
    }
}
