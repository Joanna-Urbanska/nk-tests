package selenium.test.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage {
    WebDriver driver;

    public LogoutPage(WebDriver driver){
        this.driver = driver;
        driver.switchTo().defaultContent();
    }

    public boolean isLoggedOut() {
        return driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/a")).isDisplayed();
    }
}
