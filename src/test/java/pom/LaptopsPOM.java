package pom;

import base.BaseDemoBlaze;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LaptopsPOM extends BaseDemoBlaze {

    @FindBy(linkText = "Sony vaio i5")
    public WebElement sonyViaoI5;

    public LaptopsPOM() {
        PageFactory.initElements(driver, this);
    }

    public void isSonyViaoLaptopLinkVisible(){
        Assert.assertTrue(sonyViaoI5.isDisplayed());
    }

    public void clickSonyViaoI5(){
        sonyViaoI5.click();
    }

}
