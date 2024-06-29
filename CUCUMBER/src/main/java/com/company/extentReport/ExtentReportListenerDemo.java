package com.company.extentReport;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class ExtentReportListenerDemo implements ITestListener {
	private ExtentReports extent;

  private ThreadLocal <ExtentTest> extentTestThread=new ThreadLocal<>();
  
  Logger log =LogManager.getLogger(ExtentReportListenerDemo.class);
    
    @Override
    public void onStart(ITestContext context) {
        log.info("onstart started");

    	String path= System.getProperty("user.dir")+"\\test-output\\extentReportmyyy.html";

        ExtentSparkReporter spark = new ExtentSparkReporter(path);
         extent = new ExtentReports();
        extent.attachReporter(spark);
        System.out.println("Extent Report: Test Suite Execution Started");
        log.info("onstart completed");


    }   

    @Override
    public void onTestStart(ITestResult result) {
        log.info("onTestStart started");

    	ExtentTest test = extent.createTest(result.getMethod().getMethodName());
       extentTestThread.set(test);
        System.out.println("Extent Report: Test Case Execution Started - " + result.getMethod().getMethodName());

        log.info("onTestStart finished");

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("onTestSuccess started");

        extentTestThread.get().log(Status.PASS, "Test Passed");
        System.out.println("Extent Report: Test Case Passed - " + result.getMethod().getMethodName());
        log.info("onTestSuccess finished");


    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.info("onTestFailure started");

        extentTestThread.get().log(Status.FAIL, "Test Failed");
        log.info("onTestFailure finished");

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.info("onTestSkipped started");

        extentTestThread.get().log(Status.SKIP, "Test Skipped");
        log.info("onTestSkipped finished");

    }
    
    @Override
    public void onFinish(ITestContext context) {
        log.info("onFinish started");

        extent.flush();
        System.out.println("Extent Report: Test Suite Execution Finished");
        log.info("onFinish finished");


    }
}
