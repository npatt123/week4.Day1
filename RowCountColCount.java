package week4.Day1;

import java.util.List;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RowCountColCount {
	
	public static void main(String[] args) {
		//setup driver
		WebDriverManager.chromedriver().setup();
		//create object for chromedriver
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//launch the url
		driver.get("https://html.com/tags/table/");
		
		//Get the table count
		
		List <WebElement> table = driver.findElements(By.xpath("//table"));
		int tableCount = table.size();
		int totalRowCount = 0, totalColCount =0;
		
		
		//Get the rows count of both the tables
		
		for(int i=1; i <= tableCount; i++ ) {
			
			List <WebElement> row= driver.findElements(By.xpath("//table[" + i + "]//tr"));
			int rowCount = row.size();		
			totalRowCount = totalRowCount+ rowCount;
			
		}
		System.out.println("Total row count : " +totalRowCount );
		
		
		//Get the col count of both the tables
		
		
		for(int i=1; i <= tableCount; i++ ) {
			
			List <WebElement> col= driver.findElements(By.xpath("//table[" + i + "]//th"));
			int colCount = col.size();		
			totalColCount = totalColCount+ colCount;
			
		}
		System.out.println("Total column count : " +totalColCount );
		
		
		
		
		
		
		
	}

}
