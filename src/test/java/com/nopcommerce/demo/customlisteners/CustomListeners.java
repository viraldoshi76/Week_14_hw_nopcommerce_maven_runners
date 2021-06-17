package com.nopcommerce.demo.customlisteners;

import com.nopcommerce.demo.utility.Utility;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class CustomListeners implements ITestListener {


    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("This on TestStart"+ iTestResult.getName());

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("This on TestSuccess"+ iTestResult.getName());

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("This on TestFail"+ iTestResult.getName());

        String screenshotName = Utility.takeScreenShot(iTestResult.getName());
        // This line required for ReportNG reports
        System.setProperty("org.uncommons.reportng.escape-output", "false");
        Reporter.log("Click to see screenshot");
        Reporter.log("<a target = \"_blank\" href="+screenshotName+">Screenshot</a>");
        Reporter.log("<br>");
        Reporter.log("<br>");
        Reporter.log("<a target = \"_blank\" href="+screenshotName+"><img src="+screenshotName+" height=200 width=200></img></a>");


    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("This on TestSkipped"+ iTestResult.getName());

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }

    }

