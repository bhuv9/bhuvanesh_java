package chromebrowser;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DrownUsingXpath {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		
		
		driver.get("https://www.leafground.com/select.xhtml");
		
		
		
		driver.findElement(By.xpath("//select[@class='ui-selectonemenu']")).click();
		Thread.sleep(2000);
		
	
		WebElement source1 = driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
		Select drop=new Select(source1);
		drop.selectByVisibleText("Puppeteer");
		source1.click();
		
		
		String title = driver.getTitle();
		System.out.println(title);
		
		
		driver.findElement(By.xpath("//span[@class='ui-button-icon-primary ui-icon ui-icon-triangle-1-s']")).click();
		
		
		Thread.sleep(4000);
		List<WebElement> findElements = driver.findElements(By.xpath("//span/ul/li"));
		for (int i = 0; i < findElements.size(); i++) {
			String course = findElements.get(i).getText();
			 if (course.equalsIgnoreCase("RestAssured")) {
				  findElements.get(i).click();
				
			}
			
			
			
		}
		String title2 = driver.getTitle();
		System.out.println(title2);
		
		Thread.sleep(4000);
		
		
		
		driver.findElement(By.xpath("//label[@class='ui-selectonemenu-label ui-inputfield ui-corner-all']")).click();
		Thread.sleep(4000);
		List<WebElement> findElements2 = driver.findElements(By.xpath("//li[@role='option']"));
		for (int i = 0; i <findElements2.size(); i++) {
			
			String country=findElements2.get(i).getText();
			if (country.equalsIgnoreCase("Germany")) {
				findElements2.get(i).click();
				
			}
		}
		Thread.sleep(4000);
		
		
		
		driver.findElement(By.id("j_idt87:city_label")).click();
		List<WebElement> findElements3 = driver.findElements(By.xpath("//li[@role='option']"));
		for (int i = 0; i < findElements3.size(); i++) {
			String city=findElements3.get(i).getText();
			if (city.equalsIgnoreCase("Frankfurt")) {
				findElements3.get(i).click();
				
			}
			
			
		}
		
		
		String title3 = driver.getTitle();
		System.out.println(title3);
		Thread.sleep(4000);
		
		
		
		driver.findElement(By.id("j_idt87:lang_label")).click();
		List<WebElement> findElements4 = driver.findElements(By.xpath("//li[@role='option']"));
		for (int j = 0; j < findElements4.size(); j++) {
			String language=findElements4.get(j).getText();
			if (language.equalsIgnoreCase("Tamil")) {
				findElements4.get(j).click();
				
			}
			
		}
		
		String title4 = driver.getTitle();
		System.out.println(title4);
		
		Thread.sleep(4000);
		
		
		
		driver.findElement(By.id("j_idt87:value_label")).click();
		List<WebElement> findElements5 = driver.findElements(By.xpath("//li[@role='option']"));
		for (int i = 0; i < findElements5.size(); i++) {
			String value=findElements5.get(i).getText();
			if (value.equalsIgnoreCase("இரண்டு")) {
				findElements5.get(i).click();
				
			}
		}
		
		String title5 = driver.getTitle();
		System.out.println(title5);
		Thread.sleep(4000);
		
		
		
		driver.close();

	}

}
