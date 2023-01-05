package chromebrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Tnpsc {

	public static void main(String[] args) throws InterruptedException {
			WebDriverManager.chromedriver().setup();
			WebDriver chrome = new ChromeDriver();
            chrome.manage().window().maximize();	
            chrome.get("https://www.tnpsc.gov.in/");
            chrome.findElement(By.linkText("Apply Online"));
            chrome.get("https://apply.tnpscexams.in/secure?app_id=UElZMDAwMDAwMQ==");
            Thread.sleep(2000);
            String title = chrome.getTitle();
            System.out.println(title);
            chrome.findElement(By.xpath("//a[@class=\"topBtn btn btn-danger\"]"));
            WebElement eng = chrome.findElement(By.xpath("//a[@class=\"topBtn btn btn-danger\"]"));
            eng.click();
            String title2 = chrome.getTitle();
            System.out.println(title2);
			Thread.sleep(2000);
			chrome.findElement(By.partialLinkText("Notifications")).click();
			Thread.sleep(2000);
			chrome.findElement(By.linkText("Apply Now")).click();
			Thread.sleep(2000);
			String title3 = chrome.getTitle();
			System.out.println(title3);
			chrome.findElement(By.id("EMAIL_ID")).sendKeys("bhuvi");
			chrome.findElement(By.id("PASSWORD")).sendKeys("bhuvanesh");
			chrome.findElement(By.xpath("//div[@class='col-sm-5 pull-right']")).click();
			Thread.sleep(4000);
			
			chrome.close();
			
			
	}

}
