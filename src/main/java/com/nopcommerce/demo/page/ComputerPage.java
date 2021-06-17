package com.nopcommerce.demo.page;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;
import org.testng.Reporter;

import javax.print.DocFlavor;

public class ComputerPage extends Utility {

    HomePage homepage = new HomePage();
    By desktopLink =By.xpath("//h2[@class='title']//a[@href='/desktops']");

    public void clickOnComputer(){
        Reporter.log("Click on Computer "+homepage.computersLink.toString()+"<br>");
        clickOnElement(waitUntilVisibilityOfElement(homepage.computersLink,20));

    }

    public void clickOnDesktop(){
        Reporter.log("Click on Desktop "+desktopLink.toString()+"<br>");
        clickOnElement(waitUntilVisibilityOfElement(desktopLink,50));

    }



}
