package week3.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBus {

	public static void main(String[] args) throws InterruptedException {
      WebDriverManager.chromedriver().setup();
      ChromeDriver driver = new ChromeDriver();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
      driver.manage().window().maximize();
      
      driver.get("https://www.redbus.in/");
      driver.findElement(By.id("src")).sendKeys("Chennai");
      driver.findElement(By.xpath("//li[@data-no='1']")).click();
      driver.findElement(By.id("dest")).sendKeys("Bangalore");
      driver.findElement(By.xpath("//li[@data-id='122']")).click();
      Thread.sleep(4000);
      driver.findElement(By.id("onward_cal")).click();
      Thread.sleep(4000);
      driver.findElement(By.xpath("//td[text()='13']")).click();
      driver.findElement(By.xpath("//button[@class='fl button']")).click();
      Thread.sleep(4000);
      
      driver.findElement(By.xpath("//div[@class='close-primo']")).click();
      String text1 = driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText();
      System.out.println(text1);
      driver.findElement(By.xpath("//label[text()='SLEEPER']")).click();
      String text2 = driver.findElement(By.xpath("(//div[@class='travels lh-24 f-bold d-color'])[2]")).getText();
      System.out.println(text2);
      
      driver.findElement(By.xpath("(//div[@class='button view-seats fr'])[2]")).click();
      String text3 = driver.findElement(By.xpath("(//div[@class='seat-left m-top-30'])[2]")).getText();
      System.out.println(text3);
      
      
      
      
      Thread.sleep(4000);
      driver.close();
	}

}
