package week2.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amarzon {

	public static void main(String[] args) throws InterruptedException {
 ChromeDriver dr = new ChromeDriver();
 dr.get("https://www.amazon.in/");
 dr.manage().window().maximize();
 dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
 dr.findElement(By.id("twotabsearchtextbox")).sendKeys("bags for mens",Keys.ENTER);
 
 
 
 String string = dr.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).getText();
 System.out.println(string);
 
 
 List<WebElement> findElements = dr.findElements(By.xpath("//li/span/a/span"));
 for (int i = 0; i <findElements.size(); i++) {
	 String brand1 = findElements.get(i).getText();
	 if (brand1.equalsIgnoreCase("Safari")) {
		 findElements.get(i).click();
		 break;
		
	}
	
}
 Thread.sleep(2000);
 
 List<WebElement> findElements2 = dr.findElements(By.xpath("//li/span/a/span"));
 for (int i = 0; i < findElements2.size(); i++) {
	 String brand2 = findElements2.get(i).getText();
	 if (brand2.equalsIgnoreCase("Generic")) {
		 findElements2.get(i).click();
		 break;
		
	}
	
}
 
 String page2 = dr.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
 System.out.println(page2);
 
 
 dr.findElement(By.xpath("//span[@class='a-button-text a-declarative']")).click();
 dr.findElement(By.xpath("//a[text()='Newest Arrivals']")).click();
 
 
 String page3 = dr.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[2]")).getText();
 System.out.println(page3);
 String page4 = dr.findElement(By.xpath("//div[@class='a-row a-size-base a-color-base']")).getText();
 System.out.println(page4);
 
 
 dr.close();
 
 
	}

}
