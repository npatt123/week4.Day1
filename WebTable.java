package week4.Day1;

import java.time.Duration;
import java.time.temporal.TemporalAmount;
import java.util.ArrayList;
import java.util.List;

import org.apache.xmlbeans.impl.soap.Text;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable {
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get("http://www.leafground.com/pages/table.html");

		// Getting the table from the web page
		WebElement elementTable = driver.findElement(By.tagName("table"));
		// Creating an empty list
		// List<String> list = new ArrayList<String>();
		// Getting the rows from the table
		List<WebElement> rows = elementTable.findElements(By.tagName("tr"));
		int rowsize = rows.size();
		// Getting Columns head count
		List<WebElement> cols = elementTable.findElements(By.tagName("th"));
		int colsize = cols.size();
		int count = 0;
		int leastcount =0;

		System.out.println("Number of Rows :" + rowsize);
		System.out.println("Number of Columns :" + colsize);

		// Get the progress value of 'Learn to interact with Elements'
		for (int i = 1; i < rows.size(); i++) {
			String text = rows.get(i).getText();
			if (text.contains("Elements")) {
				String textPercent = text.replaceAll("\\D", "");
				int percent = Integer.parseInt(textPercent);
				System.out.println("The progress value of 'Learn to interact with Elements'  : " + percent + "%");
			}

		}
		//Check the vital task for the least completed progress.
		
		for(int i1 = 1; i1 < rows.size(); i1++) {			
						
				WebElement rowCol = driver.findElement(By.xpath("//table//tr[" + (i1 + 1) + "]//td[2]"));			
				String valueText = rowCol.getText();	
				String temp = valueText.replaceAll("\\D", "");
				int percent = Integer.parseInt(temp);				
				//finding the least percent
				if(percent < count) {
					
					count = percent;
					leastcount = count;										
				}
				else {
					count = percent;				
					
				}				
									
		}
		for(int i2 = 1; i2 < rows.size(); i2++) {
			
			WebElement row1= driver.findElement(By.xpath("//table//tr[" + (i2 + 1) + "]"));
			String valueText = row1.getText();
			String temp = valueText.replaceAll("\\D", "");
			int percent = Integer.parseInt(temp);
			
			if (percent == leastcount) {
				
				driver.findElement(By.xpath("//table//tr[" + (i2 + 1) + "]//td[3]")).click();
				System.out.println("Least percentile value is selected");
			}
			
			
		}
	}


}

