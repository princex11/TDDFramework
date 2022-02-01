package base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseDemoBlaze {
    public static Properties prop = new Properties();
    public static WebDriver driver;

    public BaseDemoBlaze(){
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("C:\\Users\\Prince\\eclipse-workspace\\TDDFramework\\src\\test\\java\\environmentVariables\\config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            prop.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initialSetup(){
        System.setProperty("web-driver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("baseUrl"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
    }

    public void screenShots(String filename){
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file , new File("C:\\Users\\Prince\\eclipse-workspace\\TDDFramework\\src\\test\\java\\screenshots\\"+filename+".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
