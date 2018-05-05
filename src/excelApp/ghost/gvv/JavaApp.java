package excelApp.ghost.gvv;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class JavaApp
{
    JavaApp() throws IOException
    {
        fileManagerEA = new FileManagerExcelApp();
        workbook = new HSSFWorkbook();
        sheet = workbook.createSheet("Employees sheet");
        list = CableDAO.getListCables();
        rownum = 0;
        style = createStyleForTitle(workbook);
        row = sheet.createRow(rownum);
    }

    private static HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook)
    {
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        HSSFCellStyle style = workbook.createCellStyle();
        return style;
    }

    public static void run() throws IOException {
        createTableHeader();
        //...
        generateCableList();
        writeCableList();
        mergeTableHeaderCells();
        writeToTheFile();
    }

    private static void writeToTheFile() throws IOException
    {
        File file = new File("D:/JavaLib/CablesJ.xls");
        file.getParentFile().mkdirs();
        FileOutputStream outFile = new FileOutputStream(file);
        workbook.write(outFile);
        System.out.println("Created file: " + file.getAbsolutePath());
    }

    private static void createTableHeader()
    {
        int count = 0;
        for(int[] n : tableHeaderCellsIndex)
        {
            for(int s : n)
            {
                cell = row.createCell(s, CellType.STRING);
                cell.setCellValue(headerTableCells[count]);
                cell.setCellStyle(style);
                count++;
            }
            rownum++;
            row = sheet.createRow(rownum);
        }
        rowStart = rownum;
    }

    private static void generateCableList() throws IOException {
        fileManagerEA.run();
    }

    private static void writeCableList()
    {
        for(Cable cable : list)
        {
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue(cable.getCableDesignation());
            System.out.print(cable.getCableDesignation() + " ");

            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue(cable.getStartPoint());
            System.out.print(cable.getStartPoint() + " ");

            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue(cable.getEndPoint());
            System.out.print(cable.getEndPoint() + " ");

            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue(cable.getCableBrand());
            System.out.print(cable.getCableBrand() + " ");

            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue(cable.getNumberAndSelectionsOfCores());
            System.out.print(cable.getNumberAndSelectionsOfCores() + " ");

            cell = row.createCell(5, CellType.NUMERIC);
            cell.setCellValue(cable.getCableLength());
            System.out.print(cable.getCableLength() + " ");

            System.out.println();

            rownum++;
            row = sheet.createRow(rownum);
        }
    }

    private static void mergeCells()
    {
        sheet.addMergedRegion
        (new CellRangeAddress
                (
                        mergeCellRegionIndex[0][0],
                        mergeCellRegionIndex[0][1],
                        mergeCellRegionIndex[0][2],
                        mergeCellRegionIndex[0][3]
                )
        );
    }

    private static void mergeTableHeaderCells()
    {
        for(int i = 0; i < mergeCellRegionIndex.length; i++)
        {
            sheet.addMergedRegion
            (new CellRangeAddress
                (
                    mergeCellRegionIndex[i][0],
                    mergeCellRegionIndex[i][1],
                    mergeCellRegionIndex[i][2],
                    mergeCellRegionIndex[i][3]
                )
            );
        }
    }


    static HSSFCellStyle style;
    static HSSFWorkbook workbook;
    static HSSFSheet sheet;
    static List<Cable> list;
    private static int rownum;
    static Cell cell;
    static Row row;
    static FileManagerExcelApp fileManagerEA;

    static int rowStart = 0;

    private final static int[][] mergeCellRegionIndex = {
            {0, 2, 0, 0},
            {0, 0, 1, 2},
            {0, 0, 3, 8},
            {1, 2, 1, 1},
            {1, 2, 2, 2},
            {1, 1, 3, 5},
            {1, 1, 6, 8},
    };

    private final static int[][] tableHeaderCellsIndex = {
            {0, 1, 3},
            {1, 2, 3, 6},
            {3, 4, 5, 6, 7, 8},
    };

    private final static String[] headerTableCells = {
            "Позначення кабеля, провода",
            "Трасса",
            "Кабель, проводів",
            "Початок",
            "Кінець",
            "по проекту",
            "прокладено",
            "Марка",
            "Кількість кабелів та переріз жил",
            "Довжина, м",
            "Марка",
            "Кількість кабелів та переріз жил",
            "Довжина, м",
    };
}