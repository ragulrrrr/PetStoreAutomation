package api.utilities;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class TestListener implements ITestListener, ISuiteListener {
	int counter = 1;

	public void onTestFailure(ITestResult result) {

		if (result.getThrowable() != null) {

			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			result.getThrowable().printStackTrace(pw);
			System.out.println(sw.toString());
		}
		
		
		//BaseTest base=new BaseTest();
		/*File file=DriverManagers.getDriver().getScreenshotAs(OutputType.FILE);
		
		
		byte[] encoded=null;
		try {
			encoded=Base64.encodeBase64(FileUtils.readFileToByteArray(file));
		}catch (Exception e) {
			// TODO: handle exception
		}
				
		Map<String,String> params=new HashMap<String,String>();
		params=result.getTestContext().getCurrentXmlTest().getAllParameters();
		
		String imagePath="Screenshots"+File.separator+params.get("platformName")+File.separator+
				TestUtils.getDateTime()+File.separator+result.getTestClass().getRealClass().getSimpleName()+File.separator+
				result.getName()+".png";
		
		String completImagePath=System.getProperty("user.dir")+File.separator+imagePath;
		try {
			FileUtils.copyFile(file, new File(imagePath));
			Reporter.log("this is the sample screenshot");
			System.out.println(completImagePath);
			Reporter.log("<a href='"+completImagePath+"'> <imag src='"+completImagePath+"' hight='400' width='400'/> </a>");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//ExtentReport.getTest().log(Status.FAIL, "Test Failed");
		ExtentReport.getTest().fail("Test Failed");
		
		ExtentReport.getTest().fail(result.getThrowable());
		//FrameworkLogger.logs(LogType.FAIL, result.getName() + " is failed miserably");
		//ExtentLogger.fail(result.getThrowable());
		//((RemoteWebDriver) DriverManager.getDriver()).executeScript("lambda-status=failed");
	}

	public void onTestStart(ITestResult result ) {
		
		//BaseTest base=new BaseTest();
		ExtentReport.startTest(result.getName(), result.getMethod().getDescription())
		.assignCategory("api")
		.assignAuthor("SF-QE");
		
		
		
		
		/*String desc = null;
		if (result.getParameters() != null) {
			Object[] obj = result.getParameters();
			List<Object> list = new ArrayList<Object>();
			for (Object strTemp : obj) {
				list.add(strTemp);
			}
			desc = "With Parameter " + list.toString();
		} else {
			desc = result.getMethod().getDescription();
		}*/
		//FrameworkLogger.logs(LogType.WRITESTEPS, "TC_" + counter++ + ": " + result.getName());
		//ExtentReport.startTest(result.getName(), desc)
		//		.assignCategory(((RemoteWebDriver) DriverManager.getDriver()).getCapabilities()
		//				.getCapability("platformVersion") + "_"
		//				+ ((RemoteWebDriver) DriverManager.getDriver()).getCapabilities().getCapability("deviceName"))
		//		.assignAuthor("Manoj Lonar");
		//((RemoteWebDriver) DriverManager.getDriver()).executeScript("lambda-name="+ result.getName());
		

	}

	public void onTestSuccess(ITestResult result) {
		ExtentReport.getTest().log(Status.PASS, "Test Passes");
	//	FrameworkLogger.logs(LogType.EXTENTCONSOLE, "Test Case passed");
	//	ExtentReport.getReporter().flush();
		//((RemoteWebDriver) DriverManager.getDriver()).executeScript("lambda-status=passed");

	}

	public void onTestSkipped(ITestResult result) {
		if (result.getThrowable() != null) {

			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			result.getThrowable().printStackTrace(pw);
			System.out.println(sw.toString());
		}
		ExtentReport.getTest().log(Status.SKIP, "Test Skipped");
	//	FrameworkLogger.logs(LogType.SKIP, " is skipped.");
	//	ExtentLogger.fail(result.getThrowable());
	}

	public void onFinish(ITestContext context) {
	//	ExtentReport.getReporter().flush();
	}

	public void onStart(ITestContext result) {
	//	ExtentReport.startTest(result.getClass().getSimpleName(), "Steps before TC starts: ");
	//	TestUtils.writeInFile("Steps before TC starts: " + result.getClass().getSimpleName(), "testSteps");

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	//@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		
	}

	//@Override
	public void onFinish(ISuite suite) {
		ExtentReport.getReporter().flush();
		
	}

/*	@Override // BeforeSuite
	public void onStart(ISuite suite) {
		TestUtils.clearTheFile("TestSteps.txt");
		TestUtils.writeInFile("*********" + TestUtils.getDateTime() + "*********", "Orders");

	}

	@Override // AfterSuite
	public void onFinish(ISuite suite) {

	}*/
}
