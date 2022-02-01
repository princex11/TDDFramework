package testing;

import base.BaseDemoBlaze;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pom.*;

public class AddToCart extends BaseDemoBlaze {

    DemoBlazeIndexPOM indexPOM;
    LoginPOM loginPOM;
    LaptopsPOM laptopsPOM;
    SelectedLaptopPOM selectedLaptopPOM;
    CartPOM cartPOM;

    public AddToCart() {
        super();
    }

    @BeforeTest
    public void init(){
        initialSetup();
        indexPOM = new DemoBlazeIndexPOM();
        indexPOM.clickLogin();
    }

    @Test(priority = 1)
    public void login_userName_password_clickLogInBtn(){
        loginPOM = new LoginPOM();
        loginPOM.typeUserName(prop.getProperty("userName"));
        loginPOM.typePassword(prop.getProperty("password"));
        loginPOM.clickBtnLogIn();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        indexPOM.isNameOfUserVisible();
        screenShots("afterlogin");
    }

    @Test(priority = 2)
    public void after_login_click_laptops_navigate_to_laptops(){
        indexPOM.clickLaptops();
        try {
            Thread.sleep(5000);
            screenShots("laptopsPage");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        laptopsPOM = new LaptopsPOM();
        laptopsPOM.isSonyViaoLaptopLinkVisible();

    }

    @Test(priority = 3)
    public void at_laptops_select_sonyViaoI5_and_verify_sonyViaoI5_page(){
        laptopsPOM.clickSonyViaoI5();
        String actual = driver.getCurrentUrl();
        Assert.assertEquals(actual, "https://demoblaze.com/prod.html?idp_=8");
        try {
            Thread.sleep(3000);
            screenShots("selectedLaptopPage");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test(priority = 4)
    public void at_selected_laptop_click_addToCart(){
        selectedLaptopPOM = new SelectedLaptopPOM();
        selectedLaptopPOM.clickBtnAddToCart();
        WebDriverWait wait = new WebDriverWait(driver, 3000);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
        screenShots("addToCart");
    }

    @Test(priority = 5)
    public void navigate_to_cart_and_verify_added_product(){
        driver.navigate().to("https://demoblaze.com/cart.html#");
        cartPOM = new CartPOM();
        cartPOM.isProductTitleVisible();
        screenShots("cart");
    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }

}
