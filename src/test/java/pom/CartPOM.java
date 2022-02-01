package pom;

import base.BaseDemoBlaze;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CartPOM extends BaseDemoBlaze {

    @FindBy(xpath = "//*[@id=\"tbodyid\"]/tr/td[2]")
    public WebElement productTitle;

    public CartPOM() {
        PageFactory.initElements(driver, this);
    }

    public void isProductTitleVisible(){
        Assert.assertTrue(productTitle.isDisplayed());
    }
}
