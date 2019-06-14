package selenium.test.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    WebDriver driver;


    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public LoginPage fillLoginForm(String email, String password) {
        driver.findElement(By.id("login")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
        return this;
    }

    public DashboardPage submitLoginForm() {
        driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/div[1]/article/div/form/div[3]/button")).click();
        driver.switchTo().frame("nk_portal_frame");
        return new DashboardPage(driver);
    }
}
