package utils;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Utility {

    public static WebDriver driver;
    public static String sheetname;

    public void browserLaunch() throws IOException {
        driver = new ChromeDriver();
        driver.get("https://www.demoblaze.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void closeBrowser() {
        driver.quit();
    }

    public static String[][] readExcel(String sheetname) throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\Kupsi\\eclipse-workspace\\product-store\\data\\UserDetails.xlsx");
        try (XSSFWorkbook book = new XSSFWorkbook(fis)) {
            XSSFSheet sheet = book.getSheet(sheetname);
            if (sheet == null) {
                System.out.println("Sheet not found");
            }

            int rowcount = sheet.getLastRowNum();
            short columncount = sheet.getRow(0).getLastCellNum();

            String[][] data = new String[rowcount][columncount];

            for (int i = 1; i <= rowcount; i++) {
                XSSFRow row = sheet.getRow(i);
                if (row == null) continue;  

                for (int j = 0; j < columncount; j++) {
                    XSSFCell cell = row.getCell(j);
                    data[i - 1][j] = getCellValue(cell); 
                }
            }
            return data;
        }
    }

    public static String getCellValue(Cell cell) {
        if (cell == null) {
            return "";  // Avoid NullPointerException
        }
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString(); // Convert date to string
                } else {
                    return String.valueOf((long) cell.getNumericCellValue()); // Convert number to string
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            default:
                return "";
        }
    }
}
