package week4.Day1;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.io.IOException;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.google.common.base.CharMatcher;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDeal {
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//Load the url
		driver.get("https://www.snapdeal.com/");
		Thread.sleep(9000);
		
		//Search for Training Shoes
		WebElement inputField = driver.findElement(By.xpath("//input[@id='inputValEnter']"));
		inputField.sendKeys("Training Shoes",Keys.ENTER);
		Thread.sleep(15000);
		
	     //Get the Count of the search results
		List<WebElement> inputField2 = driver.findElements(By.xpath("//p[contains(text(),'Shoes')]"));
		System.out.println("Count of Items displayed : " + inputField2.size());		
		
		//Click the sort arrow button
		WebElement inputField3 = driver.findElement(By.xpath("//i[@class ='sd-icon sd-icon-expand-arrow sort-arrow']"));
		Thread.sleep(20000);
		inputField3.click();
		
		//Choose the option LOW-HIGH
		WebElement inputField4 = driver.findElement(By.xpath("(//li[@class='search-li'])[2]"));
		Thread.sleep(20000);
		inputField4.click(); 
		
		Thread.sleep(20000);
		
		//Check if the items displayed are sorted correctly		
		List<WebElement> field5 = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		Thread.sleep(20000);
		List<Integer> priceList = new ArrayList <Integer>();
		
		for(WebElement eachprice : field5) {			
			
			String attribute = eachprice.getAttribute("display-price");	
			int value = Integer.parseInt(attribute);
			priceList.add(value);
		}
		for(int i = 0; i < priceList.size();i++){
			int j= i+1;		
				
				int a = priceList.get(i);
				int b = priceList.get(j);
				
				if(b >= a) {
					
					System.out.println("The list is in sorted Order");
				}
				else {
					System.out.println("The list is NOT in sorted Order");	
					break;				
				}			
					
		}
		
		//Enter the price range (900-1500)
		
		WebElement rangeField1 = driver.findElement(By.xpath("//input[@name = 'fromVal']"));
		Thread.sleep(9000);
		rangeField1.clear();
		rangeField1.sendKeys("900");
		WebElement rangeField2 = driver.findElement(By.xpath("//input[@name = 'toVal']"));
		Thread.sleep(9000);
		rangeField2.clear();
		rangeField2.sendKeys("1500");
		
		//Click on GO button
		
		WebElement goButton = driver.findElement(By.xpath("//div[@class ='price-go-arrow btn btn-line btn-theme-secondary']"));
		Thread.sleep(9000);
		goButton.click(); 
		
		//Filter with color Blue and//Verify the Blue check box is enabled
		Thread.sleep(9000);
		driver.findElement(By.xpath("//button[@class='view-more-button btn btn-line btn-theme-secondary viewMoreFilter' and @data-filtername ='Color_s'] ")).click();		
		WebElement color = driver.findElement(By.xpath("//label[@for ='Color_s-Blue']"));
		Thread.sleep(20000);
		if(color.isEnabled()) {
			color.click();
			Thread.sleep(20000);
									
			}
		else {
			System.out.println("Blue Color is not enabled");		
			}
		
		//Click on first resulting Training shoes
		
		driver.findElement(By.xpath("(//div[@class = 'product-tuple-description '])[1]")).click();
		Thread.sleep(20000);
		String currentHandles = driver.getWindowHandle();
		Set<String> newhandles = driver.getWindowHandles();
			
		
		
		for (String eachWindow : newhandles){
			if(!eachWindow.equals(currentHandles)) {
				driver.switchTo().window(eachWindow);
			}			
		}
				
		
		//Print the cost and the discount percentage
		
		WebElement cost = driver.findElement(By.xpath("//span[@class='payBlkBig']"));
		Thread.sleep(20000);
		String price = cost.getText();
		WebElement discount= driver.findElement(By.xpath("//span[@class='pdpDiscount ']"));
		Thread.sleep(20000);
		String discount1 = discount.getText();
		System.out.println("Price of the shoe : " +price );
		System.out.println("Discount percentage : " +discount1  );
		
		
		//Take the snapshot of the shoes
		
		Thread.sleep(20000);		
		File source = driver.getScreenshotAs(OutputType.FILE);	
		Thread.sleep(20000);
		File destination = new File("D:\\TestLeaf\\LearnSelenium\\src\\main\\java\\week4\\screenshot\\nalini.png");
		FileUtils.copyFile(source, destination);
		
		
		//Close the  window
		driver.quit();
		
		
		
		
		
		
		
		
		
		

			
			
			
		
		
		
		
	

		
		
		
		
		
		
	}
}
	         


