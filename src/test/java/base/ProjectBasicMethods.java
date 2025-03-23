package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import utils.Utility;

import java.io.IOException;

public class ProjectBasicMethods extends Utility {

	@BeforeMethod
	public void launchBrowser() throws IOException {
		browserLaunch();
	}

	@AfterMethod
	public void browserClose() {
		closeBrowser();
	}

	@DataProvider(name = "readData")
	public String[][] readData() throws IOException {
		String[][] data = readExcel(sheetname);
		return data;
	}
}
