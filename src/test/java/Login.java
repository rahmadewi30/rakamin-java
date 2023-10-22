import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

public class Login {
    @Test
    public void openBrowser() {
        WebDriver driver;
        String baseUrl = "https://saucedemo.com/";

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        String title = driver.getTitle();
        System.out.println(title);

        driver.close();
    }

    @Test
    public void getTitle_Edge() {
        WebDriver driver;
        String baseUrl = "https://saucedemo.com/";

        WebDriverManager.chromedriver().setup();

        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        String title = driver.getTitle();
        System.out.println(title);

        String usernameButton = "Username";

        WebElement ele1 = driver.findElement(By.id(usernameButton));
        WebElement ele2 = driver.findElement(By.className("button"));

        ele1.click();
        ele1.sendKeys("email.com");
        ele1.getText();

        ele2.isDisplayed();
        ele2.click();

        driver.findElement(By.xpath("/*contains")).isDisplayed();
        driver.findElement(By.cssSelector("#button")).isDisplayed();


        driver.close();
    }

}
