package testing;

import base.BaseDemoBlaze;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pom.DemoBlazeIndexPOM;
import pom.SignUpPOM;

import java.time.Duration;

public class SignUp extends BaseDemoBlaze {

    DemoBlazeIndexPOM indexPOM;
    SignUpPOM signUpPOM;

    public SignUp() {
        super();
    }

    @BeforeTest
    public void init(){
        initialSetup();
        indexPOM = new DemoBlazeIndexPOM();
        indexPOM.clickSignUp();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
    }

    @Test
    public void signUp_userName_password_clickSignUpBtn_displayAlert(){
        signUpPOM = new SignUpPOM();
        signUpPOM.typeUserName(prop.getProperty("userName"));
        signUpPOM.typePassword(prop.getProperty("password"));
        signUpPOM.clickBtnSignup();
        WebDriverWait wait = new WebDriverWait(driver, 3000);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    
    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }

}
