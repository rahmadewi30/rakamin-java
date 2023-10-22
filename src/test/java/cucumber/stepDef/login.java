package cucumber.stepDef;

import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class login {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("SauceLab login page")
    public void saucelab_login_page(){
        driver = new ChromeDriver();
        driver.get(baseUrl);
       // String loginPageAssert = driver.findElement(By.xpath(" //div[contains(@class,'login_logo ')]"));

    }
}
