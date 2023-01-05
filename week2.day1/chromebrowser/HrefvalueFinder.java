package chromebrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HrefvalueFinder {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver chrome = new ChromeDriver();
        chrome.manage().window().maximize();	
        chrome.get("https://www.tnpsc.gov.in/");
        chrome.findElement(By.linkText("Apply Online"));
        Thread.sleep(2000);
       chrome.get("https://apply.tnpscexams.in/secure?app_id=UElZMDAwMDAwMQ==");
       chrome.findElement(By.linkText("English"));
       WebElement hrefV = chrome.findElement(By.linkText("English"));
       
       
        String v = hrefV.getAttribute("href");
        System.out.println("the Href value is"+v);
        chrome.close();
        
        
        
	}

}
