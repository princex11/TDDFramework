package pom;

import base.BaseDemoBlaze;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SelectedLaptopPOM extends BaseDemoBlaze {

    @FindBy(linkText = "Add to cart")
    public WebElement btnAddToCart;

    public SelectedLaptopPOM() {
        PageFactory.initElements(driver, this);
    }

    public void isBtnAddToCartVisible(){
        Assert.assertTrue(btnAddToCart.isDisplayed());
    }

    public void clickBtnAddToCart(){
        btnAddToCart.click();
    }

}
