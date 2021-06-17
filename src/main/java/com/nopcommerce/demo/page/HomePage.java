package com.nopcommerce.demo.page;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import java.util.List;

public class HomePage extends Utility {

    By computersLink = By.xpath("//ul[@class='top-menu notmobile']//a[text()='Computers ']");
    By electronicsLink = By.xpath("//ul[@class='top-menu notmobile']//a[text()='Electronics ']");
    By apparelLink = By.xpath("//ul[@class='top-menu notmobile']//a[text()='Apparel ']");
    By digitalDownloadLink = By.xpath("//ul[@class='top-menu notmobile']//a[text()='Digital downloads ']");
    By booksLink = By.xpath("//ul[@class='top-menu notmobile']//a[text()='Books ']");
    By jewelryLink = By.xpath("//ul[@class='top-menu notmobile']//a[text()='Jewelry ']");
    By giftCardsLink = By.xpath("//ul[@class='top-menu notmobile']//a[text()='Gift Cards ']");
    By homePageMenuTabs = By.xpath("//div[@class='header-menu']/ul[1]/li/a");

    By pageTitleText=By.xpath("//div[@class='page-title']");

    public String selectMenu(String menu) {
        Reporter.log("Getting list of top menu tabs "+homePageMenuTabs.toString()+"<br>");
        List<WebElement> menuList = driver.findElements(homePageMenuTabs);
        String expectedText = null;
        for (WebElement element: menuList){
            Reporter.log("Getting list from home pagemenu tabs"+element.toString()+"compare with menu list"+menu+"<br>");
            if (element.getText().equalsIgnoreCase(menu)){
                expectedText=element.getText();
                Reporter.log("Click on element"+element.toString()+"<br>");
                element.click();
                break;
            }
        }
        return expectedText;
    }

    public String getActualText(){

        Reporter.log("getting title text "+pageTitleText.toString()+"<br>");
        return waitUntilVisibilityOfElement(pageTitleText,30).getText();
    }
}
