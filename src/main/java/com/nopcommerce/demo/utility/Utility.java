package com.nopcommerce.demo.utility;


import com.nopcommerce.demo.basepage.BasePage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Utility extends BasePage {



    /**
     * this method will click on element
     * @param by
     */

    public void clickOnElement(By by){
        driver.findElement(by).click();

    }

    public void clickOnElement(WebElement element){
       element.click();

    }

    /**
     * This method will get text from element
     * @param by
     * @return
     */
    public String getTextFromElement(By by){
       return driver.findElement(by).getText();// or you can write like String text = driver.findElement(by)   //te
    }

    //This method get text from element by element
    public String getTextFromElement(WebElement element){
        return element.getText();
    }

    /**
     * This method will send text on element
     * @param by
     * @param text
     */
    public void sendTextToElement(By by,String text){

        driver.findElement(by).sendKeys(text);
    }

    //This method will send text on element by element
    public void sendTextToElement(WebElement element,String text){

        element.sendKeys(text);
    }


    /**
     * This method will select value from dropdown
     * @param by
     * @param value
     */
    public void selectByValueDropDown(By by,String value){
        Select select =new Select(driver.findElement(by));
        select.selectByValue(value);

    }

    public void selectByValueDropDown(WebElement element,String value){
        Select select =new Select(element);
        select.selectByValue(value);

    }

    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }

    public void mouseHoverToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    /**
     * This method will used to wait web driver until element become clickable
     */
    public void waitUntilElementToBeClickable(By by, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(by)));
    }

    /**
     * This method will used to wait web driver until presence of element located by locator
     */
    public void waitUntilPresenceOfElementLocated(By by, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    /**
     * This method will used to wait web driver until visibility of element located by locator
     */
    public void waitUntilVisibilityOfElementLocated(By by, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }


    /**
     * This method will used to wait until element located
     * @param by
     * @param timeout
     * @return
     */
    public WebElement waitUntilVisibilityOfElement(By by,int timeout){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        WebElement element=  wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return element;

    }

    public List<String> verifyProductInDescendingOrder(By by) throws InterruptedException {
        List<WebElement> productList = driver.findElements(by);
        List<String> productNameList = new ArrayList<>();


        for (WebElement list : productList) {
            Thread.sleep(2000);
            productNameList.add(list.getText());
        }
        System.out.println(productNameList);
        return productNameList;
    }

    /**
     * This method will verify that element is displayed
     */
    public boolean verifyThatElementIsDisplayed(By by) {
        WebElement element = driver.findElement(by);
        if (element.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean verifyThatElementIsDisplayed(WebElement element) {
        if (element.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method will verify that element is displayed
     */
    public boolean verifyThatTextIsDisplayed(By by, String text) {
        WebElement element = driver.findElement(by);
        if (text.equals(element.getText())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean verifyThatTextIsDisplayed(WebElement element, String text) {
        if (text.equals(element.getText())) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method will returns list of web elements
     */
    public List<WebElement> webElementList(By by) {
        return driver.findElements(by);
    }

    public static String currentTimeStamp() {
        Date d = new Date();
        return d.toString().replace(":", "_").replace(" ", "_");
    }

    /*
     *Screenshot methods
     */
    public static String takeScreenShot(String fileName) {
        String filePath = System.getProperty("user.dir") + "/test-output/html/";
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File scr1 = screenshot.getScreenshotAs(OutputType.FILE);
        String imageName = fileName + currentTimeStamp() + ".jpg";
        String destination = filePath + imageName;
        try {
            FileUtils.copyFile(scr1, new File(destination));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }




}
