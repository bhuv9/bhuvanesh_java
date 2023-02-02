package marathon2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class SalesForce {


	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		ChromeOptions chrome = new ChromeOptions();
		chrome.addArguments("---disable--Notification");
		login(driver);
		mobilePublisher(driver);
		driver.quit();

	}

	public static void login(WebDriver driver) {

		driver.get(" https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com", Keys.TAB);
		driver.findElement(By.id("password")).sendKeys("Leaf@123", Keys.TAB);
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//button[@class='slds-button slds-button--neutral navButton newWindow uiButton']"))
				.click();

	}

	public static void mobilePublisher(WebDriver driver) throws InterruptedException, IOException {
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> lstWindow = new ArrayList<String>(windowHandles);
		driver.switchTo().window(lstWindow.get(1));

		driver.findElement(By.cssSelector(".slds-button.slds-button_brand")).click();

		Shadow learn = new Shadow(driver);
		learn.setImplicitWait(4);
		learn.findElementByXPath("//span[text()='Learning']").click();
		WebElement findElementByXPath = learn.findElementByXPath("//span[text()='Learning on Trailhead']");

		Actions ac = new Actions(driver);
		ac.moveToElement(findElementByXPath).build().perform();
		WebElement findElementByXPath2 = learn.findElementByXPath("//a[text()='Salesforce Certification']");
		findElementByXPath2.click();
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//a[text()='Administrator']")).click();
		
		List<WebElement> certificateTitle = driver.findElements(By.xpath("//div[@class='credentials-card_title']"));
		
		for (WebElement title : certificateTitle) {
			 String text = title.getText();
			 System.out.println(text);
			 
			
		}
		
		
		WebElement location = driver.findElement(By.xpath("//a[text()='Business Administration Specialist']"));
		ac.scrollToElement(location).build().perform();
		Thread.sleep(5000);
		TakesScreenshot ts= (TakesScreenshot) driver;
		File srcfile = ts.getScreenshotAs(OutputType.FILE);
		File target = new File("D:\\Test Leaf\\Selenium\\ScreenShot\\certificat.png");
		FileUtils.copyFile(srcfile, target);
		driver.quit();

	}
	

}
