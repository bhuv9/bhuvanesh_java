package base;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassIrctc {
	public   RemoteWebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test,node ;
	public String testName,testDescription,testCategory,testAuthor,URLlink ;
	public ChromeOptions options;
	public static int ranNum;


	@BeforeSuite
	public void startReport() {

		ExtentHtmlReporter reporter = new ExtentHtmlReporter("D:\\Test Leaf\\PageObjectModel\\new_report\\result.html");
		reporter.setAppendExisting(true);
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}
	@BeforeClass
	public void testDetails() {

		test = extent.createTest(testName, testDescription);
		test.assignCategory(testCategory);
		test.assignAuthor(testAuthor);


	}
	public int takeSnap() throws IOException {

		 
		try {
			
			ranNum = (int)(Math.random()*99999999+1000000);
			TakesScreenshot snp = (TakesScreenshot)driver;
			File src = snp.getScreenshotAs(OutputType.FILE);
			File des = new File("D:\\Test Leaf\\PageObjectModel\\snapShot\\img"+ranNum+".png");


			FileUtils.copyFile(src, des);
		} catch (WebDriverException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}catch (NullPointerException e) {
			e.printStackTrace();
		}
		return ranNum;
	}

	public void reportStep(String stepdetails, String status) throws IOException {
		int ranNum = takeSnap();
		if (status.equalsIgnoreCase("pass")) {
			node.pass(stepdetails, MediaEntityBuilder.createScreenCaptureFromPath(".././PageObjectModel/snapshot/img"+ranNum+".png").build());


		}
		else if (status.equalsIgnoreCase("fail")) {
			node.fail(stepdetails, MediaEntityBuilder.createScreenCaptureFromPath(".././PageObjectModel/snapshot/img"+ranNum+".png").build());
			throw new RuntimeException("see extent report for more information");
		}


	}

	@AfterSuite
	public void closeReport() {

		extent.flush();
	}




	@BeforeMethod
	public void launchBrowser() {

		node = test.createNode(testName);
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", "/opt/chromedriver");
		options = new ChromeOptions();
		options.addArguments("--Allow--remote--origins");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@AfterMethod
	public void exitBrowser() {

		driver.close();
	}




}


