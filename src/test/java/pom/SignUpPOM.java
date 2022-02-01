package pom;

import base.BaseDemoBlaze;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPOM extends BaseDemoBlaze {

    @FindBy(id = "sign-username")
    public WebElement txtUserName;

    @FindBy(id = "sign-password")
    public WebElement txtPassword;

    @FindBy(xpath = "//*[@id=\"signInModal\"]/div/div/div[3]/button[2]")
    public WebElement btnSignUp;

    @FindBy(linkText = "Close")
    public WebElement btnClose;

    public SignUpPOM(){
        PageFactory.initElements(driver, this);
    }

    public void typeUserName(String userName){
        txtUserName.sendKeys(userName);
    }

    public void typePassword(String password){
        txtPassword.sendKeys(password);
    }

    public void clickBtnSignup(){
        btnSignUp.click();
    }

    public void clickBtnClose(){
        btnClose.click();
    }
}
