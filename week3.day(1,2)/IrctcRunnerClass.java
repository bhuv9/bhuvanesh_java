package testcase;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClassIrctc;
import screen.IrctcSearchTrain;

public class IrctcRunnerClass extends BaseClassIrctc {
	@BeforeTest
	public void setup() {

		testName="IRCTC";
		testDescription="Automate the IRCTC website to search trian";
		testCategory="regression test";
		testAuthor="Bhuvanesh";
	}
	@Test
public void runTest() throws IOException {

	IrctcSearchTrain ist = new IrctcSearchTrain(driver);
	ist.enterFromSation()
	.enterToSation()
	.dateOfJourney()
	.enableTrainWithAvailabeBerth()
	.clickSearchButton();
}
}
