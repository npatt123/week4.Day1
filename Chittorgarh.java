package week4.Day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Chittorgarh {
	
	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));		
		driver.get("https://www.chittorgarh.com/");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		//click on stock market
		driver.findElement(By.id("navbtn_stockmarket")).click();
		//Click on NSE bulk Deals
		driver.findElement(By.xpath("(//a[text()='NSE Bulk Deals'])[1]")).click();
		//Get the table
		WebElement table = driver.findElement(By.xpath("//table[@class ='table table-bordered table-condensed table-striped']"));
		//Get rows from the table
		List <WebElement> rows = table.findElements(By.tagName("tr"));
		int rowSize = rows.size();
		System.out.println(rowSize);
		//Get the cols from rows
		List <WebElement> cols = table.findElements(By.tagName("th"));
		int ColSize = cols.size();
		System.out.println(ColSize);
		
		//Creating a empty list
		List<String> list = new ArrayList<String>();
		//Get all the security names
		for(int i =1; i < rowSize; i++) {
			
			WebElement rowsCols = driver.findElement(By.xpath("//table[@class = 'table table-bordered table-condensed table-striped']//tr["  + (i)  +  "]//td[3]"));
			Thread.sleep(40000);
			list.add(rowsCols.getText());
			
						
		}
		System.out.print(list);
		
		//Ensure whether there are duplicate Security names - remove duplicates
		Set<String> noDuplicate1 = new HashSet<String>(list);
		System.out.println(noDuplicate1);
		
		
		Set<String> noDuplicate = new HashSet<String>();
		
		for(String eachValue : list) {
			
			boolean add = noDuplicate.add(eachValue);
			
			if(add != true) {
				
				System.out.println("Duplicate Security name: " + eachValue );
			}
			else {
				System.out.println("unique Security name: " + eachValue );
			}
		}
			
}


}
