package screen;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import base.BaseClassIrctc;

public class IrctcSearchTrain extends BaseClassIrctc{
	public  RemoteWebDriver driver;
	public IrctcSearchTrain(RemoteWebDriver driver) {
        this.driver=driver;
        
    }
	public IrctcSearchTrain enterFromSation() throws IOException {
		try {
			driver.findElement(By.xpath("(//input[@role='searchbox'])[1]")).sendKeys("CHENNAI EGMORE - MS (CHENNAI)",Keys.ENTER);
			reportStep("fromStation is entered successfully", "pass");
		} catch (IOException e) {
			reportStep("fromStation is not entered successfully"+e, "fail");
		}
		return this;
		
	}
	public IrctcSearchTrain enterToSation() throws IOException {
		try {
			driver.findElement(By.xpath("(//input[@role='searchbox'])[2]")).sendKeys("VILLUPURAM JN - VM (PONDICHERRY/PUDUCHERRY)",Keys.ENTER);
			reportStep("ToStation is entered successfully", "pass");
		} catch (IOException e) {
			reportStep("ToStation is not entered successfully"+e, "fail");
		}
		return this;
		
	}
	public IrctcSearchTrain dateOfJourney() throws IOException {
		try {
			driver.findElement(By.xpath("(//input[contains(@class,'inputtext ')])[3]")).click();
			driver.findElement(By.xpath("//table[contains(@class,'calendar ')]//tr[3]/td[4]")).click();
			reportStep("date is selected successfully", "pass");
		} catch (IOException e) {
			reportStep("date is selected successfully", "fail");
					}
		return this;

	}
	public IrctcSearchTrain enableTrainWithAvailabeBerth() throws IOException {
		
		try {
			WebElement date = driver.findElement(By.xpath("//label[@for='availableBerth']"));
			date.click();
			boolean selected = date.isSelected();
			System.out.println(selected);
			if (selected==false) {
				date.click();
				reportStep("checkbox is selected successfully", "pass");
			}
		} catch (Exception e) {
			reportStep("checkbox is not selected successfully", "fail");
		}
		return this;

	}
	public IrctcSearchTrain clickSearchButton() throws IOException {

		try {
			driver.findElement(By.xpath("//button[@label='Find Trains']")).click();
			reportStep("searh button is clicked  successfully", "pass");
		} catch (IOException e) {
			reportStep("searh button is clicked  successfully", "fail");
		}
		return this;
	}
	
	
}
