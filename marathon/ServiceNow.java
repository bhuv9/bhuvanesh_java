package marathon2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class ServiceNow {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// WebDriverWait wait = new WebDriverWait(driver, 10);

		driver.manage().window().maximize();
		login(driver);
		service(driver);
		mobile(driver);
		driver.quit();
	}

	public static void login(WebDriver driver) {
		driver.get("https://dev62925.service-now.com/");
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("GAhMak34tH-^");
		driver.findElement(By.id("sysverb_login")).click();
		// Alert alert = driver.switchTo().alert();
		//alert.dismiss();

	}

	public static void service(WebDriver driver) {
		Shadow driv = new Shadow(driver);
		driv.setImplicitWait(10);
		WebElement d1 = driv.findElementByXPath("//div[text()='All']");
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// wait.until(ExpectedConditions.visibilityOf(d1));
		d1.click();
		driv.findElementByXPath("//span[text()='Service Catalog']").click();
		WebElement frame1 = driv.findElementByXPath("//iframe[@title='Main Content']");
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("//h2[contains(text(),'Mobiles')]")).click();
		driver.findElement(By.xpath("//strong[contains(text(),'Apple iPhone 13')]")).click();
		driver.findElement(By.xpath("//label[text()='No']")).click();
		WebElement dropDown = driver.findElement(By.id("IO:33494b069747011021983d1e6253af45"));
		Select s = new Select(dropDown);
		s.selectByIndex(2);
		driver.findElement(By.xpath("(//label[@class='radio-label'])[5]")).click();
		driver.findElement(By.xpath("//label[text()='256 GB [add $100.00]']")).click();
		driver.findElement(By.id("oi_order_now_button")).click();
		String text = driver.findElement(By.xpath("//a[@id='requesturl']")).getText();
		System.out.println(text);
	}

	public static void mobile(WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver ;
		File srcfile = ts.getScreenshotAs(OutputType.FILE);
		File target = new File("D:\\Test Leaf\\Selenium\\ScreenShot\\mobile.png");
		FileUtils.copyFile(srcfile, target);
		
		
		
		
		
		
	}

}
