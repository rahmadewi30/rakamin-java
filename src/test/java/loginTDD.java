import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileReader;
import java.io.IOException;

public class loginTDD {
    //login menggunakan fitur Data Driven Test (DDT)
    @Test
    public void login_tdd(){
        WebDriver driver;
        String baseUrl = "https://saucedemo.com/";

        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();

        String csvDir = System.getProperty("user.dir")+"/src/test/data/test-data.csv";

        try(CSVReader reader = new CSVReader(new FileReader(csvDir))){
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null){
                String username = nextLine[0];
                String password = nextLine[1];
                String status = nextLine[2];

                driver = new ChromeDriver(opt);
                //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
                driver.manage().window().maximize();
                driver.get(baseUrl);
                String loginpageAssert = driver.findElement(By.xpath("//div[contains(@class,'login_logo')]")).getText();
                Assert.assertEquals(loginpageAssert,"Swag Labs");

                //interaksi element
                driver.findElement(By.id("user-name")).sendKeys(username);
                driver.findElement(By.id("password")).sendKeys(password);
                driver.findElement(By.xpath(" //input[contains(@id,'login-button')]")).click();

                //assertion
                if(status.equals("success")){
                    String dashboardAssert = driver.findElement(By.xpath("//span[contains(@class,'title')]")).getText();
                    Assert.assertEquals(dashboardAssert,"Products");

                } else {
                    String errorMessageAssert = driver.findElement(By.xpath("//div[contains(@class,'error-message-container error')]")).getText();
                    Assert.assertEquals(errorMessageAssert,"Epic sadface: Username and password do not match any user in this service");

                }
                driver.quit();
            }

        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException(e);
        }

    }
}
