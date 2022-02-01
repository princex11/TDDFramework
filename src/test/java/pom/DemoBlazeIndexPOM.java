package pom;

import base.BaseDemoBlaze;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DemoBlazeIndexPOM extends BaseDemoBlaze {

    @FindBy(xpath = "//*[@id=\"signin2\"]")
    public WebElement signUp;

    @FindBy(id = "login2")
    public WebElement login;

    @FindBy(linkText = "Laptops")
    public WebElement laptops;

    @FindBy(id = "nameofuser")
    public WebElement nameOfUser;

    public DemoBlazeIndexPOM() {
        PageFactory.initElements(driver, this);
    }

    public void clickSignUp(){
        signUp.click();
    }

    public void clickLogin(){
        login.click();
    }

    public void clickLaptops(){
        laptops.click();
    }

    public void isNameOfUserVisible(){
        Assert.assertTrue(nameOfUser.isDisplayed());
    }

}
