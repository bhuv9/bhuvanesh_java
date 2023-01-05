package chromebrowser;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Logintestleaf {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 driver.get("www.google.com");
		 //driver.get("http://leaftaps.com/opentaps/control/main");
	}

}
