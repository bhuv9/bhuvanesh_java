package chromebrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BookMyShow {

	public static void main(String[] args) throws InterruptedException {
		
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://in.bookmyshow.com/explore/home/chennai");
			Thread.sleep(2000);
			driver.findElement(By.cssSelector(".jWuMjc")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("mobileNo")).sendKeys("8899776655");
			Thread.sleep(2000);
			driver.findElement(By.cssSelector(".hZAtFl")).click();
			Thread.sleep(2000);
			String string = driver.findElement(By.cssSelector(".iACvlF")).getText();
			System.out.println(string);
			
	}

}
