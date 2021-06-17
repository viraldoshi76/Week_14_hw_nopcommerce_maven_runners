package com.nopcommerce.demo.page;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;
import org.testng.Reporter;

public class BuildYourOwnComputer extends Utility {

    By actualTextBuildYourOwnCompuer = By.xpath("//h1[contains(text(),'Build your own computer')]");
    By select22GHzIntelPentiumDualCoreE2200 = By.xpath("//dd[@id='product_attribute_input_1']//select[@id='product_attribute_1']");
    By select8GB = By.xpath("//dd[@id='product_attribute_input_2']//select[@id='product_attribute_2']");
    By select400GB = By.xpath("//ul[@class='option-list']/li[@data-attr-value='7']/input[@id='product_attribute_3_7']");
    By selectVistaPremium = By.xpath("//li[@data-attr-value='9']/input[@id='product_attribute_4_9']");
    By selectTotalCommander = By.xpath("//li[@data-attr-value='12']//input[@id='product_attribute_5_12']");
    By totalPriceValue = By.xpath("//div[@class='product-price']/span[@id='price-value-1']");
    By addToCartButton = By.xpath("//div[@class='add-to-cart-panel']/button[@id='add-to-cart-button-1']");
    By productHasBeenAdded = By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]");
    By closeGreenBar = By.xpath("//span[@title='Close']");

    public String verifyTextBuildYourOwnComputer(){
        Reporter.log("Getting Build Your Own Computer Text"+actualTextBuildYourOwnCompuer.toString()+"<br>");
       return getTextFromElement(waitUntilVisibilityOfElement(actualTextBuildYourOwnCompuer,50));

    }

    public void selectProcessor(String value){
        Reporter.log("selcet processor "+value+"<br>");
        selectByValueDropDown(waitUntilVisibilityOfElement(select22GHzIntelPentiumDualCoreE2200,50),value);
    }

    public void selectRam(String value){
        Reporter.log("Select Ram"+ value.toString()+"<br>");
        selectByValueDropDown(waitUntilVisibilityOfElement(select8GB,50),value);
    }

    public void selectHDD(){
        Reporter.log("Select HDD"+select400GB.toString()+"<br>");
        clickOnElement(waitUntilVisibilityOfElement(select400GB,50));
    }

    public void selectOS(){
        Reporter.log("Select OS"+selectVistaPremium.toString()+"<br>");
        clickOnElement(waitUntilVisibilityOfElement(selectVistaPremium,50));
    }

    public void selectSoftware(){
        Reporter.log("Select Software"+selectTotalCommander.toString()+"<br>");
        clickOnElement(waitUntilVisibilityOfElement(selectTotalCommander,50));
    }

    public String actualPriceValue(){
        Reporter.log("Getting Actual price Text "+totalPriceValue.toString()+"<br>");
        return getTextFromElement(waitUntilVisibilityOfElement(totalPriceValue,50));
    }

    public void clickOnAddToCartButton(){
        Reporter.log("Click on Add to Cart "+addToCartButton.toString()+"<br>");
        clickOnElement(waitUntilVisibilityOfElement(addToCartButton,50));

    }

    public String actualGreenBarText(){
        Reporter.log("Getting Green Bar Text Message"+productHasBeenAdded.toString()+"<br>");
        return getTextFromElement(waitUntilVisibilityOfElement(productHasBeenAdded,50));
    }

    public void clickOnCrossOfGreenBar(){
        Reporter.log("Click on Green bar "+closeGreenBar.toString()+"<br>");
        clickOnElement(waitUntilVisibilityOfElement(closeGreenBar,50));
    }

}
