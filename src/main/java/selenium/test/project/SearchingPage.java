package selenium.test.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class SearchingPage {
    WebDriver driver;

    public SearchingPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isPaginationVisible() {
        return driver.findElement(By.xpath("/html/body/div/div[1]/div[4]/div[3]/div/div/section/div[2]/div[1]/input")).isDisplayed();
    }
}

