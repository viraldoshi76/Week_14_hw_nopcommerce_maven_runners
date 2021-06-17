package com.nopcommerce.demo.homePage;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.page.HomePage;
import com.nopcommerce.demo.retryAnalyzer.RetryAnalyzer;
import com.nopcommerce.demo.testBase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(CustomListeners.class)
public class TopMenuTest extends TestBase {

    HomePage homepage=new HomePage();
    SoftAssert softAssert = new SoftAssert();

    @Test(groups = {"smoke","regression"},retryAnalyzer = RetryAnalyzer.class)
    public void selectMenuAndClick() throws InterruptedException {
        String expectedText=homepage.selectMenu("Computers");
        String actualText=homepage.getActualText();
        softAssert.assertEquals(expectedText,actualText);

    }


}
