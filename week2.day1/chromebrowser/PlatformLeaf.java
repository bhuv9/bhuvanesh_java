package chromebrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PlatformLeaf {


	public static void main(String[] args) throws InterruptedException {
WebDriverManager.chromedriver().setup();
ChromeDriver driver = new ChromeDriver();
driver.manage().window().maximize();

driver.get("http://leaftaps.com/opentaps/control/main");
String ti1 = driver.getTitle();
System.out.println(ti1);
driver.findElement(By.id("username")).sendKeys("demosalesmanager");
driver.findElement(By.id("password")).sendKeys("crmsfa");
driver.findElement(By.className("decorativeSubmit")).click();
String ti2 = driver.getTitle();
System.out.println(ti2);
driver.findElement(By.linkText("CRM/SFA")).click();
driver.findElement(By.linkText("Leads")).click();
driver.findElement(By.linkText("Create Lead")).click();
String ti3 = driver.getTitle();
System.out.println(ti3);
driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Bconclave");
Thread.sleep(2000);
driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Bhuvanesh");
driver.findElement(By.id("createLeadForm_lastName")).sendKeys("moorthy");
Thread.sleep(2000);
String ti4 = driver.getTitle();
System.out.println(ti4);
driver.findElement(By.id("createLeadForm_dataSourceId")).click();
WebElement source1 = driver.findElement(By.id("createLeadForm_dataSourceId"));
Select drop = new Select(source1);
drop.selectByVisibleText("Cold Call");
source1.click();
Thread.sleep(1000);
driver.findElement(By.id("createLeadForm_marketingCampaignId")).click();
WebElement source2 = driver.findElement(By.id("createLeadForm_marketingCampaignId"));
Select drop2 =new Select(source2);
drop2.selectByVisibleText("Demo Marketing Campaign");
source2.click();
Thread.sleep(1000);
driver.findElement(By.id("createLeadForm_industryEnumId")).click();
WebElement source3 = driver.findElement(By.id("createLeadForm_industryEnumId"));
Select drop3 = new Select(source3);
drop3.selectByVisibleText("Computer Software");
source3.click();
Thread.sleep(1000);
driver.findElement(By.className("smallSubmit")).click();
Thread.sleep(1000);
String text = driver.findElement(By.id("viewLead_firstName_sp")).getText();
System.out.println(text);




driver.close();

     
	}

}
