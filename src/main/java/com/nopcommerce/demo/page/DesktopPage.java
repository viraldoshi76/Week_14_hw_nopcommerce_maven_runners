package com.nopcommerce.demo.page;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;
import org.testng.Reporter;

import java.util.List;

public class DesktopPage extends Utility {

    By sortByFilterLink = By.id("products-orderby");
    By sortFilterByZToA = By.xpath("//h2[@class='product-title']");
    By addToCartButton = By.xpath("//button[@onclick='return AjaxCart.addproducttocart_catalog(\"/addproducttocart/catalog/1/1/1\"),!1']");


    public void sortFilterZtoA(String value) {
        Reporter.log("Select Z to A filter"+value+"<br>");
        selectByValueDropDown(waitUntilVisibilityOfElement(sortByFilterLink, 50), value);

    }

    public List<String> verifyProductArrangeZtoAOrder() throws InterruptedException {

        //List<WebElement> productList = driver.findElements(By.xpath("//h2[@class='product-title']"));
            Reporter.log("verify product are arranged in descending order "+sortFilterByZToA.toString()+"<br>");
            return verifyProductInDescendingOrder(sortFilterByZToA);
    }

    public void sortFilterAtoZ(String value){
        Reporter.log("Sort Filter by A to Z "+value+"<br>");
        selectByValueDropDown(waitUntilVisibilityOfElement(sortByFilterLink,50),value);
    }

    public void clickOnAddToCartOnBuildYourOwnComputer(){
        Reporter.log("Click on Add to Cart on Build Your own computer"+addToCartButton.toString()+"<br>");
        clickOnElement(waitUntilVisibilityOfElement(addToCartButton,50));
    }



}



