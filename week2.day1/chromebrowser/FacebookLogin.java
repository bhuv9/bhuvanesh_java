package chromebrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookLogin {

	public static void main(String[] args) throws InterruptedException {
WebDriver fb=new ChromeDriver();
fb.manage().window().maximize();
fb.get("https://www.facebook.com/login.php");
fb.findElement(By.id("email")).sendKeys("bhuvanesh@gmail.com");
fb.findElement(By.name("pass")).sendKeys("8870654317");
Thread.sleep(2000);
fb.findElement(By.id("loginbutton")).click();
String pagetitle = fb.getTitle();
System.out.println(pagetitle);
String string = fb.findElement(By.cssSelector("._9ay7")).getText();
System.out.println(string);
fb.close();


	}

}
