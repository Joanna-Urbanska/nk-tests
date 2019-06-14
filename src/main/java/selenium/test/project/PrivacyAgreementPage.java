package selenium.test.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class PrivacyAgreementPage {
    WebDriver driver;

    public PrivacyAgreementPage(WebDriver driver){
        this.driver = driver;
    }

    public PrivacyAgreementPage clickAgree() {
        driver.findElement(By.xpath("//html//body//div[3]//div[1]//div[2]//div//div[3]//button[2]")).click();
        return this;
    }

}
