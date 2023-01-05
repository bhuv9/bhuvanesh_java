package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amarzon {

	public static void main(String[] args) {
 ChromeDriver dr = new ChromeDriver();
 dr.get("https://www.amazon.in/");
 dr.manage().window().maximize();
 dr.findElement(By.id("twotabsearchtextbox")).sendKeys("laptop",Keys.ENTER);
 
 
	}

}
