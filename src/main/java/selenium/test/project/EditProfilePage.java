package selenium.test.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditProfilePage {
    WebDriver driver;

    public EditProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public EditProfilePage changeNameTo(String newName) {
        WebElement nameField = driver.findElement(By.xpath("//*[@id=\"edit_form_first_name\"]"));
        nameField.clear();
        nameField.sendKeys(newName);
        return this;
    }

    public EditProfilePage submitEditProfileForm() {
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[3]/div[2]/div/div[2]/div[1]/form/div[2]/button")).click();
        return this;
    }

    public DashboardPage backToDashboardPage() {
        driver.findElement(By.linkText("Start")).click();
        return new DashboardPage(driver);
    }
}
