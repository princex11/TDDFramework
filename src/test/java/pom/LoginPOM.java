package pom;

import base.BaseDemoBlaze;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM extends BaseDemoBlaze {

    @FindBy(id = "loginusername")
    public WebElement txtUserName;

    @FindBy(id = "loginpassword")
    public WebElement txtPassword;

    @FindBy(xpath = "//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")
    public WebElement btnLogin;

    @FindBy(linkText = "Close")
    public WebElement btnClose;

    public LoginPOM(){
        PageFactory.initElements(driver, this);
    }

    public void typeUserName(String userName){
        txtUserName.sendKeys(userName);
    }

    public void typePassword(String password){
        txtPassword.sendKeys(password);
    }

    public void clickBtnLogIn(){
        btnLogin.click();
    }

    public void clickBtnClose(){
        btnClose.click();
    }
}
