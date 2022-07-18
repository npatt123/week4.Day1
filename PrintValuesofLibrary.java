package week4.Day1;

import java.time.Duration;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrintValuesofLibrary {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://html.com/tags/table/");

		String libraryName = "Absolute Usage";

		WebElement table = driver.findElement(By.xpath("//div[@class='render']//table[1]"));
		Thread.sleep(30000);
		List<WebElement> tableHeader = table.findElements(By.tagName("th"));
		Thread.sleep(30000);
		List<WebElement> tableRow = table.findElements(By.tagName("tr"));
		Thread.sleep(30000);

		List<String> headerValues = new ArrayList<String>();
		List<String> rowColValues = new ArrayList<String>();

		// To get the table header into list
		for (int i = 0; i < tableHeader.size(); i++) {
			headerValues.add(tableHeader.get(i).getText());

		}

		// To get the row values and add it to the list
		for (int i1 = 1; i1 < tableRow.size(); i1++) {
			WebElement rowsOrder = tableRow.get(i1);
			List<WebElement> tableCol = rowsOrder.findElements(By.tagName("td"));
			for (int j = 1; j < tableCol.size(); j++) {
				if (tableCol.get(0).getText().equalsIgnoreCase(libraryName)) {
					rowColValues.add(tableCol.get(j).getText());
				}
			}
		}

		// To add the key and value

		LinkedHashMap<String, String> keyValue = new LinkedHashMap<String, String>(); 
		System.out.println("The values for the library " + libraryName + " are " + keyValue);

	}

}
